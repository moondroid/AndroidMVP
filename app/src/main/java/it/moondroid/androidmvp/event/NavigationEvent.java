package it.moondroid.androidmvp.event;

/**
 * Created by Marco on 09/06/2015.
 */
public class NavigationEvent {

    public enum Destination {LOGIN_FORM, WELCOME, NOTES_LIST, BACK};

    public final Destination destination;

    public NavigationEvent(Destination destination) {
        this.destination = destination;
    }
}
