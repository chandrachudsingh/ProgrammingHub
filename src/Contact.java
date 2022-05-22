import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contact extends JPanel
{
	Font F;
	Color C,Cborder;
	JLabel lbst,lbcontact1,lbcontact2;
	
	public Contact()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbst=new JLabel("For any queries contact us at:");
		lbst.setForeground(Color.RED);
		lbst.setFont(F);

		lbcontact1=new JLabel("Email : chandrachudsingh81@gmail.com");
		lbcontact1.setForeground(Color.BLUE);
		lbcontact1.setFont(F);
		lbcontact2=new JLabel("           devanshichowdhary3@gmail.com");
		lbcontact2.setForeground(Color.BLUE);
		lbcontact2.setFont(F);
		
		C=new Color(125,20,125);
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		setBackground(Color.BLACK);
		add(lbst);
		add(lbcontact1);
		add(lbcontact2);
	}
	
	public Insets getInsets()
	{
		return new Insets(100, 300, 200, 300);
	}
}
