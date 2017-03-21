package org.ex;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;







	public class play2 extends Activity {
		Boolean isBackPressed = false;
	    /** Called when the activity is first created. */
		GameView ve;
		DataManipulator db;
		String str2;
		String[] user;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
            db = new DataManipulator(this);
		    Bundle extras = getIntent().getExtras();
			str2 = extras.getString("user_details");
			
			user = str2.split("-");
	        
			requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
			ve = new GameView(this);
	        setContentView(ve);
	    }
	
	    
	    @Override
	    public void onBackPressed() {
	    	
	
	    	isBackPressed = true;
	    	showDialog(0);
	    	
	    	return;   
	    }
	    
       	    
	    @Override
	    protected Dialog onCreateDialog(int id) {
	
	    	Dialog dialog = null;    	
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You want to quit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            play2.this.finish();
                            Intent i=new Intent(play2.this,ProfileData.class);
        					startActivity(i);
                    }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	isBackPressed = false;
                            dialog.cancel();
                    }
            });
            AlertDialog alert = builder.create(); 
            dialog = alert;
            alert.show();
    

	    	return dialog;
	    	
	    }
	    
	    @Override
	    protected void onPause() {
	    	super.onPause();
	        
            	  
	 
	    }
	    private void upd() {
	        String nam = user[1];
	    	finish();
	    	db.updateDb(ve.score,nam);
			
		}
		@Override
	    protected void onResume() {
	    	// TODO Auto-generated method stub
	    	super.onResume();
	    	return;
	    }
	    @Override
	    protected void onDestroy() {
	    	// TODO Auto-generated method stub
	    	super.onDestroy();
	    	upd();
	    	finish();
	    }
	    
	 }


