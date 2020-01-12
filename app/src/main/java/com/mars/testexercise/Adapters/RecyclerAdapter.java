package com.mars.testexercise.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mars.testexercise.Model.User;
import com.mars.testexercise.R;
import com.mars.testexercise.View.DetailsActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<User> userList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    public RecyclerAdapter(ArrayList userList) {
        this.userList = userList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);


        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.name.setText(userList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), DetailsActivity.class);
                i.putExtra("id", position);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
