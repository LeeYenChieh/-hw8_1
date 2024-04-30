public class Main {
    public static void main(String[] args) throws java.io.IOException{
        try{
            java.io.File inputFile = new java.io.File(args[0]);
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(inputFile));
            String line;

            while((line = reader.readLine()) != null){
                String[] buffer = line.split(" ");
                if(buffer[0].equals("Fill")){
                    
                } else if(buffer[0].equals("Boil")){
                    
                } else if(buffer[0].equals("Drain")){
                    
                }
            }
        } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
