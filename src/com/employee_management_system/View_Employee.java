package com.employee_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class View_Employee  implements ActionListener{
	
	JFrame f;
	JTextField t;
	JLabel l,l1,l2;
	JButton b, b1;
	
	
View_Employee()
{
	f = new JFrame("View Employee");
	f.setBackground(Color.GREEN);
	f.setLayout(null); 
	
	l1 = new JLabel();
	l1.setBounds(0,0,500,270);
	l1.setLayout(null);
	
	ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("com/employee_management_system/icons/viewemp.jpg"));
	Image img1 = img.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
	ImageIcon ic1 = new ImageIcon(img1);
	l1.setIcon(ic1);
	
	l2 = new JLabel("Employee Id");
	l2.setVisible(true);
	l2.setBounds(40,60,260,30);
	l2.setForeground(Color.BLACK);
	Font f1=new Font("Airal", Font.BOLD,30);
	l2.setFont(f1);
	l1.add(l2);
	f.add(l1);
	
	t = new JTextField();
	t.setBounds(240,60,220,30);
	l1.add(t);
	
	b = new JButton("Search");
	b.setBounds(140,150,100,30);
	b.addActionListener(this);
	l1.add(b);
	
	b1 = new JButton("Cancel");
	b1.setBackground(Color.RED);
	b1.setForeground(Color.WHITE);
	b1.addActionListener(this);
	b1.setBounds(260,150,100,30);
	l1.add(b1);
	
	f.setSize(500,270);
	f.setLocation(450,250);
	f.setVisible(true);

}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b)
	{
		f.setVisible(false);
		new View_Employee_Data(t.getText());
	}
	if(e.getSource()==b1) 
	{
	f.setVisible(false);
	new HomePage();	
	}
	
	
}
public static void main(String [] args) {
	new View_Employee();
}


}
