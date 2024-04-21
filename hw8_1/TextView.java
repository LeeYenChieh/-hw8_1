import java.util.ArrayList;
import java.util.Scanner;

public class TextView{
    String TextViewName;
    Text text;
    ArrayList<Element> elements;

    TextView(String TextViewName){
        this.TextViewName = TextViewName;
        this.text = null;
        this.elements = new ArrayList<Element>();
    }

    private void addElement(Element element){
        this.elements.add(element);
    }

    private void setText(Text text){
        this.text = text;
    }

    private void display(){
        if(this.text == null){
            System.out.println("No text to display");
            return;
        }
        this.text.displayText();
        for(Element element : this.elements){
            element.display();
        }
        System.out.println("");
    }
}