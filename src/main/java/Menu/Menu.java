package Menu;

import Menu.Actions.MenuAction;
import Services.ContactService;
import UI.ContactView;

import java.util.List;
import java.util.Scanner;


public class Menu {
    private final List<MenuAction> actions;
    private final Scanner sc;
    private ContactService contactService;
    private final ContactView contactView;

    public Menu(List<MenuAction> actions, Scanner sc, ContactService contactService, ContactView contactView) {
        this.actions = actions;
        this.sc = sc;
        this.contactService = contactService;
        this.contactView = contactView;
    }

    public void show()
    {
        System.out.println("Please enter your choice:");
        for(int i=0;i<actions.size();i++)
        {
            System.out.printf("%d for %s\n",i+1, actions.get(i).getName());
        }
    }
    public void run()
    {
        while(true)
        {
            show();
            int actionId=sc.nextInt()-1;
            sc.nextLine();
            if(actionId>actions.size()-1) {
                System.out.println("Please enter a valid choice!!!\n");
                continue;
            }
            if(actions.get(actionId).closeAfter())
                break;
            contactService=actions.get(actionId).doAction(contactService,contactView);


        }
    }

}
