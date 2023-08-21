package br.dev.kgb.mobile.estoquemp.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Produto {

    //Atributos

    private int id;
    private int categoriaProduto;
    private String nomeProduto;
    private String codigoProduto;
    private int estoqueProduto;



    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Produto (JSONObject jp) {
        try {
            Integer numero = (int) jp.get("id");
            this.setId(numero);
            this.setNomeProduto((String) jp.get("nomeProduto"));
            numero = (int) jp.get("categoriaProduto");
            this.setCategoriaProduto(numero);
            this.setCodigoProduto((String) jp.get("codigoProduto"));
            numero = (int) jp.get("estoqueProduto");
            this.setEstoqueProduto(numero);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Produto () {
        this.setId(0);
        this.setNomeProduto("");
        this.setCategoriaProduto(0);
        this.setCodigoProduto("");
        this.setEstoqueProduto(0);

    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("nomeProduto", this.nomeProduto);
            json.put("categoriaProduto", this.categoriaProduto);
            json.put("codigoProduto", this.codigoProduto);
            json.put("codigoProduto", this.codigoProduto);
            json.put("estoqueProduto", this.estoqueProduto);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    //Metodos
    public int getId(){return this.id; }
    public int getCategoriaProduto(){
        return this.categoriaProduto;
    }
    public String getNomeproduto(){ return  this.nomeProduto;}
    public String getCodigoProduto(){return this.codigoProduto;}
    public int getEstoqueProduto(){ return this.estoqueProduto; }

    public void setId(int id){ this.id = id;}
    public void setCategoriaProduto(int catePro){
        if (catePro >= 1 && catePro <=11){
            this.categoriaProduto = catePro;
        }else
            this.categoriaProduto = 0;
    }

    public void setNomeProduto(String np){
        if (np.length() < 1){
            this.nomeProduto = "A definir";
        }else {
            this.nomeProduto = np;
        }
    }
    public void setCodigoProduto(String cp) {
        if (cp.length() < 13) {
            this.codigoProduto = "Incorreto";
        } else {
            this.codigoProduto = cp;
        }
    }

    public void setEstoqueProduto(int ee){
        this.estoqueProduto = ee;
    }

}
