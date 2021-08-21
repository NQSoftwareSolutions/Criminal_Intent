package com.nqsoftwaresolutions.criminalintent;

import android.content.Context;

public class CrimeLab {
    /**
     * Static object of CrimeLab
     * s prefix representing that CrimeLab object is static variable
     */
    private static CrimeLab sCrimeLab;

    /**Todo Private Constructor for singleton class
     * @param context of class or instance
     */
    private CrimeLab(Context context) {
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
}
