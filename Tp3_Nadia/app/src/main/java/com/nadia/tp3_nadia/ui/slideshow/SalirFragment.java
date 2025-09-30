package com.nadia.tp3_nadia.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nadia.tp3_nadia.R;
import com.nadia.tp3_nadia.databinding.FragmentSalirBinding;


public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_salir, container, false);

        new AlertDialog.Builder(requireContext())
                .setTitle("Salir de la aplicación")
                .setMessage("¿Está seguro que desea salir?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    requireActivity().finishAffinity();
                    System.exit(0);
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {

                    requireActivity()
                            .getSupportFragmentManager()
                            .popBackStack();
                })
                .setCancelable(false)
                .show();

        return root;
    }
}
