package fesdweb.model;

import java.util.ArrayList;

public class ElementPageData {
	public ArrayList<SpaceGroup> SpaceGroupSymmetry;
	public ArrayList<String> SpaceGroupCellSetting;
	public ArrayList<String> AllElements;
	public Element ElementObj;
	public ElementPageData()
	{
		SpaceGroupSymmetry = new ArrayList<SpaceGroup>();
	}
}

