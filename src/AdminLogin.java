import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AdminLogin extends JPanel implements ActionListener
{
	Font F;
	Color C,Cborder,Cbt;
	JPanel P1,P2,P21,P22,P3,Pbt,Perror;
	JLabel lbuser,lbpass,lbdscpt,lberror;
	JTextField txuser;
	JPasswordField pass;
	JButton btlogin,btaddadmin,btlangadminpage,btshowlangdetails,btdellang,btupdatelang;
	
	public AdminLogin()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbdscpt=new JLabel("Note : Only Admins can access this Panel");
		lbdscpt.setForeground(Color.BLUE);
		lbdscpt.setFont(F);
		lbuser=new JLabel("User Id");
		lbuser.setForeground(Color.RED);
		lbuser.setFont(F);
		lbpass=new JLabel("Password");
		lbpass.setForeground(Color.RED);
		lbpass.setFont(F);
		lberror=new JLabel();
		lberror.setForeground(Color.GREEN);
		lberror.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,15);
		txuser=new JTextField(25);
		txuser.setFont(F);
		txuser.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));	//to create inner padding
		pass=new JPasswordField(25);
		pass.setFont(F);
		pass.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));	//to create inner padding
		
		F=new Font("Comic Sans MS", Font.BOLD, 15);
		btlogin=new JButton("Login");
		btlogin.setFont(F);
		btlogin.setBackground(Cbt);
		btlogin.setPreferredSize(new Dimension(120,36));
		btaddadmin=new JButton("Add Admin");
		btaddadmin.setFont(F);
		btaddadmin.setBackground(Cbt);
		btlangadminpage=new JButton("Add Language");
		btlangadminpage.setFont(F);
		btlangadminpage.setBackground(Cbt);
		btshowlangdetails=new JButton("Show Language details");
		btshowlangdetails.setFont(F);
		btshowlangdetails.setBackground(Cbt);
		btupdatelang=new JButton("Update language Page");
		btupdatelang.setFont(F);
		btupdatelang.setBackground(Cbt);
		btdellang=new JButton("Delete Language Page");
		btdellang.setFont(F);
		btdellang.setBackground(Cbt);
		
		P1=new JPanel();
		P1.setBackground(C);
		P1.add(lbdscpt);
		
		P21=new JPanel();
		P21.setBackground(C);
		P21.setLayout(new FlowLayout(FlowLayout.CENTER,75,00));
		P21.add(lbuser);
		P21.add(txuser);
		
		P22=new JPanel();
		P22.setBackground(C);
		P22.setLayout(new FlowLayout(FlowLayout.CENTER,50,00));
		P22.add(lbpass);
		P22.add(pass);
		
		P3=new JPanel();
		P3.setBackground(C);		
		P3.add(btlogin);
		
		Perror=new JPanel();
		Perror.setBackground(Color.BLACK);
		Perror.add(lberror);
		
		Pbt=new JPanel();
		Pbt.setBackground(Color.BLACK);
		Pbt.setLayout(new GridLayout(2,3,20,00));
		Pbt.add(btaddadmin);
		Pbt.add(btlangadminpage);
		Pbt.add(btshowlangdetails);
		Pbt.add(btupdatelang);
		Pbt.add(btdellang);
		Pbt.add(new JLabel());
		Pbt.setVisible(false);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		
		C=new Color(125,20,125);
		setBackground(Color.BLACK);
		setLayout(new GridLayout(6,1));
		add(Perror);
		add(P1);
		add(P21);
		add(P22);
		add(P3);
		add(Pbt);
		
		txuser.requestFocus();
		
		btlogin.addActionListener(this);
		btaddadmin.addActionListener(this);
		btlangadminpage.addActionListener(this);
		btshowlangdetails.addActionListener(this);
		btupdatelang.addActionListener(this);
		btdellang.addActionListener(this);
		
		firstAdmin();
	}
	
	public void firstAdmin()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");   //to load driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
											//to build connection between Java and database 
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
					//"if not exists" used because of database not created multiple times(error)
			
			stmt.execute("Use ProgrammingHubDb");
			stmt.executeUpdate("Create table if not exists RegisterTb(User varchar(25),"
					+ "Password varchar(25),type varchar(25))");
			ResultSet rs=stmt.executeQuery("select count(*) from RegisterTb where type='Admin'");
			
			int c=0;
			while(rs.next())
				c=rs.getInt(1);
			
			if(c==0)
			{
				stmt.executeUpdate("Insert into RegisterTb(User,Password,type)values('chandra','6250','Admin')");
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
		
		txuser.requestFocus();
	}
	
	public Insets getInsets()
	{
		return new Insets(50, 150, 300, 150);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		
		if(src==btlogin)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");   //to load driver class
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
												//to build connection between Java and database 
				Statement stmt=con.createStatement();
				stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
						//"if not exists" used because of database not created multiple times(error)
				
				stmt.execute("Use ProgrammingHubDb");
				stmt.executeUpdate("Create table if not exists RegisterTb(User varchar(25),"
						+ "Password varchar(25),type varchar(25))");
				PreparedStatement pstmt=con.prepareStatement("select count(*) from RegisterTb where User=? and Password=?");
		
				pstmt.setString(1, txuser.getText());
				pstmt.setString(2, pass.getText());
				pstmt.executeQuery();
				
				ResultSet rs=pstmt.executeQuery();
				int c=0;
				while(rs.next())
					c=rs.getInt(1);
				rs=pstmt.executeQuery();
				
				con.close();
				
				if(c==1)
				{
					lberror.setText("Welcome "+txuser.getText());
					Pbt.setVisible(true);
				}
				
				else
				{
					lberror.setText("Warning!, Either Username or Password is invalid");
				}
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
		
		else if(src==btaddadmin)
		{
			JDialog D=new AddAdmin();
			D.setLocationRelativeTo(null);		// To center Dialog box
		}
		
		else if(src==btlangadminpage)
		{
			JDialog D=new LangAdmin();
			D.setLocationRelativeTo(null);
		}
		
		else if(src==btshowlangdetails)
		{
			JDialog D=new ShowDetails();
			D.setLocationRelativeTo(null);
		}
		
		else if(src==btupdatelang)
		{
			JDialog D=new UpdateLangPage();
			D.setLocationRelativeTo(null);
		}
		
		else
		{
			JDialog D=new DeleteLangPage();
			D.setLocationRelativeTo(null);
		}
	}
}
