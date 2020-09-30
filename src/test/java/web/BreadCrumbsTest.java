package web;

import com.codeborne.selenide.Condition;
import junitTags.Web;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.web.BasePage;
import pageObject.web.devices.DevicesListerPage;
import pageObject.web.locations.LocationDetailPage;
import pageObject.web.locations.LocationsListerPage;
import pageObject.web.users.AdminsPage;
import pageObject.web.users.OperatorsPage;
import pageObject.web.users.PatientsPage;
import pageObject.web.users.UserDetailPage;
import utils.Helper;

import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertAll;

@Web
public class BreadCrumbsTest extends BaseTest {
    BasePage homepage = new BasePage();
    UserDetailPage userDetail = new UserDetailPage();
    AdminsPage userAdmins = new AdminsPage();
    PatientsPage userPatients = new PatientsPage();
    OperatorsPage userOperators = new OperatorsPage();
    LocationsListerPage locationsLister = new LocationsListerPage();
    LocationDetailPage locationDetailPage = new LocationDetailPage();
    DevicesListerPage devicesLister = new DevicesListerPage();
    Helper helper = new Helper();

    @BeforeEach
    void adminLogin(){
        homepage.openPage(homepage.pageUrl());
        homepage.logInAsAdmin();
    }

    @Test
    void checkUsersAdminsBreadCrumbs(){
        userAdmins.openPage(userAdmins.pageUrl());
        helper.visitFirstRecord();
        assertAll(
                () -> $$(".MuiBreadcrumbs-li").get(0).shouldHave(Condition.text("Users")),
                () -> $$(".MuiBreadcrumbs-li").get(1).shouldHave(Condition.text("Admins")),
                () -> $$(".MuiBreadcrumbs-li").get(2).shouldHave(Condition.text(userDetail.crumbs()))
        );
    }

    @Test
    void checkUsersOperatorsBreadCrumbs(){
        userOperators.openPage(userOperators.pageUrl());
        helper.visitFirstRecord();
        assertAll(
                () -> $$(".MuiBreadcrumbs-li").get(0).shouldHave(Condition.text("Users")),
                () -> $$(".MuiBreadcrumbs-li").get(1).shouldHave(Condition.text("Operators")),
                () -> $$(".MuiBreadcrumbs-li").get(2).shouldHave(Condition.text(userDetail.crumbs()))
        );
    }

    @Test
    void checkUsersPatientsBreadCrumbs(){
        userPatients.openPage(userPatients.pageUrl());
        assertAll(
                () -> $$(".MuiBreadcrumbs-li").get(0).shouldHave(Condition.text("Users")),
                () -> $$(".MuiBreadcrumbs-li").get(1).shouldHave(Condition.text("Patients"))
        );
    }

    @Test
    void checkLocationsBreadCrumbs(){
        locationsLister.openPage(locationsLister.pageUrl());
        helper.visitFirstRecord();
        assertAll(
                () -> $$(".MuiBreadcrumbs-li").get(0).shouldHave(Condition.text("Locations")),
                () -> $$(".MuiBreadcrumbs-li").get(1).shouldHave(Condition.text(locationDetailPage.crumbs()))
        );
    }

    @Test
    void checkDevicesBreadCrumbs(){
        devicesLister.openPage(devicesLister.pageUrl());
        helper.visitFirstRecord();
        assertAll(
                () -> $$(".MuiBreadcrumbs-li").get(0).shouldHave(Condition.text("Devices")),
                () -> $$(".MuiBreadcrumbs-li").get(1).shouldHave(Condition.text(devicesLister.crumbs()))
        );
    }

}
