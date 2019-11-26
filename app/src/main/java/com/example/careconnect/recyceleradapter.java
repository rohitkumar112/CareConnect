package com.example.careconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recyceleradapter extends RecyclerView.Adapter<recyceleradapter.viewholder> {
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycler,parent,false);

        return new viewholder(view);
    }
    public String[] data;
    public int credit;
    public int debit;
    public Context context;
    public List<Integer> creditlist=new ArrayList<Integer>();
    public List<Integer> debitlist=new ArrayList<Integer>();

    public recyceleradapter(List<Integer> credit, List<Integer> debit, Context context)
    {
        this.creditlist=credit;
        this.debitlist=debit;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.name.setText(String.valueOf(debitlist.get(position)));

    }



    @Override
    public int getItemCount() {
        return creditlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
TextView name;
    public viewholder(@NonNull final View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(context,name.getText().toString(),Toast.LENGTH_SHORT).show();
    }
});
    }
}
}
