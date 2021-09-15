package UI;

import Models.Contact;
import Util.ListUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ContactView {
    private final Scanner sc;

    public Contact readContact()
    {
        System.out.println("Please enter a name for a new contact");
        String name=sc.nextLine();

        System.out.println("Please enter a phone number");
        String phoneNumber=sc.nextLine();
        return new Contact().setName(name).setPhone(phoneNumber);
    }
    public void showContact(Contact contact)
    {
        System.out.printf("ID: %d \tName: %20s \tPhone number: %s\n", contact.getId(),contact.getName(),contact.getPhone());
    }

    public void showContacts(List<Contact> contacts)
    {
        System.out.println("-----------------------Contacts-----------------------------");

        if(contacts.size()>0)
            ListUtils.forEach(contacts,elem->showContact(elem));
        /*{
            for (Contact contact : contacts) {
                showContact(contact);
            }
        }*/
        else
            System.out.println("No contacts");
        System.out.println("------------------------------------------------------------");
    }
    public String getStringToSearch()
    {
        System.out.println("Please enter a name or first letters of it");
        return sc.nextLine();
    }
    public String getFileName()
    {
        System.out.println("Please enter a file name");
        return sc.nextLine();
    }

    public Integer getContactIdToDelete()
    {
        System.out.println("Please enter id of a contact you want to delete");
        Integer result= sc.nextInt();
        sc.nextLine();
        return result;
    }
    public void showAllNames(String str)
    {
        System.out.println("-----------------------Names-----------------------------");
        System.out.println(str);
        System.out.println("------------------------------------------------------------");

    }

}
