package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_Employee_Data implements ActionListener
{
	JFrame f;
	JLabel id,eid,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11;
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
		
		eid = new JLabel("emp_id");
		eid.setBounds(330,70,200,30);
		eid.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid);
		
		id1 = new JLabel("Name");
		id1.setBounds(330,120,300,30);
		id1.setFont(new Font("serif",Font.BOLD,20));
		id9.add(id1);
		
		eid = new JLabel("emp_id");
		eid.setBounds(330,70,200,30);
		eid.setFont(new Font("serif",Font.BOLD,20));
		id9.add(eid);
		
		
		
		
	}
	public void actionPerformed(ActionEvent e){
		
		
	}
	public static void main(String [] args){
		
	}
}
