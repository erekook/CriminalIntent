package com.jinyi.android.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.jinyi.android.criminalintent.fragment.CrimeRecyclerListFragment;

/**
 * Created by long on 2017/12/12.
 */

public class CrimeRecyclerListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeRecyclerListFragment();
    }

}
