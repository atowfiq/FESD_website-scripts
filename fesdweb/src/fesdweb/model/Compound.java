package fesdweb.model;



public class Compound {
	public int AtomicNo; 
	public int CodID;
	public String Formula; 
	public int SpaceGroup;
	public String CrystalSystem;
	public String SpaceGroupName;
	public String SymmetrySpaceGroupNameHall;
	public String CellAngleAlpha;
	public String CellFormulaUnitsZ;
	public String CellLengthA;
	public String CellLengthB;
	public String CellLengthC;
	public String CellVolume;
	public String Cif;
	
	public Compound(int atomicNo, int codID, String formula, int spaceGroup, String crystalSystem, String spaceGroupName) {

		AtomicNo  = atomicNo;
		CodID =  codID;
		Formula = formula;
		SpaceGroup = spaceGroup;
		CrystalSystem = crystalSystem;
		SpaceGroupName = spaceGroupName;
		
	}
	


	public Compound(int atomicNo, int codID, String formula, int spaceGroup, String crystalSystem, String spaceGroupName, String _symmetry_space_group_name_Hall,
			String _cell_angle_alpha, String _cell_formula_units_Z, String _cell_length_a, String _cell_length_b, String _cell_length_c, String _cell_volume) {
		// TODO Auto-generated constructor stub
		AtomicNo  = atomicNo;
		CodID =  codID;
		Formula = formula;
		SpaceGroup = spaceGroup;
		CrystalSystem = crystalSystem;
		SpaceGroupName = spaceGroupName;

		SymmetrySpaceGroupNameHall = _symmetry_space_group_name_Hall;
		CellAngleAlpha= _cell_angle_alpha;
		CellFormulaUnitsZ= _cell_formula_units_Z;
		CellLengthA =_cell_length_a;
		CellLengthB = _cell_length_b;
		CellLengthC = _cell_length_c;
		CellVolume = _cell_volume;
	}

}
