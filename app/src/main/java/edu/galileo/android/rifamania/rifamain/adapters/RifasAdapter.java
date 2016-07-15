package edu.galileo.android.rifamania.rifamain.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.entities.Rifa;

/**
 * Created by Roberto Hdez. on 14/07/16.
 */

public class RifasAdapter extends RecyclerView.Adapter<RifasAdapter.ViewHolder> {
    private List<Rifa> rifaList;
    private OnItemCLickListener onItemClickListener;

    public RifasAdapter(List<Rifa> rifaList, OnItemCLickListener onItemClickListener) {
        this.rifaList = rifaList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_rifa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Rifa currentRifa = rifaList.get(position);

        holder.title.setText(currentRifa.getName());
        holder.date.setText(currentRifa.getDate());
        holder.cost.setText(currentRifa.getCost());

        holder.setOnItemClickListener(currentRifa, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return rifaList.size();
    }

    public void setRifa(Rifa rifa){
        rifaList.add(rifa);
        notifyDataSetChanged();
    }

    public void setRifas(List<Rifa> rifas){
        this.rifaList = rifas;
        notifyDataSetChanged();
    }

    public void removeRifa(Rifa rifa){
        rifaList.remove(rifa);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.date)
        TextView date;
        @Bind(R.id.cost)
        TextView cost;
        @Bind(R.id.imgDelete)
        ImageButton imgDelete;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener(final Rifa currentRifa, final OnItemCLickListener onItemCLickListener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemCLickListener.onItemCLick(currentRifa);
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemCLickListener.onDeleteClick(currentRifa);
                }
            });
        }
    }
}
