package com.klix.mobile.pages.login;

import com.klix.mobile.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.mobile.pages.login.AppLoginPageElements.CLIENT_ID_INPUT;
import static com.klix.mobile.pages.login.AppLoginPageElements.CLIENT_PASSWORD_INPUT;
import static com.klix.mobile.pages.login.AppLoginPageElements.CLIENT_USERNAME_INPUT;
import static com.klix.mobile.pages.login.AppLoginPageElements.LOCATION_BUTTON;
import static com.klix.mobile.pages.login.AppLoginPageElements.LOGIN_SIGN_IN_SUBTITLE;
import static com.klix.mobile.pages.login.AppLoginPageElements.LOGIN_SIGN_IN_TITLE;
import static com.klix.mobile.pages.login.AppLoginPageElements.SIGN_IN_BUTTON;

//TODO -- methods will be deleted after language selecting test in login screen will be refactored
@Component
public class AppLoginPageMethods extends Base {

    @Step("Enter client ID {id} to the text input field")
    private void enterClientIdToTextField(Long id) {
        enterText(CLIENT_ID_INPUT, id);
    }

    @Step("Enter username {username} to the text input field")
    private void enterClientUsernameToTextField(String username) {
        enterText(CLIENT_USERNAME_INPUT, username);
    }

    @Step("Enter password {password} to to the text input field")
    private void enterClientPasswordToTextField(String password) {
        enterText(CLIENT_PASSWORD_INPUT, password);
    }

    @Step("Press Sign in button to login to the driver app")
    private void pressSignButton() {
        click(SIGN_IN_BUTTON);
    }

    @Step("Login to the mobile application with ID {id}, user {username}, password {password}")
    public void loginToDriverApp(Long id, String username, String password) {
        enterClientIdToTextField(id);
        enterClientUsernameToTextField(username);
        enterClientPasswordToTextField(password);
        pressSignButton();
    }

    @Step("Validate language button visibility")
    public void validateLanguageButtonVisibility() {
        waitForElementToBeVisible(LOCATION_BUTTON);
    }

    @Step("Press language button")
    public void pressLanguageButton() {
        click(LOCATION_BUTTON);
    }

    @Step("Validate Sign In title visibility")
    public void validateTitleVisibility() {
        waitForElementToBeVisible(LOGIN_SIGN_IN_TITLE);
    }

    @Step("Validate subtitle visibility")
    public void validateSubTitleVisibility() {
        waitForElementToBeVisible(LOGIN_SIGN_IN_SUBTITLE);
    }

    @Step("Validate Sign In button visibility")
    public void validateSignInButtonVisibility() {
        waitForElementToBeVisible(SIGN_IN_BUTTON);
    }
}
