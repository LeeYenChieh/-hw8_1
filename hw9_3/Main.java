public class Main {
    public static void main(String[] args) throws java.io.IOException{
        FillHandler fillHandler = new FillHandler();
        BoilHandler boilHandler = new BoilHandler();
        DrainHandler drainHandler = new DrainHandler();
        fillHandler.setNextHandler(boilHandler);
        boilHandler.setNextHandler(drainHandler);
        drainHandler.setNextHandler(fillHandler);

        Boiler boiler = Boiler.getBoilerInstance();
        boiler.setHandler(fillHandler);
        try{
            java.io.File inputFile = new java.io.File(args[0]);
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(inputFile));
            String line;

            while((line = reader.readLine()) != null){
                String[] buffer = line.split(" ");
                boiler.operation(buffer[0]);
            }
        } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
