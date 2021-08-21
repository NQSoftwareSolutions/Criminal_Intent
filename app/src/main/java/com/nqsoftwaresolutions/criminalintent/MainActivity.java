package com.nqsoftwaresolutions.criminalintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configFragmentManager();
    }

    /**Todo Config Fragments
     * Get Fragment Manager
     * get fragment from fragment manager with id provided in parent activity layout
     * check if fragment is null then create one & add
     * fragment will not null when Activity is recreated
     *      b/c of rotation of any other configuration change.
     */
    private void configFragmentManager() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.id_fl_crimeFragment);
        addFragment(fm,fragment);
    }

    /**Todo Add a fragment
     * @param fm fragment manager
     * @param fragment fragment available in fragment manager
     */
    private void addFragment(FragmentManager fm, Fragment fragment) {
        if (fragment == null){
            fragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.id_fl_crimeFragment, fragment).commit();
        }
    }
}
