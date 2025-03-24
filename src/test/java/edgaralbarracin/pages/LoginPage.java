package edgaralbarracin.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LoginPage extends PageObject {

    @FindBy(name = "username")
    private WebElementFacade usernameField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(className = "orangehrm-login-button")
    private WebElementFacade loginButton;

    @FindBy(className = "oxd-alert-content-text")
    private WebElementFacade errorAlertContentMessage;

    @FindBy(className = "oxd-input-field-error-message")
    private List<WebElementFacade> fieldErrorMessages;

    @FindBy(className = "oxd-userdropdown-name")
    private WebElementFacade userDropdownName;

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        open();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorAlertContentMessage() {
        errorAlertContentMessage.waitUntilVisible();
        return errorAlertContentMessage.getText();
    }

    public List<WebElementFacade> getFieldErrorMessages() {

        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("oxd-input-field-error-message")));
        return fieldErrorMessages;
    }

    public String getUserDropdownName() {
        userDropdownName.waitUntilVisible();
        return userDropdownName.getText();
    }
}