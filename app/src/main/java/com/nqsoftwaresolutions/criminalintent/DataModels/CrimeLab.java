package com.nqsoftwaresolutions.criminalintent.DataModels;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    /**
     * Static object of CrimeLab
     * s prefix representing that CrimeLab object is static variable
     */
    private static CrimeLab sCrimeLab;
    /**
     * Empty list for crime objects.
     */
    private List<Crime> mCrimeList;

    /**Todo Private Constructor for singleton class
     * @param context of class or instance
     *                implement list with array list
     *                load array list with 100 crimes (Title & solved or not)
     *                every 3rd crime is solved
     *                add crime in array list
     */
    private CrimeLab(Context context) {
        mCrimeList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime # "+ i);
            crime.setSolved(i % 3 == 0);
            mCrimeList.add(crime);
        }
    }

    /**Todo get method for singleton class CrimeLab
     * @param context of class or instance
     * @return CrimeLab
     */
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    /**
     * @return crime list
     */
    public List<Crime> getCrimeList(){
        return mCrimeList;
    }

    /**Todo get crime object
     * @param id of crime
     * @return crime object
     */
    public Crime getCrime(UUID id){
        for (Crime crime : mCrimeList){
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
