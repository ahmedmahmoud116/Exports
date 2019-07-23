package pkj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParsers {
	public CSVParsers() {
		
	}
	public String[] getElements(File f) throws IOException {
		FileReader fr = new FileReader(f);
		BufferedReader sc = new BufferedReader(fr);
		String row;
		ArrayList<String> total = new ArrayList<>();
		while ((row = sc.readLine()) != null) {
			 String[] data = row.split(",");
			 for(int count = 0; count<3 ;count++) {
				 total.add(data[count]);
			 }
		}
		sc.close();
		String[] totala = new String[total.size()];
		return total.toArray(totala);
	}

}
