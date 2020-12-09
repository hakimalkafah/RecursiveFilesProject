import java.io.File;

public class RecursiveFileReader {

	public static void main(String[] args) {
		

	}
	
	void displayFiles (File file)
	{
		for(File fileEntry : file.listFiles())
		{
			if(fileEntry.isFile())
				System.out.print(file.getName());
			else 
				displayFiles(fileEntry);
		}
	}

	int countFiles(File file) {
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
