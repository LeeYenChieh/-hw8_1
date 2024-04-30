public class Motif extends Style {
    @Override
    public void display(Button button) {
        System.out.println("MotifButton" + " " + button.getName());
    }
    @Override
    public void display(ScrollBar scrollBar) {
        System.out.println("MotifScrollBar" + " " + scrollBar.getName());
    }@Override
    public void display(Window window) {
        System.out.println("MotifWindow" + " " + window.getName());
    }
}
