package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {
	
	JLabel l1;
	Font f1,f2,f3;
	JPanel p1;
	
	
	
	HomePage()
	{
		super("Employee Home Page");
		setLocation(0,0);
		setSize(1550,800);
		
		f1= new Font("Lucida Fax",Font.BOLD,20);
		f2= new Font("Lucida Fax",Font.BOLD,20);
		f3= new Font("Lucida Fax",Font.BOLD,20);
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("com/employee_management_system/icons/HomePage.jpg"));
		Image img = ic.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(img);
		l1= new JLabel(ic1);
		
		JMenuBar m1 = new JMenuBar();
		JMenu men1 = new JMenu("Profile");
		JMenuItem ment1 = new JMenuItem("Complete Profile");
		JMenuItem ment2 = new JMenuItem("View Profile");
		
		JMenu men2 = new JMenu("Manage");
		JMenuItem ment3= new JMenuItem("Update Details");
		
		JMenu men3 = new JMenu("Attendence");
		JMenuItem ment4= new JMenuItem("Take Attendence");
		JMenuItem ment5 = new JMenuItem("View Attendence");
		
		JMenu men4 = new JMenu("Leave");
		JMenuItem ment6 = new JMenuItem("Apply Leave");
		JMenuItem ment7 = new JMenuItem("View Leaves");
		
		JMenu men5 = new JMenu("Salary");
		JMenuItem ment8= new JMenuItem("Add Salary");
		JMenuItem ment9= new JMenuItem("Generate Salary Slip");
		
		
		
		JMenu men7 = new JMenu("Delete");
		JMenuItem ment11 = new JMenuItem("Delete Employee");
		
		JMenu men6 = new JMenu("Exit");
		JMenuItem ment10 = new JMenuItem("LogOut");
		
		
		men1.add(ment1);
		men1.add(ment2);
		men2.add(ment3);
		men3.add(ment4);
		men3.add(ment5);
		men4.add(ment6);
		men4.add(ment7);
		men5.add(ment8);
		men5.add(ment9);
		men6.add(ment10);
		men7.add(ment11);
		
		m1.add(men1);
		m1.add(men2);
		m1.add(men3);
		m1.add(men4);
		m1.add(men5);
		m1.add(men7);
		m1.add(men6);
		
		
		men1.setFont(f1);
		men2.setFont(f1);
		men3.setFont(f1);
		men4.setFont(f1);
		men5.setFont(f1);
		men6.setFont(f1);
		men7.setFont(f1);
		
		
		ment1.setFont(f2);
		ment2.setFont(f2);
		ment3.setFont(f2);
		ment4.setFont(f2);
		ment5.setFont(f2);
		ment6.setFont(f2);
		ment7.setFont(f2);
		ment8.setFont(f2);
		ment9.setFont(f2);
		ment10.setFont(f2);
		ment11.setFont(f2);
		
		m1.setBackground(Color.BLACK);
		
		men1.setForeground(Color.GRAY);
		men2.setForeground(Color.GRAY);
		men3.setForeground(Color.GRAY);
		men4.setForeground(Color.GRAY);
		men5.setForeground(Color.GRAY);
		men6.setForeground(Color.RED);
		men7.setForeground(Color.GRAY);
		
		ment1.setForeground(Color.BLACK);
		ment2.setForeground(Color.BLACK);
		ment3.setForeground(Color.BLACK);
		ment4.setForeground(Color.BLACK);
		ment5.setForeground(Color.BLACK);
		ment6.setForeground(Color.BLACK);
		ment7.setForeground(Color.BLACK);
		ment8.setForeground(Color.BLACK);
		ment9.setForeground(Color.BLACK);
		ment10.setForeground(Color.BLACK);
		ment11.setForeground(Color.BLACK);
		
		
		setJMenuBar(m1);
		add(l1);
	}

	
	public void actionPerformed(ActionEvent e) {
		String comnd = e.getActionCommand();
		if(comnd.equals("Complete Profile"))
		{
			
			new Add_Employee();			
		}
		else if(comnd.equals("View Profile"))
		{
			new View_Employee();		
		}
		else if(comnd.equals("Update Details"))
		{
			new Update_Details_Data().setVisible(true);
		}
		else if(comnd.equals("Take Attendence")) 
		{
			new addTimesheet().setVisible(true);
		}
		else if(comnd.equals("View Attendence")) 
		{
			new addTimesheet().setVisible(true);
		}
		else if(comnd.equals("Apply Leave")) 
		{
			new Apply_Leave().setVisible(true);
		}
		else if(comnd.equals("View Leaves")) 
		{
			new View_Leaves().setVisible(true);
		}
		else if(comnd.equals("Add Salary")) 
		{
			new Salary().setVisible(true);
		}
		else if(comnd.equals("Generate Salary Slip")) 
		{
			new Generate_PaySlip().setVisible(true);
		}
		else if(comnd.equals("Delete Employee")) 
		{
			new Delete_Employee().setVisible(true);
		}
		else if(comnd.equals("LogOut")) 
		{
			System.exit(0);
		}
		
	}
	public static void main(String [] args) {
		new HomePage().setVisible(true);
	}
}
