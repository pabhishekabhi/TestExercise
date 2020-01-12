package com.mars.testexercise.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mars.testexercise.Constants.Constants;
import com.mars.testexercise.R;
import com.mars.testexercise.ViewModel.DetailsActivityViewModel;
import com.mars.testexercise.ViewModel.HomeActivityViewModel;

public class DetailsActivity extends AppCompatActivity {

    TextView txtName, txtUserName, txtEmail, txtAddress, txtCompany, txtPhoneNumber;
    LinearLayout linearLayout;

    int pos;

    Context context;
    DetailsActivityViewModel detailsActivityViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        context = this;

        linearLayout = findViewById(R.id.layout);


        txtName = findViewById(R.id.txtName);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);
        txtCompany = findViewById(R.id.txtCompany);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);

        Bundle b = getIntent().getExtras();
        pos = b.getInt("id");

        detailsActivityViewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel.class);

        detailsActivityViewModel.init(
                pos,
                txtName,
                txtUserName,
                txtEmail,
                txtAddress,
                txtCompany,
                txtPhoneNumber);

        detailsActivityViewModel.swipeListner(
                context,
                linearLayout,
                pos
        );
    }
}
