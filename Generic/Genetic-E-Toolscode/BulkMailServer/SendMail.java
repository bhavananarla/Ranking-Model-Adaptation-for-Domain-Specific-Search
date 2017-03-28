import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;

public class SendMail 
{
    
    public static void main(String[] argv) 
    {
	ResultSet rs1=null,rs2=null,rs3=null,rs4=null;
	String from="admin@localhost";
	Connection con=null;
	Statement stmt1=null,stmt2=null,stmt3=null,stmt4=null;


	String subject="From Webmaster";
	String content,listname;
	int msgid;
	String sql1=null,sql2=null,sql3=null,sql4=null;

	try
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","scott","tiger");
		stmt1 = con.createStatement();
		stmt2=con.createStatement();
		stmt3=con.createStatement();
		stmt4=con.createStatement();
		
		sql1 = "select * from message where status = 0 ";
		rs1 = stmt1.executeQuery(sql1);

			while(rs1.next())
			{
				msgid = rs1.getInt(1);
				content = rs1.getString(2);
				listname = rs1.getString(4);
	
				System.out.println(listname);

				sql2 = "select listno from listmaster where listname = '"+listname+"'";
				rs2 = stmt2.executeQuery(sql2);
				rs2.next();
				

				int listno = rs2.getInt(1);
				System.out.println(listno);
				sql3 = "select email from listdetails where listno = "+listno;

				rs3 = stmt3.executeQuery(sql3);
				while(rs3.next())
				{
					String email = rs3.getString(1);
					System.out.println(email);
					String mailhost = "localhost";
					Properties props = System.getProperties();
					String mailer = "MyMailerProgram";
					props.put("mail.smtp.host", mailhost);
					Session session = Session.getDefaultInstance(props, null);
					Message msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(from));
					String msg_text=content;									
		   			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email,false));
					msg.setSubject(subject);
					msg.setHeader("X-Mailer", mailer);
					msg.setSentDate(new Date());
					msg.setText(msg_text);
					Transport.send(msg);
					sql4 = "update message set status = 1 where messageid = "+msgid;
					stmt4.executeUpdate(sql4);
				}
				
				
		       }//while loop
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt1.close();
				stmt2.close();
				stmt3.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
    }
}
