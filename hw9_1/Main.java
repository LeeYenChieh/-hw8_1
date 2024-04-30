public class Main {
    public static void main(String[] args) throws java.io.IOException{
        Application app = new Application();

        try{
            java.io.File inputFile = new java.io.File(args[0]);
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(inputFile));
            String line;

            while((line = reader.readLine()) != null){
                String[] buffer = line.split(" ");
                if(buffer[0].equals("Window") || buffer[0].equals("ScrollBar") || buffer[0].equals("Button")){
                    app.addWidget(buffer[0], buffer[1]);
                } else if(buffer[0].equals("PM") || buffer[0].equals("Motif")){
                    app.setStyle(buffer[0]);
                } else{
                    app.present();
                }
            }
        } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
