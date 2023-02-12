package com.klix.mobile.pages.login;

import com.klix.mobile.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.mobile.pages.login.AppLoginPageElements.LOCATION_BUTTON;
import static com.klix.mobile.pages.login.AppLoginPageElements.LOGIN_SIGN_IN_SUBTITLE;
import static com.klix.mobile.pages.login.AppLoginPageElements.LOGIN_SIGN_IN_TITLE;
import static com.klix.mobile.pages.login.AppLoginPageElements.SIGN_IN_BUTTON;
import static com.klix.mobile.pages.login.constants.LoginConstants.LANGUAGE_LINK_ENGLISH;
import static com.klix.mobile.pages.login.constants.LoginConstants.LOGIN_ENGLISH;
import static com.klix.mobile.pages.login.constants.LoginConstants.LOGIN_POLSKI;
import static com.klix.mobile.pages.login.constants.LoginConstants.LOGIN_SIGN_IN_SUBTITLE_EN;
import static com.klix.mobile.pages.login.constants.LoginConstants.LOGIN_SIGN_IN_SUBTITLE_PL;
import static org.assertj.core.api.Assertions.assertThat;

//TODO -- Login assertions will be deleted or refactored after language selecting test in login screen will be
// refactored
@Component
public class AppLoginPageAssertions extends Base {

    @Step("Verify default language for OnTrack application")
    public void verifyDefaultLanguage() {
        assertThat(getText(LOCATION_BUTTON)).contains(LANGUAGE_LINK_ENGLISH);
    }

    @Step("Verify Sign In title in English")
    public void assertEnglishTitle() {
        assertThat(getText(LOGIN_SIGN_IN_TITLE)).isEqualTo(
                LOGIN_ENGLISH);
    }

    @Step("Verify Sign In title in Polish")
    public void assertPolishTitle() {
        assertThat(getText(LOGIN_SIGN_IN_TITLE)).isEqualTo(
                LOGIN_POLSKI);
    }

    @Step("Verify Subtitle in English")
    public void assertEnglishSubTitle() {
        assertThat(getText(LOGIN_SIGN_IN_SUBTITLE)).isEqualTo(
                LOGIN_SIGN_IN_SUBTITLE_EN);
    }

    @Step("Verify Subtitle in Polish")
    public void assertPolishSubTitle() {
        assertThat(getText(LOGIN_SIGN_IN_SUBTITLE)).isEqualTo(
                LOGIN_SIGN_IN_SUBTITLE_PL);
    }

    @Step("Verify Sign In button text in English")
    public void assertSignInButtonInEnglish() {
        assertThat(getText(SIGN_IN_BUTTON)).isEqualTo(LOGIN_ENGLISH);
    }

    @Step("Verify Sign In button text in Polish")
    public void assertSignInButtonInPolish() {
        assertThat(getText(SIGN_IN_BUTTON)).isEqualTo(LOGIN_POLSKI);
    }
}