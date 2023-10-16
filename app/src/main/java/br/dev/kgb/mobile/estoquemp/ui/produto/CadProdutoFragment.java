package br.dev.kgb.mobile.estoquemp.ui.produto;

import android.content.Context;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import br.dev.kgb.mobile.estoquemp.R;
import br.dev.kgb.mobile.estoquemp.model.Produto;

public class CadProdutoFragment extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener{

    private View view = null;
    private EditText etNomeDoProduto;
    private EditText etCodigoDoProduto;
    private EditText etEstoqueDoProduto;
    private Spinner spCategoriaDoProduto;
    private Spinner spUnidadeMedida;
    private Button btSalvar;//volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;


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
        this.spUnidadeMedida = (Spinner) view.findViewById(R.id.spUnidadeMedida);
        this.btSalvar = (Button) view.findViewById(R.id.btSalvarTela);
        this.btSalvar.setOnClickListener(this);//definindo o listener do botão

        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
        //inicializando a fila de requests do SO18
        this.requestQueue.start();

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
              produto.setUnidadeMedida(this.spUnidadeMedida.getSelectedItemPosition());

              //chamar o web server
              jsonObjectReq = new JsonObjectRequest(
                      Request.Method.POST,
                      "http://10.0.2.2/cadproduto.php",
                      produto.toJsonObject(), this, this);
              requestQueue.add(jsonObjectReq);


          }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,"Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();
    }

    @Override
    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o jason que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e texto são para a mensagem na tela o toast
            Context context = view.getContext();
            //pegando mensagem que veio do json
            CharSequence text = jason.getString("message");
            //duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificar se deu certo e limpado os campos
            if (jason.getBoolean("success"));{
                //mensagem de sucesso

                this.etNomeDoProduto.setText("");
                this.etCodigoDoProduto.setText("");
                this.etEstoqueDoProduto.setText("");
                this.spCategoriaDoProduto.setSelection(0);
                this.spUnidadeMedida.setSelection(0);

            }
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }



    }
}