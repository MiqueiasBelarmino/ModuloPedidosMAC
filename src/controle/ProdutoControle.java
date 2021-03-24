/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;
import modelo.Produto;
import util.Tools;

/**
 *
 * @author Miquéias
 */
public class ProdutoControle {
    
    
    
    /**
     * <p>Esse método busca produto na base de dados pelo código passado por parâmetro</p>
     *
     * @param codigo parametro para localizar o produto
     * @return o objeto do Produto
     */
    public static Produto buscaPorCodigo(int codigo) {
        
        Connection connection = Conexao.getConnection();//cria uma conexão com o banco de dados
        String sql = "Select * from ProdutosEstoque where ProdEst_Codigo = " + codigo + " and Emp_Codigo = 2 and GrupoEst_Codigo = "+Tools.GRUPO_PRODUTO;
        PreparedStatement pstm = null;
        Produto produto = new Produto();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //se existir registro atribui em produto
            if (rset.next()) {
                produto.setEmpCodigo(rset.getInt("Emp_Codigo"));
                produto.setGrupoEstCodigo(rset.getInt("GrupoEst_Codigo"));
                produto.setProdEstCodigo(rset.getString("ProdESt_Codigo"));
                produto.setProdEstDescricao(rset.getString("ProdEst_Descricao"));
                produto.setProdEstUnidadeMedida(rset.getString("ProdEst_Unidademedida"));
                produto.setProdEstAplicacao(rset.getString("ProdEst_Aplicacao"));
                produto.setProdEstCodigoFabricacao(rset.getString("ProdEst_CodigoFabricacao"));
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
        return produto;
    }

    /**
     * <p>Esse método busca produtos na base de dados pelo nome passado por parâmetro</p>
     *
     * @param nome parametro para localizar os produtos
     * @return lista de produtos se houver correspondência 
     */
    public static List<Produto> buscaPorNome(String nome) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from ProdutosEstoque where ProdEst_Descricao like '%" + nome + "%' and Emp_Codigo = 2 and GrupoEst_Codigo = "+Tools.GRUPO_PRODUTO;
        PreparedStatement pstm = null;
        List<Produto> produtos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //enquanto existir registro atribui vai adicionando na lista "produtos"
            while (rset.next()) {
                Produto produto = new Produto();
                produto.setEmpCodigo(rset.getInt("Emp_Codigo"));
                produto.setGrupoEstCodigo(rset.getInt("GrupoEst_Codigo"));
                produto.setProdEstCodigo(rset.getString("ProdESt_Codigo"));
                produto.setProdEstDescricao(rset.getString("ProdEst_Descricao"));
                produto.setProdEstUnidadeMedida(rset.getString("ProdEst_Unidademedida"));
                produto.setProdEstAplicacao(rset.getString("ProdEst_Aplicacao"));
                produtos.add(produto);
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
        return produtos;
    }
    
    public static List<Produto> buscaDinamica(String valor) {
        Connection connection = Conexao.getConnection();
        String sql;
        if (Tools.isInt(valor)) {
            sql = "Select * from ProdutosEstoque where ProdEst_Codigo = " + valor + " and Emp_Codigo = 2 and GrupoEst_Codigo = "+Tools.GRUPO_PRODUTO;
        } else {
            sql = "Select * from ProdutosEstoque where ProdEst_Descricao like '%" + valor + "%' and Emp_Codigo = 2 and GrupoEst_Codigo = "+Tools.GRUPO_PRODUTO;
        }
        
        PreparedStatement pstm = null;
        List<Produto> produtos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //enquanto existir registro atribui vai adicionando na lista "produtos"
            while (rset.next()) {
                Produto produto = new Produto();
                produto.setEmpCodigo(rset.getInt("Emp_Codigo"));
                produto.setGrupoEstCodigo(rset.getInt("GrupoEst_Codigo"));
                produto.setProdEstCodigo(rset.getString("ProdESt_Codigo"));
                produto.setProdEstDescricao(rset.getString("ProdEst_Descricao"));
                produto.setProdEstUnidadeMedida(rset.getString("ProdEst_Unidademedida"));
                produto.setProdEstAplicacao(rset.getString("ProdEst_Aplicacao"));
                produtos.add(produto);
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
        return produtos;
    }

    /**
     * <p>
     * Esse método busca todos os produtos na base de dados</p>
     *
     * @return lista de produtos se houver correspondência
     */
    public static List<Produto> buscaTodos() {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from ProdutosEstoque where Emp_Codigo = 2 and GrupoEst_Codigo = "+Tools.GRUPO_PRODUTO;
        PreparedStatement pstm = null;
        List<Produto> produtos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //enquanto existir registro atribui vai adicionando na lista "produtos"
            while (rset.next()) {
                Produto produto = new Produto();
                produto.setEmpCodigo(rset.getInt("Emp_Codigo"));
                produto.setGrupoEstCodigo(rset.getInt("GrupoEst_Codigo"));
                produto.setProdEstCodigo(rset.getString("ProdESt_Codigo"));
                produto.setProdEstDescricao(rset.getString("ProdEst_Descricao"));
                produto.setProdEstUnidadeMedida(rset.getString("ProdEst_Unidademedida"));
                produto.setProdEstAplicacao(rset.getString("ProdEst_Aplicacao"));
                produtos.add(produto);
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
        return produtos;
    }
}
