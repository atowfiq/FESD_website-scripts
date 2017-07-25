package fesdweb.model;

import java.util.ArrayList;

public class PartialBandstructure {
	
	public int ElementIndex;
	public String Element;
	public ArrayList<String> PartialEnergy;
	public ArrayList<String> Header;
	public PartialBandstructure(int ei,String e,ArrayList<String> pe,ArrayList<String> header)
	{
		ElementIndex= ei;
		Element = e;
		PartialEnergy=pe;
		Header =header;
	}
	
	
	
}
