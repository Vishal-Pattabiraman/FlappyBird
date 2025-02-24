package flappybird;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gamepannel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean Gameover=false;
	public static int score=0;
	public static final int WIDTH=600;
	public static final int  HEIGHT=800;
	// need to move  the game pannel while we are playing the game 
	
	private int xcoor=0;
	private BufferedImage img;
	
	
	birdimage bi=new birdimage();
	
	wallimage wi=new wallimage(gamepannel.WIDTH);
	wallimage wi2=new wallimage(gamepannel.WIDTH+(gamepannel.WIDTH/2));
	
	public  gamepannel() {
		LoadImage();
		// mouse prs event 
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e ) {
				super.mousePressed(e);
				bi.goUpwards();
			}
			
		});
		
	}

	private void LoadImage() {
		 
		
		try {
			
			img=ImageIO.read(new File("C:\\Users\\VIKVIS\\eclipse-workspace\\Fallpybird\\images\\background.jpg"));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		} 
		
	}

	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.drawImage(img, xcoor,0, null);
		g.drawImage(img, xcoor+2400,0, null);
		bi.drawBird(g);
		wi.drawBird(g);
		wi2.drawBird(g);
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		g.drawString("Score "+score,WIDTH/2,100);
	 
	}
	
	public void Move() { 
		bi.BirdMovement();
	    wi.wallMovement();
	    wi2.wallMovement();
	    
	    if(Gameover) {
	    	wi.X=gamepannel.WIDTH;
	    	wi2.X=gamepannel.WIDTH+(gamepannel.WIDTH/2);
	    	Gameover=false;
	    }
		xcoor+=-6;
		if(xcoor==-2400) {
			xcoor=0;
		}
		if(wi.X==birdimage.x || wi2.X==birdimage.x) {
			score+=1;
			
			
		}
	}
	public static boolean popUpmessage() {
	 
	 int result =JOptionPane.showConfirmDialog(null,"game over, your score is: "+score+"\n Do you whant to Restart the game ","GameOver",JOptionPane.YES_NO_OPTION);
	
	if(result==JOptionPane.YES_OPTION) {
		 return true;
	}else {
		return false;
	}
	 
 }

}
