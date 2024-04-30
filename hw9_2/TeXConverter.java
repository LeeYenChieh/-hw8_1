public class TeXConverter implements RTFConverter {
    public String Convert(String input){
        char[] outputArray = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            // "C" to "c"
            // "F" to "_"
            // "P" to "|"
            if(input.charAt(i) == 'C')
                outputArray[i] = 'c';
            else if(input.charAt(i) == 'F')
                outputArray[i] = '_';
            else if(input.charAt(i) == 'P')
                outputArray[i] = '|';
            else
                System.out.println("Error: Invalid character in input string.");
        }
        return new String(outputArray);
    }
}