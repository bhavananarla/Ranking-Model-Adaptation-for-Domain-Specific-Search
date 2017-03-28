package inet.nit.List;

import java.sql.*;
import java.util.*;

	public class ListManager{
	
	String ins_list="insert into listmaster values (?,?)";
	String ins_listdetails="insert into listdetails values (?,?,?,?)";
	String del_list="delete listmaster where listno=?";

	public void StoreData(ListMaster lis) throws Exception
	{
	Connection con=null;
	PreparedStatement pstmt=null;
	Collection col;
	Iterator itr;
	HashMap hmap;
try{
	System.out.println("before driver loaded");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("driverloaded");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","root","root");
	System.out.println("connectionloaded");

	con.setAutoCommit(false);
	pstmt=con.prepareStatement(ins_list);
	System.out.println("updated0");

	pstmt.setInt(1,lis.getListno());
	System.out.println("updated1"+lis.getListno());

	pstmt.setString(2,lis.getListname());
	System.out.println("updated2"+lis.getListname());

	pstmt.executeUpdate();
	System.out.println("updated");
	con.commit();

	//pstmt.close();
	hmap=lis.getAlldetails();//to get the hmap from list class....
	System.out.println("THISD IS FRO HASHMANMP");
	col=hmap.values();
	System.out.println("THE SIZE OF THE HASH MAP IN LIST MANAGER IS"+hmap.size());

	
	PreparedStatement pstmt1=con.prepareStatement(ins_listdetails);
	System.out.println("4updated");

	itr=col.iterator();
	System.out.println("5updated");

	while(itr.hasNext()){
	ListDetail ld=(ListDetail)itr.next();
	System.out.println("tHe number is"+ld.getListno());
	System.out.println("tHe mail is"+ld.getMailid());
	System.out.println("tHe name is"+ld.getName());
	pstmt1.setInt(1,ld.getListno());
		
	//pstmt.setInt(2,ld.getLineid());
		pstmt1.setInt(2,6);

	pstmt1.setString(3,ld.getMailid());
		
	pstmt1.setString(4,ld.getName());
	pstmt1.executeUpdate();
	}
	con.commit();
	}//end of try;
	catch(Exception e){
		//con.rollback();
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
	ps=con.prepareStatement(del_list);
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
	
	





