package Menu.Actions;

import Models.Contact;
import Services.BinaryFileContactService;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SaveContactsMenuAction implements MenuAction{
    private final ContactService contactService;
    private final ContactView contactView;


    @Override
    public void doAction() {
        String fileName=contactView.getFileName();
        ((BinaryFileContactService)contactService).saveToFile(fileName);

    }

    @Override
    public String getName() {
        return "Save contacts to a file";
    }
}
