package org.ex;


import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProfileData extends Activity {
    
	private MediaPlayer mp;
	
	/** Called when the activity is first created. */
	Button play_button;
	Button set_button;
	Button instr_button;
    Button exit_button;
    Button about_button;
    int resId;
    
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.layout.menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch(item.getItemId()){
    	case R.id.settings:
    		startActivity(new Intent(this, Prefs.class));
    	}
    	
    	
    	return false;
    }*/
    String str2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.profile);
       
       Bundle extras = getIntent().getExtras();
	   str2 = extras.getString("user_details");
	   
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        play_button = (Button)findViewById(R.id.btnPlay);
        instr_button = (Button)findViewById(R.id.btnInstr);
        set_button = (Button)findViewById(R.id.btnSet);
        exit_button = (Button)findViewById(R.id.btnExit);
      
        

        resId = R.raw.m1;
        if(mp != null){
        	mp.release();
        }
        
      //  mp = MediaPlayer.create(this, resId);
    //    mp.start();
        play_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
				// TODO Auto-generated method stub
				finish();
				Intent i=new Intent(ProfileData.this,play1.class);
				i.putExtra("user_details", str2);
				startActivity(i);
				
			}
		});
        

        
        instr_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ProfileData.this,Instruction.class);
		//		i.putExtra("user_details", str2);
				startActivity(i);
			}
		});

        set_button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    finish();
				Intent i=new Intent(ProfileData.this,SetTopics.class);
				i.putExtra("user_details", str2);
				startActivity(i);
			}
		});
  exit_button.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
	    mp.release();
		finish();
		
	
		}   
		});
		

    }
    @Override
    public void onBackPressed() {
    	
    	// TODO Auto-generated method stub
   // 	super.onBackPressed();
    	Log.d("back", "pressed");
 	   // Intent i = new Intent(ProfileData.this,ArcherFish1Activity.class);
 	//	startActivity(i);
    	finish();
    	
    	return;   
    }

}