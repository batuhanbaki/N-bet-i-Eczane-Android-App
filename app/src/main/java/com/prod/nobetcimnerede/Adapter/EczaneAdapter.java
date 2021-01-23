package com.prod.nobetcimnerede.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.prod.nobetcimnerede.EczaneDetayActivity;
import com.prod.nobetcimnerede.Models.EczaneDataModel;
import com.prod.nobetcimnerede.R;

import java.io.Serializable;
import java.util.List;

public class EczaneAdapter extends RecyclerView.Adapter<EczaneAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public CardView card_view;
        RelativeLayout rlayout;
        public TextView eczanead;
        public TextView eczaneil;
        public Button showMoreDetails;

        public ViewHolder(View view) {
            super(view);
            card_view = (CardView)view.findViewById(R.id.eczanecw);
            rlayout = (RelativeLayout) view.findViewById(R.id.cwRlayout);
            eczanead = (TextView) view.findViewById(R.id.eczanead);
            eczaneil = (TextView) view.findViewById(R.id.eczaneil);
            showMoreDetails = (Button) view.findViewById(R.id.eczaneshowBtn);
        }
    }

    List<EczaneDataModel> eczaneList;
    public EczaneAdapter(List<EczaneDataModel> eczaneList)
    {
        this.eczaneList = eczaneList;
    }

    @Override
    public EczaneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_for_mainactivity, parent, false);
        final ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.eczanead.setText(eczaneList.get(position).getEczane_adi());
        holder.eczaneil.setText(eczaneList.get(position).getEczane_il());
        holder.rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.eczanead.getContext(), EczaneDetayActivity.class);
                i.putExtra("eczanead", eczaneList.get(position).getEczane_adi());
                i.putExtra("eczaneil", eczaneList.get(position).getEczane_il());
                i.putExtra("eczaneilce", eczaneList.get(position).getEczane_ilce());
                i.putExtra("eczaneadres", eczaneList.get(position).getEczane_adres());
                i.putExtra("eczanetel", eczaneList.get(position).getEczane_telefon());
                view.getContext().startActivity(i);
            }
        });
        holder.showMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.eczanead.getContext(), EczaneDetayActivity.class);
                i.putExtra("eczanead", eczaneList.get(position).getEczane_adi());
                i.putExtra("eczaneil", eczaneList.get(position).getEczane_il());
                i.putExtra("eczaneilce", eczaneList.get(position).getEczane_ilce());
                i.putExtra("eczaneadres", eczaneList.get(position).getEczane_adres());
                i.putExtra("eczanetel", eczaneList.get(position).getEczane_telefon());
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eczaneList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
