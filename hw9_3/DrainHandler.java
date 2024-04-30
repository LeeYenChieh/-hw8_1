public class DrainHandler extends Handler{
    @Override
    public Handler operation(String op){
        if (op.equals("Drain")) {
            System.out.println("Drain the boiled chocolate");
            return this.nextHandler;
        }
        return this;
    }
}
