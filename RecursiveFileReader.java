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



}
