package com_log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

// Reads in the combat log file we specify and puts it into an array list for later manipulation
public class Log_Read_In {
	String path = "C:\\Users\\Snyder\\Desktop\\Stuff\\Laptop Programming\\WoWCombatLog(Advanced).txt";
	File theFile = new File(path);
	List<String> fileLine = new ArrayList<String>();
	String[]converted;
///////////// This is running into problems, I'll have to solve later ////////////////
	/*
	public void setPath(String newPath)
	{
		path = newPath;
		try {
			FileInputStream item = new FileInputStream(newPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String currentPath()
	{
		return path;
	}
*/
///////////////////////////////////////////////////////////////////////////////////////
	public List<String> getList()
	{
		return fileLine;
	}
	

	
	public void read() throws UnsupportedEncodingException // read each line into the arraylist
	{
		try { // read the file in and convert it to a UTF-8		
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(theFile),"UTF-8"));
			try {
				String temp;
				while ((temp = br.readLine()) != null)
				{
					fileLine.add(temp);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
