package br.dev.kgb.mobile.estoquemp.ui.produto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.dev.kgb.mobile.estoquemp.R;


public class CadProdutoFragment extends Fragment {

    private View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_produto, container, false);
        return this.view;rm
    }
}