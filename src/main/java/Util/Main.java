package Util;

import Menu.Actions.*;
import Menu.Menu;
import Models.Contact;
import Services.*;
import Services.XmlFileContactService;
import UI.ContactView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Contact> Contacts=new ArrayList<>();
        Contact C1=new Contact().setName("Andrey").setPhone("111-11-11");
        Contact C2=new Contact().setName("Sergey").setPhone("222-22-22");
        Contact C3=new Contact().setName("Ivan").setPhone("333-33-133");
        Scanner sc=new Scanner(System.in);
        ContactService contactService=new XmlFileContactService(Contacts,"contact.obj");
        contactService.add(C1);
        contactService.add(C2);
        contactService.add(C3);
        ContactView contactView=new ContactView(sc);
        List<MenuAction> Actions=new ArrayList<>();

        Actions.add(new ReadFromXmlMenuAction());
        Actions.add(new ReadFromJsonMenuAction());
        Actions.add(new ShowContactsMenuAction());
        Actions.add(new SaveToXmlMenuAction());
        Actions.add(new SaveToJsonMenuAction());
        Actions.add(new AddContactMenuAction());
        //Actions.add(new FindContactsMenuAction());
        Actions.add(new RemoveContactMenuAction());
        //Actions.add(new ShowInCapitalMenuAction());
        //Actions.add(new GetNamesMenuAction());
        Actions.add(new ExitMenuAction());
        Menu menu=new Menu(Actions,sc,contactService,contactView);
        menu.run();

    }
}
