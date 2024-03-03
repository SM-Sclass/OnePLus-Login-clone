package in.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConT {
	
	Connection c;
	Statement Stm;
	
	ConT() throws Exception
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3307/interv","root","");
		Stm = c.createStatement();
	    }
		catch (Exception e)
		{
			e.printStackTrace();
		
		
	}

	}

}
