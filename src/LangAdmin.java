import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LangAdmin extends JDialog implements ActionListener
{
	Color Cborder,Cbt;
	Font F,Ftx;
	JScrollPane Jsp,thlangtypeScroll,thistoryScroll,tbestScroll,tindustriesScroll,tbooksScroll,tlecturesScroll;
	JPanel P,P1,P2,P3,P4,P5,P6,P7,P8,P9;
	JLabel lblang,lblangtype,lblogo,lbhistory,lbapp,lbbest,lbstats,lbindustries,lbbooks,lblectures,lbgreet;
	JLabel lbsoft1,lbsoft2,lbsoft3,lbsoft4,lbsoft5;
	JLabel lbAppImg,lbStatsImg;
	JTextField txlang,txsoft1,txsoft2,txsoft3,txsoft4,txsoft5;
	JTextArea thlangtype,thistory,tbest,tindustries,tbooks,tlectures;
	JButton btlogo,btapp,btstats,btsoft1,btsoft2,btsoft3,btsoft4,btsoft5,btinsert,btinsert2;
	String StatsFileName, logoFileName, AppFileName, SoftwareFileName, SoftwareFileName2, SoftwareFileName3, SoftwareFileName4, SoftwareFileName5, BestFileName;

	public LangAdmin()
	{
		Cborder=new Color(150,0,205);
		Cbt=new Color(145,204,241);
		
		setVisible(true);
		
		// Get Screen Size
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)(size.getWidth() * 0.8);
	    int h = (int)(size.getHeight() * 0.8);
	    
		setSize(new Dimension(w,h));
		setPreferredSize(new Dimension(w,h));
		
		F=new Font("comic sans",Font.PLAIN,20);
		Ftx=new Font("Arial",Font.PLAIN,16);
		
		lblang=new JLabel("Language Name");
		lblang.setForeground(Color.RED);
		lblang.setFont(F);
		lblangtype=new JLabel("Language type");
		lblangtype.setForeground(Color.RED);
		lblangtype.setFont(F);
		lblogo=new JLabel("Logo");
		lblogo.setForeground(Color.RED);
		lblogo.setFont(F);
		lbhistory=new JLabel("History");
		lbhistory.setForeground(Color.RED);
		lbhistory.setFont(F);
		lbapp=new JLabel("Application");
		lbapp.setForeground(Color.RED);
		lbapp.setFont(F);
		lbbest=new JLabel("Best for");
		lbbest.setForeground(Color.RED);
		lbbest.setFont(F);
		lbstats=new JLabel("Stats");
		lbstats.setForeground(Color.RED);
		lbstats.setFont(F);
		lbsoft1=new JLabel("Software IDE 1");
		lbsoft1.setForeground(Color.RED);
		lbsoft1.setFont(F);
		lbsoft2=new JLabel("Software IDE 2");
		lbsoft2.setForeground(Color.RED);
		lbsoft2.setFont(F);
		lbsoft3=new JLabel("Software IDE 3");
		lbsoft3.setForeground(Color.RED);
		lbsoft3.setFont(F);
		lbsoft4=new JLabel("Software IDE 4");
		lbsoft4.setForeground(Color.RED);
		lbsoft4.setFont(F);
		lbsoft5=new JLabel("Software IDE 5");
		lbsoft5.setForeground(Color.RED);
		lbsoft5.setFont(F);
		lbindustries=new JLabel("Industries");
		lbindustries.setForeground(Color.RED);
		lbindustries.setFont(F);
		lbbooks=new JLabel("Books");
		lbbooks.setForeground(Color.RED);
		lbbooks.setFont(F);
		lblectures=new JLabel("Lectures");
		lblectures.setForeground(Color.RED);
		lblectures.setFont(F);
		
		lbAppImg=new JLabel();
		lbAppImg.setPreferredSize(new Dimension(360,180));
		lbAppImg.setVisible(false);
		lbStatsImg=new JLabel();
		lbStatsImg.setPreferredSize(new Dimension(360,180));
		lbStatsImg.setVisible(false);
		
		F=new Font("comic sans",Font.PLAIN,40);
		lbgreet=new JLabel();
		lbgreet.setForeground(Color.GREEN);
		lbgreet.setFont(F);
		
		txlang=new JTextField(25);
		txlang.setFont(Ftx);
		txlang.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txsoft1=new JTextField(25);
		txsoft1.setFont(Ftx);
		txsoft1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txsoft2=new JTextField(25);
		txsoft2.setFont(Ftx);
		txsoft2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txsoft3=new JTextField(25);
		txsoft3.setFont(Ftx);
		txsoft3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txsoft4=new JTextField(25);
		txsoft4.setFont(Ftx);
		txsoft4.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txsoft5=new JTextField(25);
		txsoft5.setFont(Ftx);
		txsoft5.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		thlangtype=new JTextArea();
		thlangtype.setFont(Ftx);
		thlangtype.setLineWrap(true);
		thlangtype.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		thlangtype.setRows(4);
		thlangtypeScroll = new JScrollPane (thlangtype);
		thistory=new JTextArea();
		thistory.setFont(Ftx);
		thistory.setLineWrap(true);
		thistory.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		thistory.setRows(4);
		thistoryScroll = new JScrollPane (thistory);
		tbest=new JTextArea();
		tbest.setFont(Ftx);
		tbest.setLineWrap(true);
		tbest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tbest.setRows(4);
		tbestScroll = new JScrollPane (tbest);
		tindustries=new JTextArea();
		tindustries.setFont(Ftx);
		tindustries.setLineWrap(true);
		tindustries.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tindustries.setRows(8);
		tindustriesScroll = new JScrollPane (tindustries);
		tbooks=new JTextArea();
		tbooks.setFont(Ftx);
		tbooks.setLineWrap(true);
		tbooks.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tbooks.setRows(8);
		tbooksScroll = new JScrollPane (tbooks);
		tlectures=new JTextArea();
		tlectures.setFont(Ftx);
		tlectures.setLineWrap(true);
		tlectures.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tlectures.setRows(8);
		tlecturesScroll = new JScrollPane (tlectures);
		
		btlogo=new JButton("Logo");
		btlogo.setPreferredSize(new Dimension(200,100));
		btlogo.setBackground(Cbt);
		btlogo.setFont(Ftx);
		btapp=new JButton("Application");
		btapp.setPreferredSize(new Dimension(400,180));
		btapp.setBackground(Cbt);
		btapp.setFont(Ftx);
		btstats=new JButton("Stats");
		btstats.setPreferredSize(new Dimension(400,180));
		btstats.setBackground(Cbt);
		btstats.setFont(Ftx);
		btsoft1=new JButton("Software 1");
		btsoft1.setPreferredSize(new Dimension(250,100));
		btsoft1.setBackground(Cbt);
		btsoft1.setFont(Ftx);
		btsoft2=new JButton("Software 2");
		btsoft2.setPreferredSize(new Dimension(250,100));
		btsoft2.setBackground(Cbt);
		btsoft2.setFont(Ftx);
		btsoft3=new JButton("Software 3");
		btsoft3.setPreferredSize(new Dimension(250,100));
		btsoft3.setBackground(Cbt);
		btsoft3.setFont(Ftx);
		btsoft4=new JButton("Software 4");
		btsoft4.setPreferredSize(new Dimension(250,100));
		btsoft4.setBackground(Cbt);
		btsoft4.setFont(Ftx);
		btsoft5=new JButton("Software 5");
		btsoft5.setPreferredSize(new Dimension(250,100));
		btsoft5.setBackground(Cbt);
		btsoft5.setFont(Ftx);
		btinsert=new JButton("Insert");
		btinsert.setPreferredSize(new Dimension(200,50));
		btinsert.setBackground(Cbt);
		btinsert.setFont(Ftx);
		btinsert2=new JButton("Insert More");
		btinsert2.setPreferredSize(new Dimension(200,50));
		btinsert2.setBackground(Cbt);
		btinsert2.setFont(Ftx);
		btinsert2.setVisible(false);
		
		P1=new JPanel();
		P1.setBackground(Color.BLACK);
		P1.setLayout(new GridLayout(1,3,40,20));
		P1.add(lblang);
		P1.add(btlogo);
		P1.add(txlang);
		
		P2=new JPanel();
		P2.setBackground(Color.BLACK);
		P2.setLayout(new GridLayout(2,2,40,20));
		P2.add(lblangtype);
		P2.add(thlangtypeScroll);
		P2.add(lbhistory);
		P2.add(thistoryScroll);
		
		P3=new JPanel();
		P3.setBackground(Color.BLACK);
		P3.setLayout(new GridLayout(2,3,40,20));
		P3.add(lbapp);
		P3.add(lbAppImg);
		P3.add(btapp);
		P3.add(lbstats);
		P3.add(lbStatsImg);
		P3.add(btstats);
		
		P4=new JPanel();
		P4.setBackground(Color.BLACK);
		P4.setLayout(new GridLayout(1,2,40,20));
		P4.add(lbbest);
		P4.add(tbest);
		
		P5=new JPanel();
		P5.setBackground(Color.BLACK);
		P5.setLayout(new GridLayout(5,3,40,10));
		P5.add(lbsoft1);
		P5.add(btsoft1);
		P5.add(txsoft1);
		P5.add(lbsoft2);
		P5.add(btsoft2);
		P5.add(txsoft2);
		P5.add(lbsoft3);
		P5.add(btsoft3);
		P5.add(txsoft3);
		P5.add(lbsoft4);
		P5.add(btsoft4);
		P5.add(txsoft4);
		P5.add(lbsoft5);
		P5.add(btsoft5);
		P5.add(txsoft5);
		
		P6=new JPanel();
		P6.setBackground(Color.BLACK);
		P6.setLayout(new GridLayout(3,2,40,20));
		P6.add(lbindustries);
		P6.add(tindustriesScroll);
		P6.add(lbbooks);
		P6.add(tbooksScroll);
		P6.add(lblectures);
		P6.add(tlecturesScroll);
		
		P7=new JPanel();
		P7.setBackground(Color.BLACK);
		P7.add(btinsert);
		
		P8=new JPanel();
		P8.setBackground(Color.BLACK);
		P8.setLayout(new FlowLayout(FlowLayout.CENTER,200,00));
		P8.add(lbgreet);
		P8.add(btinsert2);
		
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
		
		gbc.gridy = 6;
		P.add(P7, gbc);
		
		gbc.gridy = 7;
		P.add(P8, gbc);
		
		Jsp=new JScrollPane();
		Jsp.setViewportView(P);
		Jsp.setBorder(BorderFactory.createLineBorder(Cborder,20));
		Jsp.getVerticalScrollBar().setUnitIncrement(15);
		
		setBackground(Color.BLACK);
		add(Jsp);
		
		txlang.requestFocus();
		
		btlogo.addActionListener(this);
		btapp.addActionListener(this);
		btstats.addActionListener(this);
		btsoft1.addActionListener(this);
		btsoft2.addActionListener(this);
		btsoft3.addActionListener(this);
		btsoft4.addActionListener(this);
		btsoft5.addActionListener(this);
		btinsert.addActionListener(this);
		btinsert2.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		
		if(txlang.getText().equals("")||thlangtype.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please fill the Language name and Language type before selection of images", "Alert", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(src==btlogo)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\LogoImages\\"));
			jfc.showOpenDialog(null);
			File logoFile=jfc.getSelectedFile();
			logoFileName="../src/LogoImages/"+logoFile.getName();
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(logoFileName));
				FileInputStream fin=new FileInputStream(logoFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}
				
				ImageIcon icon = new ImageIcon(logoFileName);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btlogo.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btapp)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\ApplicationImg\\"));
			jfc.showOpenDialog(null);
			File AppFile=jfc.getSelectedFile();
			AppFileName="../src/ApplicationImg/"+AppFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(AppFileName));
				FileInputStream fin=new FileInputStream(AppFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}
				
				ImageIcon icon = new ImageIcon(AppFileName);
				Image newImage = icon.getImage().getScaledInstance(360, 180, Image.SCALE_DEFAULT);
				lbAppImg.setIcon(new ImageIcon(newImage));
				lbAppImg.setVisible(true);
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btstats)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\StatsImg\\"));
			jfc.showOpenDialog(null);
			File StatsFile=jfc.getSelectedFile();
			StatsFileName="../src/StatsImg/"+StatsFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(StatsFileName));
				FileInputStream fin=new FileInputStream(StatsFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}
			
				ImageIcon icon = new ImageIcon(StatsFileName);
				Image newImage = icon.getImage().getScaledInstance(360, 180, Image.SCALE_DEFAULT);
				lbStatsImg.setIcon(new ImageIcon(newImage));
				lbStatsImg.setVisible(true);
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btinsert)
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
		
				String LangName=txlang.getText();
				
				stmt.executeUpdate("Create table if not exists LangTb(LangId int auto_increment primary key,LangName varchar(50) Unique,LangType varchar(100))");
				
				if(thlangtype.getText() != null && thistory.getText() != null && tbest.getText() != null && txsoft1.getText() != null &&
						txsoft2.getText() != null && txsoft3.getText() != null && txsoft4.getText() != null && txsoft5.getText() != null &&
						tindustries.getText() != null && tbooks.getText() != null && tlectures.getText() != null && logoFileName != null &&
						AppFileName != null && StatsFileName != null && SoftwareFileName != null && SoftwareFileName2 != null &&
						SoftwareFileName3 != null && SoftwareFileName4 != null && SoftwareFileName5 != null)
				{
					PreparedStatement pstmt=con.prepareStatement("Insert into LangTb(LangName,LangType) values(?,?)");
					pstmt.setString(1, txlang.getText());
					pstmt.setString(2, thlangtype.getText());
					pstmt.executeUpdate();
					
					LangName=LangName.replace("+", "p");
					LangName=LangName.replace("#", "sharp");
					LangName=LangName.replace("-", "_");
					
					stmt.executeUpdate("Create table if not exists "+LangName+"Tb(Logo varchar(50),LangType varchar(80) ,History varchar(255),"
							+ "Application varchar(80),Stats varchar(80),Bestfor varchar(255),Soft1Img varchar(80),soft1 varchar(80),"
							+ "Soft2Img varchar(80),soft2 varchar(80),Soft3Img varchar(80),soft3 varchar(80),"
							+ "Soft4Img varchar(80),soft4 varchar(80),Soft5Img varchar(80),soft5 varchar(80),"
							+ "Industry varchar(255),Books varchar(255),Lectures varchar(255))");
					
					pstmt=con.prepareStatement("Insert into "+LangName+"Tb(Logo,LangType,History,Application,Stats,Bestfor,Soft1Img,soft1,Soft2Img,"
							+ "soft2,Soft3Img,soft3,Soft4Img,soft4,Soft5Img,soft5,Industry,Books,Lectures)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

					pstmt.setString(1, logoFileName);
					pstmt.setString(2, thlangtype.getText());
					pstmt.setString(3, thistory.getText());
					pstmt.setString(4, AppFileName);
					pstmt.setString(5, StatsFileName);
					pstmt.setString(6, tbest.getText());
					pstmt.setString(7, SoftwareFileName);
					pstmt.setString(8, txsoft1.getText());
					pstmt.setString(9, SoftwareFileName2);
					pstmt.setString(10, txsoft2.getText());
					pstmt.setString(11, SoftwareFileName3);
					pstmt.setString(12, txsoft3.getText());
					pstmt.setString(13, SoftwareFileName4);
					pstmt.setString(14, txsoft4.getText());
					pstmt.setString(15, SoftwareFileName5);
					pstmt.setString(16, txsoft5.getText());
					pstmt.setString(17, tindustries.getText());
					pstmt.setString(18, tbooks.getText());
					pstmt.setString(19, tlectures.getText());
					pstmt.executeUpdate();
				
					lbgreet.setText("Insertion successful");
					lbgreet.setVisible(true);
					btinsert2.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill all the above columns", "Attention!", JOptionPane.ERROR_MESSAGE);
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
		
		else if(src==btinsert2) 
		{
			txlang.setText("");
			thlangtype.setText("");
			thistory.setText("");
			tbest.setText("");
			txsoft1.setText("");
			txsoft2.setText("");
			txsoft3.setText("");
			txsoft4.setText("");
			txsoft5.setText("");
			tindustries.setText("");
			tbooks.setText("");
			tlectures.setText("");
			
			lbAppImg.setIcon(null);
			lbAppImg.setVisible(false);
			lbStatsImg.setIcon(null);
			lbStatsImg.setVisible(false);
			
			btlogo.setIcon(null);
			btapp.setIcon(null);
			btstats.setIcon(null);
			btsoft1.setIcon(null);
			btsoft2.setIcon(null);
			btsoft3.setIcon(null);
			btsoft4.setIcon(null);
			btsoft5.setIcon(null);
			
			btinsert2.setVisible(false);
			lbgreet.setVisible(false);
			
			txlang.requestFocus();
		}
		
		else if(src==btsoft1)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\SoftwareImg\\"));
			jfc.showOpenDialog(null);
			File SoftwareFile=jfc.getSelectedFile();
			SoftwareFileName="../src/SoftwareImg/"+SoftwareFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(SoftwareFileName));
				FileInputStream fin=new FileInputStream(SoftwareFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}
				
				ImageIcon icon = new ImageIcon(SoftwareFileName);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btsoft1.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btsoft2)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\SoftwareImg2\\"));
			jfc.showOpenDialog(null);
			File SoftwareFile=jfc.getSelectedFile();
			SoftwareFileName2="../src/SoftwareImg2/"+SoftwareFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(SoftwareFileName2));
				FileInputStream fin=new FileInputStream(SoftwareFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}

				ImageIcon icon = new ImageIcon(SoftwareFileName2);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btsoft2.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else if(src==btsoft3)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\SoftwareImg3\\"));
			jfc.showOpenDialog(null);
			File SoftwareFile=jfc.getSelectedFile();
			SoftwareFileName3="../src/SoftwareImg3/"+SoftwareFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(SoftwareFileName3));
				FileInputStream fin=new FileInputStream(SoftwareFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}

				ImageIcon icon = new ImageIcon(SoftwareFileName3);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btsoft3.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(src==btsoft4)
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\SoftwareImg4\\"));
			jfc.showOpenDialog(null);
			File SoftwareFile=jfc.getSelectedFile();
			SoftwareFileName4="../src/SoftwareImg4/"+SoftwareFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(SoftwareFileName4));
				FileInputStream fin=new FileInputStream(SoftwareFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}

				ImageIcon icon = new ImageIcon(SoftwareFileName4);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btsoft4.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else 
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setCurrentDirectory(new File("E:\\Eclipse Workspace\\ProjectPrj\\src\\SoftwareImg5\\"));
			jfc.showOpenDialog(null);
			File SoftwareFile=jfc.getSelectedFile();
			SoftwareFileName5="../src/SoftwareImg5/"+SoftwareFile.getName();
			
			try
			{
				FileOutputStream fout=new FileOutputStream(new File(SoftwareFileName5));
				FileInputStream fin=new FileInputStream(SoftwareFile);
				byte[]buffer=new byte[1];
				
				while(fin.read(buffer)>0)
				{
					fout.write(buffer);
				}

				ImageIcon icon = new ImageIcon(SoftwareFileName5);
				Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				btsoft5.setIcon(new ImageIcon(newImage));
				fout.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

