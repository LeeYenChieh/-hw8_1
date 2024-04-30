public abstract class Handler {
    private Handler nextHandler;
    public Handler operation(String op){return this;};
    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }
}
