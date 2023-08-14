package br.dev.kgb.mobile.estoquemp.model;

public class Produto {
    //Atributos
    private int categoriaProduto;
    private String nomeProduto;
    private String codigoProduto;
    private int estoqueProduto;


    void setCategoriaProduto(int catePro){
        if (catePro >= 1 && catePro <=4){
            this.categoriaProduto = catePro;
        }else
            this.categoriaProduto = 0;
    }

    int getCategoriaProduto(){
        return this.categoriaProduto;
    }

    void setNomeProduto(String np){
        if (np.length() < 1){
            this.nomeProduto = "A definir";
        }else {
            this.nomeProduto = np;
        }
    }
}
