/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;
import modelo.FuncionarioMAC;
import util.Tools;

/**
 *
 * @author Miquéias
 */
public class FuncionarioControle {
    
    
    public static FuncionarioMAC buscaPorCodigoUsuario(int codigo) {
        
        Connection connection = Conexao.getConnection();
        String sql = "select * from viewBuscaFuncionariosPedidosMac where Usu_Codigo = " + codigo;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        FuncionarioMAC funcionario = new FuncionarioMAC();

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                funcionario.setEmpCodigo(rset.getInt("Emp_Codigo"));
                funcionario.setNomeFuncionario(rset.getString("NomeFuncionario"));
                funcionario.setPessoaCodigo(rset.getInt("Pessoa_Codigo"));
                funcionario.setUsuCodigo(rset.getInt("Usu_Codigo"));
            }
        } catch (SQLException e) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return funcionario;
    }
    
    public static FuncionarioMAC buscaPorCodigoPessoa(int codigo) {
        
        Connection connection = Conexao.getConnection();
        String sql = "select * from viewBuscaFuncionariosPedidosMac where Pessoa_Codigo = " + codigo;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        FuncionarioMAC funcionario = new FuncionarioMAC();

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                funcionario.setEmpCodigo(rset.getInt("Emp_Codigo"));
                funcionario.setNomeFuncionario(rset.getString("NomeFuncionario"));
                funcionario.setPessoaCodigo(rset.getInt("Pessoa_Codigo"));
                funcionario.setUsuCodigo(rset.getInt("Usu_Codigo"));
            }
        } catch (SQLException e) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return funcionario;
    }

    public static List<FuncionarioMAC> buscaDinamica(String valor) {

        Connection connection = Conexao.getConnection();
        String sql;
        if (Tools.isInt(valor)) {
            sql = "Select * from viewBuscaFuncionariosPedidosMac where Pessoa_Codigo = " + valor;
        } else {
            sql = "Select * from viewBuscaFuncionariosPedidosMac where NomeFuncionario like '%" + valor + "%' ";
        }

        PreparedStatement pstm = null;
        List<FuncionarioMAC> funcionarios = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                FuncionarioMAC funcionario = new FuncionarioMAC();
                funcionario.setEmpCodigo(rset.getInt("Emp_Codigo"));
                funcionario.setNomeFuncionario(rset.getString("NomeFuncionario"));
                funcionario.setPessoaCodigo(rset.getInt("Pessoa_Codigo"));
                funcionario.setUsuCodigo(rset.getInt("Usu_Codigo"));
                funcionarios.add(funcionario);
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
        return funcionarios;
    }

    public static List<FuncionarioMAC> buscaTodos() {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from viewBuscaFuncionariosPedidosMac";
        PreparedStatement pstm = null;
        List<FuncionarioMAC> funcionarios = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                FuncionarioMAC funcionario = new FuncionarioMAC();
                funcionario.setEmpCodigo(rset.getInt("Emp_Codigo"));
                funcionario.setNomeFuncionario(rset.getString("NomeFuncionario"));
                funcionario.setPessoaCodigo(rset.getInt("Pessoa_Codigo"));
                funcionario.setUsuCodigo(rset.getInt("Usu_Codigo"));
                funcionarios.add(funcionario);
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
        return funcionarios;
    }
}
