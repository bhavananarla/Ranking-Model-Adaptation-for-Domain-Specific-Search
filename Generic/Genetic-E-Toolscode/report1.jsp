<%@ page import="java.sql.*"%>
<html>
 <body bgcolor=227050 align=center><br><br>
               <h1><center><img src="generic.bmp"></center></h1>
<% 

Class.forName("com.mysql.jdbc.Driver");
Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
System.out.println(con);

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from listmaster");


%>

 <br>
<br>
<form action="" method="post">
<center> <h2> List Name </h2> 
<select name="k">
<% while(rs.next()){ %>
<option><%= rs.getString(2)%></option>
<% } %>
</select>
</center><br>
<center><input type="submit" value="click-here" /></center>

</form><br><br>

<% 
	String str = request.getParameter("k");

		


ResultSet rs1 = st.executeQuery(" select * from listdetails where listno = (select listno from listmaster where listname='"+str+"')");


 %>

<br>

<center>


<table bgcolor="lightyellow" border="2" height="20" width="250">
<tr bgcolor="lightblue"><td align="center"  ><h2>Name</h2></td><td align="center"  ><h2>Mail</h2></td></tr>



<% while(rs1.next()) { %>
<center>
<tr><td align="center"  ><h2><%= rs1.getString("name") %></h2></td>



<td align="center"><h2><%= rs1.getString("email") %></h2></td></tr>

</center>
<% } %>
</table>
</center>

<Center><a href="Report.html"><font color="lightyellow" size="6">Back To Reports Page</font></a></center>

<% con.close(); %>

