import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

public class Cpp extends JApplet
{
	Font F;
	Color C;
	JScrollPane Jsp;
	JPanel Plang,Phistory,Papp,Pbest,Pstats,Pindustry,Psoft,Pbooks,Plectures;
	JTextArea thistory,tindustry,tbest,tbooks,tlecture;
	JLabel lblang,lbsoftware,lbindustry,lbapp,lbbest,lbstats,lbhistory,lbbooks,lblectures,lbsuggest;
	JLabel lbstatsimg,lblogo,lbappimg,lbsoft1,lbsoft2,lbsoft3,lbsoft4,lbsoft5,lbsoft1img,lbsoft2img,lbsoft3img,lbsoft4img,lbsoft5img;
	
	public void init()
	{
		F=new Font("comic sans",Font.PLAIN,40);
		lblang=new JLabel("C++");
		lblang.setForeground(Color.GREEN);
		lblang.setFont(F);
		
		F=new Font("comic sans",Font.PLAIN,20);
		lbhistory=new JLabel("History");
		lbhistory.setForeground(Color.RED);
		lbhistory.setFont(F);
		lbindustry=new JLabel("Industries");
		lbindustry.setForeground(Color.RED);
		lbindustry.setFont(F);
		lbbooks=new JLabel("Books");
		lbbooks.setForeground(Color.RED);
		lbbooks.setFont(F);
		lblectures=new JLabel("Lectures");
		lblectures.setForeground(Color.RED);
		lblectures.setFont(F);
		lbsuggest=new JLabel("Suggestions");
		lbsuggest.setForeground(Color.RED);
		lbsuggest.setFont(F);
		lbbest=new JLabel("Best For:");
		lbbest.setForeground(Color.RED);
		lbbest.setFont(F);
		lbapp=new JLabel("Application of C++");
		lbapp.setForeground(Color.RED);
		lbapp.setFont(F);
		lbstats=new JLabel("C++ staticts");
		lbstats.setForeground(Color.RED);
		lbstats.setFont(F);
		
		lblogo=new JLabel(new ImageIcon("../src/Images/C++.png"));
		lbappimg=new JLabel(new ImageIcon("../src/Images/Application-of-C.jpg"));
		lbstatsimg=new JLabel(new ImageIcon("../src/Images/popularity.jpg"));
		lbsoft1img=new JLabel(new ImageIcon("../src/Images/Dev.png"));
		lbsoft2img=new JLabel(new ImageIcon("../src/Images/visualstudio.jpg"));
		lbsoft3img=new JLabel(new ImageIcon("../src/Images/codeblocks.jpg"));
		lbsoft4img=new JLabel(new ImageIcon("../src/Images/eclipse.jpg"));
		lbsoft5img=new JLabel(new ImageIcon("../src/Images/codelite.jpg"));
		
		F=new Font("comic sans",Font.PLAIN,20);
		lbsoftware=new JLabel("Popular Softwawres for C++");
		lbsoftware.setForeground(Color.RED);
		lbsoftware.setFont(F);
		lbsoft1=new JLabel("Dev-C++");
		lbsoft1.setForeground(Color.BLACK);
		lbsoft2=new JLabel("VisualStudio");
		lbsoft2.setForeground(Color.BLACK);
		lbsoft3=new JLabel("CodeBlocks");
		lbsoft3.setForeground(Color.BLACK);
		lbsoft4=new JLabel("Eclipse");
		lbsoft4.setForeground(Color.BLACK);
		lbsoft5=new JLabel("Codelite");
		lbsoft5.setForeground(Color.BLACK);
		
		C=new Color(125,20,125);
		F=new Font("comic sans",Font.PLAIN,15);
		thistory=new JTextArea();
		thistory.setForeground(Color.BLACK);
		thistory.setBackground(C);
		thistory.setText("Before the initial standardization in 1998, C++ was developed by "
				+ "Danish computer scientist Bjarne Stroustrup at Bell Labs since 1979 as an "
				+ "extension of the C language; he wanted an efficient and flexible language "
				+ "similar to C that also provided high-level features for program organization.");
		thistory.setFont(F);
		
		tindustry=new JTextArea();
		tindustry.setForeground(Color.BLACK);
		tindustry.setBackground(C);
		tindustry.setText("# ISRO\r\n" + 
				"# Cisco networks\r\n" + 
				"# Nvidia\r\n" + 
				"# Symantec\r\n" + 
				"# Amdocs\r\n" + 
				"# KPIT\r\n" + 
				"# Imagination technology\r\n" + 
				"# GS lab\r\n" + 
				"# IBM\r\n" + 
				"# Pubmatic\r\n" + 
				"# Thoughtworks\r\n" + 
				"# TCS\r\n" + 
				"# Marvell semiconductors\r\n" + 
				"# Igate\r\n" + 
				"# Tech mahindra\r\n" + 
				"# INFOSYS\r\n" + 
				"# Wipro\r\n" + 
				"# Geometric software\r\n" + 
				"# 3DPLM\r\n" + 
				"# Emerson\r\n" + 
				"# Ericson\r\n" + 
				"# Bosch Engineering\r\n" + 
				"# Persistent system\r\n" + 
				"# Captronic systems\r\n" + 
				"# Atos\r\n" + 
				"# Ittiam system\r\n" + 
				"# Aricent\r\n" + 
				"# Eaton\r\n" + 
				"# Sungaurd\r\n" + 
				"# Capgemini\r\n" + 
				"# Syntel\r\n" + 
				"# Zte");
		
		tbest=new JTextArea();
		tbest.setForeground(Color.BLACK);
		tbest.setBackground(C);
		tbest.setFont(F);
		tbest.setText("# Games\n"
				+ "# operating systems and\n"
				+ "# very low-level programming that requires better control of hardware on the PC or server");
		
		
		tbooks=new JTextArea();
		tbooks.setForeground(Color.BLACK);
		tbooks.setBackground(C);
		tbooks.setFont(F);
		tbooks.setText("1).Stroustrup: The C++ Programming Language\n"
				+ "2).Accelerated C++: Practical Programming by Example by Andrew Koenig and Barbara E. Moo/n"
				+ "3).C++ Primer (5th Edition) 5th Edition by Stanley B. Lippman, Josée Lajoie, and Barbara E. Moo\n"
				+ "4).Effective Modern C++: 42 Specific Ways to Improve Your Use of C++11 and C++14 (1st Edition) by Scott Meyers\n"
				+ "5).Exceptional C++: 40 New Engineering Puzzles, Programming Problems, and Solutions by Herb Sutter\n");

		tlecture=new JTextArea();
		tlecture.setForeground(Color.BLACK);
		tlecture.setBackground(C);
		tlecture.setFont(F);
		tlecture.setText("# URDUIT Academy\n"
				+ "# freecodecamp.org\n"
				+ "# learn.com\n"
				+ "# ProgrammingKnowledge\n"
				+ "# C++ by saurabh shukla");
		
		Plang=new JPanel();
		Plang.setBackground(C);
		Plang.setLayout(new FlowLayout(FlowLayout.LEFT));
		Plang.add(lblogo);
		Plang.add(lblang);
		
		Phistory=new JPanel();
		Phistory.setBackground(C);
		Phistory.setLayout(new GridLayout(2,1,10,00));
		Phistory.add(lbhistory);
		Phistory.add(thistory);
		
		Papp=new JPanel();
		Papp.setBackground(C);
		Papp.add(lbapp);
		Papp.add(lbappimg);
		
		Pbest=new JPanel();
		Pbest.setBackground(C);
		Pbest.setLayout(new GridLayout(2,1,10,00));
		Pbest.add(lbbest);
		Pbest.add(tbest);
		
		Pstats=new JPanel();
		Pstats.setBackground(C);
		Pstats.setLayout(new GridLayout(2,1,10,00));
		Pstats.add(lbstats);
		Pstats.add(lbstatsimg);
		
		Psoft=new JPanel();
		Psoft.setBackground(C);
		Psoft.setLayout(new GridLayout(2,1,10,00));
		Psoft.add(lbsoftware);
		Psoft.add(new JLabel());
		Psoft.add(new JLabel());
		Psoft.add(new JLabel());
		Psoft.add(lbsoft1img);
		Psoft.add(lbsoft1);
		Psoft.add(lbsoft2img);
		Psoft.add(lbsoft2);
		Psoft.add(lbsoft3img);
		Psoft.add(lbsoft3);
		Psoft.add(lbsoft4img);
		Psoft.add(lbsoft4);
		Psoft.add(lbsoft5img);
		Psoft.add(lbsoft5);
		
		Pindustry=new JPanel();
		Pindustry.setBackground(C);
		Pindustry.setLayout(new GridLayout(2,1,10,00));
		Pindustry.add(lbindustry);
		Pindustry.add(tindustry);
		
		Pbooks=new JPanel();
		Pbooks.setBackground(C);
		Pbooks.setLayout(new GridLayout(2,1,10,00));
		Pbooks.add(lbbooks);
		Pbooks.add(tbooks);
		
		Plectures=new JPanel();
		Plectures.setBackground(C);
		Plectures.setLayout(new GridLayout(2,1,10,00));
		Plectures.add(lblectures);
		Plectures.add(tlecture);
		
		JPanel P=new JPanel();
		P.setLayout(new GridLayout(9,1,10,00));
		P.add(Plang);
		P.add(Phistory);
		P.add(Papp);
		P.add(Pbest);
		P.add(Pstats);
		P.add(Pindustry);
		P.add(Psoft);
		P.add(Pbooks);
		P.add(Plectures);
		
		Jsp=new JScrollPane();
		Jsp.setBackground(C);
		Jsp.setViewportView(P);
		
		setBackground(C);
		add(Jsp);
	}
	
	public Insets getInsets()
	{
		return new Insets(20, 150, 20, 150);
	}
}
