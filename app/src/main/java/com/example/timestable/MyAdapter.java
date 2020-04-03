package com.example.timestable;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.*;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> data;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> data) {
        this.data = data;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView number;
        public MyViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.textView);
        }

        public void bind(final String model) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO implement OnClickListener
                }
            });
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        MyViewHolder vh = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.times_table_row, parent, false));
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = data.get(position);
        holder.number.setText(item);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(item);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }
}