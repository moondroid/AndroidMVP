package it.moondroid.androidmvp;

import it.moondroid.androidmvp.event.NavigationEvent;

/**
 * Created by Marco on 10/06/2015.
 */
public interface MainViewInterface {

    void showLogin();

    void showWelcome();

    void onBackPressed();
}
