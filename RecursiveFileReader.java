import java.io.File;
import java.util.Scanner;

public class RecursiveFileReader {

	public static void main(String[] args) {
		Scanner fileInput = new Scanner(System.in);
		
		System.out.print("Please Enter a valid Directory: ");   // Asks user for a valid directory
		String fileDirectory = fileInput.nextLine();
		
		File file = new File(fileDirectory);
		
		if(file.isDirectory()) {  // Checks if input is a valid directory
			System.out.println("\nNumber of Files: " + countFiles(file) + "\n");     // displays number of files in given directory
			System.out.println("File Names:");
			displayFiles(file);      // Displays all of the file names in given directory 
		} else {
			System.out.println(fileDirectory + " is not a valid Directory.");
		}
		
		System.out.println();     
		System.out.println("\nPlease enter a directory and a file you'd like\nto"
				+ " search for: ");
		System.out.print("\nEnter directory: ");      // User enters a directory where he wants a specific file found in
		File directory = new File(fileInput.nextLine());
		
		if(!(directory.isDirectory()))   // Error message if directory isn't entered
			System.out.println(fileDirectory + " is not a valid Directory.");
		
		
		System.out.print("\nEnter file name: ");        // user enters file name they want to find
		File fileName = new File(fileInput.nextLine());
			
			
		System.out.println("\nSearching for file... ");
		
		// Display if entered file is found or not. 
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
			System.out.println(fileEntry.getName());  // prints file or directory
			
			if(fileEntry.isDirectory())   // if file is a directory, it calls displayFiles recursively
				displayFiles(fileEntry);
		}
	}

	
	static int countFiles(File file) {
		File[] files = file.listFiles(); // Creates an array of files and stores the result of listfiles() into the File array
		int counter = 0; //Counter for the number of files there are in the directory.
		
		
		for(File c : files) {  //Cycles through the files array an stores the current contents of the array in File object c.
			counter ++;  //Increments counter by 1.
			
			if(c.isDirectory()) //Checks to see if c is a valid directory
				//If it is, then 1 is added to the counter and a recursive step happens where it goes further into the sub-directories
				counter += countFiles(c);  
		}
		
		return counter; //Returns the value stored inside counter.
	}
	
	
	static boolean fileFound(File file, File findFile) {
		
		if(file.getName().equals(findFile.getName())) {   // compares the file given by user to file passed in as perametter 
			System.out.println("\n" + file.getPath());	  // Displays file's full path (For extra credit)
			return true;
		}
		
		if(file.isDirectory()) {
			if(findFile.isDirectory()) {
				File[] files = file.listFiles();
				
				for(File f : files) {
					if(fileFound(f,findFile)) {
						return true;
					}
				}
			}
			
			File[] files = file.listFiles();   // Stores a list of all the files in the passed in directory in an array
			
			for(File f : files) {    //Cycles through the files array an stores the current contents of the array in File object f.
				
				if(fileFound(f,findFile))  // runs every file and/or directory in the array through findFile() recursively 
					return true; 
			}
		}
		
		return false;    // If the file isn't found in this directory, the method returns false;
	}
}


