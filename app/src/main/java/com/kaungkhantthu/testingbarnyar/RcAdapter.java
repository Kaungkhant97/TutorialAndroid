package com.kaungkhantthu.testingbarnyar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 11/6/16.
 */

public class RcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final ArrayList<String> mlist;
    private String TAG = "RcAdapter";
    private final int ASANNTEXT = 1111;
    ;

    public RcAdapter(Context mcontext, ArrayList<String> arrayList) {
        this.mlist = arrayList;
        this.context = mcontext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == ASANNTEXT) {
            View nview = inflater.inflate(R.layout.nitem, parent, false);

            return new nViewHolder(nview);
        } else {
            View v = inflater.inflate(R.layout.mitem, parent, false);
            return new mViewHolder(v);

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String data = mlist.get(position);

        if (holder instanceof mViewHolder) {
            mViewHolder mViewHolder = (RcAdapter.mViewHolder) holder;
            mViewHolder.txt_title.setText(data);
        } else {


            nViewHolder nViewHolder = (RcAdapter.nViewHolder) holder;
            nViewHolder.ntxt_title.setText(data);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if ((position % 2) == 0) {
            return ASANNTEXT;
        } else {
            return super.getItemViewType(position);
        }

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_title;

        public mViewHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
        }
    }

    public class nViewHolder extends RecyclerView.ViewHolder {
        public TextView ntxt_title;

        public nViewHolder(View itemView) {
            super(itemView);
            ntxt_title = (TextView) itemView.findViewById(R.id.txt_ntitle);
        }
    }

}
