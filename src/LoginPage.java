import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class LoginPage extends JDialog
{
	JScrollPane Rjsp,Ljsp;
	JSplitPane Jsp;
	
	public LoginPage()
	{
		setVisible(true);
		
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)(size.getWidth() * 0.8);
	    int h = (int)(size.getHeight() * 0.6);
		    
		this.setSize(new Dimension(w,h));
		this.setPreferredSize(new Dimension(w,h));
		
		Rjsp=new JScrollPane(new SignIn());
		Ljsp=new JScrollPane(new Register());
		
		Jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,Rjsp,Ljsp);
		Jsp.setResizeWeight(0.5);
		add(Jsp);
	}
}
