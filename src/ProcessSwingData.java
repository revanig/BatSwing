import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.*;
/**
 * 
 * Takes a csv file and processes into arraylist of DataPoints
 * @author Revani Govender
 *
 */
public class ProcessSwingData { 
	
	static public ArrayList<DataPoint> readFile(String file) throws IOException {
		ArrayList<DataPoint> swing = new ArrayList<DataPoint>();
		System.out.print(file);
		try {
	        

			//Get the scanner instance
			Scanner scanner = new Scanner(new File(file));
			//Use Delimiter as COMMA
			scanner.useDelimiter(",");
			int index = 0;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] values = line.split(",");

				int time = Integer.parseInt(values[0]);
				float ax = Float.parseFloat(values[1]);
				float ay = Float.parseFloat(values[2]);
				float az = Float.parseFloat(values[3]);
				float wx = Float.parseFloat(values[4]);
				float wy = Float.parseFloat(values[5]);
				float wz = Float.parseFloat(values[6]);
				DataPoint point = new DataPoint(time, ax, ay, az, wx, wy, wz);
				swing.add(point);
			}
			scanner.close();
		} 
		catch (FileNotFoundException fe) 
		{
			fe.printStackTrace();
		}
		
		return swing;
		
	}



}
