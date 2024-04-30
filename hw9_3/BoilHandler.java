public class BoilHandler extends Handler{
    @Override
    public Handler operation(String op){
        if (op.equals("Boil")) {
            System.out.println("Boil chocolate");
            return this.nextHandler;
        }
        return this;
    }
}
