package controller.command.language;

import controller.command.Command;
import org.apache.log4j.Logger;
import utils.InputUtils;
import view.menu.LanguageMenu;
import view.resource.ResourceManager;
import view.resource.messages.InputMessage;

public class ChangeLanguageCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(ChangeLanguageCommand.class);

    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.CHOOSE_LANGUAGE);
        VIEW.printMessage(LanguageMenu.INSTANCE.getMenu());
        try {
            int chooseLanguage = InputUtils.readInt();
            LanguageMenuItem chooseLocation = LanguageMenuItem.values()[chooseLanguage - 1];
            ResourceManager.INSTANCE.changeResource(chooseLocation.getLocale());
            LOGGER.info("Language changed to " + chooseLocation);
        } catch (IndexOutOfBoundsException e){
            LOGGER.warn("wrong input number");
        }
    }
}
