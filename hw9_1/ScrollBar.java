public class ScrollBar extends Widget {
    ScrollBar (String name){
        this.name = name;
    }
    @Override
    public void display(Style style){
        style.display(this);
    };
}
