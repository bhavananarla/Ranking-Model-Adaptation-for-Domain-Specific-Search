package inet.nit.Form;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import java.util.*;
import java.lang.*;
//import store.*;


public class TestFormServlet extends HttpServlet
{

Form form;
//ListMaster master= new ListMaster()
public void storeElementsInHash(HttpServletRequest req)
{	HttpSession session = req.getSession(true);
	int previous=Integer.parseInt((String)session.getAttribute("previous"));
	int limit=Integer.parseInt((String)session.getAttribute("limit"));
	for(int i=previous;i<limit;i++)
	{
		String Fname=req.getParameter("Fname"+i);
		String Flength=req.getParameter("Flength"+i);
		
			session.setAttribute("Fname"+i, Fname);
			session.setAttribute("Flength"+i, Flength);

			}
	
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
	System.out.println("enter the method storeInDatabase");

//ListMaster master = new ListMaster();
	form = new Form();

HttpSession session = req.getSession(true);
int loop=Integer.parseInt((String)session.getAttribute("num_of_fields"));
int formid = Integer.parseInt(((String)session.getAttribute("FormId")));
System.out.println("the value is formid"+formid);
form.setFormId(formid);
form.setField(loop);
//int getlist=master.getListno();
form.setFormName((String)getSessionElement(req,"FormName"));
	System.out.println("before hashmap"	);
//HashMap hash = (HashMap)getSessionElement(req,"hash");	
//int size = hash.size();
//System.out.println("Its From hashmap"+size);
	

			
	for(int i=0;i<loop;i++){
	String Fname=(String)session.getAttribute("Fname"+i);
	int Flength=Integer.parseInt((String)session.getAttribute("Flength"+i));
	int getlist=form.getFormId();
	System.out.println("the value of ther getList"+ getlist);
	//ListDetail detail = new ListDetail();
	FormDetail detail = new FormDetail();
	detail.setFieldName(Fname);
	detail.setFieldLength(Flength);
	detail.setFormId(getlist);
	System.out.println("from the get Listnoobserve"+detail.getFormId());
	form.addFormDetails(detail);
	System.out.println("IN TEST SERVLET DATABASE METHOD"+Flength+"" +Fname+"");

	//master.setListno();
}

}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	try{
		java.util.Date d=new java.util.Date();
	long l=d.getTime();
	res.setDateHeader("expires",l);
	System.out.println("enter the method dopost()");	
	HttpSession session=req.getSession(true);
	storeElementsInHash(req);
		System.out.println("one");
	PrintWriter out = res.getWriter();
	out.println("<html><body bgcolor=227050>");
	System.out.println("two");

	storeInDatabase(req);
	System.out.println("three");
	FormManager Fman=new FormManager();
	System.out.println("four");

	Fman.StoreData(form);
		System.out.println("five");


	System.out.println("IN TEST SERVLET DOPOST");
		session.invalidate();
			
	
	out.println("<center><img src=\"generic.bmp\"></center>");
	out.println("<a href=\"FormPage.html\"><center>Home</center></a>");
	out.println("</body></html>");
		
		

		
	
	}
	catch(Exception e){
		System.out.println("the error is "+e.getMessage());
		
			
	};
	

}
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	doPost(req,res);
}

}