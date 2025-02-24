package flappybird;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class wallimage {
	
	private Random r = new Random();
	public int X;
	public int Y =r.nextInt(gamepannel.HEIGHT-400)+200;// max 600 , min 200 
	public int Width_wall=45;
		private int height = gamepannel.HEIGHT-Y;
		private int gap = 200;// the gap between the walls is 200 
		
		public static int speed = -6;
		
		private BufferedImage img = null;
		
		
	public wallimage(int X) {
		this.X=X;
		
		
		LoadImage();
		
		
	}


	private void LoadImage() {
		try {
			
			img=ImageIO.read(new File("C:\\Users\\VIKVIS\\eclipse-workspace\\Fallpybird\\images\\images.png"));
			
		
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		
	}
	
	 
	public void drawBird(Graphics g) {
		 g.drawImage(img, X, Y, null);// this is fr the bottom wall
		 g.drawImage(img,X,(-gamepannel.HEIGHT)+(Y-gap),null);  // this is for the upper wall and -800+(600-200)
		  
	}
	

	public void  wallMovement() {
	X+=speed;
		
		if(X<=Width_wall) {
			X=gamepannel.WIDTH;
			Y=r.nextInt(gamepannel.HEIGHT-400)+200;
			height = gamepannel.HEIGHT-Y;
		}
		
		Rectangle lowerReact= new Rectangle(X,Y,Width_wall,height);
		Rectangle UpperReact= new Rectangle(X,0,Width_wall,gamepannel.HEIGHT-(height+gap)); 
		
		if(lowerReact.intersects(birdimage.getBirdReact())|| UpperReact.intersects(birdimage.getBirdReact())) {
			
			boolean option=gamepannel.popUpmessage();
			if(option) {
			try {
				Thread.sleep(500);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			birdimage.reset();
			wall_reset();
		}else{
			JFrame frame=mainbird.getWindow();
			frame.dispose();
			mainbird.timer.stop(); 	
		}
		}
	}
		
		
	private void wall_reset() {
		Y =r.nextInt(gamepannel.HEIGHT-400)+200;
		height = gamepannel.HEIGHT-Y;
		gamepannel.Gameover=true;
	}

 }
