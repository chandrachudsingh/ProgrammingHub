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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddAdmin extends JDialog implements ActionListener
{
	Font F;
	Color C,Cborder,Cbt;
	JPanel P,P1,P21,P22,P2,P3,P4;
	JLabel lbadmin,lbpass,lbdscpt,lbsuccess;
	JTextField txadmin;
	JPasswordField pass;
	JButton btregister;
	
	public AddAdmin()
	{
		setVisible(true);
		setBackground(Color.BLACK);
		
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)(size.getWidth() * 0.5);
	    int h = (int)(size.getHeight() * 0.4);
	    
		setSize(new Dimension(w,h));
		setPreferredSize(new Dimension(w,h));
		
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		
		lbdscpt=new JLabel("Enter Admin Details to Register:");
		lbdscpt.setForeground(Color.BLUE);
		lbdscpt.setFont(F);
		lbadmin=new JLabel("Admin Id");
		lbadmin.setForeground(Color.RED);
		lbadmin.setFont(F);
		lbpass=new JLabel("Set Password");
		lbpass.setForeground(Color.RED);
		lbpass.setFont(F);
		lbsuccess=new JLabel();
		lbsuccess.setForeground(Color.GREEN);
		lbsuccess.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,15);
		txadmin=new JTextField(25);
		txadmin.setFont(F);
		pass=new JPasswordField(25);
		pass.setFont(F);
		
		F=new Font("comic sans", Font.BOLD, 15);
		btregister=new JButton("Register");
		btregister.setFont(F);
		btregister.setBackground(Cbt);
		btregister.setPreferredSize(new Dimension(160,36));
		
		P1=new JPanel();
		P1.setBackground(C);
		P1.add(lbdscpt);
		
		P21=new JPanel();
		P21.setBackground(C);
		P21.setLayout(new FlowLayout(FlowLayout.CENTER,75,00));
		P21.add(lbadmin);
		P21.add(txadmin);
		
		P22=new JPanel();
		P22.setBackground(C);
		P22.setLayout(new FlowLayout(FlowLayout.CENTER,30,00));
		P22.add(lbpass);
		P22.add(pass);
		
		P3=new JPanel();
		P3.setBackground(C);	
		P3.add(btregister);
		
		P4=new JPanel();
		P4.setBackground(C);
		P4.add(lbsuccess);
		
		P = new JPanel();
		P.setBackground(Color.BLACK);
		P.setBorder(BorderFactory.createLineBorder(Color.BLACK,20));
		P.setLayout(new GridLayout(5,1));
		P.add(P1);
		P.add(P21);
		P.add(P22);
		P.add(P3);
		P.add(P4);
		
		add(P);
		
		txadmin.requestFocus();
		
		btregister.addActionListener(this);
	}

	public Insets getInsets()
	{
		return new Insets(50, 50, 50, 50);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(txadmin.getText().equals("") ||  pass.getText().equals("")) 
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
			
			ResultSet rs=stmt.executeQuery("select count(*) from RegisterTb where User='"+txadmin.getText()+"'");
			
			int c=0;
			while(rs.next())
				c=rs.getInt(1);
			
			if(c==0)
			{
				PreparedStatement pstmt=con.prepareStatement("Insert into RegisterTb(User,Password,type)values(?,?,'Admin')");

				pstmt.setString(1, txadmin.getText());
				pstmt.setString(2, pass.getText());
				pstmt.executeUpdate();
				
				lbsuccess.setText("Registration successful");
			}
			
			else
				JOptionPane.showMessageDialog(null, "The username "+txadmin.getText()+" is already registered", null, JOptionPane.ERROR_MESSAGE);
		
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
