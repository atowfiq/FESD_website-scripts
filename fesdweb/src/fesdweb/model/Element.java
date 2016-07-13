package fesdweb.model;

public class Element {

	public int AtomicNo;
	public String Symbol;
	public int Group;
	public String Name;
	public int Period;
	public float MolarMass;
	public Element(int atomicNo,String symbol,int group,String name, int period, float molarMass)
	{
		AtomicNo = atomicNo;
		Symbol = symbol;
		Group = group;
		Period = period;
		MolarMass = molarMass;
		Name = name;
	}
	
}
