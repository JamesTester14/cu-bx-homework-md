package web;

import junitTags.Web;
import org.junit.jupiter.api.Test;
import pageObject.web.BasePage;
import pageObject.web.users.UsersListerPage;
import utils.BrowserLogs;
import utils.dataGeneration.UserBuilder;

import static utils.dataGeneration.Randomizer.randomizeString;

@Web
public class UserTest extends BaseTest{
    UsersListerPage userLister = new UsersListerPage();
    BasePage homepage = new BasePage();
    BrowserLogs logs = new BrowserLogs();

    @Test
    void checkUserCreation(){
        UserBuilder user = new UserBuilder().toBuilder()
                .email(randomizeString(10)+"@test.com")
                .fname(randomizeString(5)+"fname")
                .lname(randomizeString(5)+"lname")
                .phone("+380123456789")
                .company("Google")
                .gender("Male")
                .age("30")
                .height("190")
                .weight("90")
                .build();
        homepage.openPage(homepage.pageUrl());
        homepage.logInAsAdmin();
        homepage.openPage(userLister.pageUrl());
        userLister.visitOperatorsLister();
        userLister.createNewUser(user);
        userLister.asserts.checkUserSuccessCreation();
    }

    @Test
    void checkVersionNumber(){
        homepage.openPage(homepage.pageUrl());
        homepage.logInAsAdmin();
        homepage.checkVersionIs("3.4.0");
    }

    @Test
    void checkLogoutIs200(){
        homepage.openPage(homepage.pageUrl());
        homepage.logInAsAdmin();
        homepage.logout();
        homepage.asserts.checkUserIsLoggedOut();
    }

}
