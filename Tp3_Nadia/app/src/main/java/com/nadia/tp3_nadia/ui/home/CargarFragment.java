package com.nadia.tp3_nadia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nadia.tp3_nadia.databinding.FragmentCargarBinding;


public class CargarFragment extends Fragment {
    private CargarViewModel vm;

    private FragmentCargarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm  = new ViewModelProvider(this).get(CargarViewModel.class);

        vm.getmMensaje().observe(getViewLifecycleOwner(), mensaje -> {
            Toast.makeText(getContext(), mensaje, Toast.LENGTH_LONG).show();

        });
            vm.getlimpiarDatos().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    binding.etCodigo.setText("");
                    binding.etDescripcion.setText("");
                    binding.etPrecio.setText("");
                }
            });


        binding.btCargar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
                String codigo = binding.etCodigo.getText().toString();
                String descripcion= binding.etDescripcion.getText().toString();
                String precio = binding.etPrecio.getText().toString();
                vm.guardarProducto(codigo, descripcion, precio);


     }
 });

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}