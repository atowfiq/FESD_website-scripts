package fesdweb.model;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Bandstructure {
	public String Kx;
	public String Ky;
	public String Kz;
	public String X;
	public ArrayList<BandstructureEnergy> BandEnergy;
	public Bandstructure(String kx,String ky,String kz,String x)	
	{
		Kx =kx;
		Ky = ky;
		Kz = kz;
		X =x;
		
	}
}

