package sandbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

	File inputFile;
	String path;
	Scanner fileScanner;
	
	public FileIO() {
		inputFile = new File(path);
		try {fileScanner = new Scanner(inputFile);}
		catch (FileNotFoundException fnfEx) {
			System.out.println("Creating new dictionary file...");
		}
	}
}
