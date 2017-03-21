package org.ex;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CheckData extends ListActivity {
	
	TextView selection;
    public int idToModify; 
    DataManipulator dm;
    List<String[]> list = new ArrayList<String[]>();
    List<String[]> names2 =null ;
    String[] stg1,str1,stg12,stg3;
    UserDetails ud[];
   // String[] det;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        dm = new DataManipulator(this);
        names2 = dm.selectAll();

	/*	str1[0] = dm.ud.name;
		str1[1] = dm.ud.score;
		str1[2] = dm.ud.time;
		str1[3] = dm.ud.levelcompleted;
		str1[4] = dm.ud.levelplaying;
		str1[5] = dm.ud.difficulty;
		str1[6] = dm.ud.music;
		str1[7] = dm.ud.sfx;
		str1[8] = dm.ud.mode;*/
        stg1=new String[names2.size()];
        stg3=new String[names2.size()];
        int x=0;
        String stg,stg2;
        for (String[] name : names2) {
        	/*   ud[x].det[0] = name[1];
        	   ud[x].det[1] = name[2];
		       ud[x].det[2] = name[3];
		       ud[x].det[3] = name[4];
		       ud[x].det[4] = name[5];
		       ud[x].det[5] = name[6];
		       ud[x].det[6] = name[7];
		       ud[x].det[7] = name[8];
		       ud[x].det[8] = name[9];*/
               stg = name[1]+"-"+name[2];
   
              stg2 = name[0]+"-"+name[1]+"-"+name[2]+"-"+name[3]+"-"+name[4]+"-"+name[5]+"-"+name[6]
                                     +"-"+name[7]+"-"+name[8]+"-"+name[9];                                                             
               Log.d("det",stg);
               Log.d("det",stg2);  
               stg1[x]=stg;
               stg3[x]=stg2;
               Log.d("det",stg3[x]);
               x++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stg1);
        this.setListAdapter(adapter);
        selection=(TextView)findViewById(R.id.selection);
   }      
   public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(stg1[position]);
        finish();
		Intent i=new Intent(CheckData.this,ProfileData.class);
		i.putExtra("user_details",stg3[position]);
		startActivity(i);
		

   }
   @Override
   public void onBackPressed() {
   	
   	// TODO Auto-generated method stub
  // 	super.onBackPressed();
   	    Log.d("back", "pressed");
   	    finish();
	    Intent i = new Intent(CheckData.this,ArcherFish1Activity.class);
		startActivity(i);
   	    finish();
   	
   	return;   
   }


}

