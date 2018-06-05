package com.synertone.ohterapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.synertone.binderframework.MyApp;

public class MainActivity extends AppCompatActivity {

    private MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent service=new Intent();
        service.setAction("com.synertone.binderframework.MyService");
        service.setPackage("com.synertone.binderframework");
        bindService(service,new MyServiceConnection(), Service.BIND_AUTO_CREATE);
    }

    public void request(View view) {
        try {
            myApp.setName("xiaomei");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void showToast(View view) {
        try {
            Toast.makeText(MainActivity.this,myApp.getName(),Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    class MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
             myApp = MyApp.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
