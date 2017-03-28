package inet.nit.List;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
 
public class CreateListServlet extends HttpServlet
{

	int limit=0;
			int remember=0;

//Its For displaying boxes it takes 
//two variables previous and present the difference of  two variables gives number of boxes 

public StringBuffer displayBoxes(int previous,int present)
{
	StringBuffer out = new StringBuffer();
			
			out.append("<table align=center border =4 bgcolor=#bffcd3>");
			out.append("<h1><center>EnterListDetails</center></h1>");
		
		for(int j=previous;j<present;j++)
		{
			String name="name"+j;
			String email="email"+j;
			out.append("<tr><td>Name:</TD>");
			out.append("<td><input type=text name="+name+"></td>");
			//out.append("<td><input type=\"text\" name="+name+"\"></td>");
			out.append("<td>Email: </TD>");
			out.append("<td><input type=text name="+email+"></td></tr>");
			System.out.println("From Display Boxes");
		}
	
			return out;
}

public void createSession(HttpServletRequest req)
{
			HttpSession session=req.getSession(true);
			HashMap hash = new HashMap();
			session.setAttribute("ListId",req.getParameter("listid"));
			session.setAttribute("ListName",req.getParameter("listname"));
			int i = Integer.parseInt((String)req.getParameter("num_of_emp"));
			session.setAttribute("num_of_emp",i);
			limit = checkIt(0,i);
			session.setAttribute("previous",0+"");
			session.setAttribute("hash",hash);
			//session.setAttribute("limit",limit);
			System.out.println("From CreateSession");
}

public void storeElementsInHash(HttpServletRequest req)
{
	System.out.println(req.getParameter("name1")+"From storeElementsInHash");
	HttpSession session = req.getSession(true);
	int previous=Integer.parseInt((String)session.getAttribute("previous"));
	int limit=Integer.parseInt((String)session.getAttribute("limit"));
	
	System.out.println("Previous:-"+previous+"   "+"limit"+"  "+limit);
	for(int i=previous;i<limit;i++)
	{
		String name=req.getParameter("name"+i);
		String email=req.getParameter("email"+i);
		
			
			session.setAttribute("name"+i, name);
			session.setAttribute("Email"+i, email);
		System.out.println("HAI, THIS IS FROM SESSION"+ session.getAttribute("name"+i));
		System.out.println("HAI, THIS IS FROM SESSION"+ session.getAttribute("Email"+i));


	}
	

}

/*public void setSessionElement(HttpServletRequest req,String name,String email)
{
	getSession(req).setAttribute(name,value);
			System.out.println("From setSessionContext");
}*/

public HttpSession getSession(HttpServletRequest req)
{
			System.out.println("From getSession");
	return req.getSession(true);
}

/*public Object getSessionElement(HttpServletRequest req,String element)
{
			System.out.println("From getSessionElement");
	return getSession(req).getAttribute(element);
}*/


	public int checkIt(int previous,int numb)
	{

		if(previous+3>numb)
			remember=numb;
		else if(previous+3<numb)
			remember=previous+3;
		else if(previous+3==numb)
			remember=numb;
					System.out.println("From CheckIt Remember"+remember);
		return remember;
	}



public StringBuffer commonLoop()
{
		StringBuffer out = new StringBuffer();
		out.append("<html><head><title>");
		out.append("detailspage</title></head>");
		return out;
}

public StringBuffer exceptForEndLoop()
{
		StringBuffer out = new StringBuffer();
		out.append("<body bgcolor=#ffddcc><form action =\"CreateListServlet\">");
		return out;
}

public StringBuffer forEndLoop()
{
		StringBuffer out = commonLoop();
		out.append("<body bgcolor=#ffddcc><form action =\"TestServlet\">");
		return out;
}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{		res.setContentType("text/html");
			java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);

		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(true);
		
		StringBuffer buffer = new StringBuffer();
		
		int i =0;
		int cond=0;
		int limit=0;
		int previous=0;
		
		HashMap hashmap=null;
		
		out.println("<body bgcolor=\"227050\"><center><img src=\"generic.bmp\"></center>");
		
		
		if(req.getParameter("enter").equals("true"))		
		{
			createSession(req);
			limit=Integer.parseInt((String)req.getParameter("num_of_emp"));
			previous = Integer.parseInt((String)session.getAttribute("previous"));
			//limit =	remember;			// Integer.parseInt((String)session.getAttribute("limit"));
		//	cond=Integer.parseInt((String)session.getAttribute("num_of_emp"));
			//out=displayBoxes(previous,limit);
			System.out.println(previous+"  "+limit+"  "+out);
						System.out.println("For The First Time");
		}
		else
		{
			storeElementsInHash(req);
			int prelimit = Integer.parseInt((String)session.getAttribute("limit"));
			cond=Integer.parseInt((String)session.getAttribute("num_of_emp"));
			limit = checkIt(prelimit,cond);
			session.setAttribute("previous",""+prelimit);
			session.setAttribute("limit",""+limit);
			previous = Integer.parseInt((String)session.getAttribute("previous"));
			//out=displayBoxes(previous,limit);
						System.out.println("In the Else Loop");
		}
		
		//cond = Integer.parseInt((String)getSessionElement(req,"num_of_emp"));	
		if(limit<cond)
		{
			buffer.append(exceptForEndLoop());
			buffer.append(displayBoxes(previous,limit));
			System.out.println(limit+"From loopcond");
			buffer.append("<input type=hidden name=enter value=false>");
			buffer.append("<input type=submit name=Next value=Next>");
			//action = "/WebForm/CreateListServlet?enter=false&i="+limit+"\"


			buffer.append("</table></form></body></html>");
			out.println(buffer);
			out.flush();
		}
		else
		{
			
			buffer.append(forEndLoop());
			buffer.append(displayBoxes(previous,limit));
			/*urlChange="/WebForm/TestServlet";
			System.out.println(urlChange);
			out=displayBoxes(previous,limit);
			*/
			buffer.append("<input type=submit>");
			out.println(buffer);
			out.flush();
		
				System.out.println("In the Else Loop");
		}
		//out.println("<input type=submit value=\" Submit  name\"= name + ">");
		out.println("</body>");
	}
	


	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
					System.out.println("From the DoGet");
		doPost(req,res);
	
	}


}