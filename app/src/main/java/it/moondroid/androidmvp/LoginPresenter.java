package it.moondroid.androidmvp;

import de.greenrobot.event.EventBus;
import it.moondroid.androidmvp.event.NavigationEvent;

/**
 * Created by Marco on 09/06/2015.
 */
public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginViewInterface loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginViewInterface loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractor();
    }

    public void validateCredentials(String username, String password) {
        loginView.setLoginEnabled(false);
        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onLoginSuccess() {
        loginView.hideProgress();
        EventBus.getDefault().post(new NavigationEvent(NavigationEvent.Destination.BACK));
    }

    @Override
    public void onUsernameError() {
        loginView.hideProgress();
        loginView.setLoginEnabled(true);
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgress();
        loginView.setLoginEnabled(true);
        loginView.setPasswordError();
    }
}
