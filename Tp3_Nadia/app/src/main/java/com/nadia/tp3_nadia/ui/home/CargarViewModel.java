package com.nadia.tp3_nadia.ui.home;

import static com.nadia.tp3_nadia.MainActivity.productos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nadia.tp3_nadia.modelo.Producto;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mMensaje;
    private MutableLiveData<Boolean> limpiarDatos;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getmMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();

        }
        return mMensaje;

    }
    public LiveData<Boolean> getlimpiarDatos() {

        if (limpiarDatos == null) {
            limpiarDatos = new MutableLiveData<>();

        }
        return limpiarDatos;

    }


    public void guardarProducto(String codigo, String descripcion, String precio) {
        if (codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
            mMensaje.setValue("Error al cargar el producto");

            return;
        }
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                mMensaje.setValue("Codigo repetido");

                return;
            }

        }
        try {
            Float.parseFloat(precio);

        } catch (NumberFormatException e) {
            mMensaje.setValue("El precio no es correcto");

            return;
        }
        Producto producto = new Producto(codigo, descripcion, Float.parseFloat(precio));
        productos.add(producto);
        mMensaje.setValue("Dato cargado correctamente");
        limpiarDatos.setValue(true);

    }
}


