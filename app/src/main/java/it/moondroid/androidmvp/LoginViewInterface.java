package it.moondroid.androidmvp;

/**
 * Created by Marco on 09/06/2015.
 */
public interface LoginViewInterface {

    void showProgress();

    void hideProgress();

    void setLoginEnabled(boolean enabled);

    void setUsernameError();

    void setPasswordError();

}
