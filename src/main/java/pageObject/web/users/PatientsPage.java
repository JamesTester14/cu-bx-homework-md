package pageObject.web.users;

public class PatientsPage extends UserDetailPage {
    public String pageUrl(){
        return getBaseUrl() + "users/patients";
    }
}
