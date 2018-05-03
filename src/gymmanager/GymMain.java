package gymmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymMain {
	static ArrayList<String> IDList = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileManager manager = new FileManager("testFile.txt", IDList);
		new PanelsSetting(manager);
	}
}

class FileManager {
	List<String> IDList;
	String[] str = new String[8];
	String FileName;
	
	public FileManager(String FileName, ArrayList<String> IDList) {
		this.IDList = IDList;
		this.FileName = FileName;
		//readFile(FileName);
	}
    
    void readFile(String id) { // Read csv File
		try {
			FileInputStream file = new FileInputStream(FileName);
			Scanner input = new Scanner(file);
			findInfo(input, id);
			input.close();
			}
		catch(Exception e) {
			System.out.println("Error!");
			}
    }
    
    private void findInfo(Scanner input, String id) { // login (search id)
		String line = input.nextLine();
		while(input.hasNextLine()) {
			line = input.nextLine();
			if (!line.equals("")) { // Check blank
				// Read a Line =====================
				str = line.split(",");
				if (str[0].equals(id)) {
					for (int i = 0; i<8; i++)
						IDList.add(str[i]);
					break;
				}
				// =====================================
			}
		}
	}
}