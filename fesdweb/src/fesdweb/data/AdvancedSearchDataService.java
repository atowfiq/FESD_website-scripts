package fesdweb.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import fesdweb.model.Compound;
import fesdweb.model.Element;
import fesdweb.model.SpaceGroup;

public class AdvancedSearchDataService {

	public AdvancedSearchDataService()
	{
	}
	

	public ArrayList<Compound> 	SearchCompoundByOrbital( String addtionalElements,
			Boolean isShowAll, int spaceGroup, String crystalSystem,String query,double emin,double emax) {
		
		query=query.length()==0?"true=true":query;
		ArrayList<Compound> compoundList = new ArrayList<Compound>();
		Connection conn = DataUtils.CreateConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String compoundQuery = "Select atomicno, _cod_database_code, _chemical_formula_sum,_space_group_IT_number,_symmetry_cell_setting, id, source, _database_code_ICSD , _symmetry_space_group_name_HM,bsexists,dosexists from compound";
			compoundQuery =String.format(compoundQuery+ " where (%s=0 or _space_group_it_number='%s') and (char_length('%s')=0 or _symmetry_cell_setting='%s') and id ",spaceGroup,spaceGroup,crystalSystem,crystalSystem);
			String bandQuery = String.format(" (compoundid,`index`) in (select compoundid,`index` from bandstructuredata where energymin>=%s and energymax<=%s  )", emin,emax);
			String q = String.format(compoundQuery + " in (select distinct compoundid from partialbandstructuredata where %s and  %s) order by source desc;" , query,bandQuery);
			ResultSet rs = stmt.executeQuery(q);
		    
			while (rs.next()) {
					String formula = rs.getString("_chemical_formula_sum");
					Compound c = new Compound(rs.getInt("atomicno") , rs.getInt("_cod_database_code"),formula,  rs.getInt("_space_group_IT_number"), rs.getString("_symmetry_cell_setting"),
							rs.getString("_symmetry_space_group_name_HM"),rs.getInt("id"),rs.getString("source"),rs.getInt("_database_code_ICSD"),rs.getBoolean("bsexists"),rs.getBoolean("dosexists"));
					compoundList.add(c); 
			}
			rs.close();
			stmt.close();
			conn.close();
		
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return compoundList;
	}

	
	
	
	
}
