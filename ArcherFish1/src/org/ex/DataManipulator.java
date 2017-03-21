package org.ex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;



public class DataManipulator {
	
	 private static final  String DATABASE_NAME = "mydatabase4.db";
	    private static final int DATABASE_VERSION = 1;
	    static final String TABLE_NAME = "newtable4";
	    private static Context context;
	    static SQLiteDatabase db;
	    private SQLiteStatement insertStmt;
	    UserDetails ud[]; 
	    String[] b1,b2;
	    private static final String INSERT = "insert into " + TABLE_NAME + " (name,score,time,levelcompleted,levelplaying,difficulty,music,sfx,mode) values (?,?,?,?,?,?,?,?,?)";
	    public DataManipulator(Context context) {
	        DataManipulator.context = context;
	        OpenHelper openHelper = new OpenHelper(DataManipulator.context);
	        DataManipulator.db = openHelper.getWritableDatabase();
	        this.insertStmt = DataManipulator.db.compileStatement(INSERT);
	    }
	    public long insert(String name,String score,String time,String levelcompleted,String levelplaying,String difficulty,String music,String sfx,String mode) {
	        this.insertStmt.bindString(1, name);
	        this.insertStmt.bindString(2, score);
	        this.insertStmt.bindString(3, time);
	        this.insertStmt.bindString(4, levelcompleted);
	        this.insertStmt.bindString(5, levelplaying);
	        this.insertStmt.bindString(6, difficulty);
	        this.insertStmt.bindString(7, music);
	        this.insertStmt.bindString(8, sfx);
	        this.insertStmt.bindString(9, mode);

	        return this.insertStmt.executeInsert();
	    }
	    public void deleteAll() {
	        db.delete(TABLE_NAME, null, null);
	   //   db.execSQL("DROP TABLE" + TABLE_NAME);
	    }
	    public List<String[]> selectAll()
	    {
	        List<String[]> list = new ArrayList<String[]>();
	        Cursor cursor = db.query(TABLE_NAME, new String[] { "id","name","score","time","levelcompleted","levelplaying","difficulty","music","sfx","mode" }, null, null, null, null, "score desc"); 
	   //     ud.name = cursor.getString(1);
		    /*   ud.score = cursor.getString(2);
		       ud.time = cursor.getString(3);
		       ud.levelcompleted = cursor.getString(4);
		       ud.levelplaying = cursor.getString(5);
		       ud.difficulty = cursor.getString(6);
		       ud.music = cursor.getString(7);
		       ud.sfx = cursor.getString(8);
		       ud.mode = cursor.getString(9);*/
	        int x=0;
	        int i=0;
	        if (cursor.moveToFirst()) {
	           do {
	              b1=new String[]{cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
	            		  cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9)};
	          //    b2=new String[]{cursor.getString(3),cursor.getString(4),cursor.getString(5),
	            //		  cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9)};
	                list.add(b1);
	              /*  ud[i].score = b1[1];
	 		       ud[i].time = b1[2];
	 		       ud[i].levelcompleted = b2[0];
	 		       ud[i].levelplaying = b2[1];
	 		       ud[i].difficulty = b2[2];
	 		       ud[i].music = b2[3];
	 		       ud[i].sfx = b2[4];
	 		       ud[i++].mode = b2[5];*/
	                x=x+1;
	           } while (cursor.moveToNext());
	        }
	        if (cursor != null && !cursor.isClosed()) {
	           cursor.close();
	        } 
	        
	        cursor.close();
	   //     addAll(b1,b2,ud.details);
	     //   ud.score = b1[1];
		    /*   ud.time = cursor.getString(3);
		       ud.levelcompleted = cursor.getString(4);
		       ud.levelplaying = cursor.getString(5);
		       ud.difficulty = cursor.getString(6);
		       ud.music = cursor.getString(7);
		       ud.sfx = cursor.getString(8);
		       ud.mode = cursor.getString(9);*/
	        
	        return list;
	   }
	  /* private void addAll(String[] b12, String[] b22,String[] temp) {
			// TODO Auto-generated method stub
		   //String[] temp;
		   int i,j;
		   for(i=0;i<b12.length;i++)
			temp[i] = b12[i];
		  for(j=0;j<b22.length;j++)
			  temp[i++]=b22[j];
		}*/
	    
	    public void updateDb(int score,String uname){
	    	ContentValues values = new ContentValues();
	    	 	    	values.put("score",String.valueOf(score) );
	    	 
	    	String where ="name=?";
	    	String[] whereArgs = {uname};
	    	db.update(TABLE_NAME, values, where,whereArgs);
	    }
	public void delete(int rowId) {
	        db.delete(TABLE_NAME, null, null); 
	   }
	   private static class OpenHelper extends SQLiteOpenHelper {
	        OpenHelper(Context context) {
	             super(context, DATABASE_NAME, null, DATABASE_VERSION);
	        }
	        @Override
	        public void onCreate(SQLiteDatabase db) {
	             db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY, name TEXT, score TEXT,time TEXT,levelcompleted TEXT,levelplaying TEXT,difficulty TEXT, music TEXT,sfx TEXT,mode TEXT)");
	        }
	        @Override
	        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	        {
	             db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	             onCreate(db);
	        }
	   }

}
