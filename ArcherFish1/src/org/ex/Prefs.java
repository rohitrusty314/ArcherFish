package org.ex;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Prefs extends PreferenceActivity {
	
	String str2;
	String user[];
	CheckBox music_box;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.settings);
		Bundle extras = getIntent().getExtras();
		str2 = extras.getString("user_details");
		Log.d("det",str2);
		user = str2.split("-");

		 Log.d("det0",user[0]);
		 Log.d("det1",user[1]);
		 Log.d("det2",user[2]);

		 Log.d("det3",user[3]);
		 Log.d("det4",user[4]);
		 Log.d("det5",user[5]);

		 Log.d("det6",user[6]);
		 Log.d("det7",user[7]);

		 Log.d("det8",user[8]);
		 Log.d("det9",user[9]);
		music_box =   (CheckBox) findViewById(R.id.music1);
		if(user[8] == "true")
		 if(!music_box.isChecked())
	     	music_box.setChecked(true);
		 
	}
	

}
