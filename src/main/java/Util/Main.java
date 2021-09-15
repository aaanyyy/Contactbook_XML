package Util;

import Menu.Actions.*;
import Menu.Menu;
import Models.Contact;
import Services.BinaryFileContactService;
import Services.ContactService;
import Services.InMemoryContactService;
import UI.ContactView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Contact>Contacts=new ArrayList<>();
        Contact C1=new Contact().setName("Andrey").setPhone("111-11-11");
        Contact C2=new Contact().setName("Sergey").setPhone("222-22-22");
        Contact C3=new Contact().setName("Ivan").setPhone("333-33-133");
        Scanner sc=new Scanner(System.in);
        ContactService contactService=new BinaryFileContactService(Contacts,"contact.obj");
        contactService.add(C1);
        contactService.add(C2);
        contactService.add(C3);
        ContactView contactView=new ContactView(sc);
        List<MenuAction> Actions=new ArrayList<>();
        Actions.add(new AddContactMenuAction(contactService,contactView));
        Actions.add(new ReadContactsFromFileMenuAction(contactService,contactView));
        Actions.add(new ShowContactsMenuAction(contactService,contactView));
        Actions.add(new SaveContactsMenuAction(contactService,contactView));
        Actions.add(new FindContactsMenuAction(contactService,contactView));
        Actions.add(new RemoveContactMenuAction(contactService,contactView));
        Actions.add(new ShowInCapitalMenuAction(contactService,contactView));
        Actions.add(new GetNamesMenuAction(contactService,contactView));
        Actions.add(new ExitMenuAction());
        Menu menu=new Menu(Actions,sc);
        menu.run();

    }
}
