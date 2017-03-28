package inet.nit.List;

import java.io.*;
import java.util.*;
 
public class ListMaster implements Serializable{
	private int listno;
	private String listName;
	static int inc=0;
	public HashMap hmap=new HashMap();
	
	public void setListno(int listnum){
		listno=listnum;
		}

	public int getListno(){
		return(listno);
		}

	public void setListname(String listName){
		this.listName=listName;
		}

	public String getListname(){
		return listName;
		}

	//TO STORE THE DETAILS OF THE LISTDETAILS......
	public void addListDetails(ListDetail Ldetail){
		System.out.println("I AM SUCCEDED TO ADD ALLDETAILS");

		hmap.put(new Integer(inc),Ldetail);
		inc++;
		}

	//TO GET ALL THE DETAILS OF THE HMAP.......
	public HashMap getAlldetails(){
		return hmap;
		}

	//TO GET THE SIZE OF THE HASHMAP
	public int getTotalRec(){
		return hmap.size();
		}

	//TO GET THE LINE ID'S OF THE CORRESPONDING LISTNO......
	public ListDetail getLineId(int listno){
		ListDetail listdet=null;
		listdet=(ListDetail)hmap.get(new Integer(listno));
		return listdet;
		}
}	
