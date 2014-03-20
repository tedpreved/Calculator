package com.calculator.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements ActionBar.TabListener {

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	private final Fragment mFragments[] = new Fragment[2];
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
		
		getFragmentManager().putFragment(outState, CalculatorFragment.class.getSimpleName(), mFragments[0]);
		getFragmentManager().putFragment(outState, ConverterFragment.class.getSimpleName(), mFragments[1]);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if(savedInstanceState == null) {
			mFragments[0] = new CalculatorFragment();
			mFragments[1] = new ConverterFragment();
		} else {
			mFragments[0] = getFragmentManager().getFragment(savedInstanceState, CalculatorFragment.class.getSimpleName());
			mFragments[1] = getFragmentManager().getFragment(savedInstanceState, ConverterFragment.class.getSimpleName());
		}

		setContentView(R.layout.activity_main);
		
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText(R.string.title_section1)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section2)
				.setTabListener(this));
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}
	
	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		for(int i=0; i<mFragments.length; ++i) {
			if(i == tab.getPosition()) {
				if(!mFragments[i].isAdded()) {
					ft.add(R.id.fragment1, mFragments[i]);
				} 
				if(mFragments[i].isDetached()) {
					ft.attach(mFragments[i]);
				}
			} else {
				if(!mFragments[i].isDetached()) {
					ft.detach(mFragments[i]);
				}
			}
		}
		ft.commit();
//		Fragment fragment;
//		if (tab.getPosition() == 0) {
//			fragment = new CalculatorFragment(); 
//		} else {
//			fragment = new ConverterFragment();
//		}
//		getFragmentManager().beginTransaction().replace(R.id.fragment1, fragment).commit();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}
}
