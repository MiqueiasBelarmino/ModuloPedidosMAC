package modelo;

import java.math.BigDecimal;

/**
 *
 * @author Miquéias
 */
public class PedidoItem {

    private BigDecimal PedVendasProdValor;
    private int PedVendasProdQtde;
    private BigDecimal PedVendasProdTotal;
    private BigDecimal PedVendasProdIPI;
    private int PedidoVendaCodigo;
    private int EmpCodigo;
    private int GrupoCodigo;
    //private int ProdCodigo;
    private Produto produto;

    public BigDecimal getPedVendasProdValor() {
        return PedVendasProdValor;
    }

    public void setPedVendasProdValor(BigDecimal PedVendasProdValor) {
        this.PedVendasProdValor = PedVendasProdValor;
    }

    public int getPedVendasProdQtde() {
        return PedVendasProdQtde;
    }

    public void setPedVendasProdQtde(int PedVendasProdQtde) {
        this.PedVendasProdQtde = PedVendasProdQtde;
    }

    public BigDecimal getPedVendasProdTotal() {
        return PedVendasProdTotal;
    }

    public void setPedVendasProdTotal(BigDecimal PedVendasProdTotal) {
        this.PedVendasProdTotal = PedVendasProdTotal;
    }

    public BigDecimal getPedVendasProdIPI() {
        return PedVendasProdIPI;
    }

    public void setPedVendasProdIPI(BigDecimal PedVendasProdIPI) {
        this.PedVendasProdIPI = PedVendasProdIPI;
    }

    public int getPedidoVendaCodigo() {
        return PedidoVendaCodigo;
    }

    public void setPedidoVendaCodigo(int PedidoVendaCodigo) {
        this.PedidoVendaCodigo = PedidoVendaCodigo;
    }

    public int getEmpCodigo() {
        return EmpCodigo;
    }

    public void setEmpCodigo(int EmpCodigo) {
        this.EmpCodigo = EmpCodigo;
    }

    public int getGrupoCodigo() {
        return GrupoCodigo;
    }

    public void setGrupoCodigo(int GrupoCodigo) {
        this.GrupoCodigo = GrupoCodigo;
    }

//    public int getProdCodigo() {
//        return ProdCodigo;
//    }
//
//    public void setProdCodigo(int ProdCodigo) {
//        this.ProdCodigo = ProdCodigo;
//    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
