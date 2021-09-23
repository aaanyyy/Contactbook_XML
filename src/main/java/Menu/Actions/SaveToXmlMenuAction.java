package Menu.Actions;

import Services.BinaryFileContactService;
import Services.ContactService;
import Services.InFileContactService;
import Services.XmlFileContactService;
import UI.ContactView;


public class SaveToXmlMenuAction implements MenuAction {


    @Override
    public ContactService doAction(ContactService contactService, ContactView contactView) {
        String fileName= contactView.getFileName();
        if(!(contactService instanceof XmlFileContactService))

        contactService =new XmlFileContactService(contactService.getAll(),fileName);



        ((InFileContactService) contactService).saveToFile(fileName);
        return contactService;

    }

    @Override
    public String getName() {
        return "Save contacts to a XML file";
    }
}
