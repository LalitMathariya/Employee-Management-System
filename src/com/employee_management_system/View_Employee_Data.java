package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_Employee_Data implements ActionListener
{
	JFrame f;
	JLabel id,eid,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,eid1, eid2,eid3,eid4,eid5,eid6,eid7,eid8;
	String emp_id,name,father,address,phone,email,education,post,age,dob,adhar;
	JButton b1,b2;
	ImageIcon icon;
	
	
	View_Employee_Data(String Eid)
	{
		try 
		{
			ConnectionClass obj = new ConnectionClass();
			String 	q = "Select * from employee where Eid ='"+Eid+"'";
			ResultSet rs = obj.stm.executeQuery(q);
			
			while(rs.next()) {
				name = rs.getString("name");
				father = rs.getString("fname");				
				age = rs.getString("age");
				dob = rs.getString("dob");				
				address = rs.getString("address");
				phone = rs.getString("phone");				
				email = rs.getString("email");
				education = rs.getString("education");				
				post = rs.getString("job_post");
				adhar = rs.getString("adhar");
				emp_id = rs.getString("Eid");
				
				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		f = new JFrame("Display Employee Details");
		f.setVisible(true);
		f.setSize(595,642);
		f.setLocation(450,200);
		f.setBackground(Color.WHITE);
		f.setLayout(null);
		
		id9 = new JLabel();
		id9.setBounds(0,0,595,642);
		id9.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("com/employee_management_system/icons/HomePage.jpg"));
		id9.setIcon(img);
		
		id8 = new JLabel("Employee Details");
		id8.setBounds(170,10,250,40);
		f.add(id8);
		id8.setFont(new Font("Airal" , Font.BOLD,28));
		id9.add(id8);
		f.add(id9);
		
		id = new JLabel("Employee Id");
		id.setBounds(180,70,120,30);
		id.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id);
		
		eid = new JLabel(emp_id);
		eid.setBounds(330,70,200,30);
		eid.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid);
		
		
		
		id1 = new JLabel("Name");
		id1.setBounds(180,120,300,30);
		id1.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id1);
		
		eid1 = new JLabel(name);
		eid1.setBounds(330,120,200,30);
		eid1.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid1);
		
		id2 = new JLabel("Father's name");
		id2.setBounds(180,170,300,30);
		id2.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id2);
		
		eid2 = new JLabel(father);
		eid2.setBounds(330,170,200,30);
		eid2.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid2);
		
		id3 = new JLabel("Address");
		id3.setBounds(180,220,300,30);
		id3.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id3);
		
		eid3 = new JLabel(address);
		eid3.setBounds(330,220,200,30);
		eid3.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid3);
		
		id4 = new JLabel("Phone No.");
		id4.setBounds(180,270,300,30);
		id4.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id4);
		
		eid4 = new JLabel(phone);
		eid4.setBounds(330,270,200,30);
		eid4.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid4);
		
		id5 = new JLabel("Email");
		id5.setBounds(180,320,300,30);
		id5.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id5);
		
		eid5 = new JLabel(email);
		eid5.setBounds(330,320,200,30);
		eid5.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid5);
		
		id6 = new JLabel("Education");
		id6.setBounds(180,370,300,30);
		id6.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id6);
		
		eid6 = new JLabel(education);
		eid6.setBounds(330,370,200,30);
		eid6.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid6);
		
		id7 = new JLabel("Job Post");
		id7.setBounds(180,420,300,30);
		id7.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id7);
		
		eid7 = new JLabel(post);
		eid7.setBounds(330,420,200,30);
		eid7.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid7);
		
		
		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(160,520,100,30);
		b1.addActionListener(this);
		id9.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.RED);
		b2.setForeground(Color.WHITE);
		b2.setBounds(350,520,100,30);
		b2.addActionListener(this);
		id9.add(b2);
		
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1) {
			JOptionPane.showMessageDialog(null, "Printed Successfully");
			f.setVisible(false);
			new HomePage();
		}
		if(e.getSource()==b2) {
			f.setVisible(false);
			new View_Employee();
		}
		
	}
	
}
