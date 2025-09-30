package com.nadia.tp3_nadia.ui.gallery;

import static com.nadia.tp3_nadia.MainActivity.productos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nadia.tp3_nadia.databinding.ActivityMainBinding;
import com.nadia.tp3_nadia.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel vm;
    private ProductoAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ListarViewModel.class);

        binding = FragmentListarBinding.inflate(inflater, container, false);
        //ProductoAdapter adapter = new ProductoAdapter(productos, getContext(), getLayoutInflater());
        //GridLayoutManager glm = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        //binding.rvLista.setLayoutManager(glm);
        //binding.rvLista.setAdapter(adapter);

        adapter = new ProductoAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        GridLayoutManager glm = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.rvLista.setLayoutManager(glm);
        binding.rvLista.setAdapter(adapter);
        vm.getLista().observe(getViewLifecycleOwner(), productos -> {
            adapter.setListaProductos(productos);
        });
        vm.cargarLista();
        return binding.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}