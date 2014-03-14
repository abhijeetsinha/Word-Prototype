package com.example.testword5;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MyFragment2 extends Activity {

	private static final String TITLES[]={"Back","New", "Open","Make a copy","History","Settings"};
	private static final String INFO[]={"This is NEW fragment","This is OPEN fragment",
		"This is MAKE A COPY fragment","This is HISTORY fragment","This is SETTINGS fragment"};
	static Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity=this;
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		setContentView(R.layout.fragment_layout);
	}

	
	public static class DetailsActivity extends Activity{
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				finish();
				return;
			}
			if (savedInstanceState == null) {
				DetailsFragment details = new DetailsFragment();
				details.setArguments(getIntent().getExtras());
				getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
			}
		}
	}
	
	public static class TitlesFragment extends ListFragment{
		boolean mDualPane;
		int mCurCheckPosition = 1;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
			setListAdapter(new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_activated_1,
					TITLES));
			
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null) {
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 1);
			}
			
			if (mDualPane) {
				getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				showDetails(mCurCheckPosition);
			} 
			
			else {
				getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				getListView().setItemChecked(mCurCheckPosition, true);
				//getListView().setBackgroundColor("#357ec7");
			}
		}
		
		
		
	
		/*public View getView(int position, View convertView, ViewGroup parent){
			View v = super.getView(position,convertView,parent);
			TextView text=(TextView)v.findViewById(android.R.id.text1);
			text.setTextColor(Color.WHITE);
			return v;
		}*/
		
		@Override
		public void onViewCreated(View v, Bundle savedInstanceState){
			super.onViewCreated(v, savedInstanceState);
			ListView l=getListView();
			l.setBackgroundColor(Color.parseColor("#357ec7"));
		}
		
		@Override
		public void onSaveInstanceState(Bundle outState) {
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}
		
		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			showDetails(position);
		}
		
		void showDetails(int index) {
			
			if(index==0)
				activity.finish();
			else{
				mCurCheckPosition = index;
				
				if (mDualPane) {
					getListView().setItemChecked(index, true);
					DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
					
					if (details == null || details.getShownIndex() != index) {
						details = DetailsFragment.newInstance(index);

						FragmentTransaction ft = getFragmentManager().beginTransaction();
						ft.replace(R.id.details, details);
						ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
						ft.commit();
					}

				} else {

					Intent intent = new Intent();
					intent.setClass(getActivity(), DetailsActivity.class);
					intent.putExtra("index", index);
					startActivity(intent);
				}
			}
			
		}
		
	}
	
	public static class DetailsFragment extends Fragment{
		
		public static DetailsFragment newInstance(int index) {
			DetailsFragment f = new DetailsFragment();

			Bundle args = new Bundle();
			args.putInt("index", index);
			f.setArguments(args);

			return f;	
		}

		public int getShownIndex() {
			return getArguments().getInt("index", 0);
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			ScrollView scroller = new ScrollView(getActivity());
			TextView text = new TextView(getActivity());
			int padding = (int) TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
							.getResources().getDisplayMetrics());
			text.setPadding(padding, padding, padding, padding);
			scroller.addView(text);
			text.setText(INFO[getShownIndex()-1]);
			return scroller;
		}
	}

}
