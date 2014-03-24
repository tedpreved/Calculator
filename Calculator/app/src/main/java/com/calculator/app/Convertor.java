package com.calculator.app;

import android.util.Log;

/**
 * Created by Monstr on 10.03.14.
 */

public class Convertor {
	
	private Convertor() {
	}

	final static double[] mas = { 1000, 1000, 1000};

    public static double ans=0.0;

    private static final String TAG = "myLogs";

    private static  String answer;

	public static String convert(int number1, int number2, String mFirst,
			String mSecond, boolean chek) {

        // number1, number2 позиция спиннера
        // mFirst, mSecond числа из tv
        //chek если true - то левая кнопка, если false то правая

        double Item1=Double.valueOf(mFirst);
        double Item2=Double.valueOf(mSecond);

        if(chek==true){
            //------------------------------Left Button-----------------------
            if(number1>number2){
                Log.d(TAG, String.valueOf(number1));
                Log.d(TAG,String.valueOf(number2));
                //------------Delenie---------
                ans=Item2;
                for(;number1!=number2;number1--){
                    ans=ans/mas[number1];
                }
            }
            if(number1<number2){
                Log.d(TAG, String.valueOf(number1));
                Log.d(TAG,String.valueOf(number2));
                //--------------------------Umnogenie-------------------------
                ans=Item2;
                for(;number2!=number1;number1++){
                    ans*=mas[number1];
                } }
        } else {
            if(number1<number2){
                Log.d(TAG, String.valueOf(number1));
                Log.d(TAG,String.valueOf(number2));
                //------------Delenie---------
                ans=Item1;
                for(;number2!=number1;number2--){
                    ans=ans/mas[number2];
                }
            }
            if(number1>number2){
                Log.d(TAG, String.valueOf(number1));
                Log.d(TAG,String.valueOf(number2));
                //--------------------------Umnogenie-------------------------
                ans=Item1;
                for(;number1!=number2;number2++){
                    ans*=mas[number2];
                }
            }
        }
        answer=Double.toString(ans);
		return answer;
	}

}
