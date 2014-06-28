package com.saucelabs.appium;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by sriramangajala on 06/05/2014.
 */
public class StepDefs {
    static boolean IOS = true;


    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        driver = RunTests.getDriver();
//        if(isElementPresent(By.name("Logout")))
//        driver.findElement(By.name("Logout")).click();
        //  values = new ArrayList<Integer>();
    }

    private boolean isElementPresent(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
                System.out.println(e.getMessage());
        }
        return false;
    }

    @Given("^User is on Login Page$")
    public void User_is_on_Login_Page() {
//        Assert.assertTrue(driver.findElement(By.tagName("text")).getScreenText().contains("Mobile Test Lab"));
//        Assert.assertEquals(driver.findElement(By.tagName("button")).getScreenText(), "Login");
    }

    @When("^User Enter '(.*)' in Username textfield$")
    public void User_Enter_Validuser_in_Username_textfield(String username) {
        if(IOS)
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElements(By.className("UIATextField")).get(0).sendKeys(username);
        }
        else
        driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys(username);


    }

    @When("^User Enter '(.*)' in Password textfield$")
    public void User_Enter_ValidPass_in_Password_textfield(String password) {

        if(IOS)
            driver.findElements(By.className("UIASecureTextField")).get(0).sendKeys(password);
        else
            driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("Sri123");
    }

    @When("^User clicks on (.*) button$")
    public void User_clicks_on_Login_button(String button) {
        if(button.equals("Logout"))
        {
            driver.findElement(By.name("Logout")).click();
            return;
        }
        if(IOS)
        driver.findElement(By.name("Login")).click();
        else
        driver.findElement(By.xpath("//android.widget.Button[1]")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^User should see welcome message as '(.*)'$")
    public void User_should_see_welcome_message_as_Welcome_Validuser(String welcomeMessage) {
        System.out.print(getScreenText());
        Assert.assertTrue(getScreenText().contains(welcomeMessage));
    }

    @Then("'(.*)' should be displayed$")
    public void please_enter_valid_Username_and_Passord_should_be_displayed(String error) {
        System.out.print(driver.findElement(By.xpath("//android.widget.EditText[1]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.EditText[1]")).getText().contains(error));
    }

    @When("^I close the message$")
    public void close_message()
    {
        driver.findElement(By.name("Ok")).click();
    }


    public boolean isTextPresent(String text) {
        List<WebElement> elements;

        if(IOS)
        elements = driver.findElements(By.className("UIAStaticText"));
        else
        elements = driver.findElements(By.className("android.widget.TextView"));

        if (elements.size() == 0)
            return false;

        for (WebElement element : elements) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public String getScreenText()
    {
        String returnText=null;
        List<WebElement> elements ;
        if(IOS)
            elements = driver.findElements(By.className("UIAStaticText"));
        else
            elements = driver.findElements(By.className("android.widget.TextView"));

        if (elements.size() == 0)
            return "";

        for (WebElement element : elements) {
            returnText = returnText + element.getText();
        }
        return returnText;
    }





//    driver.findElements(By.tagName("textField")).get(0).sendKeys("testlabuser");
//    driver.findElements(By.tagName("secure")).get(0).sendKeys("testlabpassword");
//    driver.findElement(By.tagName("button")).click();
//    try {
//        Thread.sleep(5000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    System.out.print(driver.findElements(By.tagName("text")).get(1).getScreenText());
//    Assert.assertTrue(driver.findElements(By.tagName("text")).get(1).getScreenText().contains("Welcome"));

//    @After
//    public void stop()
//    {
//       // driver.quit();
//    }

//    driver.findElements(By.tagName("textField")).get(0).sendKeys("testlabuser");
//    driver.findElements(By.tagName("secure")).get(0).sendKeys("testlabpassword");
//    driver.findElement(By.tagName("button")).click();
//    try {
//        Thread.sleep(5000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    System.out.print(driver.findElements(By.tagName("text")).get(1).getScreenText());
//    Assert.assertTrue(driver.findElements(By.tagName("text")).get(1).getScreenText().contains("Welcome"));

    //    @After
//    public void stop()
//    {
//       // driver.quit();
//    }
    @Given("^User is on the Folders View Page$")
    public void User_is_on_the_Folders_View_Page() {
        User_Enter_Validuser_in_Username_textfield("sri123");
        User_Enter_ValidPass_in_Password_textfield("Sri123");
        User_clicks_on_Login_button("Login");
        driver.findElement(By.name("Open")).click();

    }

    @When("^the user clicks on '(.*)' button$")
    public void clickOnButton(String button)
    {
        driver.findElement(By.name(button)).click();
    }

    @When("^the user clicks on the all folders$")
    public void the_user_clicks_on_the_parent_folder_Level_one_which_has_symbol(DataTable arg1) {
       List<List<String>> folders = (arg1.raw());

        for(List<String> folder:folders)
        {
            driver.findElement(By.name(folder.get(0))).click();
        }


    }

    @When("^taps on the Folder name with '(.*)'$")
    public void User_taps_on_foldername(String folder) {
        driver.findElement(By.name(folder)).click();

    }

    @Then("^User should see 'Testcaseview' page.$")
    public void User_should_see_Testcaseview_page() {
       Assert.assertTrue(isTextPresent("Test Cases View"));
    }

    @Given("^user is in test case page$")
    public void user_is_in_test_case_page() {
        User_is_on_the_Folders_View_Page();
        User_taps_on_foldername("Non functional");
        User_taps_on_foldername("Installation1");
        driver.findElement(By.name("Add Test Cases")).click();

    }

    @When("^'title' is set as '(.*)'$")
    public void _title_is_set_as_Test_case_Title(String title) {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys(title);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]")).click();
    }

    @When("^select 'Tester one' in the 'owner' from drop down list$")
    public void select_Tester_one_in_the_owner_from_drop_down_list() {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
    }

    @When("^select 'low' in the 'priority' from drop down list$")
    public void select_low_in_the_priority_from_drop_down_list() {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2 ]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
    }

    @When("^'description' is set as '(.*)'$")
    public void _description_is_set_as_Test_case_description(String data) {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]")).sendKeys(data);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]")).click();
    }

    @When("^'test data' is set as '(.*)'$")
    public void _test_data_is_set_as_Test_case_data(String data) {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[2]")).sendKeys(data);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]")).click();
    }

    @When("^'test steps' is set as '(.*)'$")
    public void _test_steps_is_set_as_Test_Steps(String data) {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[3]")).sendKeys(data);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]")).click();
    }

    @When("^'Expected Result' is set as '(.*)'$")
    public void _Expected_Result_is_set_as_Expected_Result(String data) {
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[4]")).sendKeys(data);
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]")).click();
    }

    @When("^click on save$")
    public void click_on_save() {
        driver.findElement(By.name("Save")).click();
    }

    @Then("^the success message is shown as dialog$")
    public void the_success_message_is_shown_as_dialog() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isTextPresent("Testcase is saved successfully"));
        driver.findElement(By.name("Ok")).click();
    }

}
