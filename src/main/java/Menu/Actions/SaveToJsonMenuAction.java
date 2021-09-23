package Menu.Actions;

import Services.BinaryFileContactService;
import Services.ContactService;
import Services.InFileContactService;
import Services.JsonFileContactService;
import UI.ContactView;


public class SaveToJsonMenuAction implements MenuAction {



    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        if(!(contactService instanceof JsonFileContactService))

        contactService =new JsonFileContactService(contactService.getAll(),fileName);



        ((InFileContactService) contactService).saveToFile(fileName);
        return contactService;

    }

    @Override
    public String getName() {
        return "Save contacts to a JSON file";
    }
}
