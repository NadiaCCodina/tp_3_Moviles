package com.nadia.tp3_nadia.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadia.tp3_nadia.R;
import com.nadia.tp3_nadia.modelo.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {
    private List<Producto> listaProductos;
    private Context context;
    private LayoutInflater inflater;

    public ProductoAdapter(List<Producto> listaProductos, Context context, LayoutInflater inflater) {
        this.listaProductos = listaProductos;
        this.context = context;
        this.inflater = inflater;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolderProducto(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.tvCodigo.setText("Codigo: " + producto.getCodigo());
        holder.tvDescripcion.setText("Descripcion: " + producto.getDescripcion());
        holder.tvPrecio.setText("Precio: " + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder{
        TextView tvCodigo, tvDescripcion, tvPrecio;


        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            tvCodigo= itemView.requireViewById(R.id.tvCodigo);
            tvDescripcion = itemView.requireViewById(R.id.tvDescripcion);
            tvPrecio = itemView.requireViewById(R.id.tvPrecio);
        }
    }
}


