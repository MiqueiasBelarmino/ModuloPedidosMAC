package modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Miquéias
 */
public class Pedido {

    private int pedidoVendaCodigo;
    private Date pedidoVendaData;
    private String pedidoVendaFormaPagamento;
    private String pedidoVendaNumeroNota;
    private Date pedidoVendaVencimento;
    private String pedidoVendaObservacao;
    private int EmpCodigo;
    //private int pessoaCodigoCliente;
    private Cliente cliente;
    private int pessoaFJCodigoCliente;
    private int pessoaCodigoFunc;
    private int PFisicaCodigoFunc;
    private BigDecimal pedidoVendaTotalProdutos;
    private BigDecimal pedidoVendaAcrescimo;
    private BigDecimal pedidoVendaDesconto;
    private BigDecimal pedidoVendaTotalPedido;
    private String pedidoVendaComprador;
    private int pedidoVendaUsuarioRegistro;

    public int getPedidoVendaCodigo() {
        return pedidoVendaCodigo;
    }

    public void setPedidoVendaCodigo(int pedidoVendaCodigo) {
        this.pedidoVendaCodigo = pedidoVendaCodigo;
    }

    public Date getPedidoVendaData() {
        return pedidoVendaData;
    }

    public void setPedidoVendaData(Date pedidoVendaData) {
        this.pedidoVendaData = pedidoVendaData;
    }

    public String getPedidoVendaFormaPagamento() {
        return pedidoVendaFormaPagamento;
    }

    public void setPedidoVendaFormaPagamento(String pedidoVendaFormaPagamento) {
        this.pedidoVendaFormaPagamento = pedidoVendaFormaPagamento;
    }

    public String getPedidoVendaNumeroNota() {
        return pedidoVendaNumeroNota;
    }

    public void setPedidoVendaNumeroNota(String pedidoVendaNumeroNota) {
        this.pedidoVendaNumeroNota = pedidoVendaNumeroNota;
    }

    public Date getPedidoVendaVencimento() {
        return pedidoVendaVencimento;
    }

    public void setPedidoVendaVencimento(Date pedidoVendaVencimento) {
        this.pedidoVendaVencimento = pedidoVendaVencimento;
    }

    public String getPedidoVendaObservacao() {
        return pedidoVendaObservacao;
    }

    public void setPedidoVendaObservacao(String pedidoVendaObservacao) {
        this.pedidoVendaObservacao = pedidoVendaObservacao;
    }

    public int getEmpCodigo() {
        return EmpCodigo;
    }

    public void setEmpCodigo(int EmpCodigo) {
        this.EmpCodigo = EmpCodigo;
    }

//    public int getPessoaCodigoCliente() {
//        return pessoaCodigoCliente;
//    }
//
//    public void setPessoaCodigoCliente(int pessoaCodigoCliente) {
//        this.pessoaCodigoCliente = pessoaCodigoCliente;
//    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public int getPessoaFJCodigoCliente() {
        return pessoaFJCodigoCliente;
    }

    public void setPessoaFJCodigoCliente(int pessoaFJCodigoCliente) {
        this.pessoaFJCodigoCliente = pessoaFJCodigoCliente;
    }

    public int getPessoaCodigoFunc() {
        return pessoaCodigoFunc;
    }

    public void setPessoaCodigoFunc(int pessoaCodigoFunc) {
        this.pessoaCodigoFunc = pessoaCodigoFunc;
    }

    public int getPFisicaCodigoFunc() {
        return PFisicaCodigoFunc;
    }

    public void setPFisicaCodigoFunc(int PFisicaCodigoFunc) {
        this.PFisicaCodigoFunc = PFisicaCodigoFunc;
    }

    public BigDecimal getPedidoVendaTotalProdutos() {
        return pedidoVendaTotalProdutos;
    }

    public void setPedidoVendaTotalProdutos(BigDecimal pedidoVendaTotalProdutos) {
        this.pedidoVendaTotalProdutos = pedidoVendaTotalProdutos;
    }

    public BigDecimal getPedidoVendaAcrescimo() {
        return pedidoVendaAcrescimo;
    }

    public void setPedidoVendaAcrescimo(BigDecimal pedidoVendaAcrescimo) {
        this.pedidoVendaAcrescimo = pedidoVendaAcrescimo;
    }

    public BigDecimal getPedidoVendaDesconto() {
        return pedidoVendaDesconto;
    }

    public void setPedidoVendaDesconto(BigDecimal pedidoVendaDesconto) {
        this.pedidoVendaDesconto = pedidoVendaDesconto;
    }

    public BigDecimal getPedidoVendaTotalPedido() {
        return pedidoVendaTotalPedido;
    }

    public void setPedidoVendaTotalPedido(BigDecimal pedidoVendaTotalPedido) {
        this.pedidoVendaTotalPedido = pedidoVendaTotalPedido;
    }

    public String getPedidoVendaComprador() {
        return pedidoVendaComprador;
    }

    public void setPedidoVendaComprador(String pedidoVendaComprador) {
        this.pedidoVendaComprador = pedidoVendaComprador;
    }

    public int getPedidoVendaUsuarioRegistro() {
        return pedidoVendaUsuarioRegistro;
    }

    public void setPedidoVendaUsuarioRegistro(int pedidoVendaUsuarioRegistro) {
        this.pedidoVendaUsuarioRegistro = pedidoVendaUsuarioRegistro;
    }
    
    
    
}
