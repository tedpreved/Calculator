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
public class CalculatorFragment extends Fragment {

	private TextView tvBox;

	private double mFirst = 0;
	private double mSecond = 0;
	private int mTemp;
	private int mCheckRepeat;

	public static final String TAG_FOR_TEMP = "TEMP";
	public static final String TAG_FOR_CHECKREPEAT = "CHECKREPEAT";
	public static final String TAG_FOR_FIRST = "FIRST";
	public static final String TAG_FOR_SECOND = "SECOND";

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(TAG_FOR_TEMP, mTemp);
		outState.putInt(TAG_FOR_CHECKREPEAT, mCheckRepeat);
		outState.putDouble(TAG_FOR_FIRST, mFirst);
		outState.putDouble(TAG_FOR_SECOND, mSecond);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		if (savedInstanceState != null) {

			mFirst = savedInstanceState.getDouble(TAG_FOR_FIRST);
			mSecond = savedInstanceState.getDouble(TAG_FOR_SECOND);
			mTemp = savedInstanceState.getInt(TAG_FOR_TEMP);
			mCheckRepeat = savedInstanceState.getInt(TAG_FOR_CHECKREPEAT);

		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_calc, null);

		tvBox = (TextView) v.findViewById(R.id.Box);

		Button btn0 = (Button) v.findViewById(R.id.btn0);
		Button btn1 = (Button) v.findViewById(R.id.btn1);
		Button btn2 = (Button) v.findViewById(R.id.btn2);
		Button btn3 = (Button) v.findViewById(R.id.btn3);
		Button btn4 = (Button) v.findViewById(R.id.btn4);
		Button btn5 = (Button) v.findViewById(R.id.btn5);
		Button btn6 = (Button) v.findViewById(R.id.btn6);
		Button btn7 = (Button) v.findViewById(R.id.btn7);
		Button btn8 = (Button) v.findViewById(R.id.btn8);
		Button btn9 = (Button) v.findViewById(R.id.btn9);
		
		Button btnDiv = (Button) v.findViewById(R.id.btnDiv);
		Button btnMul = (Button) v.findViewById(R.id.btnMul);
		Button btnAns = (Button) v.findViewById(R.id.btnAns);
		Button btnDot = (Button) v.findViewById(R.id.btnDot);
		Button btnDel = (Button) v.findViewById(R.id.btnDel);
		Button btnClear = (Button) v.findViewById(R.id.btnClear);
		Button btnPlus = (Button) v.findViewById(R.id.btnPlus);
		Button btnMin = (Button) v.findViewById(R.id.btnMin);

		View.OnClickListener btnList = new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				switch (v.getId()) {
				case R.id.btn0:
					if ((tvBox.getText().length() == 1)
							& (tvBox.getText().toString().contains("0")) == true) {
					} else {
						tvBox.setText(tvBox.getText() + "0");
					}
					break;
				case R.id.btn1:
					tvBox.setText(tvBox.getText() + "1");
					break;
				case R.id.btn2:
					tvBox.setText(tvBox.getText() + "2");
					break;
				case R.id.btn3:
					tvBox.setText(tvBox.getText() + "3");
					break;
				case R.id.btn4:
					tvBox.setText(tvBox.getText() + "4");
					break;
				case R.id.btn5:
					tvBox.setText(tvBox.getText() + "5");
					break;
				case R.id.btn6:
					tvBox.setText(tvBox.getText() + "6");
					break;
				case R.id.btn7:
					tvBox.setText(tvBox.getText() + "7");
					break;
				case R.id.btn8:
					tvBox.setText(tvBox.getText() + "8");
					break;
				case R.id.btn9:
					tvBox.setText(tvBox.getText() + "9");
					break;
				case R.id.btnDot:

					if (tvBox.getText().length() != 0) {
						if (tvBox.getText().toString().contains(".") == true) {
						} else {
							tvBox.setText(tvBox.getText() + ".");
						}
					}

					break;
				case R.id.btnDel:
					CharSequence Buff = tvBox.getText();
					if (tvBox.getText().length() < 1) {
						tvBox.setText("1");
					}
					tvBox.setText(Buff.subSequence(0,
							(tvBox.getText().length() - 1)));
					break;
				case R.id.btnClear:
					tvBox.setText(null);
					mFirst = 0;
					mSecond = 0;
					mCheckRepeat = 0;
					break;
				case R.id.btnMul:

					mFirst = Double.valueOf(tvBox.getText().toString());
					mTemp = 1;
					tvBox.setText(null);
					break;
				case R.id.btnDiv:
					mFirst = Double.valueOf(tvBox.getText().toString());
					mTemp = 2;
					tvBox.setText(null);
					break;
				case R.id.btnPlus:
					mFirst = Double.valueOf(tvBox.getText().toString());
					mTemp = 3;
					tvBox.setText(null);
					break;
				case R.id.btnMin:
					mFirst = Double.valueOf(tvBox.getText().toString());
					mTemp = 4;
					tvBox.setText(null);
					break;
				case R.id.btnAns:
					switch (mTemp) {
					case 1:
						if (mCheckRepeat == 0) {
							mSecond = Double
									.valueOf(tvBox.getText().toString());
							tvBox.setText(String.valueOf((mFirst * mSecond)));
							mFirst = mFirst * mSecond;

							mCheckRepeat = 1;
						} else {
							tvBox.setText(String.valueOf((mFirst * mSecond)));
							mFirst = mFirst * mSecond;
							mCheckRepeat = 1;
						}
						break;
					case 2:
						if (mCheckRepeat == 0) {
							mSecond = Double
									.valueOf(tvBox.getText().toString());
							tvBox.setText(String.valueOf((mFirst / mSecond)));
							mFirst = mFirst / mSecond;
							mCheckRepeat = 1;
						} else {
							tvBox.setText(String.valueOf((mFirst / mSecond)));
							mFirst = mFirst / mSecond;
							mCheckRepeat = 1;
						}
						break;
					case 3:
						if (mCheckRepeat == 0) {
							mSecond = Double
									.valueOf(tvBox.getText().toString());
							tvBox.setText(String.valueOf(mFirst + mSecond));
							mFirst = mFirst + mSecond;
							mCheckRepeat = 1;
						} else {
							tvBox.setText(String.valueOf(mFirst + mSecond));
							mFirst = mFirst + mSecond;

							mCheckRepeat = 1;
						}
						break;
					case 4:
						if (mCheckRepeat == 0) {
							mSecond = Double
									.valueOf(tvBox.getText().toString());
							tvBox.setText(String.valueOf((mFirst - mSecond)));
							mFirst = mFirst - mSecond;
							mCheckRepeat = 1;
						} else {
							tvBox.setText(String.valueOf((mFirst - mSecond)));
							mFirst = mFirst - mSecond;
							mCheckRepeat = 1;
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
