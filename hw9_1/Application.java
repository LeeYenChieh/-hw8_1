import java.util.ArrayList;

public class Application {
    ArrayList<Widget> windows;
    ArrayList<Widget> scrollbars;
    ArrayList<Widget> buttons;
    Style style;

    public Application(){
        windows = new ArrayList<>();
        scrollbars = new ArrayList<>();
        buttons = new ArrayList<>();
        style = new Motif();
    }

    public void addWidget(String type, String name){
        if(type.equals("Window"))
            windows.add(new Window(name));
        if(type.equals("ScrollBar"))
            scrollbars.add(new ScrollBar(name));
        if(type.equals("Button"))
            buttons.add(new Button(name));
    }

    public void setStyle(String type){
        if(type.equals("Motif")){
            style = new Motif();
        }
        if(type.equals("PM")){
            style = new PM();
        }
    }

    public void present(){
        for(Widget w: this.windows)
            w.display(style);
        for(Widget w: this.scrollbars)
            w.display(style);
        for(Widget w: this.buttons)
            w.display(style);
    }
}