package com.example.evaluationtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProcessesAdapter extends RecyclerView.Adapter<ProcessesAdapter.viewHolder> {

    ArrayList<ProcessesModel> processesModels;
    Context context;


    public ProcessesAdapter(ArrayList<ProcessesModel> processesModels, Context context) {
        this.processesModels = processesModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.processes_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.mainIMG.setImageResource(processesModels.get(position).getMainImg());
        holder.title.setText(processesModels.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return processesModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView mainIMG;
        TextView title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            mainIMG=itemView.findViewById(R.id.process_img);
            title=itemView.findViewById(R.id.process_title);
        }
    }
}
