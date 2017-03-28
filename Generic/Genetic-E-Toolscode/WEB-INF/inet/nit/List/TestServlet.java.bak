package inet.nit.List;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import java.util.*;
import java.lang.*;
//import store.*;


public class TestServlet extends HttpServlet
{
HttpSession session;
ListMaster master;
//ListMaster master = new ListMaster();
public void storeElementsInHash(HttpServletRequest req)
{	 session= req.getSession(true);
	System.out.println(req.getParameter("name1")+"From storeElementsInHash");
	
	int previous=Integer.parseInt((String)session.getAttribute("previous"));
	int limit=Integer.parseInt((String)session.getAttribute("limit"));
	HashMap hash = (HashMap)session.getAttribute("hash");
	System.out.println("Previous:-"+previous+"   "+"limit"+"  "+limit);
	for(int i=previous;i<limit;i++)
	{
		String name=req.getParameter("name"+i);
		String email=req.getParameter("email"+i);
		System.out.println("IN TEST SERVLET1");
		System.out.println(name+"  "+email);
			session.setAttribute("name"+i, name);
			session.setAttribute("Email"+i, email);

		System.out.println("I AM CHECCKING FOR THE VALIE "+session.getAttribute("name"+i));
		System.out.println("I AM CHECCKING FOR THE VALIE"+ session.getAttribute("Email"+i));
	}
	//session.setAttribute("hash",hash);
System.out.println(hash.size());

}

public HttpSession getSession(HttpServletRequest req)
{
			System.out.println("From getSession");
	return req.getSession(true);
}

public Object getSessionElement(HttpServletRequest req,String element)
{
			System.out.println("From getSessionElement");
	return getSession(req).getAttribute(element);
}



public void storeInDatabase(HttpServletRequest req)
{
master = new ListMaster();
HttpSession session = req.getSession(true);
int listno = Integer.parseInt(((String)getSessionElement(req,"ListId")));
System.out.println("I AM CHECCKING FOR THE "+listno);
master.setListno(listno);

int getlist=master.getListno();	
master.setListname((String)getSessionElement(req,"ListName"));	
HashMap hash = (HashMap)getSessionElement(req,"hash");	
int size = hash.size();
System.out.println("Its From hashmap"+size);
	
int loop=Integer.parseInt((String)session.getAttribute("num_of_emp"));
			
	for(int i=0;i<loop;i++){
	/*String name= (String)hash.get("name"+i);
	System.out.println("MY NAME IS "+name);
	

	
	String mail=(String)hash.get("Email"+i);
	System.out.println("MY NAME IS "+mail);*/
	String name=(String)session.getAttribute("name"+i);
	String email=(String)session.getAttribute("Email"+i);
	
	ListDetail detail = new ListDetail();
	detail.setName(name);
	detail.setMailid(email);
	detail.setListno(getlist);
	System.out.println("from the get Listnoobserve"+detail.getListno());
	master.addListDetails(detail);
	System.out.println("IN TEST SERVLET DATABASE METHOD"+ email+"" + name+"");

	//master.setListno();
}

}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{	PrintWriter out = res.getWriter();
	try{
		java.util.Date d=new java.util.Date();
	long l=d.getTime();
	res.setDateHeader("expires",l);
	//ListMaster master = new ListMaster();
	HttpSession session=req.getSession(true);
	System.out.println("zero");

	storeElementsInHash(req);
		System.out.println("one");
	
		out.println("<html><head></head><body bgcolor=227050>");
		out.println("<center><img src=\"generic.bmp\"></center>");
	System.out.println("two");

	storeInDatabase(req);
	System.out.println("three");

	ListManager  Lman=new ListManager();
	System.out.println("four");

	Lman.StoreData(master);
		System.out.println("five");
	System.out.println(".....session id="+session.getId());
	session.invalidate();
	
			/*session=null;
		if(session==null){
			System.out.println("the session value is null");
			}*/
	//session.logout();
	

	out.println("<a href=\"ListPage.html\"><center>Home</center></a>");
	out.println("</body></html>");
		
		

		
	
	}
	catch(Exception e){
		System.out.println(e.getMessage());
      out.println("ListId Already Existed");
	out.println("<a href=\"CreateList\"><center>Back</center></a>");
	};
	

//"<a href =\"/WebForm/CreateListServlet?enter=false&i="+limit+" \ " >Next</a>"
}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	doPost(req,res);
}

}