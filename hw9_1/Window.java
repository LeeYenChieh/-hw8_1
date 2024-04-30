public class Window extends Widget{
    Window (String name){
        this.name = name;
    }
    @Override
    public void display(Style style){
        style.display(this);
    };
}
