package com.calculator.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

                Button Calc,Conv;
                Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
                Button btnDiv,btnMul,btnDel,btnClear,btnAns,btnDot,btnPlus,btnMin;
                TextView Box;


               public static double first=1;
               public static double second=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

            Calc=(Button) findViewById(R.id.Calc);
            Conv=(Button) findViewById(R.id.Conv);
            Box=(TextView)findViewById(R.id.Box);


        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);

        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnAns=(Button)findViewById(R.id.btnAns);
        btnDot=(Button)findViewById(R.id.btnDot);
        btnDel=(Button)findViewById(R.id.btnDel);
        btnClear=(Button)findViewById(R.id.btnClear);
        btnPlus=(Button)findViewById(R.id.btnPlus);
        btnMin=(Button)findViewById(R.id.btnMin);
        btnDot=(Button)findViewById(R.id.btnDot);

        View.OnClickListener btnList = new View.OnClickListener() {
            public  int temp;
            @Override


            public void onClick(View v) {

                switch(v.getId()){
                    case R.id.Conv:
                        Intent intentConverter=new Intent(getApplicationContext(),Converter.class);
                        startActivity(intentConverter);
                        break;
                    case R.id.Calc:
                        Intent intentCalculator=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intentCalculator);
                        break;
                    case R.id.btn0:
                        Box.setText(Box.getText()+"0");
                        break;
                    case R.id.btn1:
                        Box.setText(Box.getText()+"1");
                        break;
                    case R.id.btn2:
                        Box.setText(Box.getText()+"2");
                        break;
                    case R.id.btn3:
                        Box.setText(Box.getText()+"3");
                        break;
                    case R.id.btn4:
                        Box.setText(Box.getText()+"4");
                        break;
                    case R.id.btn5:
                        Box.setText(Box.getText()+"5");
                        break;
                    case R.id.btn6:
                        Box.setText(Box.getText()+"6");
                        break;
                    case R.id.btn7:
                        Box.setText(Box.getText()+"7");
                        break;
                    case R.id.btn8:
                        Box.setText(Box.getText()+"8");
                        break;
                    case R.id.btn9:
                        Box.setText(Box.getText()+"9");
                        break;
                    case R.id.btnDot:
                        Box.setText(Box.getText()+".");
                        break;
                    case R.id.btnClear:
                        CharSequence Buff =Box.getText();
                        Box.setText(Buff.subSequence(0,(Box.getText().length()-1)));
                        break;
                    case R.id.btnDel:
                        Box.setText(null);
                        break;
                    case R.id.btnMul:
                        first=Double.valueOf(Box.getText().toString());
                        temp=1;
                        Box.setText(null);
                        break;
                    case R.id.btnDiv:
                        first=Double.valueOf(Box.getText().toString());
                        temp=2;
                        Box.setText(null);
                        break;
                    case R.id.btnPlus:
                        first=Double.valueOf(Box.getText().toString());
                        temp=3;
                        Box.setText(null);
                        break;
                    case R.id.btnMin:
                        first=Double.valueOf(Box.getText().toString());
                        temp=4;
                        Box.setText(null);
                        break;
                    case R.id.btnAns:
                        switch (temp){
                            case 1:
                                second=Double.valueOf(Box.getText().toString());
                                Box.setText(String.valueOf((second*first)));
                                break;
                            case 2:
                                second=Double.valueOf(Box.getText().toString());
                                Box.setText(String.valueOf((first/second)));
                                break;
                            case 3:
                                second=Double.valueOf(Box.getText().toString());
                                Box.setText(String.valueOf((first+second)));
                                break;
                            case 4:
                                second=Double.valueOf(Box.getText().toString());
                                Box.setText(String.valueOf((first-second)));
                                break;
                            default:
                            break;
                        }
                        break;

                    default:
                        break;

                }

            }
        };

        Conv.setOnClickListener(btnList);
        Calc.setOnClickListener(btnList);

        btn0.setOnClickListener(btnList);
        btn1.setOnClickListener(btnList);
        btn2.setOnClickListener(btnList);
        btn3.setOnClickListener(btnList);
        btn4.setOnClickListener(btnList);
        btn5.setOnClickListener(btnList);
        btn6.setOnClickListener(btnList);
        btn7.setOnClickListener(btnList);
        btn8.setOnClickListener(btnList);
        btn9.setOnClickListener(btnList);

        btnDel.setOnClickListener(btnList);
        btnClear.setOnClickListener(btnList);
        btnAns.setOnClickListener(btnList);
        btnDot.setOnClickListener(btnList);

        btnMul.setOnClickListener(btnList);
        btnDiv.setOnClickListener(btnList);
        btnPlus.setOnClickListener(btnList);
        btnMin.setOnClickListener(btnList);
    }
}
