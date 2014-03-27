package com.calculator.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.app.FragmentManager;

public class MainActivity2 extends Activity implements ActionBar.TabListener {

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,getActionBar().getSelectedNavigationIndex());
		
	}

	private ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main2);
		
		
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		
		PagerAdapter pAdapter =new TabsPagerAdapter(getFragmentManager());
		mViewPager.setAdapter(pAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
			@Override
            public void onPageSelected(int position) {
                // When swiping between pages, select the
                // corresponding tab.
                getActionBar().setSelectedNavigationItem(position);
            }
		});
		
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText(R.string.title_section1)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section2)
				.setTabListener(this));
		
		ActionBar.TabListener tabListener= new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		
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
		mViewPager.setCurrentItem(tab.getPosition(),true);
		
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}
}
