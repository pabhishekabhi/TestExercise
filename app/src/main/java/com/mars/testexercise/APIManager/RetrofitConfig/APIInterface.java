package com.mars.testexercise.APIManager.RetrofitConfig;

import com.mars.testexercise.Constants.GetAPI;
import com.mars.testexercise.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    /*Fetch Users*/

    @GET(GetAPI.GetUsers)
    Call<ArrayList<User>> fetchUsers();

}

