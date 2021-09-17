package Menu.Actions;

import Services.ContactService;
import Services.CsvFileContactService;
import UI.ContactView;


public class SaveToCsvMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        if(!(contactService instanceof CsvFileContactService))
            contactService =new CsvFileContactService(contactService.getAll(),fileName);

        ((CsvFileContactService) contactService).saveToFile(fileName);
        return contactService;

    }

    @Override
    public String getName() {
        return "Save contacts to a CSV file";
    }
}
