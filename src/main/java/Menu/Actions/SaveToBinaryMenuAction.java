package Menu.Actions;

import Services.BinaryFileContactService;
import Services.ContactService;
import Services.InFileContactService;
import UI.ContactView;


public class SaveToBinaryMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        if(!(contactService instanceof BinaryFileContactService))

        contactService =new BinaryFileContactService(contactService.getAll(),fileName);



        ((InFileContactService) contactService).saveToFile(fileName);
        return contactService;

    }

    @Override
    public String getName() {
        return "Save contacts to a binary file";
    }
}
