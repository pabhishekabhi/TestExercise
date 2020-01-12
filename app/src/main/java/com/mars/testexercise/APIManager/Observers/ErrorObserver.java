package com.mars.testexercise.APIManager.Observers;

import java.util.Observable;

public class ErrorObserver extends Observable
{
    private static ErrorObserver self;

    public static ErrorObserver getSharedInstance()
    {
        if (self == null)
            self = new ErrorObserver();
        return self;
    }

    public void raiseNotification(Object dataObject)
    {
        setChanged();
        notifyObservers(dataObject);
    }
}