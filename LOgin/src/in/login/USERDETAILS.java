package in.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class USERDETAILS extends JFrame implements ActionListener {
	
	JButton edit;
	String Id;
	
	USERDETAILS( String sp)
	{
		setLayout(null);
		setTitle("User");
		setSize(800 , 550);
		setVisible(true);
		setLocation(350 , 200);
		
	    Id = sp;
		
		JLabel DEtail = new JLabel();
		DEtail.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail.setBounds(100 , 225 , 180 , 25);
		add(DEtail);
		
		JLabel DEtail2 = new JLabel();
		DEtail2.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail2.setBounds(100 , 275 , 350 , 25);
		add(DEtail2);
		
		JLabel DEtail3 = new JLabel();
		DEtail3.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail3.setBounds(100 , 325 , 350 , 25);
		add(DEtail3);
		
		JLabel DEtail4 = new JLabel();
		DEtail4.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail4.setBounds(100 , 375 , 350 , 25);
		add(DEtail4);
		
		JLabel DEtail5 = new JLabel();
		DEtail5.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail5.setBounds(100 , 425 , 350 , 25);
		add(DEtail5);
		
		JLabel DEtail6 = new JLabel();
		DEtail6.setFont(new Font("Osward" , Font.BOLD,20));
		DEtail6.setBounds(100 , 475 , 350 , 25);
		add(DEtail6);
		
		
		try {
			 ConT c = new ConT();
			 String query = "SELECT * FROM user WHERE Usid = '"+sp+"' ;";
//			 PreparedStatement preparedStatement = c.c.prepareStatement(query);
			 
			 ResultSet rs = c.Stm.executeQuery(query);
			 
			 if(rs.next())
			 {
				 DEtail.setText("Name : " + rs.getString("Name"));
				 DEtail2.setText("LastName : " + rs.getString("Sname"));
				 DEtail3.setText("Date of Birth : " + rs.getString("DOB"));
				 DEtail4.setText("GENDER : " + rs.getString("gender"));
				 DEtail5.setText("EMAIL : " + rs.getString("email"));
				 DEtail6.setText("Password : " + rs.getString("Password"));
			 }
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		edit = new JButton("EDIT");
		edit.setFont(new Font("Osward" , Font.BOLD,12));
		edit.setBounds(105 , 525 , 150 , 22);
		edit.setBackground(Color.black);
		edit.setForeground(Color.white);
		edit.addActionListener(this);
		add(edit);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == edit)
		{
			try
			{
				setVisible(false);
				new Edituser(Id).setVisible(true);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new USERDETAILS("9876543110");

	}

}
