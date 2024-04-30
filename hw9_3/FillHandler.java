public class FillHandler extends Handler{
    @Override
    public Handler operation(String op){
        if (op.equals("Fill")) {
            System.out.println("Fill chocolate");
            return this.nextHandler;
        }
        return this;
    }
}
