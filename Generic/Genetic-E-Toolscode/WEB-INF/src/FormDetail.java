package inet.nit.Form;
import java.util.*;
import java.io.*;
 
	public class FormDetail implements Serializable
	{
		private int Formid;
		private int Lineid;
		private String FieldName;
		private int Fieldlength;
		
		public void setFormId(int Formid){
			this.Formid=Formid;
		}
		public int getFormId(){
			return (Formid);
		}

		public void setLineId(int Lineid){
			this.Lineid=Lineid;
		}
		public int getLineId(){
			return (Lineid);
		}
		
		public void setFieldName(String FieldName){
			this.FieldName=FieldName;
		}
		public String getFieldName(){
			return FieldName;
		}

		public void setFieldLength(int Fieldlength){
			this.Fieldlength=Fieldlength;
			}


		public int getFieldLength(){
			return(Fieldlength);
			}
}

		