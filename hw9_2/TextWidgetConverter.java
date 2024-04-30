import java.util.ArrayList;
public class TextWidgetConverter implements RTFConverter {
    public String Convert(String input){
        ArrayList<String> outputArray = new ArrayList<String>();
        for(int i = 0; i < input.length(); i++){
            // "C" to "<Char>"
            // "F" to "<Font>"
            // "P" to "<Paragraph>"
            if(input.charAt(i) == 'C')
                outputArray.add("<Char>");
            else if(input.charAt(i) == 'F')
                outputArray.add("<Font>");
            else if(input.charAt(i) == 'P')
                outputArray.add("<Paragraph>");
            else
                System.out.println("Error: Invalid character in input string.");
        }
        String returnString = new String();
        for(String s : outputArray)
            returnString += s;
        return returnString;
    }
}