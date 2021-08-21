package com.nqsoftwaresolutions.criminalintent.Controllers;

import androidx.fragment.app.Fragment;

import com.nqsoftwaresolutions.criminalintent.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
