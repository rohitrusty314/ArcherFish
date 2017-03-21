package org.ex;

import android.R.color;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class play extends Activity {

	
	 Button set_button,home_button,lvl1_button,lvl2_button,lvl3_button,btn;
	 private static final String TAG = "Archer-fish";
	 int val[] = {0,0};
	 String str2;
	 
	 /*private void openNewGameDialog(){
		 new AlertDialog.Builder(this).setTitle(R.string.new_game_title).setItems(R.array.difficulty,
				     new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int i) {
							// TODO Auto-generated method stub
							val[0] = i;
							startGame(i);
						}
					}
				 ).show();
	 }
	 
	 private void startGame(int i){
		 new AlertDialog.Builder(this).setTitle(R.string.mode_title).setItems(R.array.mode,
			     new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int j) {
						// TODO Auto-generated method stub
						val[1] = j;
						startGameMode(j);
					}
				}
			 ).show();

		 
	 }
	 
	 private void startGameMode(int j){
		
			Intent intnt=new Intent(play.this,play2.class);
			intnt.putExtra("game start",val);
			startActivity(intnt);
			finish();
			
	 }*/
	 @Override
	   public void onBackPressed() {
	   	
	   	// TODO Auto-generated method stub
	  // 	super.onBackPressed();
	   	Log.d("back", "pressed");
		    Intent i = new Intent(play.this,play1.class);
			startActivity(i);
	   	finish();
	   	
	   	return;   
	   }

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.play);
	        

		     Bundle extras = getIntent().getExtras();
			 str2 = extras.getString("user_details");
	        // new button
	        
	       /* btn = new Button(this);
	        btn.setText("Hello Button");
	        RelativeLayout.LayoutParams paramsd = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
	        		  LayoutParams.WRAP_CONTENT);
	        paramsd.height = 50;
	        paramsd.width = 50;
	        btn.setLayoutParams(paramsd);
	        addContentView(btn,paramsd);
	        btn.setCompoundDrawablesWithIntrinsicBounds(
	        		  0,     //left 
	        		  0,      //top
	        		  R.drawable.lvllock,  //right
	        		  0); 
	        */
	        //till here
	        
	      //  set_button = (Button)findViewById(R.id.btnSet1);
            home_button = (Button) findViewById(R.id.btnHome);	        
            lvl1_button = (Button) findViewById(R.id.btnLvl1);
            lvl2_button = (Button) findViewById(R.id.btnLvl2);
            lvl3_button = (Button) findViewById(R.id.btnLvl3);
	      /*  set_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i=new Intent(play.this,Setting.class);
					startActivity(i);
				}
			});*/
	        
	        lvl1_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method
					Intent i=new Intent(play.this,play2.class);
					i.putExtra("user_details", str2);
					startActivity(i);
					finish();
	//				openNewGameDialog();
				}
			});
	        

	        lvl2_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(play.this,play2Level2.class);
					
					startActivity(i);
					finish();
		//			openNewGameDialog();
				}
			});
	        

	        lvl3_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
			
					Intent i=new Intent(play.this,play2Level3.class);
					
					startActivity(i);
					finish();
					//openNewGameDialog();
				}
			});
home_button.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					Intent i=new Intent(play.this,ArcherFish1Activity.class);
					startActivity(i);
					finish();
				}
			});
  }
}
