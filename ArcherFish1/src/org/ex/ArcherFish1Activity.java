package org.ex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;

public class ArcherFish1Activity extends Activity {
	DataManipulator dm;
	Button create_button,load_button,deleteAll_button,exit_button;
	
	@Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        dm = new DataManipulator(this);
	        create_button = (Button) findViewById(R.id.button1);
	        load_button = (Button) findViewById(R.id.button2);
	        deleteAll_button = (Button) findViewById(R.id.button3);
	        
	        
	        create_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {

					Intent i = new Intent(ArcherFish1Activity.this, SaveData.class);  
	                startActivity(i);
					
				}
			});
	        
	        load_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
                    finish();
					Intent i = new Intent(ArcherFish1Activity.this, CheckData.class);  
	                startActivity(i);
					
				}
			});
	        
	        deleteAll_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {

					dm.deleteAll();
				}
			});

	      
	   }
    @Override
    public void onBackPressed() {
    	
    	// TODO Auto-generated method stub
   // 	super.onBackPressed();
    	Log.d("back", "pressed");
    	
    	finish();
    	
    	return;   
    }



}
