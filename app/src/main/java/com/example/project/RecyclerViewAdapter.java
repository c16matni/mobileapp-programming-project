package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecyclerViewItem> grass;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<RecyclerViewItem> grass, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.grass = grass;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.grass, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.namn.setText(grass.get(position).getNamn());
        holder.latin.setText(grass.get(position).getLatin());
        holder.familj.setText(grass.get(position).getFamilj());
        holder.plats.setText(grass.get(position).getPlats());
    }

    @Override
    public int getItemCount() {
        return grass.size();
    }

    public void addData(List<RecyclerViewItem> data) {
        this.grass = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView namn;
        TextView latin;
        TextView familj;
        TextView plats;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            namn = itemView.findViewById(R.id.namn);
            latin = itemView.findViewById(R.id.latin);
            familj = itemView.findViewById(R.id.familj);
            plats = itemView.findViewById(R.id.plats);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(grass.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }


}

