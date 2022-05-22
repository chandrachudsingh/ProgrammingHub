import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ShowDetails extends JDialog implements ItemListener
{
	Color C,Cborder;
	Font F,Ftx;
	JScrollPane Jsp;
	JPanel P,P1,P2,P3,P4,P5,P6,Puser,Pdata;
	JLabel lbname,lblang,lbhistory,lbapp,lbbest,lbstats,lbindustries,lbbooks,lblectures;
	JLabel lbhead,lblangtype,lbSoftHead;
	JTextField txlang,txsoft1,txsoft2,txsoft3,txsoft4,txsoft5;
	JTextArea thlangtype,thistory,tbest,tindustries,tbooks,tlectures;
	JComboBox cblang=null;
	JLabel lblogoimg,lbappimg,lbstatsimg,lbsoft1img,lbsoft2img,lbsoft3img,lbsoft4img,lbsoft5img;
	String StatsFileName, logoFileName, AppFileName, SoftwareFileName, SoftwareFileName2, SoftwareFileName3, SoftwareFileName4, SoftwareFileName5, BestFileName;
	String LangName;
	
	public ShowDetails()
	{	
		setVisible(true);
		
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)(size.getWidth() * 0.8);
	    int h = (int)(size.getHeight() * 0.8);
	    
		setSize(new Dimension(w,h));
		setPreferredSize(new Dimension(w,h));
		
		C=new Color(67,59,103);
		Cborder=new Color(150,0,205);
		
		F=new Font("comic sans",Font.BOLD,60);
		lbhead=new JLabel("", SwingConstants.CENTER);	//To center Label text
		lbhead.setForeground(Color.ORANGE);
		lbhead.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,20);
		Ftx=new Font("Arial",Font.PLAIN,16);
		
		lbname=new JLabel("Language Name");
		lbname.setForeground(Color.RED);
		lbname.setFont(F);
		lblang=new JLabel("Language");
		lblang.setForeground(Color.RED);
		lblang.setFont(F);
		lblangtype=new JLabel("Language type");
		lblangtype.setForeground(Color.RED);
		lblangtype.setFont(F);
		lbhistory=new JLabel("History");
		lbhistory.setForeground(Color.RED);
		lbhistory.setFont(F);
		lbbest=new JLabel("Best for");
		lbbest.setForeground(Color.RED);
		lbbest.setFont(F);
		lbindustries=new JLabel("Industries");
		lbindustries.setForeground(Color.RED);
		lbindustries.setFont(F);
		lbbooks=new JLabel("Books");
		lbbooks.setForeground(Color.RED);
		lbbooks.setFont(F);
		lblectures=new JLabel("Lectures");
		lblectures.setForeground(Color.RED);
		lblectures.setFont(F);
		
		txlang=new JTextField(25);
		txlang.setFont(Ftx);
		txlang.setForeground(Color.CYAN);
		txlang.setBackground(C);
		txlang.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txlang.setEditable(false);
		txsoft1=new JTextField(25);
		txsoft1.setFont(Ftx);
		txsoft1.setForeground(Color.CYAN);
		txsoft1.setBackground(C);
		txsoft1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txsoft1.setEditable(false);
		txsoft2=new JTextField(25);
		txsoft2.setFont(Ftx);
		txsoft2.setForeground(Color.CYAN);
		txsoft2.setBackground(C);
		txsoft2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txsoft2.setEditable(false);
		txsoft3=new JTextField(25);
		txsoft3.setFont(Ftx);
		txsoft3.setForeground(Color.CYAN);
		txsoft3.setBackground(C);
		txsoft3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txsoft3.setEditable(false);
		txsoft4=new JTextField(25);
		txsoft4.setFont(Ftx);
		txsoft4.setForeground(Color.CYAN);
		txsoft4.setBackground(C);
		txsoft4.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txsoft4.setEditable(false);
		txsoft5=new JTextField(25);
		txsoft5.setFont(Ftx);
		txsoft5.setForeground(Color.CYAN);
		txsoft5.setBackground(C);
		txsoft5.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		txsoft5.setEditable(false);
		
		thlangtype=new JTextArea();
		thlangtype.setFont(Ftx);
		thlangtype.setForeground(Color.CYAN);
		thlangtype.setBackground(C);
		thlangtype.setLineWrap(true);
		thlangtype.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		thlangtype.setEditable(false);
		thistory=new JTextArea();
		thistory.setFont(Ftx);
		thistory.setForeground(Color.CYAN);
		thistory.setBackground(C);
		thistory.setLineWrap(true);
		thistory.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		thistory.setEditable(false);
		tbest=new JTextArea();
		tbest.setFont(Ftx);
		tbest.setForeground(Color.CYAN);
		tbest.setBackground(C);
		tbest.setLineWrap(true);
		tbest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		tbest.setEditable(false);
		tindustries=new JTextArea();
		tindustries.setFont(Ftx);
		tindustries.setForeground(Color.CYAN);
		tindustries.setBackground(C);
		tindustries.setLineWrap(true);
		tindustries.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		tindustries.setEditable(false);
		tbooks=new JTextArea();
		tbooks.setFont(Ftx);
		tbooks.setForeground(Color.CYAN);
		tbooks.setBackground(C);
		tbooks.setLineWrap(true);
		tbooks.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		tbooks.setEditable(false);
		tlectures=new JTextArea();
		tlectures.setFont(Ftx);
		tlectures.setForeground(Color.CYAN);
		tlectures.setBackground(C);
		tlectures.setLineWrap(true);
		tlectures.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));	//to create inner padding
		tlectures.setEditable(false);
		
		lbapp=new JLabel("Application");
		lbapp.setForeground(Color.RED);
		lbapp.setFont(F);
		lbstats=new JLabel("Stats");
		lbstats.setForeground(Color.RED);
		lbstats.setFont(F);
		lbSoftHead=new JLabel("Top 5 IDE's for Current Language");
		lbSoftHead.setForeground(Color.RED);
		lbSoftHead.setFont(new Font("comic sans",Font.BOLD,20));
		
		lblogoimg=new JLabel();
		lblogoimg.setPreferredSize(new Dimension(100,100));
		lbappimg=new JLabel();
		lbappimg.setPreferredSize(new Dimension(400,240));
		lbstatsimg=new JLabel();
		lbstatsimg.setPreferredSize(new Dimension(400,240));
		lbsoft1img=new JLabel();
		lbsoft1img.setPreferredSize(new Dimension(100,100));
		lbsoft2img=new JLabel();
		lbsoft2img.setPreferredSize(new Dimension(100,100));
		lbsoft3img=new JLabel();
		lbsoft3img.setPreferredSize(new Dimension(100,100));
		lbsoft4img=new JLabel();
		lbsoft4img.setPreferredSize(new Dimension(100,100));
		lbsoft5img=new JLabel();
		lbsoft5img.setPreferredSize(new Dimension(100,100));
		
		cblang=new JComboBox();
		cblang.removeAll();     // for removing all the previous items of the cblang on revisiting this page
		
		cblang=new JComboBox();
		cblang.setPreferredSize(new Dimension(200,30));
		cblang.setFont(Ftx);
		cblang.setBackground(new Color(204,229,255));
		cblang.addItem("Select Language");
		
		P1=new JPanel();
		P1.setBackground(Color.BLACK);
		P1.setLayout(new GridLayout(2,3,40,20));
		P1.add(new JLabel());
		P1.add(lbhead);
		P1.add(new JLabel());
		P1.add(lbname);
		P1.add(lblogoimg);
		P1.add(txlang);
		
		P2=new JPanel();
		P2.setBackground(Color.BLACK);
		P2.setLayout(new GridLayout(2,2,40,20));
		P2.add(lblangtype);
		P2.add(thlangtype);
		P2.add(lbhistory);
		P2.add(thistory);
		
		P3=new JPanel();
		P3.setBackground(Color.BLACK);
		P3.setLayout(new GridLayout(2,2,40,40));
		P3.add(lbapp);
		P3.add(lbappimg);
		P3.add(lbstats);
		P3.add(lbstatsimg);
		
		P4=new JPanel();
		P4.setBackground(Color.BLACK);
		P4.setLayout(new GridLayout(1,2,40,20));
		P4.add(lbbest);
		P4.add(tbest);
		
		P5=new JPanel();
		P5.setBackground(Color.BLACK);
		P5.setLayout(new GridLayout(6,2,40,10));
		P5.add(lbSoftHead);
		P5.add(new JLabel());
		P5.add(lbsoft1img);
		P5.add(txsoft1);
		P5.add(lbsoft2img);
		P5.add(txsoft2);
		P5.add(lbsoft3img);
		P5.add(txsoft3);
		P5.add(lbsoft4img);
		P5.add(txsoft4);
		P5.add(lbsoft5img);
		P5.add(txsoft5);
		
		P6=new JPanel();
		P6.setBackground(Color.BLACK);
		P6.setLayout(new GridLayout(3,2,40,20));
		P6.add(lbindustries);
		P6.add(tindustries);
		P6.add(lbbooks);
		P6.add(tbooks);
		P6.add(lblectures);
		P6.add(tlectures);
		
		P=new JPanel();
		P.setBackground(Color.BLACK);
		P.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		P.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(40, 0, 0, 0);
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		P.add(P1, gbc);
		
		gbc.gridy = 1;
		P.add(P2, gbc);
		
		gbc.gridy = 2;
		P.add(P3, gbc);
		
		gbc.gridy = 3;
		P.add(P4, gbc);
		
		gbc.gridy = 4;
		P.add(P5, gbc);
		
		gbc.gridy = 5;
		P.add(P6, gbc);
		
		Puser=new JPanel();
		Puser.setBackground(C);
		Puser.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		Puser.setLayout(new FlowLayout(FlowLayout.CENTER,200,00));
		Puser.add(lblang);
		Puser.add(cblang);
		
		Pdata=new JPanel();
		Pdata.setBackground(Color.BLACK);
		Pdata.setLayout(new GridLayout(1,1));
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");   //to load driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
										//to build connection between Java and database 
			Statement stmt=con.createStatement();
			stmt.executeUpdate("Create database if not exists ProgrammingHubDb");   
				//"if not exists" used because of database not created multiple times(error)
			stmt.execute("Use ProgrammingHubDb");
			
			ResultSet rs=stmt.executeQuery("select distinct LangName from LangTb");
			while(rs.next())
			{
				cblang.addItem(rs.getString("LangName"));
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
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		add(Puser, BorderLayout.NORTH);
		add(Pdata, BorderLayout.CENTER);
		
		Jsp=new JScrollPane();
		Jsp.setViewportView(P);
		Jsp.setBorder(BorderFactory.createLineBorder(Cborder,20));
		Jsp.getVerticalScrollBar().setUnitIncrement(15);
//		Jsp.getVerticalScrollBar().setValue(0);
		Jsp.setVisible(false);
		Pdata.add(Jsp);
		
		cblang.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getStateChange()==ItemEvent.DESELECTED)            //for deselecting the previous item
			return;
	
		if(cblang.getSelectedIndex()!=0)
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
				
				String LangName=cblang.getSelectedItem().toString();
				txlang.setText(LangName);
				lbhead.setText(LangName);
				
				ResultSet rs=stmt.executeQuery("select LangType from LangTb where LangName='"+LangName+"'");
				while(rs.next())
					thlangtype.setText(rs.getString("LangType"));
				
				LangName=LangName.replace("+", "p");
				LangName=LangName.replace("#", "sharp");
				LangName=LangName.replace("-", "_");
				
				ImageIcon icon = null;
				Image newImage = null;
				
				rs=stmt.executeQuery("select * from "+LangName+"Tb");
				while(rs.next())
				{	
					icon = new ImageIcon(rs.getString("Logo"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lblogoimg.setIcon(new ImageIcon(newImage));
					
					thistory.setText(rs.getString("History"));
					
					icon = new ImageIcon(rs.getString("Application"));
					newImage = icon.getImage().getScaledInstance(400, 240, Image.SCALE_DEFAULT);
					lbappimg.setIcon(new ImageIcon(newImage));
					
					icon = new ImageIcon(rs.getString("Stats"));
					newImage = icon.getImage().getScaledInstance(400, 240, Image.SCALE_DEFAULT);
					lbstatsimg.setIcon(new ImageIcon(newImage));
					
					tbest.setText(rs.getString("Bestfor"));  
					
					icon = new ImageIcon(rs.getString("Soft1Img"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lbsoft1img.setIcon(new ImageIcon(newImage));
					txsoft1.setText(rs.getString("soft1"));
					
					icon = new ImageIcon(rs.getString("Soft2Img"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lbsoft2img.setIcon(new ImageIcon(newImage));
					txsoft2.setText(rs.getString("soft2"));
					
					icon = new ImageIcon(rs.getString("Soft3Img"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lbsoft3img.setIcon(new ImageIcon(newImage));
					txsoft3.setText(rs.getString("soft3"));
					
					icon = new ImageIcon(rs.getString("Soft4Img"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lbsoft4img.setIcon(new ImageIcon(newImage));
					txsoft4.setText(rs.getString("soft4"));
					
					icon = new ImageIcon(rs.getString("Soft5Img"));
					newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
					lbsoft5img.setIcon(new ImageIcon(newImage));
					txsoft5.setText(rs.getString("soft5"));
					
					tindustries.setText(rs.getString("Industry"));
					tbooks.setText(rs.getString("Books"));
					tlectures.setText(rs.getString("Lectures"));
				}
				
				Jsp.setVisible(true);
				Pdata.validate();
				
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
}