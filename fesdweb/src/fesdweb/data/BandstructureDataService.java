package fesdweb.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fesdweb.model.Bandstructure;
import fesdweb.model.BandstructureEnergy;
import fesdweb.model.Compound;
import fesdweb.model.Element;
import fesdweb.model.PartialBandstructure;



public class BandstructureDataService  {

	
	public BandstructureDataService()
	{}
	
	public ArrayList<Bandstructure> GetBandstructures(int compoundId, double emin,double emax) {
		ArrayList<Bandstructure> bs = new ArrayList();
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query =  String.format("select `index`,energy from bandstructuredata where compoundid = %s and energymin>=%s and energymax<=%s", compoundId,emin,emax);                   
			ResultSet rs = stmt.executeQuery(query);	
			try {
				while (rs.next()) {
					bs.add(new Bandstructure(rs.getInt("index"),rs.getString("energy")));
					}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return bs;
	}
	
	
	public ArrayList<String> GetOrbitalWeight(int compoundid, String element, String orbital,ArrayList<Bandstructure> bands,int elementIndex)
	{
		ArrayList<String> result = new ArrayList<>();
		String bs = "";
		
		for(Bandstructure b :bands)
		{
			if(bs.length()>0)
				bs=bs+",";
			bs = bs+"("+compoundid+","+b.Index+")";
		}
		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			String query = String.format("select `%s` from partialbandstructuredata where compoundid =%s and  (compoundid,`index`) in (%s) and element ='%s' and elementindex=%s",orbital,compoundid,bs,element,elementIndex);                   
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			 
			try {
					while (rs.next()) 
					{
						result.add(rs.getString(orbital));
					}
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.print(ex.getMessage());
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
		}
		finally
		{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return result;
	}
}

