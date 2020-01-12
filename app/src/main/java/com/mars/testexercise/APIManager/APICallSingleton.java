package com.mars.testexercise.APIManager;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mars.testexercise.APIManager.Observers.ErrorObserver;
import com.mars.testexercise.APIManager.Observers.FetchUsersObserver;
import com.mars.testexercise.APIManager.RetrofitConfig.APIClient;
import com.mars.testexercise.APIManager.RetrofitConfig.APIInterface;
import com.mars.testexercise.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APICallSingleton {

    private static APICallSingleton ourInstance;
    private static APIInterface apiInterface;

    private APICallSingleton(Context context) {

        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    private APICallSingleton() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    public static APICallSingleton getInstance(Context context) {
            if (ourInstance == null) {
                ourInstance = new APICallSingleton(context);
            }
        return ourInstance;
    }

    /*
        Login User
    */

    public static void getUsers(final Context context) {

        apiInterface.fetchUsers().enqueue(new Callback<ArrayList<User>>() {

            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

                if (response.isSuccessful()) {
                    Log.d("UserResponse", new Gson().toJson(response.body()));

                    FetchUsersObserver.getSharedInstance().raiseNotification(response.body());


                } else {
                    ErrorObserver.getSharedInstance().raiseNotification("Server internal exception");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(context, "No network available", Toast.LENGTH_LONG).show();
            }
        });
    }

}