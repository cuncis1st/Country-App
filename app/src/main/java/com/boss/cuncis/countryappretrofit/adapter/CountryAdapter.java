package com.boss.cuncis.countryappretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boss.cuncis.countryappretrofit.R;
import com.boss.cuncis.countryappretrofit.model.Result;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CoutryViewHolder> {

    List<Result> results;
    Context context;

    public CountryAdapter(List<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public CoutryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CoutryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoutryViewHolder holder, int i) {
        holder.tvResult.setText(results.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class CoutryViewHolder extends RecyclerView.ViewHolder {
        TextView tvResult;

        public CoutryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvResult = itemView.findViewById(R.id.tv_countryName);
        }
    }
}
