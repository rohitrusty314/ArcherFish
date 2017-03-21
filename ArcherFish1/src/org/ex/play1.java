package org.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class play1 extends Activity {
	
	Button home_button,set_button,new_button,quit_button,resume_button;
    
	 @Override
	   public void onBackPressed() {
	   	
	   	// TODO Auto-generated method stub
	  // 	super.onBackPressed();
	   	Log.d("back", "pressed");
		    Intent i = new Intent(play1.this,ProfileData.class);
			startActivity(i);
	   	finish();
	   	
	   	return;   
	   }

	String str2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.play1);
		
	     Bundle extras = getIntent().getExtras();
		 str2 = extras.getString("user_details");
		
	//	set_button = (Button) findViewById(R.id.btnSet2);
	//	home_button = (Button) findViewById(R.id.btnHome1);
		new_button = (Button) findViewById(R.id.btnNewGame);
		resume_button = (Button) findViewById(R.id.btnResume);
		quit_button = (Button) findViewById(R.id.btnQuit);
		
/*		 set_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					Intent i=new Intent(play1.this,Setting.class);
					startActivity(i);
				}
			});*/
		 
		/* home_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i=new Intent(play1.this,ArcherFish1Activity.class);
					startActivity(i);
				}
			});*/
		
		resume_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				Intent i=new Intent(play1.this,play2.class);
				i.putExtra("user_details", str2);
				startActivity(i);
			}
		});
	
		
		 new_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(play1.this,play.class);
					i.putExtra("user_details", str2);
					startActivity(i);
					finish();
				}
			});
		 
		 quit_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
				   finish();
				}   
				});
	}


}
