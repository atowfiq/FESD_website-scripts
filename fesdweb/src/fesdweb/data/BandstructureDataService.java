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
	
	public ArrayList<ArrayList<PartialBandstructure>> GetPartialBandstructure(int id,int from, int to) {
		ArrayList<PartialBandstructure> pbs = new ArrayList();
		Map<Integer,ArrayList<PartialBandstructure>> map = new HashMap();
 		Statement stmt = null;
		try {
			Connection conn = DataUtils.CreateConnection();
			stmt = conn.createStatement();
			                   
			ResultSet rs = stmt.executeQuery("select * from partialbandstructuredata where compoundid="+id+" and `index`>="+from+" and `index`<="+to );
			ResultSetMetaData rsmd = rs.getMetaData();
			 
			try {
					while (rs.next()) 
					{
						int elementIndex = rs.getInt("ElementIndex");
						int index = rs.getInt("index");
						String element = rs.getString("Element");
						ArrayList<String> pe = new ArrayList();
						ArrayList<String> header=new ArrayList();
						for(int i=5;i<25;i++)
						{
							if(rs.getString(i)!=null)
							{
								pe.add(rs.getString(i));
								header.add(rsmd.getColumnName(i));
							}
						}
						if(!map.containsKey(index))
							map.put(index,new ArrayList());
						map.get(index).add(new PartialBandstructure(elementIndex,element,pe,header));
					//	pbs.add(new PartialBandstructure(elementIndex,element,pe,header));
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
		ArrayList<ArrayList<PartialBandstructure>> r =new ArrayList(map.values());
		return r;
	}
	
	public ArrayList<String> GetOrbitalWeight(int compoundid, String element, String orbital,ArrayList<Bandstructure> bands)
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
			String query = String.format("select %s from partialbandstructuredata where (compoundid,`index`) in (%s) and element ='%s'",orbital,bs,element);                   
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

