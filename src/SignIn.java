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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends JPanel implements ActionListener
{
	Font F;
	Color C,Cbt;
	JPanel P,P1,P2,P3,P4,P5;
	JLabel lbuser,lbpass,lbsign,lberror;
	JTextField txuser;
	JPasswordField pass;
	JButton btsign;
	public static String username="";              //for taking username to use it on other pages
	
	public SignIn()
	{	
		C=new Color(67,59,103);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbsign=new JLabel("Sign-in here:");
		lbsign.setForeground(Color.BLUE);
		lbsign.setFont(F);
		
		lbuser=new JLabel("Username");
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
		pass=new JPasswordField(25);
		pass.setFont(F);
		
		btsign=new JButton("Signin");
		btsign.setBackground(Cbt);
		
		P1=new JPanel();
		P1.setBackground(C);
		P1.add(lbsign);
		
		P2=new JPanel();
		P2.setBackground(C);
		P2.setLayout(new FlowLayout(FlowLayout.CENTER,75,00));
		P2.add(lbuser);
		P2.add(txuser);
		
		P3=new JPanel();
		P3.setBackground(C);
		P3.setLayout(new FlowLayout(FlowLayout.CENTER,75,00));
		P3.add(lbpass);
		P3.add(pass);
		
		P4=new JPanel();
		P4.setBackground(C);
		P4.setLayout(new GridLayout(3,3));
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(btsign);
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		
		P5=new JPanel();
		P5.setBackground(C);
		P5.add(lberror);
		P5.setVisible(false);
		
		P = new JPanel();
		P.setBackground(Color.BLACK);
		P.setLayout(new GridLayout(5,1));
		P.add(P1);
		P.add(P2);
		P.add(P3);
		P.add(P4);
		P.add(P5);
		
		C=new Color(125,20,125);
		setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,20));
		add(P);
		
		txuser.requestFocus();
		
		btsign.addActionListener(this);
	}
	
//	public Insets getInsets()
//	{
//		return new Insets(100, 0, 0, 100);
//	}

	@Override
	public void actionPerformed(ActionEvent ae) 
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
			
			ResultSet rs=pstmt.executeQuery();
			int c=0;
			while(rs.next())
				c=rs.getInt(1);
			rs=pstmt.executeQuery();
			
			con.close();
			
			if(c==1)
			{
				lberror.setText("Welcome "+txuser.getText());
				username=txuser.getText();
			}
			else
			{
				lberror.setText(" ");
				JOptionPane.showMessageDialog(null, "Warning! Either Username or Password is invalid");
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
}
