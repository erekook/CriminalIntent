package com.jinyi.android.criminalintent.myinterface;

import android.view.View;

/**
 * Created by long on 2017/12/12.
 */

public interface OnRecyclerViewItemClickListener<T> {
    void onItemClick(View view,T item);
}
