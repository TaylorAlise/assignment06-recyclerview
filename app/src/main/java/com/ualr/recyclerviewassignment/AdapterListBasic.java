package com.ualr.recyclerviewassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

public class AdapterListBasic extends RecyclerView.Adapter {

    private List<Inbox> mItems;
    private Context mContext;


    public AdapterListBasic(Context context, List<Inbox> items) {
        this.mItems = items;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout, parent, false);
        vh = new PersonViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonViewHolder viewHolder = (PersonViewHolder) holder;

        Inbox p = mItems.get(position);

        viewHolder.name.setText(p.getFrom());
        viewHolder.email.setText(p.getEmail());
        viewHolder.date.setText(p.getDate());
        //Tools.displayImageRound(mContext, viewHolder, image, p.getImage());
    }

    @Override
    public int getItemCount() { return this.mItems.size(); }


    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView email;
        public TextView date;
        public View lyt_parent;


        public PersonViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
            email = v.findViewById(R.id.email);
            date = v.findViewById(R.id.date);
            lyt_parent = v.findViewById(R.id.lyt_parent);


            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        /*private OnItemClickListener mOnItemClickListener;

        public interface OnItemClickListener {
            void onItemClick(View view, Inbox obj, int position);
        }

        public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mOnItemClickListener = mItemClickListener;
        }*/


    }


}
