package fesdweb.model;

public class DataViewerObj implements Comparable {

	public DataViewerObj(String fileName,int fileCount)
	{
		FileCount  = fileCount;
		FileName =  fileName;
		
		
	}
	public int FileCount;
	public String FileName;
	public boolean IsError;
	public String Error;
	public String ConvergeLog;
	public String OutLog;
	@Override
	public int compareTo(Object o) {
		
		
		return ((DataViewerObj)o).FileCount-this.FileCount;
	}
}
