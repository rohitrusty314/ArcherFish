package org.ex;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite3 {
 //   private static final int BMP_ROWS = 1;
 //   private static final int BMP_COLUMNS = 1;
    private int x = 100;
    private int y = 100;
    private int xSpeed = 20;
    private GameView3 gameView;
    private Bitmap bmp;
   // private int currentFrame = 0;
    private int width;
    private int height;
    private int ySpeed;
    boolean falling = false,fallen = false;
     
     
      public Sprite3(GameView3 gameView3, Bitmap bmp) {
		// TODO Auto-generated constructor stub
    	  
    	  this.gameView = gameView3;
          this.bmp = bmp;
          this.width = bmp.getWidth();// / BMP_COLUMNS;
          this.height = bmp.getHeight() ;/// BMP_ROWS;
          Random rnd = new Random();
      /*    x = rnd.nextInt(gameView.getWidth() - width);
          y = rnd.nextInt((gameView.getHeight()-300) - height);*/
          xSpeed = rnd.nextInt(25)-5;
          ySpeed = rnd.nextInt(25)-5;
	}

	private void update() {
            if (x > gameView.getWidth() - width - xSpeed || x + xSpeed < 0) {
                   xSpeed = -xSpeed;
            }
            x = x + xSpeed;
            if (y > (gameView.getHeight()-300) - height - ySpeed || y + ySpeed < 0) {
                   ySpeed = -ySpeed;
            }
            y = y + ySpeed;
      }

      public void onDraw(Canvas canvas,int bx,int by) {
          if(!fallen){
          if(collision(bx,by) || falling){
        	  fall();
              falling = true;
          }
          else 
        	  update();
          }
          canvas.drawBitmap(bmp, x, y, null);
      }
	
      public boolean collision(int bx, int by){
    	  int t1 = x - bx;
    	  int t2 = y - by;
    	  if(t1<0){
    		  t1 = -t1;
    	  }
    	  if(t2<0){
    		  t2 = -t2;
    	  }
    	  if(t1<=40 && t2<=40){
    		  return true;
    	  }
    	  else
    		  return false;
    	  
      }
      
      public void fall(){
    	  y = y + 20;
    	  if (y > (gameView.getHeight()-100) - height - ySpeed || y + ySpeed < 0) {
    		  fallen = true;
    	  }
      }
      
      public boolean isCollition(float x2, float y2) {
          return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
    }
	
}
