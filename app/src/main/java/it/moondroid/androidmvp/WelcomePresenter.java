package it.moondroid.androidmvp;

import de.greenrobot.event.EventBus;
import it.moondroid.androidmvp.event.NavigationEvent;

/**
 * Created by Marco on 09/06/2015.
 */
public class WelcomePresenter {

    private WelcomeViewInterface welcomeView;
    private LoginInteractor loginInteractor;

    public WelcomePresenter(WelcomeViewInterface loginView) {
        this.welcomeView = loginView;
        this.loginInteractor = new LoginInteractor();
    }

    public void checkLoggedState(){
        if (loginInteractor.isLogged()){
            welcomeView.showLoggedUser(loginInteractor.getUsername());
            welcomeView.showLogoutButton();
        }else {
            welcomeView.showAnonymousUser();
            welcomeView.showLoginButton();
        }
    }

    public void doLogin(){
        EventBus.getDefault().post(new NavigationEvent(NavigationEvent.Destination.LOGIN_FORM));
    }

    public void doLogout(){
        loginInteractor.logout();
        checkLoggedState();
    }
}
