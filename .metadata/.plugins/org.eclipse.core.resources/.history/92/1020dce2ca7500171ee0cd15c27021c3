package fesdweb.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fesdweb.data.BandstructureDataService;
import fesdweb.data.CompoundDataService;
import fesdweb.data.DataUtils;
import fesdweb.data.DosDataService;
import fesdweb.model.Bandstructure;
import fesdweb.model.BandstructureChartData;
import fesdweb.model.Compound;
import fesdweb.model.CompoundElementOrbital;
import fesdweb.model.Dos;

import com.google.gson.Gson;

/**
 * Servlet implementation class BandStructureServlet
 */
@WebServlet("/DosServlet")
public class DosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	DosDataService _DosService;
    public DosServlet() {
    	super();
        
    	_DosService= new DosDataService();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int compoundid = Integer.parseInt(request.getParameter("id").toString());
		
		
		 Dos dos = _DosService.GetDos(compoundid);
		 String json = new Gson().toJson(dos);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
