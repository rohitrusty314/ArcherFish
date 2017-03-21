package org.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class l1Compl extends Activity {
	Button btn1,btn2,btn3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l1comp);
		
		
		btn1 = (Button) findViewById(R.id.btnHomeCompl);
		btn2 = (Button) findViewById(R.id.retry);
		btn3 = (Button) findViewById(R.id.btnnxtLvl);
		
		
		 btn1.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					Intent i=new Intent(l1Compl.this,ArcherFish1Activity.class);
					startActivity(i);
				}
			});
		 
		 btn3.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					Intent i=new Intent(l1Compl.this,play2Level2.class);
					startActivity(i);
				}
			});

		 
		 btn2.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					Intent i=new Intent(l1Compl.this,play2.class);
					startActivity(i);
				}
			});
		 
		 
	}

}
