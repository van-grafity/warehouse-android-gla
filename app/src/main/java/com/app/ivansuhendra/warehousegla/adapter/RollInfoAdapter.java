package com.app.ivansuhendra.warehousegla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    private boolean isChecked;
    private OnCheckedChangeListener mCheckedChangeListener;

    public RollInfoAdapter(Context mContext, List<Model> mItems, boolean isChecked, RollInfoAdapter.onItemClickListener clicked) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.isChecked = isChecked;
        this.mClicked = clicked;
    }

    public interface onItemClickListener {
        void onClick(View view, int position, Model carton);
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean isChecked);
    }

    public void setCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mCheckedChangeListener = listener;
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
        holder.bind(model, isChecked, mClicked);
    }

    public void setData(List<Model> newData) {
        mItems.clear();
        mItems.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItems.size() == 0 ? 0 : mItems.size();
    }

    public class RollInfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView btnItemView;
        CheckBox dump;

        public RollInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnItemView = itemView.findViewById(R.id.btn_item_view);
            dump = itemView.findViewById(R.id.dump);
        }

        public void bind(final Model model, boolean isChecked, final RollInfoAdapter.onItemClickListener clickListener) {
            tvName.setText(model.getName());
//            dump.setChecked(isChecked);

            if (!isChecked) {
                dump.setVisibility(View.GONE);
            } else {
                dump.setVisibility(View.VISIBLE);
            }

            dump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (mCheckedChangeListener != null) {
                        mCheckedChangeListener.onCheckedChanged(isChecked);
                    }
                }
            });

            btnItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClick(v, getAdapterPosition(), model);
                }
            });
        }
    }
}