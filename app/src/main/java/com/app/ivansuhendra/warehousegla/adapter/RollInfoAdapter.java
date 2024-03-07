package com.app.ivansuhendra.warehousegla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ivansuhendra.warehousegla.R;
import com.app.ivansuhendra.warehousegla.model.Model;

import java.util.List;

public class RollInfoAdapter extends RecyclerView.Adapter<RollInfoAdapter.RollInfoViewHolder> {
    private List<Model> mItems;
    private Context mContext;
    private RollInfoAdapter.onItemClickListener mClicked;

    public RollInfoAdapter(Context mContext, List<Model> mItems, RollInfoAdapter.onItemClickListener clicked) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.mClicked = clicked;
    }

    public interface onItemClickListener {
        void onClick(View view, int position, Model carton);
    }

    @NonNull
    @Override
    public RollInfoAdapter.RollInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fabric_roll, parent, false);
        return new RollInfoAdapter.RollInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RollInfoAdapter.RollInfoViewHolder holder, int position) {
        Model model = mItems.get(position);
        holder.tvName.setText(model.getName());

        holder.btnItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClicked.onClick(v, holder.getAdapterPosition(), model);
            }
        });
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

    public static class RollInfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView btnItemView;

        public RollInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnItemView = itemView.findViewById(R.id.btn_item_view);
        }
    }
}