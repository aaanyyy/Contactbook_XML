package Menu;

import Menu.Actions.MenuAction;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class Menu {
    private final List<MenuAction> actions;
    private final Scanner sc;
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
            actions.get(actionId).doAction();

        }
    }

}
