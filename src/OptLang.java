import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class OptLang extends JPanel implements ActionListener
{
	Font F;
	Color C,Cborder,Cbt;
	JPanel P1,P2,P3,P4,P5,Pc;
	JLabel lbsearch,lbselect,lbtop;
	JTextField txsearch;
	JButton btsearch,btfind;
	JButton btpython,btjava,btruby,bthtml,btjs,btc,btcpp,btcsharp,btobj_c,btphp,btsql,btswift;
	JCheckBox chproced,chfun,chobj,chscript,chlogic;
	JScrollPane Jsp;
	
	public OptLang()
	{	
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbsearch=new JLabel("Search");
		lbsearch.setForeground(Color.WHITE);
		lbsearch.setFont(F);
		lbselect=new JLabel("Select Language type:");
		lbselect.setForeground(Color.RED);
		lbselect.setFont(F);
		lbtop=new JLabel("Top Programming Languages");
		lbtop.setForeground(Color.RED);
		lbtop.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,16);
		txsearch=new JTextField(20);
		txsearch.setFont(F);
		txsearch.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		
		F=new Font("comic sans",Font.PLAIN,18);
		chproced=new JCheckBox("Procedural");
		chproced.setForeground(Color.PINK);
		chproced.setBackground(C);
		chproced.setFont(F);
		chfun=new JCheckBox("Functional");
		chfun.setForeground(Color.PINK);
		chfun.setBackground(C);
		chfun.setFont(F);
		chobj=new JCheckBox("Object-Oriented");
		chobj.setForeground(Color.PINK);
		chobj.setBackground(C);
		chobj.setFont(F);
		chscript=new JCheckBox("Scripting");
		chscript.setForeground(Color.PINK);
		chscript.setBackground(C);
		chscript.setFont(F);
		chlogic=new JCheckBox("Logic");
		chlogic.setForeground(Color.PINK);
		chlogic.setBackground(C);
		chlogic.setFont(F);
		
		ImageIcon icon=new ImageIcon("../src/Images/search.jpg");
		btsearch=new JButton(icon);
		btsearch.setSize(new Dimension(36,27));
		btsearch.setPreferredSize(new Dimension(36,27));
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(btsearch.getSize().width, btsearch.getSize().height, java.awt.Image.SCALE_SMOOTH);
		icon=new ImageIcon(newimg);
		btsearch.setToolTipText("Search");
		
		F=new Font("Comic Sans MS", Font.BOLD, 15);
		btfind=new JButton("Find");
		btfind.setFont(F);
		btfind.setBackground(Cbt);
		btfind.setPreferredSize(new Dimension(120,36));
		
		F=new Font("comic sans",Font.BOLD,15);
		btpython=new JButton("Python");
		btpython.setForeground(Color.ORANGE);
		btpython.setBackground(C);
		btpython.setFont(F);
		btjava=new JButton("Java");
		btjava.setForeground(Color.ORANGE);
		btjava.setBackground(C);
		btjava.setFont(F);
		btruby=new JButton("Ruby");
		btruby.setForeground(Color.ORANGE);
		btruby.setBackground(C);
		btruby.setFont(F);
		bthtml=new JButton("HTML");
		bthtml.setForeground(Color.ORANGE);
		bthtml.setBackground(C);
		bthtml.setFont(F);
		btjs=new JButton("Javascript");
		btjs.setForeground(Color.ORANGE);
		btjs.setBackground(C);
		btjs.setFont(F);
		btc=new JButton("C Language");
		btc.setForeground(Color.ORANGE);
		btc.setBackground(C);
		btc.setFont(F);
		btcpp=new JButton("C++");
		btcpp.setForeground(Color.ORANGE);
		btcpp.setBackground(C);
		btcpp.setFont(F);
		btcsharp=new JButton("C#");
		btcsharp.setForeground(Color.ORANGE);
		btcsharp.setBackground(C);
		btcsharp.setFont(F);
		btobj_c=new JButton("Objective-C");
		btobj_c.setForeground(Color.ORANGE);
		btobj_c.setBackground(C);
		btobj_c.setFont(F);
		btphp=new JButton("PHP");
		btphp.setForeground(Color.ORANGE);
		btphp.setBackground(C);
		btphp.setFont(F);
		btsql=new JButton("SQL");
		btsql.setForeground(Color.ORANGE);
		btsql.setBackground(C);
		btsql.setFont(F);
		btswift=new JButton("Swift");
		btswift.setForeground(Color.ORANGE);
		btswift.setBackground(C);
		btswift.setFont(F);
		
		P1=new JPanel();
		P1.setBackground(Color.BLACK);
		P1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		P1.setBorder(BorderFactory.createLineBorder(Cborder,5));
		P1.add(lbsearch);
		P1.add(txsearch);
		P1.add(btsearch);
		
		P2=new JPanel();
		P2.setBackground(C);
		P2.setLayout(new FlowLayout(FlowLayout.LEFT));
		P2.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		P2.add(lbselect);
		
		P3=new JPanel();
		P3.setBackground(C);
		P3.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
		P3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		P3.add(chproced);
		P3.add(chfun);
		P3.add(chobj);
		P3.add(chscript);
		P3.add(chlogic);
		
		P4=new JPanel();
		P4.setBackground(C);
		P4.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		P4.add(btfind);

		P5=new JPanel();
		P5.setBackground(C);
		P5.setLayout(new GridLayout(7,2,40,10));
		P5.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		P5.add(lbtop);
		P5.add(new JLabel());
		P5.add(btpython);
		P5.add(btjava);
		P5.add(btruby);
		P5.add(bthtml);
		P5.add(btjs);
		P5.add(btc);
		P5.add(btcpp);
		P5.add(btcsharp);
		P5.add(btobj_c);
		P5.add(btphp);
		P5.add(btsql);
		P5.add(btswift);
		
		Pc=new JPanel();
		Pc.setBackground(Color.BLACK);
		Pc.setLayout(new GridLayout(5,1));
		Pc.add(new JLabel(),BorderLayout.NORTH);
		Pc.add(P2,BorderLayout.CENTER);
		Pc.add(P3,BorderLayout.CENTER);
		Pc.add(P4,BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		add(P1,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		add(P5,BorderLayout.SOUTH);
		
		btsearch.addActionListener(this);
		btfind.addActionListener(this);
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
		return new Insets(40, 150, 40, 150);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		
		if(src==btsearch)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");   //to load driver class
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
												//to build connection between Java and database 
				Statement stmt=con.createStatement();
				stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
						//"if not exists" used because of database not created multiple times(error)
				
				String LangName=txsearch.getText();
				
				stmt.execute("Use ProgrammingHubDb");
				
				ResultSet rs=stmt.executeQuery("select count(*) from LangTb where LangName='"+LangName+"'");
				int c=0;
				while(rs.next())
					c=rs.getInt(1);
				
				if(c!=0)
				{
					JDialog D=new ShowLangDetails(LangName);
					D.setLocation(200,100);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "It seems either you have entered a wrong Language name "
							+ "or we do not have that in our database.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				con.close();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btfind)
		{
			Boolean fun=false,proced=false,obj=false,script=false,logic=false;
			String st = "";
			if(chfun.isSelected())
			{
				if(!st.equals(""))
					st+="and ";
				
				st="LangType like '%Function%' ";
				fun=true;
			}
			if(chproced.isSelected())
			{
				if(!st.equals(""))
					st+="and ";
				
				st+="LangType like '%Procedur%'";
				proced=true;
			}
			if(chobj.isSelected())
			{
				if(!st.equals(""))
					st+="and ";
				
				st+="LangType like '%Object-orient%' ";
				obj=true;
			}
			if(chscript.isSelected())
			{
				if(!st.equals(""))
					st+="and ";
				
				st+="LangType like '%Script%' ";
				script=true;
			}
			if(chlogic.isSelected())
			{
				if(!st.equals(""))
					st+="and ";
				
				st+="LangType like '%Logic%' ";
				logic=true;
			}
			
			JDialog D=new LangTypeSelect(fun,proced,obj,script,logic,st);
			D.setLocation(200,100);
		}
		
		else if(src==btpython)
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
			JDialog D=new ShowLangDetails("php");
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
