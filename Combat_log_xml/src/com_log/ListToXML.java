package com_log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ListToXML	{
	
	List<ArrayList> bigList = new ArrayList<ArrayList>();
	public ListToXML(ArrayList<ArrayList> bigList)
	{
		this.bigList = bigList;
	}
	
	public void createXML() throws TransformerException
			{
			try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document doc = build.newDocument();

        Element root = doc.createElement("CombatLog");
        doc.appendChild(root);
        

        Iterator itr = bigList.iterator(); // iterating through each line
        int n = 1; // Add onto name of action to keep track of everything
        while(itr.hasNext())
        {
        	Element Action = doc.createElement("Action" + n);
        	n++;
        	root.appendChild(Action);
        	Iterator itr2 = ((List<ArrayList>) itr.next()).iterator(); // iterating through each piece in the line
        	
        	if (itr2.hasNext())
        	{Text theDate = doc.createTextNode((String) itr2.next()); // first piece is always date
        	Action.appendChild(theDate);}
        
        	if (itr2.hasNext())
        	{Text theTime = (Text) doc.createTextNode((String) itr2.next()); // second piece is alawys time
        	Action.appendChild(theTime);}
        	
        	if(itr2.hasNext())
        	{Element Info = doc.createElement("Info"); // everything else is the data we want
        	Action.appendChild(Info);
        	Integer x = 1;
        	while(itr2.hasNext()) // just append it all into the info section
        	{
        		Element Num = doc.createElement("Act_Info_" + x);
        		Info.appendChild(Num);
        		Text Temp = doc.createTextNode((String) itr2.next());
        		Num.appendChild(Temp);
        		x++;
        	}
        	}
        }


        
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

 
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
        DOMSource source = new DOMSource(doc);
        try {
            FileWriter fos = new FileWriter("C:\\Users\\Snyder\\Desktop\\Stuff\\Laptop Programming\\testFile.xml");
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        } catch (IOException e) {

            e.printStackTrace();
        }

    } catch (ParserConfigurationException ex) {
        System.out.println("Error building document");
    }
}
}

