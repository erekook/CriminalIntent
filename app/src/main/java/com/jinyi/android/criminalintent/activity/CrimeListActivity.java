package com.jinyi.android.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.jinyi.android.criminalintent.fragment.CrimeListFragment;

/**
 * Created by long on 2017/12/8.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
