package org.ex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class play2Level2 extends Activity {

	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Bundle extras = getIntent().getExtras();
	        int[] value = extras.getIntArray("game start");
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(new GameView2(this,value));
	    }

}
