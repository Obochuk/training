package controller.command.language;

import controller.command.Command;
import controller.utils.InputUtils;
import org.apache.log4j.Logger;
import utils.ResourceManager;
import view.messages.InputMessage;
import view.utils.MenuUtil;

public class ChangeLanguageCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(ChangeLanguageCommand.class);

    @Override
    public void execute() {
        VIEW.printMessage(InputMessage.CHOOSE_LANGUAGE);
        final String MENU = MenuUtil.generateMenuFromItems(AvailableLocale.values());
        VIEW.printMessage(MENU);
        try {
            int chooseLanguage = InputUtils.readInt();
            AvailableLocale chooseLocation = AvailableLocale.values()[chooseLanguage - 1];
            ResourceManager.INSTANCE.changeResource(chooseLocation.getLocale());
            LOGGER.info("Language changed to " + chooseLocation);
        } catch (IndexOutOfBoundsException e){
            LOGGER.warn("wrong input number");
        }
    }
}
