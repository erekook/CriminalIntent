package com.jinyi.android.criminalintent.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jinyi.android.criminalintent.entity.Crime;
import com.jinyi.android.criminalintent.R;
import com.jinyi.android.criminalintent.entity.CrimeLab;
import com.jinyi.android.criminalintent.myinterface.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
/**
 * Created by long on 2017/12/12.
 */

public class CrimeRecyclerAdapter extends RecyclerView.Adapter<CrimeRecyclerAdapter.MyViewHolder> implements View.OnClickListener{
    private ArrayList<Crime> mCrimes;
    private OnRecyclerViewItemClickListener<Crime> mOnItemClickListener = null;

    public CrimeRecyclerAdapter(ArrayList<Crime> mCrimes){
        this.mCrimes = mCrimes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_crime,parent,false);
        MyViewHolder vh = new MyViewHolder(view);
        // 将创建的View注册点击事件
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTitleTextView.setText(mCrimes.get(position).getmTitle());
        holder.mDateTextView.setText(Crime.formatDate(mCrimes.get(position).getmDate()));
        holder.mCheckBox.setChecked(mCrimes.get(position).ismSolved());
        // 将数据保存在itemview的Tag中，以便点击时进行获取
        holder.itemView.setTag(mCrimes.get(position));
    }


    @Override
    public int getItemCount() {
        return mCrimes.size();
    }

    @Override
    public void onClick(View v) {
        if(mOnItemClickListener != null){
            // 这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(Crime)v.getTag());
        }
    }


    public void setOnItemClickListener(OnRecyclerViewItemClickListener<Crime> listener){
        this.mOnItemClickListener = listener;
    }

    //自定义的ViewHolder，持有每个item的所有界面元素
    class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox mCheckBox;
        TextView mTitleTextView;
        TextView mDateTextView;

        public MyViewHolder(View view){
            super(view);
            mTitleTextView = (TextView)view.findViewById(R.id.crime_list_item_titleTextView);
            mDateTextView = (TextView)view.findViewById(R.id.crime_list_item_dateTextView);
            mCheckBox = (CheckBox)view.findViewById(R.id.crime_list_item_solvedCheckBox);
        }
    }
}
