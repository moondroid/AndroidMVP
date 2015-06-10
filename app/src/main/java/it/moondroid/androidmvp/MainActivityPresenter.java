package it.moondroid.androidmvp;

import de.greenrobot.event.EventBus;
import it.moondroid.androidmvp.event.NavigationEvent;

/**
 * Created by Marco on 10/06/2015.
 */
public class MainActivityPresenter {

    private MainViewInterface mainView;

    public MainActivityPresenter(MainViewInterface mainView) {
        this.mainView = mainView;
    }

    public void onStart(){
        EventBus.getDefault().register(this);
        mainView.showWelcome();
    }

    public void onStop(){
        EventBus.getDefault().unregister(this);
    }

    // This method will be called when a NavigationEvent is posted
    public void onEvent(NavigationEvent event){
        switch (event.destination){
            case LOGIN_FORM:
                mainView.showLogin();
                break;
            case WELCOME:
                mainView.showWelcome();
                break;
            case BACK:
                mainView.onBackPressed();
                break;
        }

    }


}
