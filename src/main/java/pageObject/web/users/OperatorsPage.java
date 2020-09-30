package pageObject.web.users;

public class OperatorsPage extends UserDetailPage {
    public String pageUrl(){
        return getBaseUrl() + "users/operators";
    }
}
