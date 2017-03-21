package org.ex;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameView extends RelativeLayout  {
    private Bitmap bmp,bis,bkg;
 
  
    
	private MediaPlayer mp1;
	int resId;
	
    int find=2,findTemp;
    static final int[] fish1 = new int[] {
    	R.drawable.f111,R.drawable.f112,R.drawable.f113,R.drawable.f114,R.drawable.f115,R.drawable.f116
    };

    

    static final int[] bbl1 = new int[] {
    	R.drawable.bbl1
    };
   

    private long stIns1 = 0L;
    private long fnIns1 = 0L;
    private long startTime = 0L;
	int extra,count=0;
	int minutes=0,i=0;
	int seconds = 0;
    
    Thread th;
	
    
    int bx,by,mode;
    int fx,fy,wd,ht;
    boolean flagShoot = false,move=false,backPress = false;
    int height,width;
    int score = 0;
    int count_init=0;
    float tx,ty;
    
    Context contxt1;
    RelativeLayout r1;
    ImageView pauseImv,shootImv;
    TextView textImv;
    long timeLeft;
    
    private List<Sprite> sprites = new ArrayList<Sprite>();
    Paint p;
    
        		public GameView(Context context){
        			
        			super(context);
        			
        			/*wd = getWidth();
        			ht = getHeight();
        			Log.d("width",Integer.toString(wd));
        			Log.d("height",Integer.toString(ht));
        	        fx = wd/2;
        	        fy=ht/2;
        	        Log.d("fx",Integer.toString(fx));
        			Log.d("fy",Integer.toString(fy));*/
        	        
        	        
        	        new CountDownTimer(30000, 1000) {

        	            public void onTick(long millisUntilFinished) {
        	            	timeLeft = millisUntilFinished;
        	            }

        				@Override
        				public void onFinish() {
        					// TODO Auto-generated method stub
        					
        				}

        	         }.start();
        			
                    p = new Paint();
        			contxt1=context;
        			win_const_code();
        			/*initialize();
        	        fx=this.getWidth()/3;
        	        fy=this.getHeight()/3;
        	        Log.d("fx",Integer.toString(fx));
        			Log.d("fy",Integer.toString(fy));*/
        	        
          this.setWillNotDraw(false);
          bkg = BitmapFactory.decodeResource(getResources(), R.drawable.lvl1bg1);


          sprites.add(createSprite(R.drawable.ins2));
          sprites.add(createSprite(R.drawable.ins3));
          sprites.add(createSprite(R.drawable.ins4));
          sprites.add(createSprite(R.drawable.ins5));
          sprites.add(createSprite(R.drawable.ins6));
          sprites.add(createSprite(R.drawable.ins7));
          sprites.add(createSprite(R.drawable.ins2));
          sprites.add(createSprite(R.drawable.ins3));
          sprites.add(createSprite(R.drawable.ins4));
          sprites.add(createSprite(R.drawable.ins5));
          sprites.add(createSprite(R.drawable.ins6));
          sprites.add(createSprite(R.drawable.ins7));

        invalidate(); 
    }
    
       
     
    private Sprite createSprite(int resouce) {
         Bitmap bis1 = BitmapFactory.decodeResource(getResources(), resouce);
         return new Sprite(this,bis1);
        	       }
    
    @Override
    protected void onDraw(final Canvas canvas) {
    	//if(!backPress){
        //Log.d("cnt",Integer.toString(count_init));
    	initialize(count_init);
    	count_init=5;
    	//Log.d("cnt",Integer.toString(count_init));
        canvas.drawBitmap(bkg,0,0, null);

        
        p.setTextSize(30);
		canvas.drawText(String.format("%04d", score), 375,80 , p);
        //timer
		//if(mode==0){
		long millis = System.currentTimeMillis() - startTime;
	       seconds = (int) (millis / 1000);
	       if((seconds!=0) && (count==0))
	          extra=seconds;
		   count=(count+1);
	       seconds     = (seconds-extra)%60;

	
		   canvas.drawText(String.format("%d",timeLeft), 375,30 , p);

		if(seconds==59 && i==0){
			minutes = minutes + 1;
			i++;
		}
		if(seconds!=59 && i!=0)
			i=0;

		if(score>=180){
	        Intent i=new Intent(getContext(),l1Compl.class);
			  getContext().startActivity(i);
			  ((Activity) getContext()).finish();
	      }	
		
		else if(seconds==50 && minutes==0 && score<100){
        Intent i=new Intent(getContext(),l1Fail.class);
		  getContext().startActivity(i);
		  ((Activity) getContext()).finish();
      }


      
	     if(move!=false){
	    	 moveFish((int)tx,(int)ty);
	     }
		
        bmp = BitmapFactory.decodeResource(getContext().getResources(),fish1[find] );
        
        canvas.drawBitmap(bmp, fx, fy, null);
        
        
	    Bitmap imbbl = BitmapFactory.decodeResource(getContext().getResources(),bbl1[0]);
        if(flagShoot){
        	 canvas.drawBitmap(imbbl,bx,by,null);
        	       
        	switch(find){
        	case 0:bx -= 30;//bmp.getWidth();
        	       by -= 10 ;//bmp.getHeight()+20;
        	 
        	       break;
        	case 1:bx -= 25;//bmp.getWidth();
    	           by -= 25 ;//bmp.getHeight()+20;
             
                   break;
        	case 2:bx -= 10;//bmp.getWidth();
    	           by -= 30 ;//bmp.getHeight()+20;
             
                   break;
        	case 3:bx += 10 ;//bmp.getWidth();
    	           by -= 30 ;//bmp.getHeight()+20;
             
                   break;
        	case 4:bx += 25;//bmp.getWidth();
    	           by -= 25 ;//bmp.getHeight()+20;
             
                   break;
        	case 5:bx += 30;//bmp.getWidth();
    	           by -= 10 ;//bmp.getHeight()+20;
             
                   break;
        	}
         }
        
        if(bx<0||bx>getWidth()||by<0||by>getHeight()){
        	flagShoot = false;
        }
        for (Sprite sprite : sprites) {
             sprite.onDraw(canvas,bx,by);
             if(sprite.collision(bx, by)){
            	 score += 10;
            	 resId = R.raw.m5;
                 if(mp1 != null){
                 	mp1.release();
                 }
                 
                 mp1 = MediaPlayer.create(contxt1, resId);
                 mp1.start();
            	 bx = 500;
            	 by=1000;
             }
        }
    }
    
    void moveFish(int sx,int sy){
    	if(sy>(getHeight()*(2/3))){
    		
    	if(sx<fx){
    		find = 0;
    		move=true;
    		fx-=10;
    	}
    	else if(sx>fx+75){
    		find=5;
    		move=true;
    		fx+=10;
    		
    	}
    	else if(sx>=fx && sx<=fx+50){
    		move=false;
    	}
    	}
    		
    		
    
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if(event.getAction()==MotionEvent.ACTION_DOWN){
         tx = event.getX();
         ty = event.getY();
         
         if(!flagShoot){
         if(tx<fx && ty<(fy-20)){
        	 if(find!=0){
        		 find=find-1;;
        	 }
         }
         else if(tx>fx && ty<(fy-20)){
        	 if(find!=5){
        		 find=find+1;
        	 }
          }
         
        }
         
         //for bubbles
         if(tx>=0 && tx<=50 && ty >=(getHeight()-60) && ty<=getHeight()){
        	 switch(find){
         	 case 0:bx = fx-30;//220;//bmp.getWidth();
         	       by = fy+5 ;//bmp.getHeight()+20;
         	 //      canvas.drawBitmap(imbbl, bx, by, null);
         	       break;
         	 case 1:bx = fx-30;//bmp.getWidth();
  	               by = fy-40 ;//bmp.getHeight()+20;
 	           //    canvas.drawBitmap(imbbl, bx, by, null);
 	               break;
         	 case 2:bx = fx-25;//bmp.getWidth();
  	               by = fy-20;//610 ;//bmp.getHeight()+20;
 	             //  canvas.drawBitmap(imbbl, bx, by, null);
 	               break;
         	 case 3:bx = fx+5;//255;//bmp.getWidth();
  	               by = fy-35;//585 ;//bmp.getHeight()+20;
 	               //canvas.drawBitmap(imbbl, bx, by, null);
 	               break;
         	 case 4:bx = fx+60;//310;//bmp.getWidth();
  	               by = fy-15;//605 ;//bmp.getHeight()+20;
 	               //canvas.drawBitmap(imbbl, bx, by, null);
 	               break;
         	 case 5:bx = fx+90;
  	               by = fy-5;
                   break;
         	}
        	 flagShoot = true;
         }
         
         //for eating
         for (int i = sprites.size() - 1; i >= 0; i--) {
             Sprite sprite = sprites.get(i);
             if (sprite.isCollition(tx, ty)) {
            	   score += 5;
                   sprites.remove(sprite);
                   fx = (int) tx;
                   break;
             }
         }
         
         
         //for pause
         if(tx>=0 && tx<=50 && ty >=15 && ty<=65){
          //   int[] value = {minutes,seconds,extra,score};
        	 Intent i=new Intent(getContext(),Pause.class);
        //	 i.putExtra("resume_details", value);
     		 getContext().startActivity(i);
     		 
         }
         
         //linear motion of the fish
         if(ty>=(getHeight()*3)/4 && ty<=(getHeight()-60)){
        	 Log.d("Linear motion","Linear motion");
        	findTemp = find;
        		
        				//	th.sleep(20);
					moveFish((int)tx,(int)ty);
			
			 }
         invalidate();
    	}
          return true;
    }
    
    void win_const_code(){
		this.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
		
	     r1=new RelativeLayout(contxt1);
	     r1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
	     
	//     this.setBackgroundResource(R.drawable.lvl1bg1);
	     this.addView(r1);
		
      
      		
	}

    
	public void initialize(int count_init){
		width=this.getWidth(); height=this.getHeight();
		if(count_init==0){
			Log.d("cnt",Integer.toString(count_init));
		  Log.d("ininit-wid", Integer.toString(width));
		  Log.d("ininit-ht", Integer.toString(height));
		  fx=width/4;
	   	  fy=height-height/5;
		  count_init=5;
		  Log.d("cnt",Integer.toString(count_init));
		}

	      		
	   pauseImv=new ImageView(contxt1);pauseImv.setId(90);	 
	   pauseImv.setImageResource(R.drawable.pause);  pauseImv.setAdjustViewBounds(true); 
	   RelativeLayout.LayoutParams pauseImv_rlp=
             new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                     RelativeLayout.LayoutParams.WRAP_CONTENT);
	   pauseImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
	   pauseImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
	   pauseImv_rlp.width=width/10; pauseImv_rlp.height=height/9;//adjusting h,w to screen h,w 
	   r1.addView(pauseImv,pauseImv_rlp);
	   
	   
	   shootImv=new ImageView(contxt1);shootImv.setId(92);		 
	   shootImv.setImageResource(R.drawable.shoot1);  shootImv.setAdjustViewBounds(true);
	    RelativeLayout.LayoutParams shootImv_rlp=
               new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
		                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
	    shootImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
	    shootImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
	    shootImv_rlp.width=width/10; shootImv_rlp.height=height/9;//adjusting h,w to screen h,w
	    r1.addView(shootImv, shootImv_rlp);
	 
       
	    textImv=new TextView(contxt1);textImv.setId(95);		 
		   
		    RelativeLayout.LayoutParams textImv_rlp=
	               new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
			                                        RelativeLayout.LayoutParams.WRAP_CONTENT);
		    textImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		    textImv_rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		    textImv_rlp.width=width/10; textImv_rlp.height=height/9;//adjusting h,w to screen h,w
		    r1.addView(textImv, textImv_rlp);
		    
			 
	 
	}
}