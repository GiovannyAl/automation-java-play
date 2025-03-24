package edgaralbarracin;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import edgaralbarracin.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SerenityJUnit5Extension.class)

public class LoginPageTest {

    @Managed
    WebDriver driver;

    private LoginPage loginPage;

    @Test
    public void testLoginWithInvalidCredentials_shouldShowErrorMessage() {
        String expectedErrorMessage = "Invalid credentials";

        // Test con username correcto, contraseña incorrecta
        loginPage.login("Admin", "Admin");
        String errorMessageText = loginPage.getErrorAlertContentMessage();
        assertEquals(expectedErrorMessage, errorMessageText);

        // Test con username incorrecto, contraseña correcta
        loginPage.login("User", "admin123");
        String secondErrorMessageText = loginPage.getErrorAlertContentMessage();
        assertEquals(expectedErrorMessage, secondErrorMessageText);
    }

    @Test
    public void testLoginWithEmptyUsername_shouldShowErrorMessage() {
        String expectedErrorMessage = "Required";

        loginPage.login("", "admin123");
        List<WebElementFacade> errorMessages = loginPage.getFieldErrorMessages();

        assertEquals(1, errorMessages.size());
        assertEquals(expectedErrorMessage, errorMessages.get(0).getText());
    }

    @Test
    public void testLoginWithEmptyUsernameAndPassword_shouldShowErrorMessage() {
        String expectedErrorMessage = "Required";

        loginPage.login("", "");
        List<WebElementFacade> errorMessages = loginPage.getFieldErrorMessages();

        assertEquals(2, errorMessages.size());
        assertEquals(expectedErrorMessage, errorMessages.get(0).getText());
        assertEquals(expectedErrorMessage, errorMessages.get(1).getText());
    }

    @Test
    public void testLoginWithValidCredentials() {
        String expectedUsername = "IkwdDlikRs userLastNameTest";
        loginPage.login("Admin", "admin123");

        String actualUsername = loginPage.getUserDropdownName();
        assertEquals(expectedUsername, actualUsername);
    }
}

