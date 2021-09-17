package Menu.Actions;

import Services.ContactService;
import UI.ContactView;

public abstract interface MenuAction {


    public abstract ContactService doAction(ContactService contactService, ContactView contactView);
    public abstract String getName();
    default boolean closeAfter()
    {return false;}



}
