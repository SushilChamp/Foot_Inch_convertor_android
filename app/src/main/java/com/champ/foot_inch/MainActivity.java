package com.champ.foot_inch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText numA;
    EditText numB;
    EditText numC1;
    EditText numC2;
    EditText numD;
    Button butconvert1;
    Button butconvert2;
    TextView resultadd;
    TextView resultfeet1;
    TextView resultfeet2;
    TextView resultfeet3;
    TextView resultfeet4;
    CheckBox circum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numA=(EditText) findViewById(R.id.numA);
        numB= (EditText) findViewById(R.id.numB);
        numC1= (EditText) findViewById(R.id.numC1);
        numC2= (EditText) findViewById(R.id.numC2);
        numD= (EditText) findViewById(R.id.numD);
        butconvert1= (Button) findViewById(R.id.butconvert1);
        butconvert2= (Button) findViewById(R.id.butconvert2);
        circum = (CheckBox)findViewById(R.id.circum);
        resultadd= (TextView) findViewById(R.id.resultadd);
        resultfeet1=(TextView) findViewById(R.id.resultfeet1);
        resultfeet2= (TextView) findViewById(R.id.resultfeet2);
        resultfeet3= (TextView) findViewById(R.id.resultfeet3);
        resultfeet4= (TextView) findViewById(R.id.resultfeet4);

        butconvert1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String num21 = numA.getText().toString();
                String num22 = numB.getText().toString();
                String num23 = numC1.getText().toString();
                String num24 = numC2.getText().toString();

                if(!num21.isEmpty() || !num22.isEmpty() || !num23.isEmpty() || !num24.isEmpty()){

                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;
                    int num4 = 1;

                    if(!num21.isEmpty()){num1 = Integer.parseInt(num21);}
                    if(!num22.isEmpty()){num2 = Integer.parseInt(num22);}
                    if(!num23.isEmpty()){num3 = Integer.parseInt(num23);}
                    if(!num24.isEmpty()){num4 = Integer.parseInt(num24);}

                    if(num4 == 0){num4 =1;}
                    Toast.makeText(getApplicationContext(),"Converted",Toast.LENGTH_LONG).show();
                    float num5 = num1*12+num2+(float)num3/num4;
                    resultadd.setText(num5 + " in");

                }else{Toast.makeText(getApplicationContext(),"Please, fill at least one box!",Toast.LENGTH_LONG).show();}

                //if(!num21.isEmpty() && !num22.isEmpty() && !num23.isEmpty() && !num24.isEmpty()){
                //  int num1 = Integer.parseInt(num21);
                //  int num1 = Integer.parseInt(numA.getText().toString());
            }
        });

        butconvert2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String num20 = numD.getText().toString();
                if(!num20.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Converted",Toast.LENGTH_LONG).show();
                    float num6 = Float.parseFloat(num20);
                    if(circum.isChecked()){
                        num6 = num6*22/7;}

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
                    resultfeet3.setText((int)num10 + "      /");
                    resultfeet4.setText(num11 + "");

                }else {
                    Toast.makeText(getApplicationContext(), "Please, fill the box!", Toast.LENGTH_LONG).show();}

            }
        });
    }
}