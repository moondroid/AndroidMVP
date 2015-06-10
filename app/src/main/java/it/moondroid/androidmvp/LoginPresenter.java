package it.moondroid.androidmvp;

import de.greenrobot.event.EventBus;
import it.moondroid.androidmvp.event.NavigationEvent;

/**
 * Created by Marco on 09/06/2015.
 */
public class LoginPresenter extends BasePresenter<LoginViewInterface>
        implements LoginInteractor.OnLoginFinishedListener {

    private LoginInteractor loginInteractor;

    public LoginPresenter() {
        this.loginInteractor = new LoginInteractor();
    }

    public void validateCredentials(String username, String password) {
        if (isViewAttached()){
            getView().setLoginEnabled(false);
            getView().showProgress();
            loginInteractor.login(username, password, this);
        }

    }

    @Override
    public void onLoginSuccess() {
        if (isViewAttached()) {
            getView().hideProgress();
            EventBus.getDefault().post(new NavigationEvent(NavigationEvent.Destination.BACK));
        }
    }

    @Override
    public void onUsernameError() {
        if (isViewAttached()) {
            getView().hideProgress();
            getView().setLoginEnabled(true);
            getView().setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (isViewAttached()) {
            getView().hideProgress();
            getView().setLoginEnabled(true);
            getView().setPasswordError();
        }
    }
}
