package Menu.Actions;

public interface MenuAction {
    public void doAction();
    public String getName();
    default public boolean closeAfter()
    {return false;}

}
