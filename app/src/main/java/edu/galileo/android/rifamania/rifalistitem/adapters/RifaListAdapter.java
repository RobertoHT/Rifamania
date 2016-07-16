package edu.galileo.android.rifamania.rifalistitem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.entities.ItemRifa;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListAdapter extends RecyclerView.Adapter<RifaListAdapter.ViewHolder> {
    private List<ItemRifa> itemRifaList;
    private OnItemListClickListener onItemListClickListener;

    public RifaListAdapter(List<ItemRifa> itemRifaList, OnItemListClickListener onItemListClickListener) {
        this.itemRifaList = itemRifaList;
        this.onItemListClickListener = onItemListClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_item_rifa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemRifa currentItemRifa = itemRifaList.get(position);

        holder.txtItemName.setText(currentItemRifa.getName());
        if(currentItemRifa.getPaid()){
            holder.checkItemPay.setChecked(true);
        }else{
            holder.checkItemPay.setChecked(false);
        }

        holder.setOnItemListClickListener(currentItemRifa, onItemListClickListener);
    }

    @Override
    public int getItemCount() {
        return itemRifaList.size();
    }

    public void setItemRifa(ItemRifa itemRifa){
        itemRifaList.add(itemRifa);
        notifyDataSetChanged();
    }

    public void setItemsRifa(List<ItemRifa> itemsRifa){
        this.itemRifaList = itemsRifa;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        @Bind(R.id.txtItemName)
        TextView txtItemName;
        @Bind(R.id.checkItemPay)
        CheckBox checkItemPay;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

        public void setOnItemListClickListener(final ItemRifa currentItemRifa, final OnItemListClickListener onItemListClickListener) {
            checkItemPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListClickListener.onUpdateClick(currentItemRifa);
                }
            });
        }
    }
}
