import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JPanel implements ActionListener
{
	Font F;
	Color C,Cbt;
	JPanel P,P1,P2,P3,P4,P5;
	JLabel lbuser,lbpass,lbreg,lbgreet;
	JTextField txuser;
	JPasswordField pass;
	JButton btreg;
	
	public Register()
	{
		C=new Color(67,59,103);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbreg=new JLabel("New user!!, Register here:");
		lbreg.setForeground(Color.BLUE);
		lbreg.setFont(F);
		
		lbuser=new JLabel("Username");
		lbuser.setForeground(Color.RED);
		lbuser.setFont(F);
		lbpass=new JLabel("Password");
		lbpass.setForeground(Color.RED);
		lbpass.setFont(F);
		lbgreet=new JLabel();
		lbgreet.setForeground(Color.GREEN);
		lbgreet.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,15);
		txuser=new JTextField(25);
		txuser.setFont(F);
		pass=new JPasswordField(25);
		pass.setFont(F);
		
		btreg=new JButton("Register");
		btreg.setBackground(Cbt);
		
		P1=new JPanel();
		P1.setBackground(C);
		P1.add(lbreg);
		
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
		P4.add(btreg);
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		P4.add(new JLabel());
		
		P5=new JPanel();
		P5.setBackground(C);
		P5.add(lbgreet);
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
		
		btreg.addActionListener(this);
	}

//	public Insets getInsets()
//	{
//		return new Insets(50, 100, 300, 100);
//	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(txuser.getText().equals("") ||  pass.getText().equals("")) 
		{	
			JOptionPane.showMessageDialog(null, "Please fill the above columns");
			return;
		}
		
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
				
				ResultSet rs=stmt.executeQuery("select count(*) from RegisterTb where User='"+txuser.getText()+"'");
				
				int c=0;
				while(rs.next())
					c=rs.getInt(1);
				
				if(c==0)
				{
					PreparedStatement pstmt=con.prepareStatement("Insert into RegisterTb(User,Password,type)values(?,?,'User')");
					
					pstmt.setString(1, txuser.getText());
					pstmt.setString(2, pass.getText());
					pstmt.executeUpdate();
					
					lbgreet.setText("Registeration successful");
					P5.setVisible(true);
					P5.validate();
				}
				
				else
					JOptionPane.showMessageDialog(null, "The username "+txuser.getText()+" is already registered", null, JOptionPane.ERROR_MESSAGE);
			
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
	
}
