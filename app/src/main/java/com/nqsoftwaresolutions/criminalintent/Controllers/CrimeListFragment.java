package com.nqsoftwaresolutions.criminalintent.Controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nqsoftwaresolutions.criminalintent.DataModels.Crime;
import com.nqsoftwaresolutions.criminalintent.DataModels.CrimeLab;
import com.nqsoftwaresolutions.criminalintent.R;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeListRv;
    private CrimeAdapter mCrimeAdapter;

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
        updateUI();
        return view;
    }

    /**Todo update UI of RecyclerView
     * what we are doing:
     *      Creating object of crime lab
     *      creating list crimes & getting data for list from crimelab
     *      creating an adapter for recycler view with crime list
     *      setting up adapter on recycler view
     */
    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimeList = crimeLab.getCrimeList();
        mCrimeAdapter = new CrimeAdapter(crimeList);
        mCrimeListRv.setAdapter(mCrimeAdapter);
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

    /**Todo ViewHolder
     * what we are doing:
     *      we are creating constructor of ViewHolder:
     *      arguments:
     *          items row for every record
     *          parent, by which we are attaching those view items
     *          attaching the item views with parent or not
     */
    private class CrimeHolder extends RecyclerView.ViewHolder {
        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.crime_list_item_row, parent, false));
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimeList;

        public CrimeAdapter(List<Crime> crimes){
            mCrimeList = crimes;
        }

        /**Todo onCreateViewHolder
         * @param parent layout
         * @param viewType views of view holder
         * @return ViewHolder to RecyclerView
         *      This methods will called when RecyclerView Need a new ViewHolder to show
         *      This methods will return a ViewHolder to RecyclerView
         *      We need a LayoutInflater for ViewHolder so we get that.
         *      we return ViewHolder
         */
        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {

        }

        /**Todo getItemCount
         * @return number of list items
         *      This methods will get item in list & generate views for those items.
         */
        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }
    }
}
