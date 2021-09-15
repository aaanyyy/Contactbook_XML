package Menu.Actions;

public interface MenuAction {
    void doAction();
    String getName();
    default boolean closeAfter()
    {return false;}

}
