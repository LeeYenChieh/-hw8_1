public class Boiler {
    private static Boiler boilerInstance = new Boiler();
    private Handler handler;
    public static Boiler getBoilerInstance() {
        return boilerInstance;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public void operation(String op) {
        this.handler = this.handler.operation(op);
    }
}
