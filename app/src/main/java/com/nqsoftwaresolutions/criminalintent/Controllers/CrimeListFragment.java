package com.nqsoftwaresolutions.criminalintent.Controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nqsoftwaresolutions.criminalintent.R;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeListRv;

    /**
     * @param inflater for inflating the layout
     * @param container which will contain all view
     * @param savedInstanceState state of fragment
     * @return a view for fragment
     * Todo create view:
     * inflate the layout :
     *  1st arg id of layout
     *  2nd arg container
     *  3rd arg attach to root
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);
        setupRecyclerView(view);
        return view;
    }

    /**Todo setup the recycler view
     * @param view of fragment
     *             find RecyclerView
     *             Create & set linearLayoutManager
     */
    private void setupRecyclerView(View view) {
        mCrimeListRv = view.findViewById(R.id.id_rv_crime_list);
        mCrimeListRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
