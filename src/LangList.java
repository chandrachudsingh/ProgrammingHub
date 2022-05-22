import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LangList extends JPanel implements ActionListener, ListSelectionListener
{
	Color C,Cborder,Cbt,Cls;
	JPanel Phead,Pbt,Pls,Psuggest,P;
	JLabel lbhead,lbinst,lbsuggest;
	JTextField txsuggest;
	JButton[] bt;
	JButton btsubmit;
	DefaultListModel<String> model;
	JList<String> lslang;
	JScrollPane Jsp;
	
	public LangList()
	{
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		Cls=new Color(204,229,255);
		
		Font F=new Font("comic sans",Font.PLAIN,25);
		lbhead=new JLabel("Select the first letter of the Language for better options :");
		lbhead.setForeground(Color.BLUE);
		lbhead.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,20);
		lbinst=new JLabel("Can't find a language!!, don't worry..");
		lbinst.setForeground(Color.BLUE);
		lbinst.setFont(F);
		lbsuggest=new JLabel("Suggest a Language to add :");
		lbsuggest.setForeground(Color.RED);
		lbsuggest.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,18);
		txsuggest=new JTextField(20);
		txsuggest.setFont(F);
		txsuggest.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));	//to create inner padding
		
		F=new Font("Comic Sans MS", Font.BOLD, 15);
		btsubmit=new JButton("Submit");
		btsubmit.setFont(F);
		btsubmit.setBackground(Cbt);
		btsubmit.setPreferredSize(new Dimension(120,30));
		
		String[] names= {"All","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		bt=new JButton[27];
		for(int i=0;i<bt.length;i++)
		{
			bt[i]=new JButton(names[i]);
			bt[i].setBackground(Color.DARK_GRAY);
			bt[i].setForeground(Color.GREEN);
		}
		
		model=new DefaultListModel<>();
		lslang=new JList<>(model);
		
		Font Ftx=new Font("Arial",Font.PLAIN,16);
		
		lslang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     //for allowing only single selection
		model.removeAllElements();               // to remove all the previous list items
		lslang=new JList<>(model);
		lslang.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));	//to create inner padding
		lslang.setFont(Ftx);
		lslang.setBackground(Cls);
		
		Pbt=new JPanel();
		Pbt.setBackground(Color.BLACK);
		Pbt.setLayout(new GridLayout(2,14,10,5));
		for(int i=0;i<bt.length;i++)
			Pbt.add(bt[i]);
		
		Phead=new JPanel();
		Phead.setBackground(Color.BLACK);
		Phead.setLayout(new GridLayout(2,1,20,20));
		Phead.add(Pbt);
		Phead.add(lbhead);
		
		Jsp=new JScrollPane();
		Jsp.setBackground(C);
		Jsp.setViewportView(lslang);
		Jsp.getVerticalScrollBar().setUnitIncrement(15);
		
		Pls=new JPanel();
		Pls.setBackground(C);
		Pls.setLayout(new GridLayout(1,1,10,5));
		Pls.add(Jsp);
		
		Psuggest=new JPanel();
		Psuggest.setBackground(C);
		Psuggest.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));	//to create inner padding
		Psuggest.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		Psuggest.add(lbinst,gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(20,10,20,20);
		Psuggest.add(lbsuggest,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		Psuggest.add(txsuggest,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		Psuggest.add(btsubmit,gbc);
		
		P=new JPanel();
		P.setBackground(Color.BLACK);
		P.setLayout(new GridLayout(3,1,20,40));
		P.add(Phead);
		P.add(Pls);
		P.add(Psuggest);
		
		this.setBorder(BorderFactory.createLineBorder(Cborder,20));
		setBackground(Color.BLACK);
		add(P);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");   //to load driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
											//to build connection between Java and database 
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
					//"if not exists" used because of database not created multiple times(error)
			
			stmt.execute("Use ProgrammingHubDb");
			
			ResultSet rs=stmt.executeQuery("select LangName from LangTb");
			while(rs.next())
			{
				model.addElement(rs.getString("LangName"));
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
		
		for(int i=0;i<bt.length;i++)
			bt[i].addActionListener(this);
		
		btsubmit.addActionListener(this);
		lslang.addListSelectionListener(this);     //for change in list selection
	}

	public Insets getInsets()
	{
		return new Insets(40, 40, 40, 40);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		model.removeAllElements();
		
		Object src=ae.getSource();
		
		if(src==btsubmit)
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
				
				String Language=txsuggest.getText();
				
				stmt.executeUpdate("Create table if not exists SuggestionTb(LangId int auto_increment primary key,"
						+ "Language varchar(40))");
				
				ResultSet rs=stmt.executeQuery("select count(*) from LangTb where LangName='"+Language+"'");
				int c=0;
				while(rs.next())
					c=rs.getInt(1);
				
				if(c==0)
				{
					PreparedStatement pstmt=con.prepareStatement("Insert into SuggestionTb(Language)values(?)");
					pstmt.setString(1, Language);
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Thanks...Your language will be added soon.", "Entry successful",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, Language+" already present in the Database.",
							"Attention!!", JOptionPane.ERROR_MESSAGE);
				}
				
				txsuggest.setText("");
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
		
		else
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
				
				String st=null;
				
				if(src==bt[0])
					st="";
				
				for(int i=1;i<bt.length;i++)
				{
					if(src==bt[i])
					{
						st="where LangName like '"+(char)(i+64)+"%' OR LangName like '"+(char)(i+96)+"%'";
					}
				}
				
				
				ResultSet rs=stmt.executeQuery("select LangName from LangTb "+st);
				while(rs.next())
				{
					model.addElement(rs.getString("LangName"));
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
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) 
	{
		if(lslang.isSelectionEmpty())             
			return;					
		
		JDialog D=new ShowLangDetails(lslang.getSelectedValue().toString());
		D.setLocation(200,100);
		
		lslang.clearSelection();
	}
}
