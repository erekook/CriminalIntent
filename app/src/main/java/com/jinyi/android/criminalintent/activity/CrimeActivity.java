package com.jinyi.android.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.jinyi.android.criminalintent.fragment.CrimeFragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

        return new CrimeFragment().newInstance(crimeId);
    }
}
