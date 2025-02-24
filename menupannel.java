package flappybird;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
// japanel all about panel class defines a generic container which use as a layout manager to determine the compenents 
public class menupannel  extends JPanel{
	
	
	private static final long serialVersionUTD = 1L;
	// java buffred image class a sub class of image class and used to manipulate the image data 
	private BufferedImage img =null;
	public boolean  startpoint=false;
	
	
	public menupannel() {
		
		LoadImage();
		this.addMouseListener(new MouseAdapter(){
			
			public void 	mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				startpoint=true;
				
			}
			
			
		});
		
		
	}

	private void LoadImage() {
		
		try {
			img=ImageIO.read(new File("C:\\Users\\VIKVIS\\eclipse-workspace\\Fallpybird\\images\\mainmenu.jpg"));
			
		}catch(Exception ex){
			ex.printStackTrace();
			
			 
		}
	}
	 public void paint(Graphics g){
		 
		 super.paint(g);
		 
		 g.drawImage(img,0,0,gamepannel.WIDTH,gamepannel.HEIGHT,null);
		 
	 }
	 

}
