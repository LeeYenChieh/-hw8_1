
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		Application application = new Application();
		File inputFile = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line;
		while((line = reader.readLine()) != null){
			String[] buffer = line.split(" ");
			if(buffer[0].equals("Draw")) {
				application.addDocument(new DrawingDocument());
			}
			else if(buffer[0].equals("Text")) {
				application.addDocument(new TextDocument());
			}
			else if(buffer[0].equals("Present")) {
				application.display();
			}
		}
	}
	
}
