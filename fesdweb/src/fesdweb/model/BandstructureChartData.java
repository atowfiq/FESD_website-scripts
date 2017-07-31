package fesdweb.model;

import java.util.ArrayList;

public class BandstructureChartData {
	 ArrayList<Bandstructure> Bands;
	 ArrayList<CompoundElementOrbital> CompoundElementOrbitals;
	 ArrayList<String> OrbitalWeight =new ArrayList();
	 public BandstructureChartData(ArrayList<Bandstructure> bs,ArrayList<CompoundElementOrbital>  ceos,ArrayList<String> ow)
	 {
		 Bands = bs;
		 CompoundElementOrbitals = ceos;
		 OrbitalWeight = ow;
	 }

}
