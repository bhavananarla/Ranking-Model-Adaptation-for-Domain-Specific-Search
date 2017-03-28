<%@ page import="java.sql.*,java.util.*"%>
<html>
 <body bgcolor=227050 align=center><br><br>
               <h1><center><img src="generic.bmp"></center></h1>
<% 

Class.forName("com.mysql.jdbc.Driver");
Connection	con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
System.out.println(con1);

Statement st = con1.createStatement();
Statement st2 = con1.createStatement();

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
	String str= request.getParameter("k"); 
System.out.println(str);
String str1="select * from message where listname='"+str+"'";
System.out.println(str1);
ResultSet rs1 = st2.executeQuery(str1); 
 %>

<br>
 
<center><h1> The Form forwarded to the Group </h1></center>

<% while(rs1.next()) { %>
<% 
String comp = rs1.getString(2) ; 

StringTokenizer stz= new StringTokenizer(comp,":");
%>
<center>

<table bgcolor="lightyellow" border="2" height="20" width="250">



<% while(stz.hasMoreTokens()){ %>

		
<tr>
<td><%=stz.nextToken() %></td>
</tr>


<%
}
%>

</table>

</center>

 
<% } %>


<Center><a href="Report.html"><font color="lightyellow" size="6">Back To Reports Page</font></a></center>




