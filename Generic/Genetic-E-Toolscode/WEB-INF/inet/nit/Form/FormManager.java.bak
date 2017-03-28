package inet.nit.Form;
import java.sql.*;
import java.util.*;

	public class FormManager{
	
	String ins_form="insert into form values (?,?,?)";
	String ins_formdetails="insert into formdetails values (?,?,?,?)";
	String del_form="delete form where formid=?";

	public void StoreData(Form form) throws Exception
	{
	Connection con=null;
	PreparedStatement pstmt=null;
	Collection col;
	Iterator itr;
	HashMap hmap;
try{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","root","root");
	con.setAutoCommit(false);
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
	con.commit();
	}//end of try;
	catch(Exception e){
		con.rollback();
		throw e;
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
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","root","root");
	con.setAutoCommit(false);
	ps=con.prepareStatement(del_form);
	ps.setInt(1,num);
	ps.executeUpdate();
	con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally{
			con.close();
		}

	}
	
	
}
	
	





