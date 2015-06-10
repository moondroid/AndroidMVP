package it.moondroid.androidmvp;

/**
 * Created by Marco on 09/06/2015.
 */
public interface WelcomeViewInterface {

    void showLoggedUser(String username);

    void showAnonymousUser();

    void showLogoutButton();

    void showLoginButton();

    void setLogoutEnabled(boolean enabled);
}
