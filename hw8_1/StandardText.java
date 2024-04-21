
public class StandardText implements Text{
    private String content;
    StandardText(String content){
        this.content = content;
    }

    @Override
    public void displayText(){
        System.out.printf("%s ", this.content);
    }
}