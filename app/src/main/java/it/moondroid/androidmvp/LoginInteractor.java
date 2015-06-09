package it.moondroid.androidmvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Marco on 09/06/2015.
 */
public class LoginInteractor {

    private static boolean isLogged = false;
    private static String username = "";

    public static interface OnLoginFinishedListener {
        void onSuccess();
        void onUsernameError();
        void onPasswordError();
    }

    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    LoginInteractor.isLogged = true;
                    LoginInteractor.username = username;
                    listener.onSuccess();
                }
            }
        }, 2000);
    }

    public void logout(){
        isLogged = false;
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                //TODO
            }
        }, 0);
    }

    public boolean isLogged(){
        return isLogged;
    }

    public String getUsername(){
        return username;
    }
}
