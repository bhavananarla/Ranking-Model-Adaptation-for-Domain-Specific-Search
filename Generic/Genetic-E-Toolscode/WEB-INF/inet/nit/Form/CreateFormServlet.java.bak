package inet.nit.Form;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
 
public class CreateFormServlet extends HttpServlet
{


//Its For displaying boxes it takes 
//two variables previous and present the difference of  two variables gives number of boxes 

public StringBuffer displayBoxes(int previous,int present)
{
	StringBuffer out = new StringBuffer();
			out.append("<table align=center border =4 bgcolor=#bffcd3>");
			out.append("<h1>EnterFormDetails</h1>");
		
		for(int j=previous;j<present;j++)
		{
			String Fname="Fname"+j;
			String Flength="Flength"+j;
			out.append("<tr><td>FieldName:</TD>");
			out.append("<td><input type=text name="+Fname+"></td>");
			//out.append("<td><input type=\"text\" name="+Flength+"\"></td>");
			out.append("<td>FieldLength: </TD>");
			out.append("<td><input type=text name="+Flength+"></td></tr>");
			System.out.println("From Display Boxes");
		}
	
			return out;
}

public void createSession(HttpServletRequest req)
{
			HttpSession session=req.getSession(true);
			//HashMap hash = new HashMap();
			session.setAttribute("FormId",req.getParameter("formid"));
			session.setAttribute("FormName",req.getParameter("formname"));
			int i = Integer.parseInt(req.getParameter("num_of_fields"));
			session.setAttribute("num_of_fields",""+i);
			int limit = checkIt(0,i);
			session.setAttribute("previous",0+"");
			//session.setAttribute("hash",hash);
			session.setAttribute("limit",limit+"");
			System.out.println("From CreateSession");
}

public void storeElementsInHash(HttpServletRequest req)
{
	System.out.println(req.getParameter("name1")+"From storeElementsInHash");
	HttpSession session = req.getSession(true);
	int previous=Integer.parseInt((String)session.getAttribute("previous"));
	int limit=Integer.parseInt((String)session.getAttribute("limit"));
	//HashMap hash = (HashMap)session.getAttribute("hash");
	System.out.println("Previous:-"+previous+"   "+"limit"+"  "+limit);
	for(int i=previous;i<limit;i++)
	{
		String Fname=req.getParameter("Fname"+i);
		String Flength=req.getParameter("Flength"+i);
		System.out.println(Fname+"  "+Flength);
			//hash.put("name"+i,name);
			//hash.put("Email"+i,email);
			session.setAttribute("Fname"+i, Fname);
			session.setAttribute("Flength"+i, Flength);
		System.out.println("HAI, THIS IS FROM SESSION"+ session.getAttribute("Fname"+i));
		System.out.println("HAI, THIS IS FROM SESSION"+ session.getAttribute("Flength"+i));


	}
	//session.setAttribute("hash",hash);
//System.out.println("hash size="+hash.size());

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

		int remember=0;
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
		out.append("<body bgcolor=#ffddcc><form action =\"CreateFormServlet\">");
		return out;
}

public StringBuffer forEndLoop()
{
		StringBuffer out = commonLoop();
		out.append("<body bgcolor=227050><form action =\"TestFormServlet\">");
		return out;
}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
		res.setContentType("text/html");
			java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);

		PrintWriter out = res.getWriter();
		int limit=0;
		HttpSession session=req.getSession(true);
		out.println("<body bgcolor=227050><center><img src=\"generic.bmp\"></center>");
		/*
		String urlChange="/WebForm/CreateListServlet";
		out.println("<html><head><title>");
		out.println("detailspage</title></head>");
		out.println("<body><form action ="+ urlChange + ">");
		*/
		StringBuffer buffer = new StringBuffer();
		//System.out.println(urlChange);
		int i =0,cond=0;
		//int boxes=0;
		int previous=0;
		//int loopcount=5,loopnumber=5;
		HashMap hashmap=null;
		//String nexttosubmit="true";
		
		
		if(req.getParameter("enter").equals("true"))		
		{
			createSession(req);
			previous = Integer.parseInt((String)session.getAttribute("previous"));
			limit = Integer.parseInt((String)session.getAttribute("limit"));
			cond=Integer.parseInt((String)session.getAttribute("num_of_fields"));
			//out=displayBoxes(previous,limit);
			System.out.println(previous+"  "+limit+"  "+out);
						System.out.println("For The First Time");
		}
		else
		{
			storeElementsInHash(req);
			int prelimit = Integer.parseInt((String)session.getAttribute("limit"));
			cond=Integer.parseInt((String)session.getAttribute("num_of_fields"));
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
			buffer.append("<input type=submit>");
			out.println(buffer);
			out.flush();
		
				System.out.println("In the Else Loop");
		}
		
		out.println("</body>");
	}
	


	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
					System.out.println("From the DoGet");
		doPost(req,res);
	
	}


}