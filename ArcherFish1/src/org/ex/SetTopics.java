package org.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SetTopics extends Activity {
	
	Button profile_button;
	Button sounds_button;
	Button diff_button;
	Button mode_button;
    Button exit_button;
    
    String str2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.setop);
	    
	    Bundle extras = getIntent().getExtras();
		str2 = extras.getString("user_details");
		   
	    profile_button = (Button) findViewById(R.id.buttonPro);
	    sounds_button = (Button)findViewById(R.id.button1);
        diff_button = (Button)findViewById(R.id.button2);
        mode_button = (Button)findViewById(R.id.button3);
        exit_button = (Button)findViewById(R.id.button4);

        
        profile_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(SetTopics.this,ArcherFish1Activity.class);
				i.putExtra("user_details", str2);
				startActivity(i);
				finish();
			}
		});
        
         sounds_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(SetTopics.this,Prefs.class);
				i.putExtra("user_details", str2);
				startActivity(i);
			}
		});
         
         diff_button.setOnClickListener(new OnClickListener() {
 			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				Intent i=new Intent(SetTopics.this,Difficulty.class);
 				i.putExtra("user_details", str2);
 				startActivity(i);
 			}
 		});
         
         mode_button.setOnClickListener(new OnClickListener() {
 			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				Intent i=new Intent(SetTopics.this,Mode.class);
 				i.putExtra("user_details", str2);
 				startActivity(i);
 			}
 		});
         
         exit_button.setOnClickListener(new OnClickListener() {
 			
 			public void onClick(View v) {
 				
 				// TODO Auto-generated method stub
 				finish();			
 				Intent i=new Intent(SetTopics.this,ProfileData.class);
 				i.putExtra("user_details", str2);
 				startActivity(i);
 	
 			}
 		});
		
	}

}
