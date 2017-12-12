package com.jinyi.android.criminalintent.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jinyi.android.criminalintent.activity.CrimeActivity;
import com.jinyi.android.criminalintent.activity.CrimeRecyclerListActivity;
import com.jinyi.android.criminalintent.entity.Crime;
import com.jinyi.android.criminalintent.entity.CrimeLab;
import com.jinyi.android.criminalintent.adapter.CrimeRecyclerAdapter;
import com.jinyi.android.criminalintent.R;
import com.jinyi.android.criminalintent.myinterface.OnRecyclerViewItemClickListener;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * Created by long on 2017/12/12.
 */

public class CrimeRecyclerListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<Crime> mCrimes;
    private CrimeRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button mAddButton;
    private Button mDeleteButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),VERTICAL));
        mAdapter = new CrimeRecyclerAdapter(mCrimes);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<Crime>(){

            @Override
            public void onItemClick(View view, Crime item) {
                // Start CrimeActivity
                Intent i = new Intent(getActivity(),CrimeActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID,item.getmId());
                startActivity(i);
            }
        });
        mAddButton = (Button)v.findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crime c = new Crime();
                c.setmTitle("Crime #");
                CrimeLab.get(getActivity()).addCrime(c);
                mAdapter.notifyItemInserted(mCrimes.indexOf(c));
            }
        });
        mDeleteButton = (Button)v.findViewById(R.id.delete_button);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrimeLab.get(getActivity()).deleteCrime(mCrimes.get(mCrimes.size()-1));
                mAdapter.notifyItemRemoved(mCrimes.size());
            }
        });

        return v;
    }


}
