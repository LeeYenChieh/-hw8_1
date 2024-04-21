import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        ArrayList<TextView> textViews = new ArrayList<>();
        File inputFile = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line;
		while((line = reader.readLine()) != null){
			String[] buffer = line.split(" ");
			TextView textView = null;
			for(int i = 0; i < textViews.size(); i++) {
				if(buffer[0].equals(textViews.get(i).TextViewName)) {
					textView = textViews.get(i);
					break;
				}
			}
			if(textView == null) {
				TextView tmpTextView = new TextView(buffer[0]);
				tmpTextView.setText(new StandardText(buffer[1]));
				textViews.add(tmpTextView);
			}
			else {
				if(buffer[1].equals("add")) {
					for (int i = 2; i < buffer.length; i++) {
						if(buffer[i].equals("scrollBar")) {
							textView.addElement(new ScrollBar());
						}
						else if(buffer[i].equals("thickBlackBorder")) {
							textView.addElement(new ThickBlackBorder());
						}
					}
				}
				else if(buffer[1].equals("display")) {
					textView.display();
				}
			}
		}
    }
}