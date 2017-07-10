package fesdweb.model;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Bandstructure {
	public int Index;
	public String Energy;

	public Bandstructure(int index, String energy)	
	{
		Index = index;
		Energy = energy;		
	}
}

