package inet.nit.List;

import java.util.*;
import java.io.*;

	public class ListDetail implements Serializable{
	
	private int listno;
	private int lineid;
	private String mailid;
	private String name;
	ListMaster lis=new ListMaster();
	int asd=lis.getListno();
	public void setListno(int asd){
		listno=asd;
		}
	public int getListno(){
		return(listno);
	}
	
	
	public void setLineid(int lineid){
		this.lineid=lineid;
		}
	public int getLineid(){
	
		return(lineid);
	}
	
	public void setMailid(String mailid){
		System.out.println("I AM SUCCEDED TO SET MAILID");

		this.mailid=mailid;
		}

	public String getMailid(){
		return mailid;
		}

	public void setName(String name){
		System.out.println("I AM SUCCEDED TO NAME");
		this.name=name;
		}

	public String getName(){
		return name;
	}
}
	
	
		