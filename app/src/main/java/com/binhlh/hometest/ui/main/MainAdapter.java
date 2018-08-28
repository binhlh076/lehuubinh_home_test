package com.binhlh.hometest.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.binhlh.hometest.R;
import com.binhlh.hometest.data.model.Keyword;
import com.binhlh.hometest.ui.base.BaseAdapter;

import java.util.Random;

/**
 * Created by BINHLH on 29/08/2018.
 */

public class MainAdapter extends BaseAdapter<Keyword, MainAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keyword, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Keyword keyword = mItems.get(position);
        holder.setData(keyword, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClicked(keyword, position);
                }
            }
        });
    }

    public static class ViewHolder extends BaseAdapter.ViewHolder<Keyword> {
        private TextView keyword;

        public ViewHolder(View itemView, Context context) {
            super(itemView, context);
            keyword = itemView.findViewById(R.id.tv_keyword);
        }

        @Override
        protected void setData(Keyword keyword, int position) {
            this.keyword.setText(keyword.getKeyword());
            this.keyword.setBackgroundColor(context.getResources().getColor(keyword.getColor()));
        }
    }
}
