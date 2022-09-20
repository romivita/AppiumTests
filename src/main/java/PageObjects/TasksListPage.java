package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TasksListPage extends PageBase {
    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "plus.circle")
    MobileElement addTaskBtn;

    public TasksListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickAddTaskBtn() {
        click(addTaskBtn);
    }
}
