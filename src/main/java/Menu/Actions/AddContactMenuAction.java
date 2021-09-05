package Menu.Actions;

import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        contactService.add(contactView.readContact());

    }

    @Override
    public String getName() {
        return "Add a contact";
    }
}
