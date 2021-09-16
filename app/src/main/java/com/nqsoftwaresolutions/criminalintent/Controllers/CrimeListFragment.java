package com.nqsoftwaresolutions.criminalintent.Controllers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nqsoftwaresolutions.criminalintent.DataModels.Crime;
import com.nqsoftwaresolutions.criminalintent.DataModels.CrimeLab;
import com.nqsoftwaresolutions.criminalintent.R;

import java.util.List;
import java.util.zip.Inflater;

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
        View mView = inflater.inflate(R.layout.fragment_crime_list,container,false);
        setupRecyclerView(mView);
        updateUI();
        return mView;
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
        mCrimeAdapter = new CrimeAdapter(getContext() ,crimeList);
        mCrimeListRv.setAdapter(mCrimeAdapter);
        mCrimeListRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /**Todo setup the recycler view
     * @param view of fragment
     *             find RecyclerView
     *             Create & set linearLayoutManager
     */
    private void setupRecyclerView(View view) {
        mCrimeListRv = view.findViewById(R.id.id_rv_crime_list);
        mCrimeListRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeHolder>{
        private List<Crime> mCrimeList;
        private LayoutInflater mInflater;

        public CrimeAdapter(Context context, List<Crime> crimes){
            mCrimeList = crimes;
            mInflater = LayoutInflater.from(context);
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
            View itemView = mInflater
                    .inflate(R.layout.crime_list_item_row, parent, false);
            return new CrimeHolder(itemView, new CrimeAdapter(getContext(), mCrimeList));
        }

        /**Todo onBindViewHolder
         * @param holder ViewHolder of Recycler View
         * @param position on which we have attach data on widget
         *                 create a Crime class instance &
         *                 get data from list on specified position.
         */
        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimeList.get(position);
            String crimeTitle = crime.getTitle();
            String crimeDate = crime.getDate().toString();
            holder.mTitleTv.setText(crimeTitle);
            holder.mDateTv.setText(crimeDate);
        }

        /**Todo getItemCount
         * @return number of list items
         *      This methods will get item in list & generate views for those items.
         */
        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }

        /**Todo ViewHolder
         * what we are doing:
         *      we are creating constructor of ViewHolder:
         *      arguments:
         *          items row for every record
         *          parent, by which we are attaching those view items
         *          attaching the item views with parent or not
         *      we are getting view which we have to put in Recycler view & update those
         */
        private class CrimeHolder extends RecyclerView.ViewHolder {
            private TextView mTitleTv, mDateTv;
            private CrimeAdapter mAdapter;

            public CrimeHolder(@NonNull View itemView, CrimeAdapter adapter) {
                super(itemView);
                mTitleTv = itemView.findViewById(R.id.id_tv_crime_title);
                mDateTv = itemView.findViewById(R.id.id_tv_crime_date);
                this.mAdapter = adapter;
            }
        }
    }
}
