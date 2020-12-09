import java.io.File;
import java.util.Scanner;

public class RecursiveFileReader {

	public static void main(String[] args) {
		Scanner kbrd = new Scanner(System.in);
		String dir;
		String findFile;
		int numOfFiles;
		
		System.out.println("Please enter a directory: ");
		dir = kbrd.nextLine();
		
		System.out.println("Please enter file to search for in the directory: ");
		findFile = kbrd.nextLine();
		

		File inputFile = new File(dir);

		
		displayFiles (inputFile);
		System.out.println("\nThere are: " + countFiles(inputFile) + " files in provided directory.");
		
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
}
