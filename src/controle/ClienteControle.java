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
import javax.swing.JOptionPane;
import util.Conexao;
import modelo.Cliente;
import util.Tools;

/**
 *
 * @author Miquéias
 */
public class ClienteControle {

    public static Cliente buscaPorCodigo(int codigo) {

        Connection connection = Conexao.getConnection();
        String sql = "select * from viewClienteFisicoJuridico where P_Codigo = " + codigo;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Cliente cliente = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                cliente = new Cliente();
                cliente.setCidade(rset.getString("Cidade"));
                cliente.setEmail(rset.getString("Email"));
                cliente.setEmpCodigo(rset.getInt("Emp_Codigo"));
                cliente.setNomeRazaoSocial(rset.getString("NomeRazaoSocial"));
                cliente.setpCodigo(rset.getInt("P_Codigo"));
                cliente.setPFBairro(rset.getString("PF_Bairro"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPFCPF(rset.getString("PF_CPF"));
                cliente.setPFEndereco(rset.getString("PF_Endereco"));
                cliente.setPFUF(rset.getString("PF_UF"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPJBairro(rset.getString("PJ_Bairro"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJEndereco(rset.getString("PJ_Endereco"));
                cliente.setPJUF(rset.getString("PJ_UF"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJInscricaoEstadual(rset.getString("PJ_InscricaoEstadual"));
                cliente.setPTipo(rset.getString("P_Tipo"));
                cliente.setTelefone(rset.getString("Telefone"));
                cliente.setCodigoAntigo(rset.getInt("Codigo_Antigo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteControle.buscaPorCodigo().\nErro:"+e);
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
                JOptionPane.showMessageDialog(null, "ClienteControle.buscaPorCodigo() -> closeConnection().\nErro:"+e);
            }
        }
        return cliente;
    }

    public static List<Cliente> buscaDinamica(String valor) {

        Connection connection = Conexao.getConnection();
        String sql;
        if (Tools.isInt(valor)) {
            sql = "Select * from viewClienteFisicoJuridico where P_Codigo = " + valor +" or Codigo_Antigo = "+valor;
        } else {
            sql = "Select * from viewClienteFisicoJuridico where NomeRazaoSocial like '%" + valor + "%' ";
        }

        PreparedStatement pstm = null;
        List<Cliente> clientes = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setCidade(rset.getString("Cidade"));
                cliente.setEmail(rset.getString("Email"));
                cliente.setEmpCodigo(rset.getInt("Emp_Codigo"));
                cliente.setNomeRazaoSocial(rset.getString("NomeRazaoSocial"));
                cliente.setpCodigo(rset.getInt("P_Codigo"));
                cliente.setPFBairro(rset.getString("PF_Bairro"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPFCPF(rset.getString("PF_CPF"));
                cliente.setPFEndereco(rset.getString("PF_Endereco"));
                cliente.setPFUF(rset.getString("PF_UF"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPJBairro(rset.getString("PJ_Bairro"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJEndereco(rset.getString("PJ_Endereco"));
                cliente.setPJUF(rset.getString("PJ_UF"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJInscricaoEstadual(rset.getString("PJ_InscricaoEstadual"));
                cliente.setPTipo(rset.getString("P_Tipo"));
                cliente.setTelefone(rset.getString("Telefone"));
                cliente.setCodigoAntigo(rset.getInt("Codigo_Antigo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteControle.buscaDinamica().\nErro:"+e);
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
                JOptionPane.showMessageDialog(null, "ClienteControle.buscaDinamica() -> closeConnection().\nErro:"+e);
            }
        }
        return clientes;
    }

    public static List<Cliente> buscaPorNome(String nome) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from viewClienteFisicoJuridico where NomeRazaoSocial like '%" + nome + "%' ";
        PreparedStatement pstm = null;
        List<Cliente> clientes = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setCidade(rset.getString("Cidade"));
                cliente.setEmail(rset.getString("Email"));
                cliente.setEmpCodigo(rset.getInt("Emp_Codigo"));
                cliente.setNomeRazaoSocial(rset.getString("NomeRazaoSocial"));
                cliente.setpCodigo(rset.getInt("P_Codigo"));
                cliente.setPFBairro(rset.getString("PF_Bairro"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPFCPF(rset.getString("PF_CPF"));
                cliente.setPFEndereco(rset.getString("PF_Endereco"));
                cliente.setPFUF(rset.getString("PF_UF"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPJBairro(rset.getString("PJ_Bairro"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJEndereco(rset.getString("PJ_Endereco"));
                cliente.setPJUF(rset.getString("PJ_UF"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJInscricaoEstadual(rset.getString("PJ_InscricaoEstadual"));
                cliente.setPTipo(rset.getString("P_Tipo"));
                cliente.setTelefone(rset.getString("Telefone"));
                cliente.setCodigoAntigo(rset.getInt("Codigo_Antigo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteControle.buscaPorNome().\nErro:"+e);
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
                JOptionPane.showMessageDialog(null, "ClienteControle.buscaPorNome() -> closeconnection().\nErro:"+e);
            }
        }
        return clientes;
    }

    public static List<Cliente> buscaTodos() {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from viewClienteFisicoJuridico";
        PreparedStatement pstm = null;
        List<Cliente> clientes = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setCidade(rset.getString("Cidade"));
                cliente.setEmail(rset.getString("Email"));
                cliente.setEmpCodigo(rset.getInt("Emp_Codigo"));
                cliente.setNomeRazaoSocial(rset.getString("NomeRazaoSocial"));
                cliente.setpCodigo(rset.getInt("P_Codigo"));
                cliente.setPFBairro(rset.getString("PF_Bairro"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPFCPF(rset.getString("PF_CPF"));
                cliente.setPFEndereco(rset.getString("PF_Endereco"));
                cliente.setPFUF(rset.getString("PF_UF"));
                cliente.setPFCEP(rset.getString("PF_CEP"));
                cliente.setPJBairro(rset.getString("PJ_Bairro"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJEndereco(rset.getString("PJ_Endereco"));
                cliente.setPJUF(rset.getString("PJ_UF"));
                cliente.setPJCEP(rset.getString("PJ_CEP"));
                cliente.setPJCNPJ(rset.getString("PJ_CNPJ"));
                cliente.setPJInscricaoEstadual(rset.getString("PJ_InscricaoEstadual"));
                cliente.setPTipo(rset.getString("P_Tipo"));
                cliente.setTelefone(rset.getString("Telefone"));
                cliente.setCodigoAntigo(rset.getInt("Codigo_Antigo"));
                clientes.add(cliente);
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
        return clientes;
    }
}
