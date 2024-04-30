public class PM extends Style {
    @Override
    public void display(Button button) {
        System.out.println("PMButton" + " " + button.getName());
    }
    @Override
    public void display(ScrollBar scrollBar) {
        System.out.println("PMScrollBar" + " " + scrollBar.getName());
    }@Override
    public void display(Window window) {
        System.out.println("PMWindow" + " " + window.getName());
    }
}
