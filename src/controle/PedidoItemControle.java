package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.PedidoItem;
import util.Conexao;

/**
 *
 * @author Miquéias
 */
public class PedidoItemControle extends ControleGenerico {

    /**
     * <p>
     * Esse método define um comando SQL para salvar um PedidoItem na base de
     * dados</p>
     *
     * @param pedidoItem objeto a ser configurado no comando SQL
     */
    public void save(PedidoItem pedidoItem) {
        String sql = "INSERT INTO PedidoVendaXProdutos"
                + "(PedVendasProd_Valor, "
                + "PedVendasProd_Qtde, "
                + "PedVendasProd_Total, "
                + "PedVendasProd_IPI, "
                + "PedidoVenda_Codigo, "
                + "Emp_Codigo, "
                + "GrupoEst_Codigo, "
                + "ProdEst_Codigo) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        save(sql, pedidoItem.getPedVendasProdValor(),
                pedidoItem.getPedVendasProdQtde(),
                pedidoItem.getPedVendasProdTotal(),
                pedidoItem.getPedVendasProdIPI(),
                pedidoItem.getPedidoVendaCodigo(),
                pedidoItem.getEmpCodigo(),
                pedidoItem.getGrupoCodigo(),
                pedidoItem.getProduto().getProdEstCodigo());
    }

    /**
     * <p>
     * Esse método define um comando SQL para atualizar um PedidoItem na base de
     * dados</p>
     *
     * @param pedidoItem objeto a ser configurado no comando SQL
     */
    public void update(PedidoItem pedidoItem) {
        String sql = "UPDATE PedidoVendaXProdutos SET "
                + "PedVendasProd_Valor = ?, "
                + "PedVendasProd_Qtde = ?, "
                + "PedVendasProd_Total = ?, "
                + "PedVendasProd_IPI = ?, "
                + "Emp_Codigo = ?, "
                + "GrupoEst_Codigo = ? where PedidoVenda_Codigo = ? and ProdEst_Codigo = ? ";
        update(sql, pedidoItem.getPedVendasProdValor(),
                pedidoItem.getPedVendasProdQtde(),
                pedidoItem.getPedVendasProdTotal(),
                pedidoItem.getPedVendasProdIPI(),
                pedidoItem.getEmpCodigo(),
                pedidoItem.getGrupoCodigo(),
                pedidoItem.getPedidoVendaCodigo(),
                pedidoItem.getProduto().getProdEstCodigo());
    }

    /**
     * <p>
     * Esse método define um comando SQL para remover um PedidoItem na base de
     * dados</p>
     *
     * @param pedidoItem objeto a ser configurado no comando SQL
     */
    public void delete(PedidoItem pedidoItem) {
        String sql = "DELETE FROM PedidoVendaXProdutos WHERE PedidoVenda_Codigo = ? and ProdEst_Codigo = ? and Emp_Codigo = ?";
        delete(sql, pedidoItem.getPedidoVendaCodigo(), pedidoItem.getProduto().getProdEstCodigo(), pedidoItem.getEmpCodigo());
    }

    /**
     * <p>
     * Esse método busca todos os itens de pedido na base de dados</p>
     *
     * @param codigoVenda codigo da venda para filtrar os itens
     * @return lista de itens de venda se houver correspondência
     */
    public static List<PedidoItem> buscaTodos(int codigoVenda) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from PedidoVendaXProdutos where PedidoVenda_Codigo = " + codigoVenda;
        PreparedStatement pstm = null;
        List<PedidoItem> itens = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                PedidoItem pedidoItem = new PedidoItem();
                pedidoItem.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedidoItem.setGrupoCodigo(rset.getInt("GrupoEst_Codigo"));
                pedidoItem.setPedVendasProdIPI(rset.getBigDecimal("PedVendasProd_IPI"));
                pedidoItem.setPedVendasProdQtde(rset.getInt("PedVendasProd_Qtde"));
                pedidoItem.setPedVendasProdTotal(rset.getBigDecimal("PedVendasProd_Total"));
                pedidoItem.setPedVendasProdValor(rset.getBigDecimal("PedVendasProd_Valor"));
                pedidoItem.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedidoItem.setProduto(ProdutoControle.buscaPorCodigo(rset.getInt("ProdEst_Codigo")));
                itens.add(pedidoItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                    Conexao.closeConnection();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itens;
    }
    
    public static List<PedidoItem> buscaPorProduto(int codigoProduto) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from PedidoVendaXProdutos where ProdEst_Codigo = " + codigoProduto;
        PreparedStatement pstm = null;
        List<PedidoItem> itens = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                PedidoItem pedidoItem = new PedidoItem();
                pedidoItem.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedidoItem.setGrupoCodigo(rset.getInt("GrupoEst_Codigo"));
                pedidoItem.setPedVendasProdIPI(rset.getBigDecimal("PedVendasProd_IPI"));
                pedidoItem.setPedVendasProdQtde(rset.getInt("PedVendasProd_Qtde"));
                pedidoItem.setPedVendasProdTotal(rset.getBigDecimal("PedVendasProd_Total"));
                pedidoItem.setPedVendasProdValor(rset.getBigDecimal("PedVendasProd_Valor"));
                pedidoItem.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedidoItem.setProduto(ProdutoControle.buscaPorCodigo(rset.getInt("ProdEst_Codigo")));
                itens.add(pedidoItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                    Conexao.closeConnection();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itens;
    }
}
