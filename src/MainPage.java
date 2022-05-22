import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioPermission;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPage extends JApplet implements ActionListener
{
	JPanel P;
	Color Cbt;
	Font F;
	JTabbedPane Jtb;
	JLabel lbtitle,lbimgleft,lbimgright,lbgreet;
	JButton btlogin;
	
	public void init()
	{
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)(size.getWidth() * 0.99);
	    int h = (int)(size.getHeight() * 0.86);
	    
		this.setSize(new Dimension(w,h));
		this.setPreferredSize(new Dimension(w,h));
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");   //to load driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
										//to build connection between Java and database 
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
				//"if not exists" used because of database not created multiple times(error)
		
			stmt.execute("Use ProgrammingHubDb");
			stmt.executeUpdate("Create table if not exists LangTb(LangId int auto_increment primary key,LangName varchar(50),LangType varchar(100))");
		
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
				
		F=new Font("comic sans",Font.PLAIN,50);
		
		lbtitle=new JLabel("ProgrammingHub");
		lbtitle.setForeground(Color.PINK);
		lbtitle.setFont(F);
		
		F=new Font("Bradley Hand ITC",Font.BOLD,30);
		lbgreet=new JLabel("Welcome "+SignIn.username);
		lbgreet.setForeground(Color.ORANGE);
		lbgreet.setFont(F);
		lbimgleft=new JLabel(new ImageIcon("../src/Images/img1.jpg"));
		lbimgright=new JLabel(new ImageIcon("../src/Images/img2.png"));
		
		Cbt=new Color(50, 50, 170);
		F=new Font("Comic Sans MS",Font.BOLD,18);
		btlogin=new JButton("Signin/register");
		btlogin.setBackground(Cbt);
		btlogin.setForeground(Color.YELLOW);
		btlogin.setSize(new Dimension(200,60));
		btlogin.setPreferredSize(new Dimension(200,60));
		btlogin.setFont(F);
		
		Jtb=new JTabbedPane();
		Jtb.setBackground(Color.DARK_GRAY);
		Jtb.setForeground(Color.MAGENTA);
		
		Jtb.addTab("Home", new Home());
		Jtb.addTab("Language Options", new OptLang());
		Jtb.addTab("Language List", new LangList());
		Jtb.addTab("Admin Login", new AdminLogin());
		Jtb.addTab("Feedback", new Feedback());
		Jtb.addTab("Contact", new Contact());
		Jtb.addTab("About Us", new AboutUs());
		
		F=new Font("comic sans",Font.PLAIN,20);
		Jtb.setFont(F);
		
		P=new JPanel();
		P.setBackground(Color.DARK_GRAY);
		P.setLayout(new GridLayout(1,2));
		
		JPanel P1=new JPanel();
		P1.setBackground(Color.BLACK);
		P1.setLayout(new FlowLayout(FlowLayout.LEFT));
		P1.add(lbgreet);
		
		JPanel P2=new JPanel();
		P2.setBackground(Color.BLACK);
		P2.setLayout(new FlowLayout(FlowLayout.CENTER));
		P2.add(lbtitle);
		
		JPanel P3=new JPanel();
		P3.setBackground(Color.BLACK);
		P3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		P3.add(btlogin);
		
		P.add(P1);
		P.add(P2);
		P.add(P3);

		add(P,BorderLayout.NORTH);
		add(lbimgleft,BorderLayout.WEST);
		add(lbimgright,BorderLayout.EAST);
		add(Jtb,BorderLayout.CENTER);
		
		btlogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		JDialog D=new LoginPage();                  //to display dialogbox(LoginPage)
		D.setLocationRelativeTo(null);
	}
}
