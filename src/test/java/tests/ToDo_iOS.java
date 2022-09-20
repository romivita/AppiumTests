package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import Utils.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_iOS extends TestBase {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TasksData.json",
                "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName, String taskNote) throws MalformedURLException {
        iOS_setUp("10000", "iPhone 12", "15.5", "A06AD6A3-9237-426E-B7A6-E0DA965ED715", "8200");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteTxt(taskNote);
        createTaskPage.clickSaveBtn();
        tearDown();
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task2(String taskName, String taskNote) throws MalformedURLException {
        iOS_setUp("10001", "iPhone 13 Pro", "15.5", "567342D8-0E3B-46DB-8660-819013D1F371", "8100");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteTxt(taskNote);
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}
