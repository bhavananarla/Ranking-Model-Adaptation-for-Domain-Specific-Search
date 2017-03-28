package inet.nit.Form;
import java.util.*;
import java.io.*;

	public class Form implements Serializable{
	
	private int Form_id;
	private String Form_name;
	private int num_of_fields;
	public HashMap hmap=new HashMap();
	 static int i=0;
	public void setFormId(int Form_id){
		this.Form_id=Form_id;
		}
	
	public int getFormId(){
		return (Form_id);
	}
	
	public void setFormName(String Form_name){
		this.Form_name=Form_name;
		}
	
	public String getFormName(){
		return Form_name;
	}

	public void setField(int num_of_fields){
		this.num_of_fields=num_of_fields;
		}
	
	public int getField(){
		return (num_of_fields);
	}

	//TO STORE THE DETAILS OF THE FORMDETAILS......
	public void addFormDetails(FormDetail Fdetail){
		hmap.put(new Integer(i),Fdetail);
		i++;
		}

	//TO GET ALL THE DETAILS OF THE HMAP.......
	public HashMap getAlldetails(){
		return hmap;
		}

	//TO GET THE SIZE OF THE HASHMAP
	public int getTotalRec(){
		return hmap.size();
		}
}
	//TO GET THE LINE ID'S OF THE CORRESPONDING FORMID......

	//***************pending**************************
	
	