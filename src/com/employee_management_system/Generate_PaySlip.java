package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Generate_PaySlip extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6;
	JButton bt1,bt2;
	JPanel p1;
	JTextArea ta;
	Font f;
	Choice ch1,ch2,ch3;
	
	Generate_PaySlip() {
		super("Generate Pay Slip");
		setLocation(100,100);
		setSize(500,500);
		setResizable(false);
		
		f = new Font("arial",Font.BOLD,16);
		
		l1 = new JLabel("Employee Id");
		l2 = new JLabel("Month");
		l3 = new JLabel("Year");
		
		l1.setFont(f);
		l2.setFont(f);
		l3 .setFont(f);
		
		ch1 = new Choice();
		ch2 = new Choice();
		ch3 = new Choice();
		
		try {
		ConnectionClass obj = new ConnectionClass();
		String 	q = "Select * from employee";
		ResultSet rest = obj.stm.executeQuery(q);
		while(rest.next()) {
			ch1.add(rest.getString("Eid"));
			}
		} 
		catch(Exception exx) {
		exx.printStackTrace();
		}
		
		ch2.add("January");
		ch2.add("Febuary");
		ch2.add("March");
		ch2.add("April");
		ch2.add("May");
		ch2.add("June");
		ch2.add("July");
		ch2.add("August");
		ch2.add("September");
		ch2.add("October");
		ch2.add("November");
		ch2.add("December");
		
		ch3.add("2018");
		ch3.add("2019");
		ch3.add("2020");
		ch3.add("2021");
		ch3.add("2022");
		
		ch1.setFont(f);
		ch2.setFont(f);
		ch3.setFont(f);
		
		bt1 = new JButton("Print");
		bt2 = new JButton("Close");
		
		bt1.setFont(f);
		bt2.setFont(f);
		
		bt1.setBackground(Color.BLACK);
		bt1.setForeground(Color.WHITE);
		
		bt2.setBackground(Color.BLACK);
		bt2.setForeground(Color.WHITE);
			
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4,2,10,10));
		p1.add(l1);
		p1.add(ch1);
		p1.add(l2);
		p1.add(ch2);
		p1.add(l3);
		p1.add(ch3);
		p1.add(bt1);
		p1.add(bt2);
		
		ta = new JTextArea();
		JScrollPane sp  = new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(f);

		setLayout(new BorderLayout());
		add(sp,"Center");
		add(p1,"South");
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if(e.getSource() == bt1) {
			ta.setText("----------Pay Slip--------");
			try {
				ConnectionClass obj1 = new ConnectionClass();
				String id = ch1.getSelectedItem();
				String month_year = ch2.getSelectedItem();
				String q1 = "Select * form employee where Eid ='"+id+"'";
				ResultSet rest1 = obj1.stm.executeQuery(q1);
				while(rest1.next()) {
					ta.append("\n\nEmployee id : "+Integer.parseInt(rest1.getString("id")));
					ta.append("\nEmployee Name :"+rest1.getString("name"));
					ta.append("\nEmployee Email : "+rest1.getString("email"));
					ta.append("\n-----------------------------------\n\n");
				}
				
				String q2 = "Select * form salary where month_year ='"+month_year+"' and Eid='"+id+"'";
				ResultSet rest2 = obj1.stm.executeQuery(q2);
				if(rest2.next()==false) {
					ta.append("\n-----------------------------------\n\n");
					ta.append("Record Not Found for this month and year.\n");
					ta.append("\n----------------OR---------------\n\n");
					ta.append("Please add the salary of this month and year for this record. \n");
				}
				else {
					
					ta.append("\n\nHRA : "+Integer.parseInt(rest2.getString("hra")));
					ta.append("\nDA :"+rest2.getString("da"));
					ta.append("\nMED : "+rest2.getString("mid"));
					ta.append("\nPF : "+rest2.getString("pf"));
					ta.append("\nBasic Salary : "+rest2.getString("basic"));
					ta.append("\n-----------------------------------\n\n");
					float gross_salary = Float.parseFloat(rest2.getString("hra"))+Float.parseFloat(rest2.getString("da"))+Float.parseFloat(rest2.getString("mid"))+Float.parseFloat(rest2.getString("pf"))+Float.parseFloat(rest2.getString("basic"));
					double tax = (gross_salary*2.1)/100;
					ta.append("\nGross Salary : "+gross_salary);
					ta.append("\nTotal : "+gross_salary);
					ta.append("\ntax 2.1% of salary : "+ tax);
					ta.append("\n\nHRA : "+Integer.parseInt(rest2.getString("hra")));
				}
			}
			catch(Exception exx) 
			{
				exx.printStackTrace();
			}
		}
		if(e.getSource()==bt2) {
			JOptionPane.showMessageDialog(null,"Are you Sure");
			setVisible(false);
		}
	}
}

