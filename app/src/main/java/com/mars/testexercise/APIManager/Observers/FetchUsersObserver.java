package com.mars.testexercise.APIManager.Observers;

import java.util.Observable;

public class FetchUsersObserver extends Observable
{
    private static FetchUsersObserver self;

    public static FetchUsersObserver getSharedInstance()
    {
        if (self == null)
            self = new FetchUsersObserver();
        return self;
    }

    public void raiseNotification(Object dataObject)
    {
        setChanged();
        notifyObservers(dataObject);
    }
}