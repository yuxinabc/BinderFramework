package com.synertone.binderframework;

import android.os.RemoteException;

public class MyImpl extends MyApp.Stub {
    private String name="yuxin";
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String setName(String name) throws RemoteException {
        this.name=name;
        return name;
    }
}
