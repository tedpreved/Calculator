package com.calculator.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Converter extends Activity {


    Button Calc,Conv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);


        Calc=(Button) findViewById(R.id.Calc);
        Conv=(Button) findViewById(R.id.Conv);


        View.OnClickListener btnList = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.Calc:{
                        finish();
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        break;}

                    default:
                        break;

                }

            }
        };

        Conv.setOnClickListener(btnList);
        Calc.setOnClickListener(btnList);





    }




}
