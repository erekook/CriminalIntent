package com.jinyi.android.criminalintent.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by long on 2017/12/8.
 */

public class Crime {
    public static DateFormat df = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;


    public Crime(){
        //生成唯一标识符
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public static String formatDate(Date date){
        return df.format(date);
    }
}
