public class Button extends Widget{
    Button (String name){
        this.name = name;
    }
    @Override
    public void display(Style style){
        style.display(this);
    };
}
