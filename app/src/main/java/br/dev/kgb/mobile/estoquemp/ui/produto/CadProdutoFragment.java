package br.dev.kgb.mobile.estoquemp.ui.produto;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import br.dev.kgb.mobile.estoquemp.R;
import br.dev.kgb.mobile.estoquemp.model.Produto;

public class CadProdutoFragment extends Fragment implements View.OnClickListener {

    private View view = null;

    private EditText etNomeDoProduto;
    private EditText etCodigoDoProduto;
    private EditText etEstoqueDoProduto;
    private Spinner spCategoriaDoProduto;

    private Button btSalvar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_produto, container, false);

        //LINK DADOS DA TELA COM ATRIBUSTO DO JAVA
        this.etNomeDoProduto = (EditText) view.findViewById(R.id.etNomeDoProduto);
        this.etCodigoDoProduto = (EditText) view.findViewById(R.id.etCodigoDoProduto);
        this.etEstoqueDoProduto = (EditText) view.findViewById(R.id.etEstoque);
        this.spCategoriaDoProduto = (Spinner) view.findViewById(R.id.spCategoria);
        this.btSalvar = (Button) view.findViewById(R.id.btSalvarTela);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        //verificando se é o botão salvar
          if (view.getId() == R.id.btSalvarTela) {
              //instanciando objeto de negócio
              Produto produto = new Produto();
              produto.setNomeProduto(this.etNomeDoProduto.getText().toString());
              produto.setCodigoProduto(this.etCodigoDoProduto.getText().toString());

              String qtd = this.etEstoqueDoProduto.getText().toString();  //aux conversão string para inteiro
              produto.setEstoqueProduto(Integer.valueOf(qtd));           //conversão string para inteiro

              produto.setCategoriaProduto(this.spCategoriaDoProduto.getSelectedItemPosition());
          }
    }
}