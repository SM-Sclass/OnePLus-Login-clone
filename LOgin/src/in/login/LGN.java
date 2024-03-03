package in.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class LGN extends JFrame implements ActionListener {
	
	JTextField MobD;
	JPasswordField PassD;
	JButton login , clear , signup;
	
	LGN()
	{
		setLayout(null);
		setTitle("LOGIN");
		setSize(800 , 550);
		setVisible(true);
		setLocation(350 , 200);
		
		getContentPane().setBackground(Color.white);
		
		
		JLabel Mob = new JLabel("Mobile No. : ");
		Mob.setFont(new Font("Osward" , Font.BOLD,20));
		Mob.setBounds(100 , 225 , 120 , 25);
		add(Mob);
		
		MobD = new JTextField();
		MobD.setBounds( 225, 227, 310, 20);
		add(MobD);
		
		JLabel Pass = new JLabel("Password : ");
		Pass.setFont(new Font("Osward" , Font.BOLD,20));
		Pass.setBounds(100 , 275 , 120 , 20);
		add(Pass);
		
		PassD = new JPasswordField();
		PassD.setBounds( 225, 277, 310, 20);
		PassD.setFont(new Font("Arial" , Font.PLAIN , 14));
		add(PassD);
		
		login = new JButton("SIGNIN");
		login.setFont(new Font("Osward" , Font.BOLD,12));
		login.setBounds(225 , 325 , 150 , 22);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Osward" , Font.BOLD,12));
		clear.setBounds(385 , 325 , 150 , 22);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGNUP");
		signup.setFont(new Font("Osward" , Font.BOLD,12));
		signup.setBounds(225 , 375 , 310 , 25);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		
		
	}
	
	 public void actionPerformed(ActionEvent ap)
	 {
		 if(ap.getSource() == clear)
		 {
				
				MobD.setText("");
				PassD.setText(""); 
		 }
		 else if(ap.getSource() == login)
		 {
			 ConT c;
			try {
			c = new ConT();
			 String Id = MobD.getText();
			 String Pswd = PassD.getText();
			 String query = "Select * from user Where Usid = '"+Id+"' AND  Password = '"+Pswd+"';";
//			 PreparedStatement preparedStatement = c.c.prepareStatement(query);
			 
	           
			 
			 ResultSet rs = c.Stm.executeQuery(query);
					 
					 if(rs.next())
					 {
						setVisible(false);
			            new USERDETAILS(Id).setVisible(true);
					 }
					 else 
					 {
						 JOptionPane.showMessageDialog(null, "Invalid");
					 }
			}		 
			    
			 catch (Exception e)
			 {
				 System.out.println(e);
			 }
			 
			 
		 }
		 else if (ap.getSource() == signup){
			 setVisible(false);
			 new Signupone().setVisible(true);
		 }
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LGN();
		
	}

}
