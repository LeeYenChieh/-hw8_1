import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main{
    private static String inputData;
    private static ArrayList<String> outputData;

    public static void main(String[] args){
        // open file
        File file; Scanner scanner;
        try{
            file = new File(args[0]);
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("Error: File not found., aborting.");
            return;
        }
        // read file
        TeXConverter teXConverter = new TeXConverter();
        TextWidgetConverter textWidgetConverter = new TextWidgetConverter();
        outputData = new ArrayList<String>();
        while(scanner.hasNextLine()){
            String formatType = scanner.nextLine();
            inputData = scanner.nextLine();

            if(formatType.equals("TeX"))
                outputData.add(teXConverter.Convert(inputData));
            else if(formatType.equals("TextWidget"))
                outputData.add(textWidgetConverter.Convert(inputData));
            else
                System.out.println("Error: Invalid format type.");
        }
        // close file
        scanner.close();
        // print
        for(String output : outputData)
            System.out.println(output);
    }
}