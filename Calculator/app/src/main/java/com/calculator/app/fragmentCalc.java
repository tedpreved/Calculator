package com.calculator.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Monstr on 20.03.14.
 */
public class FragmentCalc extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentcalc, null);


               final TextView Box=(TextView)v.findViewById(R.id.Box);


                Button  btn0=(Button)v.findViewById(R.id.btn0);
                Button btn1=(Button)v.findViewById(R.id.btn1);
                Button btn2=(Button)v.findViewById(R.id.btn2);
                Button btn3=(Button)v.findViewById(R.id.btn3);
                Button btn4=(Button)v.findViewById(R.id.btn4);
                Button btn5=(Button)v.findViewById(R.id.btn5);
                Button btn6=(Button)v.findViewById(R.id.btn6);
                Button btn7=(Button)v.findViewById(R.id.btn7);
                Button btn8=(Button)v.findViewById(R.id.btn8);
                Button btn9=(Button)v.findViewById(R.id.btn9);

                Button btnDiv=(Button)v.findViewById(R.id.btnDiv);
                Button btnMul=(Button)v.findViewById(R.id.btnMul);
                Button btnAns=(Button)v.findViewById(R.id.btnAns);
                Button btnDot=(Button)v.findViewById(R.id.btnDot);
                Button btnDel=(Button)v.findViewById(R.id.btnDel);
                Button btnClear=(Button)v.findViewById(R.id.btnClear);
                Button btnPlus=(Button)v.findViewById(R.id.btnPlus);
                Button btnMin=(Button)v.findViewById(R.id.btnMin);

        View.OnClickListener btnList = new View.OnClickListener() {
            public  int temp;
            public  int check;
            @Override



            public void onClick(View v) {


                double first=0;
                double second=0;

                switch(v.getId()){
                    case R.id.btn0:
                        if((Box.getText().length()==1)&(Box.getText().toString().contains("0"))==true){
                        } else {Box.setText(Box.getText()+"0");}
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

                        if(Box.getText().length()!=0){
                            if(Box.getText().toString().contains(".")==true){
                            } else {Box.setText(Box.getText()+".");
                            };
                        };

                        break;
                    case R.id.btnClear:
                        CharSequence Buff =Box.getText();
                        if(Box.getText().length()<1){ Box.setText("1");}
                        Box.setText(Buff.subSequence(0,(Box.getText().length()-1)));
                        break;
                    case R.id.btnDel:
                        Box.setText(null);
                        check=0;
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
                                if(check==0){
                                    second=Double.valueOf(Box.getText().toString());
                                    Box.setText(String.valueOf((first*second)));
                                    first=first*second;


                                    check=1;
                                } else {
                                    Box.setText(String.valueOf((first*second)));
                                    first=first*second;
                                    check=1;
                                }
                                break;
                            case 2:
                                if(check==0){
                                    second=Double.valueOf(Box.getText().toString());
                                    Box.setText(String.valueOf((first/second)));
                                    first=first/second;
                                    check=1;
                                } else {
                                    Box.setText(String.valueOf((first/second)));
                                    first=first/second;
                                    check=1;
                                }
                                break;
                            case 3:
                                if(check==0){
                                    second=Double.valueOf(Box.getText().toString());
                                    Box.setText(String.valueOf(first+second));
                                    first=first+second;
                                    check=1;
                                } else {
                                    Box.setText(String.valueOf(first+second));
                                    first=first+second;

                                    check=1;
                                }
                                break;
                            case 4:
                                if(check==0){
                                    second=Double.valueOf(Box.getText().toString());
                                    Box.setText(String.valueOf((first-second)));
                                    first=first-second;
                                    check=1;
                                } else {
                                    Box.setText(String.valueOf((first-second)));
                                    first=first-second;
                                    check=1;
                                }
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






        return v;
    }
}
