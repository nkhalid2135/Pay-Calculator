import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class DiffGui {
	
	NetPay netPayRate= new NetPay();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DiffGui();
	}


public DiffGui(){
	EventQueue.invokeLater(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				
			}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
				ex.printStackTrace();
				
			}
			//the frame everything is built on
			JFrame mainFrame= new JFrame("Testing");
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.add(new Test());
				mainFrame.pack();
				mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);
				
			//code for the textboxes+button & panel below
				JPanel southPanel= new JPanel();
				JTextField salary= new JTextField(5);
				JTextField tips= new JTextField(5);
						southPanel.add(salary);
						southPanel.add(tips);
				
				JTextField answer= new JTextField(10);
						southPanel.add(answer);
				JButton calculateButton= new JButton("Calculate!");
						southPanel.add(calculateButton);
						mainFrame.getContentPane().add(southPanel , BorderLayout.SOUTH);
						calculateButton.addActionListener(new ActionListener(){
// calculate button action listener
							@Override
							public void actionPerformed(ActionEvent e) {
								double salaryValue = Double.valueOf(salary.getText()); // get value from JTextField
					               double tipsValue = Double.valueOf(tips.getText());
					               NetPay net = new NetPay();
					               double netpayValue = net.netPayRate(salaryValue, tipsValue);
					               answer.setText(Double.toString(netpayValue));
					               
					               
								// TODO Auto-generated method stub
								
							}
							
						});
			
			}
		
	
		});
	}

public class Test extends JPanel{
	public Test(){
		setLayout(new BorderLayout());
		BackgroundPane backPane= new BackgroundPane();
		backPane.setLayout(new GridBagLayout());
		add(backPane);
		
		
		 try {
             BufferedImage tryCatch = ImageIO.read(new File("pictures/background.gif"));
             backPane.setbackgroundImage(tryCatch);
         } catch (IOException ex) {
             ex.printStackTrace();
             
             
         }
		 JLabel viewing= new JLabel("Pay Calculator");
		 viewing.setOpaque(true);
		 viewing.setForeground(Color.BLACK);
		 viewing.setBackground(Color.YELLOW);
		 viewing.setBorder(new EmptyBorder(25,25,25,25));
		 backPane.add(viewing);
	}
	public class BackgroundPane extends JPanel{
		private BufferedImage image;
			@Override
				public Dimension getPreferredSize(){
					BufferedImage image = getBackgroundImage();
					Dimension size= super.getPreferredSize();
						if(image != null){
							size.width = Math.max(size.width, image.getWidth());
							size.height = Math.max(size.height, image.getHeight());
						}
						return size;
			
		}
			public BufferedImage getBackgroundImage(){
				return image;
			}
			public void setbackgroundImage(BufferedImage x){
				if( image!=x){
					BufferedImage prevous= image;
					image=x;
					firePropertyChange("background" , prevous , image);
					revalidate();
					repaint();
					
				}
			}
			@Override
			protected void paintComponent(Graphics graphs){
				super.paintComponent(graphs);
				BufferedImage backpane= getBackgroundImage();
				if(backpane != null){
					int x = (getWidth()-backpane.getWidth())/2;
					int y = (getHeight()-backpane.getHeight())/2;
					graphs.drawImage(backpane,x,y,this);
					
				}
				
				
			}
	}
	
}
}
	

