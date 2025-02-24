package flappybird;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;// used for 
import java.awt.event.ActionEvent;
public class mainbird {
	//window 
	// pannel
	//pannel2 wall and image all comes on the second pannel 

	public  static JFrame window;
	public static  Timer timer;
	// this constructor helps to create the window and set the terminations 
	public mainbird(){
	
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// its allows to terminate the window 
		window.setSize(gamepannel.WIDTH,gamepannel.HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("FlappyBird");
		window.setResizable(false);
	    window.setVisible(true);
		
	}
	private void rendering(){
		
		menupannel mp= new menupannel();
		gamepannel gp= new gamepannel();
		//the java swing timer help for repetedly pass the event 
		
		timer =new Timer(20,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gp.repaint();
				gp.Move();
				
			};
			
		});
		window.add(mp);
		window.setVisible(true);
		
		while(mp.startpoint==false) {
			try {
			Thread.sleep(10);
			}catch(Exception ex) {
				ex.printStackTrace();
				
			}
			
		}
		window.remove(mp);
		window.add(gp);
		window.setVisible(true);
		window.revalidate();
	
		timer.start();
	}
	
	public static JFrame getWindow() {
		return window;
	}
	
	public static void main(String[] args) {
		mainbird mb = new mainbird();
		mb.rendering(); 
		 
	}



}
 