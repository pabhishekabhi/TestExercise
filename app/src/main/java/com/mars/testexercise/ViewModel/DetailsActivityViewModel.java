package com.mars.testexercise.ViewModel;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.mars.testexercise.Constants.Constants;
import com.mars.testexercise.Utility.OnSwipeTouchListener;

public class DetailsActivityViewModel extends ViewModel {

    Context context;
    LinearLayout linearLayout;
    TextView txtName, txtUserName, txtEmail, txtAddress, txtCompany, txtPhoneNumber;

    int pos;

    public void init(int position,
                     TextView txtName, TextView txtUserName, TextView txtEmail, TextView txtAddress,
                     TextView txtCompany, TextView txtPhoneNumber){

        this.pos = position;
        this.txtName = txtName;
        this.txtUserName = txtUserName;
        this.txtEmail = txtEmail;
        this.txtAddress = txtAddress;
        this.txtCompany = txtCompany;
        this.txtPhoneNumber = txtPhoneNumber;

        setData(pos);
    };


    public void swipeListner(Context context, LinearLayout linearLayout, int position){

        this.context = context;
        this.linearLayout = linearLayout;
        this.pos = position;



        linearLayout.setOnTouchListener(new OnSwipeTouchListener(context) {
            public void onSwipeTop() {

            }

            public void onSwipeRight() {
                if (pos > 0 && pos <= Constants.user.size() ) {
                    pos--;
                    setData(pos);
                }
            }

            public void onSwipeLeft() {

                if (pos >= 0 && pos < Constants.user.size() && pos!=Constants.user.size()) {
                    pos++;
                    setData(pos);
                }
            }

            public void onSwipeBottom() {

            }

        });

    }


    private void setData(int pos) {

        txtName.setText(Constants.user.get(pos).getName());
        txtUserName.setText(Constants.user.get(pos).getUsername());
        txtEmail.setText(Constants.user.get(pos).getEmail());
        txtAddress.setText(Constants.user.get(pos).getAddress().getStreet() + " , "
                + Constants.user.get(pos).getAddress().getSuite() + " , "
                + Constants.user.get(pos).getAddress().getCity() + " , "
                + Constants.user.get(pos).getAddress().getZipcode());
        txtCompany.setText(Constants.user.get(pos).getCompany().getName());
        txtPhoneNumber.setText(Constants.user.get(pos).getPhone());
    }
}
