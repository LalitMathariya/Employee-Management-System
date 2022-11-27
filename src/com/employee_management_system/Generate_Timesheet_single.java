package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Generate_Timesheet_single extends JFrame
{
	JTable t;
	String x[] = {"Employee ID" , "Name","Email","First Half" , "Second Half" ,"date"};
	String y[][] = new String [20][6];
	int i=0,j=0;
	Font f,f1;
	int count=0;

	
	Generate_Timesheet_single(String eid)
	{
		super("Particular Employee attendence record");
		setSize(1480,400);
		setLocation(0,10);
		
		f = new Font("MS UI Gothic" , Font.BOLD,17);
		
		try {
			
			ConnectionClass obj = new ConnectionClass();
			String q ="Select * from attendence where Eid ='"+eid+"'";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()) {
				count++;
				y[i][j++]=rest.getString("Eid");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("Email");
				y[i][j++]=rest.getString("first_name");
				y[i][j++]=rest.getString("second_name");
				y[i][j++]=rest.getString("day_date");
				i++;
				j=0;
			}
			if(count==0){
				JOptionPane.showMessageDialog(null,"No Record Found.");
			}
			else {
				t=new JTable(y,x);
				t.setBackground(Color.BLACK);
				t.setForeground(Color.WHITE);
				t.setFont(f);
				setSize(1480,400);
				setLocation(0,10);
				JScrollPane js = new JScrollPane(t);
				add(js);
				}
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
