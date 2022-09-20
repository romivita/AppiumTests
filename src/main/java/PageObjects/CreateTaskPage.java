package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateTaskPage extends PageBase {
    @AndroidFindBy(id = "editTextTitre")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Title'")
    MobileElement taskNameTxt;
    @AndroidFindBy(id = "editTextNote")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Description'")
    MobileElement taskNoteTxt;
    @AndroidFindBy(id = "action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    MobileElement saveBtn;

    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void enterTaskName(String taskName) {
        clear(taskNameTxt);
        sendText(taskNameTxt, taskName);
    }

    public void enterNoteTxt(String taskNote) {
        clear(taskNoteTxt);
        sendText(taskNoteTxt, taskNote);
    }

    public void clickSaveBtn() {
        click(saveBtn);
    }
}
