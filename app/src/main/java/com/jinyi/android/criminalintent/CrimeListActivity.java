package com.jinyi.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by long on 2017/12/8.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
