package org.ex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;

public class Difficulty extends Activity{
	private RadioButton easyButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.difficulty);
		easyButton = (RadioButton)  findViewById(R.id.widget2);
		easyButton.setChecked(true);
	}

}
