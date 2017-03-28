package inet.nit.Form;
import java.sql.*;
import java.util.*;

	public class FormManager{
	
	String ins_form="insert into form values (?,?,?)";
	String ins_formdetails="insert into formdetails values (?,?,?,?)";
	String del_form="delete from form where formid=?";

	public void StoreData(Form form) throws Exception
	{
	Connection con=null;
	PreparedStatement pstmt=null;
	Collection col;
	Iterator itr;
	HashMap hmap;
try{
	
	Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
	pstmt=con.prepareStatement(ins_form);
	pstmt.setInt(1,form.getFormId());
	pstmt.setString(2,form.getFormName());
	pstmt.setInt(3,form.getField());
	pstmt.executeUpdate();
	pstmt.close();
	hmap=form.getAlldetails();//to get the hmap from list class....
	col=hmap.values();
	pstmt=con.prepareStatement(ins_formdetails);
	itr=col.iterator();
	while(itr.hasNext()){
	FormDetail fd=(FormDetail)itr.next();
	pstmt.setInt(1,fd.getFormId());
	pstmt.setInt(2,fd.getLineId());
	pstmt.setString(3,fd.getFieldName());
	pstmt.setInt(4,fd.getFieldLength());
	pstmt.executeUpdate();
	}
	}//end of try;
	catch(Exception e){
	//	con.rollback();
		//throw e;
		e.printStackTrace();
	}
	finally{
		con.close();
	}
}
	public void DeleteData(int num) throws Exception
	{
		Connection con=null;
		PreparedStatement ps=null;
	try{

	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
	con.setAutoCommit(false);
	ps=con.prepareStatement(del_form);
	ps.setInt(1,num);
	ps.executeUpdate();
	con.commit();
		}catch(Exception e){
			e.printStackTrace();
			con.rollback();
			throw e;

		}finally{
			con.close();
		}

	}
	
	
}
	
	





