package flappybird;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class birdimage {
	
	private BufferedImage img=null;
	private static int bird_dia =36;
	
	public static int x=(gamepannel.WIDTH/2)-bird_dia/2;
	public static int y= gamepannel.HEIGHT/2;
	
	private static int  speed =2;
	private int acce =1;
	
	
	
	public birdimage() {
		LoadImage();
		
	}
  private void LoadImage() {
	try {
		
		img = ImageIO.read(new File("C:\\Users\\VIKVIS\\eclipse-workspace\\Fallpybird\\images\\flappybird.png"));
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
	}
 
public void drawBird(Graphics g) {
	 g.drawImage(img, x, y, null);
	  
}

public void BirdMovement() {
	if(y>=0 && y<=gamepannel.HEIGHT) {
		speed +=acce;//2+1 3,3+1 4,
		y+=speed; // y value is 400 ,400+3 403,400+4 404,
	
}else {
	boolean option=gamepannel.popUpmessage();
	if(option) {
	try {
		Thread.sleep(500);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	reset();
	}else {
		JFrame frame=mainbird.getWindow();
		frame.dispose();
		
		mainbird.timer.stop();
		
	}	
}

}

public void goUpwards() {
	speed = -17;
	
}
public  static void reset() {
	 speed=2;
	 y=gamepannel.HEIGHT/2;
	 gamepannel.Gameover=true;
	gamepannel.score =0;
}

 public static  Rectangle getBirdReact() {
	 
	 Rectangle BirdReact = new Rectangle(x,y,bird_dia,35);
	 
	 return BirdReact;
 }


}
