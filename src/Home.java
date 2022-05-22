import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Home extends JPanel implements ActionListener
{
	Font F;
	Color C,Cborder;
	JPanel Pbt,Ptxt;
	JButton btpython,btjava,btsql,btswift,btc,btcpp,btphp,btcsharp,bthtml,btruby,btjs,btobj_c;
	JList<String> lsfacts;
	JLabel lbfact;
	JTextArea thead,tinst;
	JScrollPane Jsp;
	
	public Home()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		
		F=new Font("Bradley Hand ITC",Font.BOLD,30);
		thead=new JTextArea("According to Wikipedia, there are about 700 programming\n "
				+ "languages, including esoteric coding languages. Other sources\n "
				+ "that only list notable languages still count up to an impressive\n"
				+ " 245 languages.");
		thead.setForeground(Color.ORANGE);
		thead.setBackground(Color.BLACK);
		thead.setEditable(false);
		thead.setFont(F);
		
		F=new Font("comic sans",Font.BOLD,20);
		tinst=new JTextArea("More Languages will be added soon... \nSuggest a language to add in Language list Panel");
		tinst.setForeground(Color.BLUE);
		tinst.setBackground(Color.BLACK);
		tinst.setEditable(false);
		tinst.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,20);
		lbfact=new JLabel("Cool facts");
		lbfact.setForeground(Color.RED);
		lbfact.setFont(F);
		
		F=new Font("Bahnschrift Condensed",Font.BOLD,15);
		
		String[] facts= {"------------------------------------------ Cool facts ------------------------------------",
				"1. The first programmer in the world was a woman. Her name was Ada Lovelace and she "
				+ "worked on an analytical engine back in the 1,800’s.",
				"2. Just as we said before, recent studies have shown that over 70% of coding jobs are in fields "
				+ "outside of technology.",
				"3. The first computer virus was created in 1983.",
				"4. The first computer game was created in 1961.",
				"5. The first programming language (per sé) was called Fortran, and it was created in the ’50s.",
				"6. Computer Programming Played an Important role in Ending World War II.",
				"7. It Took Less Code to Send a Man to Space Than to Run a SmartPhone.",
				"8. The first “pre-computers” were powered by steam.",
				"9. The first digital computer game never made any money.",
				"10. The computer virus was initially designed without any harmful intentions.",
				"11. There is a higher chance of you getting killed by wolves than having an SHA-1 collision in Git.",
				"12. A picture from Playboy magazine is the most widely used for all sorts of image processing algorithms.",
				"13. The first computer “bug” was identified as a dead moth.",
				"14. PHP wasn’t Meant to be Programming Language.",
				"15. Almost anything powered by electricity uses code."};
		lsfacts=new JList<String>(facts);
		lsfacts.setForeground(Color.PINK);
		lsfacts.setBackground(C);
		lsfacts.setFont(F);
		
		ImageIcon icon=new ImageIcon("../src/Images/python.jpg");
		btpython=new JButton(icon);
		btpython.setSize(new Dimension(100,100));
		btpython.setPreferredSize(new Dimension(100,100));
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(btpython.getSize().width, btpython.getSize().height, 
				java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btpython.setToolTipText("Python Programming");
		
		icon=new ImageIcon("../src/Images/java.jpg");
		btjava=new JButton(icon);
		btjava.setSize(new Dimension(100,100));
		btjava.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btjava.getSize().width, btjava.getSize().height, 
				java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btjava.setToolTipText("Java Programming");
		
		icon=new ImageIcon("../src/Images/sql.jpg");
		btsql=new JButton(icon);
		btsql.setSize(new Dimension(100,100));
		btsql.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btsql.getSize().width, btsql.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btsql.setToolTipText("Structured Query Language");
		
		icon=new ImageIcon("../src/Images/swift.jpg");
		btswift=new JButton(icon);
		btswift.setSize(new Dimension(100,100));
		btswift.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btswift.getSize().width, btswift.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btswift.setToolTipText("Swift Programming");
		
		icon=new ImageIcon("../src/Images/C.png");
		btc=new JButton(icon);
		btc.setSize(new Dimension(100,100));
		btc.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btc.getSize().width, btc.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btc.setToolTipText("C Programming");
		
		icon=new ImageIcon("../src/Images/C++.png");
		btcpp=new JButton(icon);
		btcpp.setSize(new Dimension(100,100));
		btcpp.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btcpp.getSize().width, btcpp.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btcpp.setToolTipText("C++ Programming");
		
		icon=new ImageIcon("../src/Images/php.jpg");
		btphp=new JButton(icon);
		btphp.setSize(new Dimension(100,100));
		btphp.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btphp.getSize().width, btphp.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btphp.setToolTipText("Hypertext PreProcessor");
		
		icon=new ImageIcon("../src/Images/C#.png");
		btcsharp=new JButton(icon);
		btcsharp.setSize(new Dimension(100,100));
		btcsharp.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btcsharp.getSize().width, btcsharp.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btcsharp.setToolTipText("C# Programming");
		
		icon=new ImageIcon("../src/Images/html.jpg");
		bthtml=new JButton(icon);
		bthtml.setSize(new Dimension(100,100));
		bthtml.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(bthtml.getSize().width, bthtml.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		bthtml.setToolTipText("HyperText Markup Language");
		
		icon=new ImageIcon("../src/Images/ruby.png");
		btruby=new JButton(icon);
		btruby.setSize(new Dimension(100,100));
		btruby.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btruby.getSize().width, btruby.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btruby.setToolTipText("Ruby on Rails");
		
		icon=new ImageIcon("../src/Images/javascript.jpg");
		btjs=new JButton(icon);
		btjs.setSize(new Dimension(100,100));
		btjs.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btjs.getSize().width, btjs.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btjs.setToolTipText("JavaScript Programming");
		
		icon=new ImageIcon("../src/Images/objective C.jpg");
		btobj_c=new JButton(icon);
		btobj_c.setSize(new Dimension(100,100));
		btobj_c.setPreferredSize(new Dimension(100,100));
		img=icon.getImage();
		newimg=img.getScaledInstance(btobj_c.getSize().width, btobj_c.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btobj_c.setToolTipText("Objective-C Programming");
		
		Ptxt=new JPanel();
		Ptxt.setBackground(Color.BLACK);
		Ptxt.setLayout(new GridLayout(2,1,20,20));
		Ptxt.add(thead);
		Ptxt.add(tinst);
		
		Pbt=new JPanel();
		Pbt.setBackground(Color.BLACK);
		Pbt.setLayout(new GridLayout(3,4,20,20));
		Pbt.add(btpython);
		Pbt.add(btjava);
		Pbt.add(btsql);
		Pbt.add(btswift);
		Pbt.add(btc);
		Pbt.add(btcpp);
		Pbt.add(btphp);
		Pbt.add(btcsharp);
		Pbt.add(bthtml);
		Pbt.add(btruby);
		Pbt.add(btjs);
		Pbt.add(btobj_c);
		
		Jsp=new JScrollPane();
		Jsp.setBackground(Color.BLACK);
		Jsp.setViewportView(lsfacts);
		Jsp.getVerticalScrollBar().setUnitIncrement(10);
		
		JPanel Pmix=new JPanel();
		Pmix=new JPanel();
		Pmix.setBackground(Color.BLACK);
		Pmix.setLayout(new GridLayout(1,2,20,20));
		Pmix.add(Pbt);
		Pmix.add(Jsp);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		setBackground(Color.BLACK);
		setLayout(new GridLayout(2,1,20,20));
		add(Ptxt);
		add(Pmix);
		
		btpython.addActionListener(this);
		btjava.addActionListener(this);
		btsql.addActionListener(this);
		btswift.addActionListener(this);
		btc.addActionListener(this);
		btcpp.addActionListener(this);
		btphp.addActionListener(this);
		btcsharp.addActionListener(this);
		bthtml.addActionListener(this);
		btruby.addActionListener(this);
		btjs.addActionListener(this);
		btobj_c.addActionListener(this);
	}
	
	public Insets getInsets()
	{
		return new Insets(40, 60, 40, 60);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{	
		Object src=ae.getSource();
		
		if(src==btpython)
		{
			JDialog D=new ShowLangDetails("Python");
			D.setLocation(200,100);
		}
		
		else if(src==btjava)
		{
			JDialog D=new ShowLangDetails("Java");
			D.setLocation(200,100);
		}
		
		else if(src==btsql)
		{
			JDialog D=new ShowLangDetails("SQL");
			D.setLocation(200,100);
		}
		
		else if(src==btswift)
		{
			JDialog D=new ShowLangDetails("Swift");
			D.setLocation(200,100);
		}
		
		else if(src==btc)
		{
			JDialog D=new ShowLangDetails("C");
			D.setLocation(200,100);
		}
		
		else if(src==btcpp)
		{
			JDialog D=new ShowLangDetails("C++");
			D.setLocation(200,100);
		}
		
		else if(src==btphp)
		{
			JDialog D=new ShowLangDetails("PHP");
			D.setLocation(200,100);
		}
		
		else if(src==btcsharp)
		{
			JDialog D=new ShowLangDetails("C#");
			D.setLocation(200,100);
		}
		
		else if(src==bthtml)
		{
			JDialog D=new ShowLangDetails("HTML");
			D.setLocation(200,100);
		}
		
		else if(src==btruby)
		{
			JDialog D=new ShowLangDetails("Ruby");
			D.setLocation(200,100);
		}
		
		else if(src==btjs)
		{
			JDialog D=new ShowLangDetails("JavaScript");
			D.setLocation(200,100);
		}
		
		else
		{
			JDialog D=new ShowLangDetails("Objective_C");
			D.setLocation(200,100);
		}
	}
}
