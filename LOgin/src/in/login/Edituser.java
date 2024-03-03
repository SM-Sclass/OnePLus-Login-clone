package in.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Edituser extends JFrame implements ActionListener {
	
	JTextField Fname , Lname ,MailD;
	JPasswordField PassD;
	JRadioButton male ,female ,other;
	JDateChooser date;
	JButton confirm,cancel;
	String Id;
	
	Edituser(String usid)
	{
		setLayout(null);
		setTitle("SIGNUP");
		setSize(800 , 550);
		setVisible(true);
		setLocation(350 , 200);
		
		getContentPane().setBackground(Color.white);
		
		Id = usid;
		
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
		
//		JLabel Mob = new JLabel("Mobile No. : ");
//		Mob.setFont(new Font("Osward" , Font.BOLD,20));
//		Mob.setBounds(100 , 275 , 120 , 25);
//		add(Mob);
//		
//		MobD = new JTextField();
//		MobD.setBounds( 225, 277, 150, 20);
//		add(MobD);
		
		JLabel Pass = new JLabel("Password : ");
		Pass.setFont(new Font("Osward" , Font.BOLD,20));
		Pass.setBounds(100 , 275 , 120 , 20);
		add(Pass);
		
		PassD = new JPasswordField();
		PassD.setBounds( 225, 277, 150, 20);
		PassD.setFont(new Font("Arial" , Font.PLAIN , 14));
		add(PassD);
		
		confirm = new JButton("CONFIRM");
		confirm.setFont(new Font("Osward" , Font.BOLD,12));
		confirm.setBounds(225 , 325 , 150 , 22);
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		confirm.addActionListener(this);
		add(confirm);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Osward" , Font.BOLD,12));
		cancel.setBounds(385 , 325 , 150 , 22);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
	}

	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == confirm)
		{
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
			if(Name.equals(""))
			{
				JOptionPane.showMessageDialog(null , "First Name is Required");
			}
			else if(Sname.equals(""))
			{
				JOptionPane.showMessageDialog(null , "Last Name is Required");
			}
			else if(dob.equals(""))
			{
				JOptionPane.showMessageDialog(null , "DOB is Required");
			}
			else if(gender.equals("NULL"))
			{
				JOptionPane.showMessageDialog(null , "Select Gender");
			}
			else if(Pass.equals(""))
			{
				JOptionPane.showMessageDialog(null , "Password is Required");
			}
			try
			{
				
				ConT c = new ConT();
				
				String query = "UPDATE user  SET Name = ? , DOB= ? ,Sname = ? , email= ? , gender = ? , Password = ? Where usid = ?;";
	            PreparedStatement preparedStatement = c.c.prepareStatement(query);
	            
	            // Set parameter values for the prepared statement
	            preparedStatement.setString(1, Name);
	            preparedStatement.setString(2, dob);
	            preparedStatement.setString(3, Sname);
	            preparedStatement.setString(4, email);
	            preparedStatement.setString(5, gender);
	            preparedStatement.setString(6, Pass);
	            preparedStatement.setString(7, Id);

	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            c.c.close();
				
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			setVisible(false);
			new USERDETAILS(Id).setVisible(true);
			
		}else if(a.getSource() == cancel)
		{
			setVisible(false);
			new USERDETAILS(Id).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Edituser("9004031324");
	}

}
