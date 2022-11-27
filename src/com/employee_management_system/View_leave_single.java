package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_leave_single extends JFrame{
	JTable t;
	String x[]= {"Employee ID","Name","Email","Start Date","End Date","Reason","Apply Date"};
	String y[][]= new String[20][7];
	int i=0,j=0;
	Font f,f1;
	int count=0;
	
	 View_leave_single(String eid) 
	 {
		 super("Particular Employee Leave record");
		setSize(1480,400);
		setLocation(0,10);
			
			f = new Font("MS UI Gothic" , Font.BOLD,17);
			
			try {
				
				ConnectionClass obj = new ConnectionClass();
				String q ="Select * from Apply_Leave where Eid ='"+eid+"'";
				ResultSet rest = obj.stm.executeQuery(q);
				while(rest.next()) {
				count++;

				y[i][j++]=rest.getString("eid");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("email");
				y[i][j++]=rest.getString("start_date");
				y[i][j++]=rest.getString("end_date");
				y[i][j++]=rest.getString("reason");
				y[i][j++]=rest.getString("apply_date");
					
					i++;
					j=0;
				}
				if(count==0){
					JOptionPane.showMessageDialog(null,"No Record Found.");
				}
				else {
					t=new JTable(y,x);
					t.setBackground(Color.WHITE);
					t.setForeground(Color.BLACK);
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
	
