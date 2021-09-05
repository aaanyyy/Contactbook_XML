package Menu.Actions;

import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetNamesMenuAction implements MenuAction{
private final ContactService contactService;
private final ContactView contactView;

    @Override
    public void doAction() {
        String out =contactService.getAllNames();
        contactView.showAllNames(out);

    }

    @Override
    public String getName() {
        return "Show all names (reduce example)";
    }
}
