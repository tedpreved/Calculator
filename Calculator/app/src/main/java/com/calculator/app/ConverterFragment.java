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

    public static int p1;
    public static int p2;


	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_convertor, null);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                getActivity().getApplicationContext(), R.array.mas_list,R.layout.item_row);
		//adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.item_dropdown);

		//ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity()
		//		.getApplicationContext(), android.R.layout.simple_spinner_item,
		//		data);
		//adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.row, R.id.textForSpinner,R.array.mas_list,);

		final Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner);
		final Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
		ImageButton buttonUP = (ImageButton) v.findViewById(R.id.buttonUP);
		ImageButton buttonDOWN = (ImageButton) v.findViewById(R.id.buttonDOWN);

		final EditText tv1 = (EditText) v.findViewById(R.id.CBox1);
		final EditText tv2 = (EditText) v.findViewById(R.id.CBox_2);

		tv1.setText("0");
		tv2.setText("0");

		spinner1.setAdapter(adapter1);
		spinner1.setSelection(1);

		spinner2.setAdapter(adapter1);
		spinner1.setSelection(1);

		View.OnClickListener btnConv = new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				double result = 0;

				switch (view.getId()) {
				case R.id.buttonUP: {

					Log.d(TAG, "Pressed buttonUP");

					 p1 = spinner1.getSelectedItemPosition();
                    //Log.d(TAG,String.valueOf(p1));
					 p2 = spinner2.getSelectedItemPosition();
                    //Log.d(TAG,String.valueOf(p1));
                        tv1.setText(Convertor.convert(p1,p2, tv1.getText().toString(),tv2.getText().toString(),true));
                    if(p1==p2){
                        tv1.setText(tv2.getText());
                    }

					break;
				}

				case R.id.buttonDOWN:

                    p1 = spinner1.getSelectedItemPosition();
                    //Log.d(TAG,String.valueOf(p1));
                    p2 = spinner2.getSelectedItemPosition();
                    //Log.d(TAG,String.valueOf(p1));
                    tv2.setText(Convertor.convert(p1,p2, tv1.getText().toString(),tv2.getText().toString(),false));
                    if(p1==p2){
                        tv2.setText(tv1.getText());
                    }

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
                Log.d(TAG,String.valueOf(spinner1.getSelectedItemPosition()));
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
                Log.d(TAG,String.valueOf(spinner2.getSelectedItemPosition()));
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});

		return v;
	}
}