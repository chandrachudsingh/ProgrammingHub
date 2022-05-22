import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBKImg extends JApplet
{
	JPanel P1,P2;
	private Image bgImage;
	public void init()
	{
		P1=new JPanel();
		P2=new JPanel();
		
		P1.add(new JButton("Ok"));
		P1.setSize(new Dimension(300,100));
		P1.setPreferredSize(new Dimension(300,100));
		
		add(P1,BorderLayout.NORTH);
		add(P2);
		P1.setBorder(BorderFactory.createLineBorder(Color.RED,20));
	}
	
	public void paint(Graphics g)
	{
		bgImage=Toolkit.getDefaultToolkit().getImage("LangPre.jpg");
		
		Graphics g1=P1.getGraphics();
		g1.drawImage(bgImage, 0, 0, P1.getWidth(), P1.getHeight(),null);
		
		bgImage=Toolkit.getDefaultToolkit().getImage("python.jpg");
		Graphics g2=P2.getGraphics();
		g2.drawImage(bgImage, 0, 0, null);
		
		/*P1.validate();
		P2.validate();
		P1.revalidate();*/
	}
}
