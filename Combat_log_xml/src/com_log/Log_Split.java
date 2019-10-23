package com_log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Log_Split {

	List<String> list = new ArrayList<String>(); // our original list of each line from the file
	List<ArrayList> bigList = new ArrayList<ArrayList>(); // our new list after splitting each line into lists
	List<String> subList; // holder for list to be used to hold each piece of line
	
	public Log_Split(ArrayList<String> theList)
	{
		list = theList;
	}

	// take each line (element of the list) and split it where there is a space or comma, and make a new list from the splits
	public void split()
	{
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			String[]pieces = ((String) itr.next()).split(" |\\,");
			subList = new ArrayList<String>();
			// put each piece of the string into the arraylist
			for (String s: pieces)
			{
				/*
				if (s.contains(":")) // fix anything that wont work well with xml
					s.replace(":", "_");
				if (s.contains("/"))
					s.replace("/","_");
				if (s.contains("\""))
					s.replace("\"", "");
				if (s.contains("0x0"))
					s.replace("0x0", "Null");
					*/
				subList.add(s);
			}
			bigList.add((ArrayList) subList);
		}
	}
	
	public ArrayList<ArrayList> getList()
	{
		return (ArrayList<ArrayList>) bigList;
	}
}
