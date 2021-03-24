package modelo;

/**
 *
 * @author Miquéias
 */
public class Produto {

//    private int Emp_codigo;
//    private int GrupoEst_Codigo;
//    private int ProdEst_Codigo;
//    private int Status_Codigo;
//    private int ProdEst_Descricao;
//    private int prodEstAplicacao;
//    private int ProdEst_Unidademedida;
//    private int ProdEst_EstoqueMaximo;
//    private int ProdEst_EstoqueMinimo;
//    private int GrupoContas_Codigo;
//    private int ProdEst_CodigoFabricacao;
//    private int ProdEst_EstoqueAtual;
//    private int ProdEst_CompraMinima;
//    private int ProdEst_Imagem;
//    private int ProdEst_UltimoPreco;
//    private int ProdEst_TipoDespesa;
//    private int ProdEst_PlanoCompras;
//    private int ProdEst_TipoProduto;
//    private int ProdEst_Especie;
//    private int ProdEst_EmpresaProduto;
//    private int ProdEst_Estocar;
    private int empCodigo;
    private int grupoEstCodigo;
    private String prodEstCodigoFabricacao;
    private String prodEstCodigo;
    private String prodEstDescricao;
    private String prodEstUnidadeMedida;
    private String prodEstAplicacao;

    public int getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(int empCodigo) {
        this.empCodigo = empCodigo;
    }

    public int getGrupoEstCodigo() {
        return grupoEstCodigo;
    }

    public void setGrupoEstCodigo(int grupoEstCodigo) {
        this.grupoEstCodigo = grupoEstCodigo;
    }

    public String getProdEstCodigoFabricacao() {
        return prodEstCodigoFabricacao;
    }

    public void setProdEstCodigoFabricacao(String prodEstCodigoFabricacao) {
        this.prodEstCodigoFabricacao = prodEstCodigoFabricacao;
    }

    public String getProdEstCodigo() {
        return prodEstCodigo;
    }

    public int getProdCodigoAsInt() {
        return Integer.parseInt(prodEstCodigo);
    }

    public void setProdEstCodigo(String prodEstCodigo) {
        this.prodEstCodigo = prodEstCodigo;
    }

    public String getProdEstDescricao() {
        return prodEstDescricao;
    }

    public void setProdEstDescricao(String prodEstDescricao) {
        this.prodEstDescricao = prodEstDescricao;
    }

    public String getProdEstUnidadeMedida() {
        return prodEstUnidadeMedida;
    }

    public void setProdEstUnidadeMedida(String prodEstUnidadeMedida) {
        this.prodEstUnidadeMedida = prodEstUnidadeMedida;
    }

    public String getProdEstAplicacao() {
        return prodEstAplicacao;
    }

    public void setProdEstAplicacao(String prodEstAplicacao) {
        this.prodEstAplicacao = prodEstAplicacao;
    }
    
    @Override
    public String toString() {
        return prodEstDescricao;
    }

}
