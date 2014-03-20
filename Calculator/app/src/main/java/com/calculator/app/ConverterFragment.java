package com.calculator.app;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class ConverterFragment extends Fragment {

	final static String[] data = { "gram", "kilogram", "tonna" };

	final static double[] mas = { 1, 1000, 1000 };

	private static final String TAG = "myLogs";

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_convertor, null);

		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), android.R.layout.simple_spinner_item,
				data);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), android.R.layout.simple_spinner_item,
				data);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.row, R.id.textForSpinner,R.array.mas_list,);

		final Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner);
		final Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
		ImageButton buttonUP = (ImageButton) v.findViewById(R.id.buttonUP);
		ImageButton buttonDOWN = (ImageButton) v.findViewById(R.id.buttonDOWN);

		final EditText CBox1 = (EditText) v.findViewById(R.id.CBox1);
		final EditText CBox2 = (EditText) v.findViewById(R.id.CBox_2);

		CBox1.setText("0");
		CBox2.setText("0");

		spinner1.setAdapter(adapter1);
		spinner1.setSelection(1);

		spinner2.setAdapter(adapter2);
		spinner1.setSelection(1);

		View.OnClickListener btnConv = new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				double result = 0;

				switch (view.getId()) {
				case R.id.buttonUP: {

					Log.d(TAG, "Pressed buttonUP");

					int p1 = spinner1.getSelectedItemPosition();
					int p2 = spinner2.getSelectedItemPosition();

					double numberFromEdit1 = Double.valueOf(CBox1.getText()
							.toString());
					double numberFromEdit2 = Double.valueOf(CBox2.getText()
							.toString());

					result = numberFromEdit2;
					if (p2 > p1) { // Большее преобразуем в меньшее. умножаем от
									// р1 до р2
						for (int i = p1; p2 <= i; i++)
							result *= mas[i];

					}

					if (p1 > p2) { // Меньшее преобразуем в большее. делим от р2
									// до р1
						for (int i = p1; i > p2; i--)
							result /= mas[i];

					}
					if (p1 == p2) {
						result = numberFromEdit2;
					}

					CBox1.setText(String.valueOf(result));

					break;
				}

				case R.id.buttonDOWN:

					break;
				}

			}
		};

		buttonUP.setOnClickListener(btnConv);
		buttonDOWN.setOnClickListener(btnConv);

		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int position, long l) {
				Log.d(TAG, "Modify spin1");
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});

		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int i, long l) {
				Log.d(TAG, "Modify spin2");
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});

		return v;
	}
}