package com.app.ivansuhendra.warehousegla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ivansuhendra.warehousegla.R;
import com.app.ivansuhendra.warehousegla.model.Model;

import java.util.List;

public class PackingListAdapter extends RecyclerView.Adapter<PackingListAdapter.PackingListViewHolder> {
    private List<Model> mItems;
    private Context mContext;
    private PackingListAdapter.onItemClickListener mClicked;

    public PackingListAdapter(Context mContext, List<Model> mItems, PackingListAdapter.onItemClickListener clicked) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.mClicked = clicked;
    }

    public interface onItemClickListener {
        void onClick(View view, int position, Model carton);
    }

    @NonNull
    @Override
    public PackingListAdapter.PackingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_packinglist, parent, false);
        return new PackingListAdapter.PackingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackingListAdapter.PackingListViewHolder holder, int position) {
        Model model = mItems.get(position);
        holder.tvName.setText(model.getName());
    }

    public void removeItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void setData(List<Model> newData) {
        mItems.clear();
        mItems.addAll(newData);
        notifyDataSetChanged();
    }

    public void addData(List<Model> newData) {
        int startPosition = mItems.size();
        mItems.addAll(newData);
        notifyItemRangeInserted(startPosition, newData.size());
    }

    @Override
    public int getItemCount() {
        return mItems.size() == 0 ? 0 : mItems.size();
    }

    public static class PackingListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public PackingListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}