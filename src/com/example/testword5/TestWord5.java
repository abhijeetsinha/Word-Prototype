package com.example.testword5;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ActionBar.LayoutParams;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class TestWord5 extends Activity {

	private Spinner fontface;
	private Spinner fontsize;
	private Spinner textStyles;
	private Button file;
	private Button home;
	private Button insert;
	private Button layout;
	private Button review;
	private Button view;
	private EditText editor;
	private ImageButton keyboardlock;
	private ImageButton keyboardunlock;
	private ImageView keyboard;
	
	private Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_test_word5);
		
		file=(Button)findViewById(R.id.button_file);
		home=(Button)findViewById(R.id.button_home);
		insert=(Button)findViewById(R.id.button_insert);
		layout=(Button)findViewById(R.id.button_layout);
		review=(Button)findViewById(R.id.button_review);
		view=(Button)findViewById(R.id.button_view);
		
		home.setBackgroundColor(0x0000);
		
		fontface=(Spinner)findViewById(R.id.spinner_fontface);
		final ArrayAdapter<CharSequence> adapter_fontface=ArrayAdapter.createFromResource(this,R.array.spinner_fontface,android.R.layout.simple_spinner_item);
		adapter_fontface.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fontface.setAdapter(adapter_fontface);
		
		fontsize=(Spinner)findViewById(R.id.spinner_fontsize);
		final ArrayAdapter<CharSequence> adapter_fontsize=ArrayAdapter.createFromResource(this,R.array.spinner_fontsize,android.R.layout.simple_spinner_item);
		adapter_fontsize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fontsize.setAdapter(adapter_fontsize);
		
		textStyles=(Spinner)findViewById(R.id.spinner_textstyles);
		final ArrayAdapter<CharSequence> adapter_textstyles=ArrayAdapter.createFromResource(this,R.array.spinner_textstyles,android.R.layout.simple_spinner_item);
		adapter_textstyles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		textStyles.setAdapter(adapter_textstyles);
	
		editor = (EditText) findViewById(R.id.editor);
	    LinearLayout floatView = (LinearLayout) findViewById(R.id.floating_view);
	    floatView.setVisibility(LinearLayout.GONE);
	    /*floatView.setX(300);
	    floatView.setY(300);
	    editor.setLongClickable(true);
	    editor.setOnLongClickListener(new OnLongClickListener(){
	        public boolean onLongClick(View v){
	            ((EditText)v).setText("");
	            return true;
	        }
	    });*/
		
		file.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*AlertDialog.Builder builder = new AlertDialog.Builder(TestWord5.this);
				LayoutInflater inflater = TestWord5.this.getLayoutInflater();
				builder.setView(inflater.inflate(R.layout.backstage, null));     
				builder.show();*/
				//FragmentManager fragmentManager = getFragmentManager();
				//CustomDialogFragment newFragment= new CustomDialogFragment();
				
				i=new Intent(TestWord5.this,MyFragment2.class);
				//i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
				//startActivityForResult(i,Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(i);
				
			}
			
		});
		
		home.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	            LinearLayout ribbonLayout = (LinearLayout)findViewById(R.id.ribbon_entry);
	            ribbonLayout.removeAllViews();
	 
	            LayoutInflater inflater = getLayoutInflater();
	            ribbonLayout.addView(inflater.inflate(R.layout.ribbon_home, null));
	            home.setBackgroundColor(0x0000);
	            insert.setBackgroundColor(Color.LTGRAY);
	            layout.setBackgroundColor(Color.LTGRAY);
	            review.setBackgroundColor(Color.LTGRAY);
	            view.setBackgroundColor(Color.LTGRAY);
	            
			}
			
		});
		
		insert.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	            LinearLayout ribbonLayout = (LinearLayout)findViewById(R.id.ribbon_entry);
	            ribbonLayout.removeAllViews();
	 
	            LayoutInflater inflater = getLayoutInflater();
	            ribbonLayout.addView(inflater.inflate(R.layout.ribbon_insert, null));

	            home.setBackgroundColor(Color.LTGRAY);
	            insert.setBackgroundColor(0x0000);
	            layout.setBackgroundColor(Color.LTGRAY);
	            review.setBackgroundColor(Color.LTGRAY);
	            view.setBackgroundColor(Color.LTGRAY);
	            
			}
			
		});
		
		layout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	            LinearLayout ribbonLayout = (LinearLayout)findViewById(R.id.ribbon_entry);
	            ribbonLayout.removeAllViews();
	 
	            LayoutInflater inflater = getLayoutInflater();
	            ribbonLayout.addView(inflater.inflate(R.layout.ribbon_layout, null));

	            home.setBackgroundColor(Color.LTGRAY);
	            insert.setBackgroundColor(Color.LTGRAY);
	            layout.setBackgroundColor(0x0000);
	            review.setBackgroundColor(Color.LTGRAY);
	            view.setBackgroundColor(Color.LTGRAY);
	            
			}
			
		});
		
		review.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	            LinearLayout ribbonLayout = (LinearLayout)findViewById(R.id.ribbon_entry);
	            ribbonLayout.removeAllViews();
	 
	            LayoutInflater inflater = getLayoutInflater();
	            ribbonLayout.addView(inflater.inflate(R.layout.ribbon_review, null));
	 
	            home.setBackgroundColor(Color.LTGRAY);
	            insert.setBackgroundColor(Color.LTGRAY);
	            layout.setBackgroundColor(Color.LTGRAY);
	            review.setBackgroundColor(0x0000);
	            view.setBackgroundColor(Color.LTGRAY);
	            
			}
			
		});
		
		view.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	            LinearLayout ribbonLayout = (LinearLayout)findViewById(R.id.ribbon_entry);
	            ribbonLayout.removeAllViews();
	 
	            LayoutInflater inflater = getLayoutInflater();
	            ribbonLayout.addView(inflater.inflate(R.layout.ribbon_view, null));

	            home.setBackgroundColor(Color.LTGRAY);
	            insert.setBackgroundColor(Color.LTGRAY);
	            layout.setBackgroundColor(Color.LTGRAY);
	            review.setBackgroundColor(Color.LTGRAY);
	            view.setBackgroundColor(0x0000);
	       
			}
			
		});
		
		keyboardlock=(ImageButton)findViewById(R.id.button_keyboardlock);
		keyboardunlock=(ImageButton)findViewById(R.id.button_keyboardunlock);
		keyboard=(ImageView)findViewById(R.id.keyboardicon_up);
		
		keyboardunlock.setEnabled(false);
		
		keyboardlock.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int[] coordinates=new int[2];
				keyboardlock.getLocationOnScreen(coordinates);
				Log.d("MYTAG","Reached1");
				System.out.println(coordinates[0]);
				System.out.println(coordinates[1]);
				Log.d("MYTAG","Reached2");
				keyboard.setImageResource(R.drawable.keyboard_lock);
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.setMargins(1730,720,0,0);
				keyboard.setLayoutParams(params);
				keyboardlock.setEnabled(false);
				keyboardunlock.setEnabled(true);
			}
			
		});
		
		keyboardunlock.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				keyboard.setImageResource(R.drawable.keyboard_invoke);
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.setMargins(1822,720,0,0);
				keyboard.setLayoutParams(params);
				keyboardunlock.setEnabled(false);
				keyboardlock.setEnabled(true);
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_word5, menu);
		return true;
	}

}
