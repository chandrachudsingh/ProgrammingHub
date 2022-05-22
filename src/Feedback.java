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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Feedback extends JPanel implements ActionListener
{
	Font F,Ftx;
	Color C,Cborder,Cbt;
	JLabel lbfirstline,lbsuggestion,lbnot,lbpartial,lbfully;
	JRadioButton rbnot,rbpartial,rbfully,rbref;
	ButtonGroup bg;
	JTextArea txfeed;
	JButton btsubmit;
	JPanel P1,P2,P3,P4,P5,P21,P22,P23;
	
	public Feedback()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		
		F=new Font("comic sans",Font.PLAIN,20);
		Ftx=new Font("Arial",Font.PLAIN,16);
		
		lbfirstline=new JLabel("How was your experience?");
		lbfirstline.setForeground(Color.RED);
		lbfirstline.setFont(F);
		lbsuggestion=new JLabel("Suggestions: ");
		lbsuggestion.setForeground(Color.RED);
		lbsuggestion.setFont(F);
		
		lbnot=new  JLabel(new ImageIcon("../src/Images/sad 2.1.png"));
		lbpartial=new JLabel(new ImageIcon("../src/Images/neutral 2.png"));
		lbfully=new JLabel(new ImageIcon("../src/Images/happy 2.1.png"));
		
		F=new Font("comic sans",Font.PLAIN,15);
		txfeed=new JTextArea();
		txfeed.setFont(Ftx);
		txfeed.setLineWrap(true);
		txfeed.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		JScrollPane scfeed = new JScrollPane(txfeed);
		
		F=new Font("comic sans",Font.PLAIN,18);
		rbnot=new JRadioButton("Not Satisfied");
		rbnot.setBackground(C);
		rbnot.setForeground(Color.PINK);
		rbnot.setFont(F);
		rbpartial=new JRadioButton("Partially Satisfied");
		rbpartial.setForeground(Color.PINK);
		rbpartial.setBackground(C);
		rbpartial.setFont(F);
		rbfully=new JRadioButton("Fully Satisfied");
		rbfully.setForeground(Color.PINK);
		rbfully.setBackground(C);
		rbfully.setFont(F);
		rbref = new JRadioButton();

		bg=new ButtonGroup();
		bg.add(rbfully);
		bg.add(rbpartial);
		bg.add(rbnot);
		bg.add(rbref);
		
		F=new Font("Comic Sans MS", Font.BOLD, 15);
		btsubmit=new JButton("Submit");
		btsubmit.setBackground(Cbt);
		btsubmit.setFont(F);
		btsubmit.setPreferredSize(new Dimension(120,36));
		
		P1=new JPanel();
		P1.setBackground(C);
		P1.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));	//to create inner padding
		P1.add(lbfirstline);
		
		P21=new JPanel();
		P21.setBackground(C);
		P21.setLayout(new FlowLayout());
		P21.add(rbfully);
		P21.add(lbfully);
		P22=new JPanel();
		P22.setBackground(C);
		P22.setLayout(new FlowLayout());
		P22.add(rbpartial);
		P22.add(lbpartial);
		P23=new JPanel();
		P23.setBackground(C);
		P23.setLayout(new FlowLayout());
		P23.add(rbnot);
		P23.add(lbnot);
		
		P2=new JPanel();
		P2.setBackground(C);
		P2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));	//to create inner padding
		P2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		P2.add(P21);
		P2.add(P22);
		P2.add(P23);
		
		P3=new JPanel();
		P3.setBackground(Color.BLACK);
		P3.setLayout(new GridLayout(1,1));
		P3.add(lbsuggestion);
		
		P4=new JPanel();
		P4.setBackground(Color.BLACK);
		P4.setLayout(new GridLayout(1,1));
		P4.add(scfeed);
		
		P5=new JPanel();
		P5.setBackground(Color.BLACK);
		P5.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		P5.add(btsubmit);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
	    setBackground(Color.BLACK);
		setLayout(new GridLayout(5,1));
		add(P1);
		add(P2);
		add(P3);
		add(P4);
		add(P5);	
		
		txfeed.requestFocus();
		
		btsubmit.addActionListener(this);
	}

	public Insets getInsets()
	{
		return new Insets(80, 150, 20, 150);
	}

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
			stmt.executeUpdate("Create table if not exists feedbackTb(User varchar(25),"
					+ "experience varchar(20),suggestions varchar(200))");
			
//			if(!SignIn.username.equals(""))
//			{
				PreparedStatement pstmt=con.prepareStatement("Insert into feedbackTb(User,experience,suggestions)"
						+ "values(?,?,?)");
				
				pstmt.setString(1, SignIn.username);
				
				if(rbfully.isSelected())
					pstmt.setString(2, rbfully.getText());
				else if(rbpartial.isSelected())
					pstmt.setString(2, rbpartial.getText());
				else if(rbnot.isSelected())
					pstmt.setString(2, rbnot.getText());
				
				pstmt.setString(3, txfeed.getText());
				pstmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Feedback submitted succesfully",
						"Thank you", JOptionPane.INFORMATION_MESSAGE);
				
				rbref.setSelected(true);
				txfeed.setText("");
//			}
//			
//			else
//				JOptionPane.showMessageDialog(null, "Please signin to submit feedback",
//						"Attention", JOptionPane.ERROR_MESSAGE);
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
