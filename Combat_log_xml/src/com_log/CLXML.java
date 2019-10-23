package com_log;
import com_log.Log_Read_In;
import com_log.Log_Split;
import com_log.ListToXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CLXML {

	public static void main(String[] args) throws TransformerException, UnsupportedEncodingException {
		System.out.println("Hello World!");
		
		List<ArrayList> ourList = new ArrayList<ArrayList>();
		
		Log_Read_In reader = new Log_Read_In();
		reader.read();
		
		List<String> ourFile = new ArrayList<String>();
		ourFile = reader.getList();
		
		Log_Split splitter = new Log_Split((ArrayList<String>) ourFile);
		splitter.split();
		
		ourList = splitter.getList();
		
		ListToXML conv = new ListToXML((ArrayList<ArrayList>) ourList);
		conv.createXML();
		}
		////////// These lines are for testing. On a big file, would be a little much to output
		/*
		Iterator itr = ourList.iterator();
		while(itr.hasNext())
		{
			Iterator itr2 = ((List<ArrayList>) itr.next()).iterator();
			while(itr2.hasNext())
			{
				System.out.println(itr2.next());
			}
		}
		*/
		//////////////////////////////////////////////////////////////////////////////////////////
	}



/*
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
try {
	DocumentBuilder builder = factory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/