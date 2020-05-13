package com.champ.foot_inch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    EditText numA;
    EditText numB;
    EditText numC1;
    EditText numC2;
    EditText numD;

    EditText numAx;
    EditText numBx;
    EditText numC1x;
    EditText numC2x;
    EditText numDx;

    Button butconvert1;
    Button butconvert2;
    TextView resultadd;
    TextView resultfeet1;
    TextView resultfeet2;
    TextView resultfeet3;
    TextView resultfeet4;
    CheckBox circum;
    AdView myAd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");       //Test app id     --     unit id in xml file only
        myAd1 = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAd1.loadAd(adRequest);

        numA= findViewById(R.id.ftoin_feet1);
        numB= findViewById(R.id.ftoin_inch1);
        numC1= findViewById(R.id.ftoin_frac1);
        numC2= findViewById(R.id.ftoin_frac2);
        numD= findViewById(R.id.total_inch1);

        numAx= findViewById(R.id.ftoin_feet2);
        numBx= findViewById(R.id.ftoin_inch2);
        numC1x= findViewById(R.id.ftoin_frac3);
        numC2x= findViewById(R.id.ftoin_frac4);
        numDx= findViewById(R.id.total_inch2);

        butconvert1= findViewById(R.id.button_1);
        butconvert2= findViewById(R.id.button_2);
        circum = findViewById(R.id.circum);
        resultadd= findViewById(R.id.result_1);
        resultfeet1= findViewById(R.id.result_21);
        resultfeet2= findViewById(R.id.result_22);
        resultfeet3= findViewById(R.id.result_23);
        resultfeet4= findViewById(R.id.result_24);

        butconvert1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String num21 = numA.getText().toString();
                String num22 = numB.getText().toString();
                String num23 = numC1.getText().toString();
                String num24 = numC2.getText().toString();

                String num26 = numAx.getText().toString();
                String num27 = numBx.getText().toString();
                String num28 = numC1x.getText().toString();
                String num29 = numC2x.getText().toString();


                if(!num21.isEmpty() || !num22.isEmpty() || !num23.isEmpty() || !num24.isEmpty()){

                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;
                    int num4 = 1;

                    int num1x = 0;
                    int num2x = 0;
                    int num3x = 0;
                    int num4x = 1;

                    if(!num21.isEmpty()){num1 = Integer.parseInt(num21);}
                    if(!num22.isEmpty()){num2 = Integer.parseInt(num22);}
                    if(!num23.isEmpty()){num3 = Integer.parseInt(num23);}
                    if(!num24.isEmpty()){num4 = Integer.parseInt(num24);}

                    if(!num26.isEmpty()){num1x = Integer.parseInt(num21);}
                    if(!num27.isEmpty()){num2x = Integer.parseInt(num22);}
                    if(!num28.isEmpty()){num3x = Integer.parseInt(num23);}
                    if(!num29.isEmpty()){num4x = Integer.parseInt(num24);}

                    if(num4 == 0){num4 =1;}
                    Toast.makeText(getApplicationContext(),"Converted",Toast.LENGTH_LONG).show();
                    float num5 = num1*12+num2+(float)num3/num4  +   num1x*12+num2x+(float)num3x/num4x;
                    resultadd.setText(num5 + " in");

                }else{Toast.makeText(getApplicationContext(),"Please, fill at least one box!",Toast.LENGTH_LONG).show();}
            }
        });

        butconvert2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String num20 = numD.getText().toString();
                String num25 = numDx.getText().toString();

                if(!num20.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Converted",Toast.LENGTH_LONG).show();
                    float num6x = 0;
                    if(!num25.isEmpty()){num6x = Float.parseFloat(num25);}
                    float num6 = Float.parseFloat(num20) + num6x;

                    if(circum.isChecked()){
                        num6 = (float) (num6*Math.PI);}

                    int num7 = (int) num6/12;
                    int num8 = (int) num6-num7*12;
                    float num9 = num6-num7*12-num8;
                    float num10 = num9*32;
                    int num11 = 32;
                    int num12 = (int) num10/2;
                    int num13 = num12*2;
                    if(num13!=0) {
                        while ((int) num10 - num13 <= 0) {
                            num11 = num11 / 2;
                            num10 = num12;
                            num12 = (int) num10 / 2;
                            num13 = num12 * 2;}
                    }
                    else {
                        num11 = 0;}

                    resultfeet1.setText(num7 + "");
                    resultfeet2.setText(num8 + "");
                    resultfeet3.setText((int)num10 + "     /");
                    resultfeet4.setText(num11 + "");

                }else {
                    Toast.makeText(getApplicationContext(), "Please, fill the box!", Toast.LENGTH_LONG).show();}

            }
        });
    }
}