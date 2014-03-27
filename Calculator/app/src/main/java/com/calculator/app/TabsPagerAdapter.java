package com.calculator.app;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fragments = new ArrayList<Fragment>();
		fragments.add(new CalculatorFragment());
		fragments.add(new ConverterFragment());

	}
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
		
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
}
