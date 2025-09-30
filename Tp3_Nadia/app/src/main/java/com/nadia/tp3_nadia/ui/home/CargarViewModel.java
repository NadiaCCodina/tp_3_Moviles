package com.nadia.tp3_nadia.ui.home;

import static com.nadia.tp3_nadia.MainActivity.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nadia.tp3_nadia.modelo.Producto;

public class CargarViewModel extends ViewModel {

    private MutableLiveData<String> mMensaje;

    public CargarViewModel() {

    }

    public LiveData<String> getmMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();

        }
        return mMensaje;

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

    }
}


