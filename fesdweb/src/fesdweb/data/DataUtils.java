package fesdweb.data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.text.View;

public class DataUtils {
	
	//public static final String DatatabaseUserName ="root";//towfiq: "root";
	//public static final String DatatabasePassword ="root";//towfiq: "dhaka";//IMS:"inshALLAH%6";//"root";//dhaka
	//public static final String DatatabaseName ="fedb";//IMS: "fesdb";//"fedb";//
	
	
	//public static final String FCifPath =//Towfiq:"C:\\Users\\atowf_000\\Desktop\\fcif\\";//IMS:"/home/khair/fesd/fcif/fcif/";//"E:\\fcif\\";//"/home/adnanibnekhair/fesd/fcif/"; //UNM////IMS:
	
	public static final String DatatabaseUserName ="root";
	public static final String DatatabasePassword ="root";
	public static final String DatatabaseName ="fedbfull";//IMS: "fesdb";//"fedb";//
	public static final String ViewPath ="E:\\fcif\\";///home/khair/Research/Wien2k/Data/View/cif/ //Towfiq:"C:\\Users\\atowf_000\\Desktop\\fcif\\";//IMS:"/home/khair/fesd/fcif/fcif/";//"E:\\fcif\\";//"/home/adnanibnekhair/fesd/fcif/"; //UNM////IMS:
		////local
	//IMS
	/*	public static final String DatatabaseUserName ="root";
	public static final String DatatabasePassword ="inshALLAH%6";
	public static final String DatatabaseName ="fedbfull";//"fesdbfull";//IMS: "fesdb";//"fedb";//
	//public static final String FCifPath ="/home/khair/Research/Wien2k/Data/View/cif/";//"/home/khair/fesd/fcif/fcif/";//"E:\\fcif\\";//Towfiq:"C:\\Users\\atowf_000\\Desktop\\fcif\\";//IMS:"/home/khair/fesd/fcif/fcif/";//"E:\\fcif\\";//"/home/adnanibnekhair/fesd/fcif/"; //UNM////IMS:
    public static final String ViewPath = "/home/khair/Research/Wien2k/Data/View/";
*/   
	
	public static Connection Conn = null;
	public DataUtils(){
		//
	}
	
	
	public static String GetFCifFilePath(int id,String source)
	{
	   String sourceId = Integer.toString(id);
	   if(source.equals("icsd"))
		   sourceId ="EntryWithCollCode"+sourceId; 
	   return ViewPath+"cif/"+source+"/"+sourceId+".cif";
		
	}
	public static boolean FileExists(String source, String id,String dataType)
	{
		String dt = "";
		String ext = "";
		if(dataType.equals("bs"))
		{
			dt = "bandstructure";
			ext = ".spaghetti_ps00.png";
		}
			
		else if(dataType.equals("dos"))
		{
			dt = "dos";
			ext = "00.png";
		}
		Path p = Paths.get(ViewPath,dt,source,id+ext);
		return Files.exists(p);
	}
	
	
	public static Connection CreateConnection()
	{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost/"+DatatabaseName,DatatabaseUserName, DatatabasePassword );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

	        return null;
	}
	
	
}