package com.nadia.tp3_nadia.ui.slideshow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

    public SalirViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<String> getmText() {

        if (mText == null) {
            mText = new MutableLiveData<>();

        }
        return mText;

    }

    public LiveData<String> getText() {
        return mText;
    }
}