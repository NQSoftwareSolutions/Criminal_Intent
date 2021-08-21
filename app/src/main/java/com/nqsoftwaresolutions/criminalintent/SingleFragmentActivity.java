package com.nqsoftwaresolutions.criminalintent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    /**Todo Abstract SingleFragmentActivity
     * @param savedInstanceState of activity
     *                           Set layout as main layout
     *                           get support fragment manager
     *                           find fragment inside fragment & create & add if not exist
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.id_fl_crimeFragment);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.id_fl_crimeFragment, fragment).commit();
        }
    }
}
