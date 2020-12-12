import java.io.File;
import java.util.Scanner;

public class RecursiveFileReader {

	public static void main(String[] args) {
		Scanner fileInput = new Scanner(System.in);
		
		System.out.print("PLease Enter a valid Directory: ");
		String fileDirectory = fileInput.nextLine();
		
		File file = new File(fileDirectory);
		
		if(file.isDirectory()) {
			System.out.println("\nNumber of Files: " + countFiles(file) + "\n");
			System.out.println("File Names:");
			displayFiles(file);
		} else {
			System.out.println(fileDirectory + " is not a valid Directory.");
		}
		
		System.out.println();
		System.out.println("\nPlease enter a directory and a file you'd like\nto"
				+ " search for: ");
		System.out.print("\nEnter directory: ");
		File directory = new File(fileInput.nextLine());
		
		if(!(directory.isDirectory())) 
			System.out.println(fileDirectory + " is not a valid Directory.");
		
		
		System.out.print("\nEnter file name: ");
		File fileName = new File(fileInput.nextLine());
			
			
		System.out.println("\nSearching for file... ");
		
		if(fileFound(directory,fileName) == true) {
			System.out.println("\nFound: " + fileName);
		} else {
			System.out.println("\nCould not locate: " + fileName);
			
		}
		
	}
	
	
	static void displayFiles (File file)
	{
		for(File fileEntry : file.listFiles())    // Loops through all files and directories in provided directory
		{
			if(fileEntry.isFile())    // If file is a file then print it
				System.out.println(fileEntry.getName());
			else 			  // If file is a directory then make a recursive call with inner directory
				displayFiles(fileEntry);
		}
	}

	static int countFiles(File file) {
		File[] files = file.listFiles(); // Creates an array of files and stores the result of listfiles() into the File array
		int counter = 0; //Counter for the number of files there are in the directory.
		
		for(File c : files) { //Cycles through the files array an stores the current contents of the array in File object c.
			if(c.isDirectory()) //Checks to see if c is a valid directory
				//If it is, then 1 is added to the counter and a recursive step happens where it goes further into the sub-directories
				counter += countFiles(c);  
			else
				counter++; //Increments counter by 1.
		}
		return counter; //Returns the value stored inside counter.
	}
	private static boolean fileFound(File file, File findFile) {
		if(file.getName().equals(findFile.getName())) {
			return true;
		}
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File f : files) {
				System.out.println(f.getName());		
				if(fileFound(f,findFile)) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	private static boolean fileFound(File file, File findFile) {
		/*
		boolean foundIt = false;
		for(File f : file.listFiles()) 
		{
			if(f.isDirectory())
				foundIt = fileFound(f,findFile);                // Doesnt work at all 
			
			else {
				if(f.getName().equals(findFile.getName()))
					foundIt = true;
			}
				
		}
		return foundIt;
		
		
                                                              // Works a lil bit
		for(File f : file.listFiles()) 
		{
			if(f.isDirectory())
				return fileFound(f,findFile);
			
			else {
				if(f.getName().equals(findFile.getName()))
					return true;
			}
				
		}
		return false;
		
	}
	*/
}


//  C:\Users\hakim\Desktop\CIS-141
