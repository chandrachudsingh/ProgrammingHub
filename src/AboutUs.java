import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutUs extends JPanel
{
	Panel P;
	Font F;
	Color C,Cborder;
	JLabel lbgreet,lbimg;
	JTextArea taabout;
	
	public AboutUs()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		
		F=new Font("comic sans",Font.PLAIN,20);
		lbgreet=new JLabel("Welcome user,");
		lbgreet.setFont(F);
		lbgreet.setForeground(Color.GREEN);
		
		F=new Font("comic sans",Font.BOLD,15);
		taabout=new JTextArea();
		taabout.setFont(F);
		taabout.setBackground(Color.BLACK);
		taabout.setForeground(Color.BLUE);
		taabout.setText("ProgrammingHub is a part of a Core Java training project."
				+ " This website is developed by Chandrachud singh chundawat\nand Devanshi desai "
				+ "under the supervision of Mrs. Alka mam at ComputerEducation.com.");
		taabout.setEditable(false);
		
		P=new Panel();
		P.setLayout(new GridLayout(2,1,10,25));
		P.add(lbgreet);
		P.add(taabout);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		setBackground(Color.BLACK);
		add(P);
	}
	
	public Insets getInsets()
	{
		return new Insets(50, 300, 200, 300);
	}
}
