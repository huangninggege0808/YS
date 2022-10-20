package com.example.ys;

import static com.example.ys.RoundRectImageView.getRoundBitmapByShader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<RecentsData> recentsDataList;
    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    public static final  class RecentsViewHolder extends RecyclerView.ViewHolder{
        ImageView reimagine;
        EditText reed;
        TextView retest;

        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);
            reimagine =itemView.findViewById(R.id.reimage);
            reed=itemView.findViewById(R.id.reed);
            retest =itemView.findViewById(R.id.retext);
        }
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycleview_layout,parent,false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        holder.retest.setText(recentsDataList.get(position).getTe());
        holder.reed.setText(recentsDataList.get(position).getEd());
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),recentsDataList.get(position).getId());
        Bitmap outBitmap =getRoundBitmapByShader(bitmap, 315,189,20, 3);
        holder.reimagine.setImageBitmap(outBitmap);

    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }
}
