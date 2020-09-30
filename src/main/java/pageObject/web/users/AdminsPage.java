package pageObject.web.users;

public class AdminsPage extends UserDetailPage {
    public String pageUrl(){
        return getBaseUrl() + "users/admins";
    }
}
