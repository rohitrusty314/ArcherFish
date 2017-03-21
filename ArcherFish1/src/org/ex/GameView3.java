package org.ex;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GameView3 extends RelativeLayout {
    private Bitmap bmp,bis,bkg;
    
    int find=2;
    static final int[] fish1 = new int[] {
    	R.drawable.f111,R.drawable.f112,R.drawable.f113,R.drawable.f114,R.drawable.f115,R.drawable.f116
    };

    

    static final int[] bbl1 = new int[] {
    	R.drawable.bbl1
    };
    //private SurfaceHolder holder;
    // private GameLoopThread gameLoopThread;
    //  private GameLayout gameLayout;
    //   private int x = 0; 
   
    //timer

    private long stIns1 = 0L;
    private long fnIns1 = 0L;
    private long startTime = 0L;
	int extra,count=0;
	int minutes=0,i=0;
    
    Thread th;
	
    int bx,by;
    int fx=250,fy=620;
    boolean flagShoot = false;
    int height,width;
    int score = 0;
    Context contxt1;
    RelativeLayout r1;
    ImageView pauseImv,shootImv;
    TextView textImv;
    private List<Sprite3> sprites3 = new ArrayList<Sprite3>();
    Paint p;
    
        		public GameView3(Context context){
        			
        			super(context);
                    p = new Paint();
        			contxt1=context;
        			win_const_code();
                    this.setWillNotDraw(false);

        	

          bkg = BitmapFactory.decodeResource(getResources(), R.drawable.lvl1bg1);

          
          sprites3.add(createSprite(R.drawable.ins2));
          sprites3.add(createSprite(R.drawable.ins3));
          sprites3.add(createSprite(R.drawable.ins4));
          sprites3.add(createSprite(R.drawable.ins5));
          sprites3.add(createSprite(R.drawable.ins6));
          sprites3.add(createSprite(R.drawable.ins7));
          sprites3.add(createSprite(R.drawable.ins2));
          sprites3.add(createSprite(R.drawable.ins3));
          sprites3.add(createSprite(R.drawable.ins4));
          sprites3.add(createSprite(R.drawable.ins5));
          sprites3.add(createSprite(R.drawable.ins6));
          sprites3.add(createSprite(R.drawable.ins7));
          sprites3.add(createSprite(R.drawable.ins2));
          sprites3.add(createSprite(R.drawable.ins3));
          sprites3.add(createSprite(R.drawable.ins4));
          sprites3.add(createSprite(R.drawable.ins5));
          sprites3.add(createSprite(R.drawable.ins6));
          sprites3.add(createSprite(R.drawable.ins7));
          sprites3.add(createSprite(R.drawable.ins2));
          sprites3.add(createSprite(R.drawable.ins3));
          sprites3.add(createSprite(R.drawable.ins4));
          sprites3.add(createSprite(R.drawable.ins5));
          sprites3.add(createSprite(R.drawable.ins6));
          sprites3.add(createSprite(R.drawable.ins7));
     
          invalidate(); 
    }
    
     
    private Sprite3 createSprite(int resouce) {
         Bitmap bis1 = BitmapFactory.decodeResource(getResources(), resouce);
         return new Sprite3(this,bis1);
        	       }

    @Override
    protected void onDraw(Canvas canvas) {
        int seconds = 0;
    	initialize();
        
        canvas.drawBitmap(bkg,0,0, null);
        
        p.setTextSize(30);
		canvas.drawText(String.format("%04d", score), 375,80 , p);
        //timer
		
		long millis = System.currentTimeMillis() - startTime;
	       seconds = (int) (millis / 1000);
	       if((seconds!=0) && (count==0))
	          extra=seconds;
		   count=(count+1);
	       seconds     = (seconds-extra)%60;

	
		   canvas.drawText(String.format("%02d:%02d", minutes, seconds), 375,30 , p);

		if(seconds==59 && i==0){
			minutes = minutes + 1;
			i++;
		}
		if(seconds!=59 && i!=0)
			i=0;
      
		if(score>=250){
	        Intent i=new Intent(getContext(),l1Compl.class);
	        ((Activity) getContext()).finish();
			  getContext().startActivity(i);
	      }	
		
		else if(seconds==59 && minutes==4 && score<250){
        Intent i=new Intent(getContext(),l1Fail.class);
        ((Activity) getContext()).finish();
		  getContext().startActivity(i);
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
        for (Sprite3 sprite : sprites3) {
             sprite.onDraw(canvas,bx,by);
             if(sprite.collision(bx, by)){
            	 score += 10;
            	 bx = 500;
            	 by=1000;
             }
        }
        //invalidate();  
      }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         float tx = event.getX();
         float ty = event.getY();
         
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
         if(tx>=0 && tx<=50 && ty >=690 && ty<=740){
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
         for (int i = sprites3.size() - 1; i >= 0; i--) {
             Sprite3 sprite = sprites3.get(i);
             if (sprite.isCollition(tx, ty)) {
            	   score += 5;
                   sprites3.remove(sprite);
                   fx = (int) tx;
                   break;
             }
         }
         
         
         //for pause
         if(tx>=0 && tx<=50 && ty >=15 && ty<=65){
        
        	 Intent i=new Intent(getContext(),Pause.class);
     		 getContext().startActivity(i);
         }
        	 
         
         invalidate();
          return true;
    }
    
    void win_const_code(){
		this.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
		
	     r1=new RelativeLayout(contxt1);
	     r1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
	     
	//     this.setBackgroundResource(R.drawable.lvl1bg1);
	     this.addView(r1);
		
      
      		
	}

    
	public void initialize(){
		width=this.getWidth(); height=this.getHeight();
		

	      		
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