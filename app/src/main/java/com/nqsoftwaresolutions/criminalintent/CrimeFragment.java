package com.nqsoftwaresolutions.criminalintent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nqsoftwaresolutions.criminalintent.DataModels.Crime;

public class CrimeFragment extends Fragment {
    private Crime mCrime;

    /**
     * @param savedInstanceState state of fragment
     *                           called when fragment will be created
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    /**
     * @param inflater Inflater by which we inflate our fragment on Activity
     * @param container Container where our fragment will be
     * @param savedInstanceState state of fragment
     * @return view of fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime,container,false);
        wireWidgets(view);
        return view;
    }

    private void wireWidgets(View view) {
        Button mCrimeDateBtn = view.findViewById(R.id.id_btn_crimeDate);
        EditText crimeTitleEt = view.findViewById(R.id.id_et_crimeTitle);
        CheckBox isCrimeSolvedCb = view.findViewById(R.id.id_cb_crimeSolved);

        crimeTitleEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCrimeDateBtn.setText(mCrime.getDate().toString());
        mCrimeDateBtn.setEnabled(false);

        isCrimeSolvedCb.setOnCheckedChangeListener((buttonView, isChecked) -> mCrime.setSolved(isChecked));
    }
}
