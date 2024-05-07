package testSuite;

import activities.whenDo.AddTaskScreen;
import activities.whenDo.MyListScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class WhenDoTest {
    AddTaskScreen addTaskScreen = new AddTaskScreen();
    MyListScreen myListScreen = new MyListScreen();

    @Test
    public void verifyCreateTask(){
        String title = "Andrea" + new Date().getTime();
        myListScreen.addButton.click();
        addTaskScreen.titleTextBox.setText(title);
        addTaskScreen.noteTextBox.setText("this is a note");
        addTaskScreen.saveButton.click();

        Assertions.assertTrue(myListScreen.getSpecificTask(title).isControlDisplayed(),
                "ERROR! la tarea no fue created");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }
}
