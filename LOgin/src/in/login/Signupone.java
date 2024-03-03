package in.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.PreparedStatement;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;


public class Signupone extends JFrame implements ActionListener {
	
	JTextField Fname,Lname,MailD , MobD;
//	JButton clear; 
	JPasswordField PassD;
	JButton signup;
	JDateChooser date;
	JRadioButton male ,female,other;
	
	Signupone()
	{
		setLayout(null);
		setTitle("SIGNUP");
		setSize(800 , 550);
		setVisible(true);
		setLocation(350 , 200);
		
		getContentPane().setBackground(Color.white);
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Osward" , Font.BOLD,20));
		name.setBounds(100 , 75 , 75 , 20);
		add(name);
		
		Fname = new JTextField();
		Fname.setBounds( 225, 77, 150, 20);
		add(Fname);
		
		Lname = new JTextField();
		Lname.setBounds(385, 77, 150, 20);
		add(Lname);
		
		JLabel DOB = new JLabel("DOB : ");
		DOB.setFont(new Font("Osward" , Font.BOLD,20));
		DOB.setBounds(100 , 125 , 75 , 25);
		add(DOB);
		
		date = new JDateChooser();
		date.setBounds( 225, 127, 150, 20);
		add(date);
		
		JLabel Gen = new JLabel("Gender : ");
		Gen.setFont(new Font("Osward" , Font.BOLD,20));
		Gen.setBounds(100 , 175 , 90 , 25);
		add(Gen);
		
		male = new JRadioButton("MALE");
		male.setBounds( 225, 177, 75, 20);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("FEMALE");
		female.setBounds( 305, 177, 75, 20);
		female.setBackground(Color.white);
		add(female);
		
		other = new JRadioButton("OTHER");
		other.setBounds( 385, 177, 75, 20);
		other.setBackground(Color.white);
		add(other);
		
		
		
		JLabel Email = new JLabel("Email : ");
		Email.setFont(new Font("Osward" , Font.BOLD,20));
		Email.setBounds(100 , 225 , 75 , 25);
		add(Email);
		
		MailD = new JTextField();
		MailD.setBounds( 225, 227, 150, 20);
		add(MailD);
		
		JLabel Mob = new JLabel("Mobile No. : ");
		Mob.setFont(new Font("Osward" , Font.BOLD,20));
		Mob.setBounds(100 , 275 , 120 , 25);
		add(Mob);
		
		MobD = new JTextField();
		MobD.setBounds( 225, 277, 150, 20);
		add(MobD);
		
		JLabel Pass = new JLabel("Password : ");
		Pass.setFont(new Font("Osward" , Font.BOLD,20));
		Pass.setBounds(100 , 325 , 120 , 20);
		add(Pass);
		
		PassD = new JPasswordField();
		PassD.setBounds( 225, 327, 150, 20);
		PassD.setFont(new Font("Arial" , Font.PLAIN , 14));
		add(PassD);
		
		signup = new JButton("SIGNUP");
		signup.setFont(new Font("Osward" , Font.BOLD,12));
		signup.setBounds(385 , 375 , 150 , 22);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
//		signup = new JButton("SIGNUP");
//		signup.setFont(new Font("Osward" , Font.BOLD,12));
//		signup.setBounds(225 , 375 , 150 , 22);
//		signup.setBackground(Color.black);
//		signup.setForeground(Color.white);
//		
//		add(signup);
	}
	
	
	public void actionPerformed(ActionEvent AP)
	{
		String Id = MobD.getText();
		String Name = Fname.getText();
		String Sname = Lname.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String gender ="NULL";
		String email = MailD.getText();
		String Pass = PassD.getText();
		if(male.isSelected())
		{
			gender = "male";
		}
		else if(female.isSelected())
		{
			gender = "female";
		}
		else if(other.isSelected())
		{
			gender = "other";
		}
		
		try 
		{
			if(Name.equals(""))
			{
				JOptionPane.showMessageDialog(null , "First Name is Required");
			}
			else
			{
				ConT c = new ConT();
	            // Use a prepared statement to insert data into the database
	            String query = "INSERT INTO user (Usid, Name, DOB, Sname, email, gender , Password) VALUES (?, ?, ?, ?, ?, ?,?);";
	            PreparedStatement preparedStatement = c.c.prepareStatement(query);
	            
	            // Set parameter values for the prepared statement
	            preparedStatement.setString(1, Id);
	            preparedStatement.setString(2, Name);
	            preparedStatement.setString(3, dob);
	            preparedStatement.setString(4, Sname);
	            preparedStatement.setString(5, email);
	            preparedStatement.setString(6, gender);
	            preparedStatement.setString(7, Pass);

	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            c.c.close();
	            
	            if(AP.getSource() == signup)
	            {
	            	setVisible(false);
	            	new USERDETAILS(Id).setVisible(true);
	            }
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signupone();
	}

}
