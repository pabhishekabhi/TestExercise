package com.mars.testexercise.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.mars.testexercise.APIManager.APICallSingleton;
import com.mars.testexercise.APIManager.Observers.ErrorObserver;
import com.mars.testexercise.APIManager.Observers.FetchUsersObserver;
import com.mars.testexercise.Constants.Constants;
import com.mars.testexercise.Model.User;
import com.mars.testexercise.Adapters.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class HomeActivityViewModel extends ViewModel implements Observer {


    Context context;
    RecyclerView recyclerView;

    public void init(Context context, RecyclerView recyclerView) {

        this.recyclerView = recyclerView;
        this.context = context;

        Constants.user = new ArrayList<>();
        addObservers();
        setData();
        APICallSingleton.getInstance(context).getUsers(context);
    }

    private void addObservers() {
        FetchUsersObserver.getSharedInstance().addObserver(this);
        ErrorObserver.getSharedInstance().addObserver(this);
    }

    private void deleteObservers() {
        FetchUsersObserver.getSharedInstance().deleteObserver(this);
        ErrorObserver.getSharedInstance().deleteObserver(this);
    }


    @Override
    public void update(Observable observer, final Object data) {

        if (observer instanceof FetchUsersObserver) {

            Constants.user = (ArrayList<User>) data;

            Log.d("userresponse123", "" + new Gson().toJson(Constants.user));
            setData();
        }
        if (observer instanceof ErrorObserver) {

        }
    }

    private void setData() {

        RecyclerAdapter adapter = new RecyclerAdapter(Constants.user);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
}
