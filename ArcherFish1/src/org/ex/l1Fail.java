package org.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class l1Fail extends Activity {
	Button btn1,btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l1fail);
		btn1 = (Button) findViewById(R.id.quitHome);
		btn2 = (Button) findViewById(R.id.retryFail);

		 btn1.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(l1Fail.this,ProfileData.class);
					startActivity(i);
					finish();
				}
			});
		 
		 btn2.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Intent i=new Intent(l1Fail.this,play2.class);
					startActivity(i);
					finish();
				}
			});
	}
	
	

}
