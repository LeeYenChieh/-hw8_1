public abstract class Handler {
    protected Handler nextHandler;
    public Handler operation(String op){return this;};
    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }
}
