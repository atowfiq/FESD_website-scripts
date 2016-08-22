package fesdweb.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fesdweb.model.DataViewerObj;

/**
 * Servlet implementation class DataViewerServlet
 */
@WebServlet("/DataViewerServlet")
public class DataViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataViewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		File folder =new File("/home/khair/fesd/rspttodft/output");  // new File("E:\\");//
		File[] listOfFiles = folder.listFiles();
        ArrayList<DataViewerObj> fs = new ArrayList<DataViewerObj>();
		for (File file : listOfFiles) {
			if(file.isDirectory())
			{
			    try{
			    if(file.listFiles()!=null)
			    {
			    	DataViewerObj dvo =new DataViewerObj(file.getName(), file.listFiles().length);
			    	dvo.Error  = GetError(file.getPath()+"/runs_errfile");
			    	dvo.OutLog  = GetError(file.getPath()+"/out.log");
			    	dvo.ConvergeLog  = GetConvergeLog(file.getPath()+"/runsConvgeLog.log");
			    	
			    	fs.add(dvo);
			    }
			    }
			    catch(Exception ex)
			    {
			    	ex.printStackTrace();
			    	
			    }
			}
		}
		Collections.sort(fs);
		 String json = new Gson().toJson(fs);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String GetConvergeLog(String string) {
		// TODO Auto-generated method stub
File f = new File(filePath);
		
		if(!f.exists())
			return "No File Exist";
		ArrayList<String> lines = new ArrayList<String>(); 
	     
		
		
		 String line;
		 try{
			 FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				  
		     while ((line = bufferedReader.readLine()) != null) {
		    	 if(line.startsWith("Start"))
		    	// Deal with the line
		    	 lines.add(line);
		    	 break;
		     }
		     bufferedReader.close();
		     fileReader.close();
		  }
		  catch(Exception e)
		  {
				 return "Exception:"+e.getMessage();
			  
		  }
		 if(lines.size()==0)
			 return "No Error";
	
		 return lines.get(lines.size()-1);
	}

	private String GetError(String filePath) {
		
		File f = new File(filePath);
		
		if(!f.exists())
			return "No File Exist";
		ArrayList<String> lines = new ArrayList<String>(); 
	     
		
		
		 String line;
		 try{
			 FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				  
		     while ((line = bufferedReader.readLine()) != null) {
		    	// Deal with the line
		    	 lines.add(line);
		    	 break;
		     }
		     bufferedReader.close();
		     fileReader.close();
		  }
		  catch(Exception e)
		  {
				 return "Exception:"+e.getMessage();
			  
		  }
		 if(lines.size()==0)
			 return "No Error";
	
		 return lines.get(lines.size()-1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
