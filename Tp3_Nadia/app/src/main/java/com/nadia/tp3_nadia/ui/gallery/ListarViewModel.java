package com.nadia.tp3_nadia.ui.gallery;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nadia.tp3_nadia.MainActivity;
import com.nadia.tp3_nadia.modelo.Producto;

import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends AndroidViewModel {

    private  MutableLiveData<String> mText;
    private  MutableLiveData<List<Producto>> mListaM;

    public ListarViewModel( Application application) {
        super(application);
    }


    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<List<Producto>> getLista() {
        if (mListaM == null) {
            mListaM = new MutableLiveData<>();
        }
        return mListaM;
    }
    public void cargarLista(){

        MainActivity.productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {

                return o1.getDescripcion().compareTo(o2.getDescripcion());}});
        mListaM.setValue( MainActivity.productos);
    }


}