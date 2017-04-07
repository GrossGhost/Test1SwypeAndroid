package com.example.gross.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gross.myapplication.R;
import com.example.gross.myapplication.model.ListItemGuitar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gross on 04.04.2017.
 */

public class GuitarAdapter extends RecyclerView.Adapter<GuitarAdapter.GuitarHolder> implements Filterable {

    private List<ListItemGuitar> listData;
    private List<ListItemGuitar> listDataCopy;
    private LayoutInflater inflater;
    private ClickListener clickListener;

    public GuitarAdapter(List<ListItemGuitar> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
        this.listDataCopy = listData;
    }

    @Override
    public GuitarHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new GuitarHolder(view);

    }

    @Override
    public void onBindViewHolder(GuitarHolder holder, int position) {

        ListItemGuitar item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.price.setText(item.getPrice());
        Picasso.with(holder.itemView.getContext())
                .load(item.getImageId())
                .resize(220, 220)
                .into(holder.image);

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ListItemGuitar> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = listDataCopy;
                } else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }
                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                listData = (List<ListItemGuitar>) results.values;
                GuitarAdapter.this.notifyDataSetChanged();

            }
        };
    }

    private List<ListItemGuitar> getFilteredResults(String constraint) {
        List<ListItemGuitar> results = new ArrayList<>();
        for (ListItemGuitar item : listDataCopy) {
            if (item.getTitle().toLowerCase().contains(constraint)) {
                results.add(item);
            }
        }
        return results;

    }

    class GuitarHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, price;
        private ImageView image;
        private View conteiner;

        public GuitarHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_title);
            price = (TextView) itemView.findViewById(R.id.item_price);
            image = (ImageView) itemView.findViewById(R.id.item_image);
            conteiner = itemView.findViewById(R.id.item_cont);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (clickListener != null) {
                clickListener.itemClicked(v, getPosition());
            }

        }
    }

    public ListItemGuitar getSelectedGuitar(int position) {
        return listData.get(position);
    }

    public interface ClickListener {
        void itemClicked(View view, int position);
    }


}
