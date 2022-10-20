package com.example.ys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    Context context;
    List<TopicData> topicDataList;
    public TopicAdapter(Context context, List<TopicData> topicDataList) {
        this.context = context;
        this.topicDataList= topicDataList;
    }

    public static final  class TopicViewHolder extends RecyclerView.ViewHolder{
           ImageView reeimage;
           TextView reedes;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            reeimage=itemView.findViewById(R.id.imageView31);
            reedes=itemView.findViewById(R.id.textView57);
        }
    }


    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.topic,parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
         holder.reeimage.setImageResource(topicDataList.get(position).getIdd());
         holder.reedes.setText(topicDataList.get(position).getDescribe());
    }


    @Override
    public int getItemCount() {
        return topicDataList.size();
    }
}