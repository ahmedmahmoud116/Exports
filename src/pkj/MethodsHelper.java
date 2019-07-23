package pkj;
import java.io.File;
import java.io.IOException;
import org.apache.commons.csv.*;
import java.io.FileReader;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

public class MethodsHelper {
	public MethodsHelper() {
		
	}
	public void tester() throws IOException {
		File f = new File("C:\\Users\\lenovo\\Documents\\Downloads\\Compressed\\Java1\\Week3\\Exports\\exports\\exportdata.csv");
		FileReader fr = new FileReader(f);
		CSVParser csv = new CSVParser(fr,CSVFormat.DEFAULT.withIgnoreHeaderCase().withFirstRecordAsHeader().withTrim());
//		System.out.println(countryInfo(csv, "Nauru"));
//		listExportersTwoProducts(csv, "cotton" , "flowers");
//		System.out.println("The number of country that export " + "cocoa " + "is: " + numberOfExporters(csv , "cocoa"));
		bigExporters(csv, "$999,999,999,999");
	}
	
	public String countryInfo(CSVParser cs,String country) throws IOException {
		boolean test = false;
		String result = "NOT FOUND";
		for(CSVRecord cr: cs) {
			if(cr.get("Country").equalsIgnoreCase(country)) {
				test = true;
				result = cr.get(0) + ": " + cr.get(1) + ": " + cr.get(2);
			}
		}
		if(!test) 
			return result;
		return result;
	}
	
	public void listExportersTwoProducts(CSVParser cs,String item1,String item2) {
		System.out.println("Countries that contain both " + item1 + " " + item2 + ": ");
		for(CSVRecord cr: cs) {
			if(cr.get(1).contains(item1) && cr.get(1).contains(item2))
				System.out.println(cr.get(0));
		}
	}
	
	public int numberOfExporters(CSVParser cs,String item) {
		int count = 0;
		for(CSVRecord cr: cs) {
			if(cr.get(1).contains(item))
				count++;
		}
		return count;
	}
	
	public void bigExporters(CSVParser cs,String value) {
		System.out.println("The countries that has value bigger than " + value + " is: ");
		for(CSVRecord cr: cs) {
			if(cr.get(2).length() > value.length())
				System.out.println(cr.get(0) + " " + cr.get(2));
		}
	}
}
