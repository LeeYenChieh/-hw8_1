

import java.util.ArrayList;

public class Application {
	ArrayList<Document> documents = new ArrayList<>();
	
	public void addDocument(Document document) {
		documents.add(document);
	}
	public void display() {
		for(Document document : documents) {
			document.display();
		}
	}
}
