package org.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Pause extends Activity {
	
	Button resume_button;
	Button new_button;
	Button exit_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pause);
		
	//	Bundle extras = getIntent().getExtras();
	  //     final int[] val = extras.getIntArray("resume_details");	
		   resume_button = (Button)findViewById(R.id.btnPauseResume);
	       new_button = (Button)findViewById(R.id.btnPauseNewGame);
	       exit_button = (Button)findViewById(R.id.btnPauseExit);
	       
	       
	       resume_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(Pause.this,play2.class);
	//				i.putExtra("resume_details", val);
					startActivity(i);
					finish();
				}
			});
	        

	        
	        new_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					Intent i=new Intent(Pause.this,play2.class);
					startActivity(i);
				}
			});

	        exit_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
	
					Intent i=new Intent(Pause.this,ProfileData.class);
					startActivity(i);
					finish();
				}
			});

	}

}
