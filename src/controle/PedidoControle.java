package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pedido;
import util.Conexao;
import util.Tools;

/**
 *
 * @author Miquéias
 */
public class PedidoControle extends ControleGenerico {

    public static boolean permiteAlterarExcluir(int codigoUsuario) {
        //String administrador = "N";
        String alterarExcluir = "N";
        Connection connection = Conexao.getConnection();
        //String sql = "select Usu_Administrador, Usu_PermiteAlterarExcluir from Usuario where Usu_Codigo = " + codigoUsuario;
        String sql = "select Usu_PermiteAlterarExcluir from Usuario where Usu_Codigo = " + codigoUsuario;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                //administrador = rset.getString("Usu_Administrador");
                alterarExcluir = rset.getString("Usu_PermiteAlterarExcluir");
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

        if (alterarExcluir == null){ //|| administrador == null) {
            return false;
        } else {
            return "S".equals(alterarExcluir); //&& "S".equals(administrador);
        }
    }

    public static String buscaNomeFuncionario(int codigo) {

        String nome = "";
        Connection connection = Conexao.getConnection();
        String sql = "select NomeFuncionario from viewBuscaFuncionariosPedidosMac where Usu_Codigo = " + codigo;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                nome = rset.getString("NomeFuncionario");
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
        return nome;
    }

    public static int buscaCodigoFuncionario(int codigo) {

        int codigoPessoa = 0;
        Connection connection = Conexao.getConnection();
        String sql = "select Pessoa_Codigo from viewBuscaFuncionariosPedidosMac where Usu_Codigo = " + codigo;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                codigoPessoa = rset.getInt("Pessoa_Codigo");
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
        return codigoPessoa;
    }

    public static int geraCodigo() {

        int codigo = 0;
        Connection connection = Conexao.getConnection();
        String sql = "select max(PedidoVenda_Codigo) from PedidoVenda where Emp_Codigo = 2";
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {

                codigo = rset.getInt(1);
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
        if (codigo > 0) {
            codigo += 1;
        } else {
            codigo = 1;
        }
        return codigo;
    }

    /**
     * <p>
     * Esse método define um comando SQL para salvar um pedido na base de
     * dados</p>
     *
     * @param pedido objeto a ser configurado no comando SQL
     */
    public void save(Pedido pedido) {
        String sql = "INSERT INTO PedidoVenda"
                + "(PedidoVenda_Codigo, "
                + "PedidoVenda_Data, "
                + "PedidoVenda_FormaPagamento, "
                + "PedidoVenda_NumeroNota, "
                + "PedidoVenda_Vencimento, "
                + "PedidoVenda_Observacao, "
                + "Emp_Codigo, "
                + "Pessoa_CodigoCliente, "
                + "PessoaFJ_CodigoCliente, "
                + "Pessoa_CodigoFunc, "
                + "PFisica_CodigoFunc, "
                + "PedidoVenda_TotalProdutos, "
                + "PedidoVenda_Acrescimo, "
                + "PedidoVenda_Desconto,"
                + "PedidoVenda_TotalPedido, "
                + "PedidoVenda_Comprador,"
                + "PedidoVenda_UsuarioRegistro) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        save(sql, pedido.getPedidoVendaCodigo(),
                pedido.getPedidoVendaData(),
                pedido.getPedidoVendaFormaPagamento(),
                pedido.getPedidoVendaNumeroNota(),
                pedido.getPedidoVendaVencimento(),
                pedido.getPedidoVendaObservacao(),
                pedido.getEmpCodigo(),
                pedido.getCliente().getpCodigo(),
                pedido.getPessoaFJCodigoCliente(),
                pedido.getPessoaCodigoFunc(),
                pedido.getPFisicaCodigoFunc(),
                pedido.getPedidoVendaTotalProdutos(),
                pedido.getPedidoVendaAcrescimo(),
                pedido.getPedidoVendaDesconto(),
                pedido.getPedidoVendaTotalPedido(),
                pedido.getPedidoVendaComprador(),
                pedido.getPedidoVendaUsuarioRegistro());
    }

    /**
     * <p>
     * Esse método define um comando SQL para atualizar um pedido na base de
     * dados</p>
     *
     * @param pedido objeto a ser configurado no comando SQL
     */
    public void update(Pedido pedido) {
        String sql = "UPDATE PedidoVenda SET "
                + "PedidoVenda_Data = ?, "
                + "PedidoVenda_FormaPagamento = ?, "
                + "PedidoVenda_NumeroNota = ?, "
                + "PedidoVenda_Vencimento = ?, "
                + "PedidoVenda_Observacao = ?, "
                //+ "EmpCodigo = ?, "
                + "Pessoa_CodigoCliente = ?, "
                + "PessoaFJ_CodigoCliente = ?, "
                + "Pessoa_CodigoFunc = ?, "
                + "PFisica_CodigoFunc = ?, "
                + "PedidoVenda_TotalProdutos = ?, "
                + "PedidoVenda_Acrescimo = ?, "
                + "PedidoVenda_Desconto = ?,"
                + "PedidoVenda_TotalPedido = ?, "
                + "PedidoVenda_UsuarioRegistro = ?,"
                + "PedidoVenda_Comprador = ? where PedidoVenda_Codigo = ?";
        update(sql,
                pedido.getPedidoVendaData(),
                pedido.getPedidoVendaFormaPagamento(),
                pedido.getPedidoVendaNumeroNota(),
                pedido.getPedidoVendaVencimento(),
                pedido.getPedidoVendaObservacao(),
                //pedido.getEmpCodigo(),
                pedido.getCliente().getpCodigo(),
                pedido.getPessoaFJCodigoCliente(),
                pedido.getPessoaCodigoFunc(),
                pedido.getPFisicaCodigoFunc(),
                pedido.getPedidoVendaTotalProdutos(),
                pedido.getPedidoVendaAcrescimo(),
                pedido.getPedidoVendaDesconto(),
                pedido.getPedidoVendaTotalPedido(),
                pedido.getPedidoVendaUsuarioRegistro(),
                pedido.getPedidoVendaComprador(),
                pedido.getPedidoVendaCodigo());
    }

    /**
     * <p>
     * Esse método define um comando SQL para remover um pedido da base de
     * dados</p>
     *
     * @param pedido objeto a ser configurado no comando SQL
     */
    public void delete(Pedido pedido) {
        String sql = "DELETE FROM PedidoVenda WHERE PedidoVenda_Codigo = ? ";
        delete(sql, pedido.getPedidoVendaCodigo());
    }

    /**
     * <p>
     * Esse método busca pedido por código na base de dados</p>
     *
     * @param codigo parametro para localizar o pedido
     * @return objeto pedido se houver correspondência
     */
    public static Pedido buscaPorCodigo(int codigo) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from PedidoVenda where PedidoVenda_Codigo = " + codigo + " and Emp_Codigo = 2;";
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        Pedido pedido = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça

            if (rset.next()) {
                pedido = new Pedido();
                pedido.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedido.setPFisicaCodigoFunc(rset.getInt("PFisica_CodigoFunc"));
                pedido.setPessoaCodigoFunc(rset.getInt("Pessoa_CodigoFunc"));
                pedido.setPedidoVendaAcrescimo(rset.getBigDecimal("PedidoVenda_Acrescimo"));
                pedido.setPedidoVendaData(rset.getDate("PedidoVenda_Data"));
                pedido.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedido.setPedidoVendaDesconto(rset.getBigDecimal("PedidoVenda_Desconto"));
                pedido.setPedidoVendaFormaPagamento(rset.getString("PedidoVenda_FormaPagamento"));
                pedido.setPedidoVendaNumeroNota(rset.getString("PedidoVenda_NumeroNota"));
                pedido.setPedidoVendaObservacao(rset.getString("PedidoVenda_Observacao"));
                pedido.setPedidoVendaTotalPedido(rset.getBigDecimal("PedidoVenda_TotalPedido"));
                pedido.setPedidoVendaTotalProdutos(rset.getBigDecimal("PedidoVenda_TotalProdutos"));
                pedido.setPedidoVendaVencimento(rset.getDate("PedidoVenda_Vencimento"));
                pedido.setCliente(ClienteControle.buscaPorCodigo(rset.getInt("Pessoa_CodigoCliente")));
                pedido.setPessoaFJCodigoCliente(rset.getInt("PessoaFJ_CodigoCliente"));
                pedido.setPedidoVendaComprador(rset.getString("PedidoVenda_Comprador"));
                pedido.setPedidoVendaUsuarioRegistro(rset.getInt("PedidoVenda_UsuarioRegistro"));
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
        return pedido;
    }

    /**
     * <p>
     * Esse método busca todos os pedidos por cliente na base de dados</p>
     *
     * @param codigoCliente
     * @return lista de pedidos se houver correspondência
     */
    public static List<Pedido> buscaPorCliente(int codigoCliente) {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from PedidoVenda where Pessoa_CodigoCliente = " + codigoCliente + " and Emp_Codigo = 2";
        PreparedStatement pstm = null;
        List<Pedido> pedidos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Pedido pedido = new Pedido();
                pedido.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedido.setPFisicaCodigoFunc(rset.getInt("PFisica_CodigoFunc"));
                pedido.setPessoaCodigoFunc(rset.getInt("Pessoa_CodigoFunc"));
                pedido.setPedidoVendaAcrescimo(rset.getBigDecimal("PedidoVenda_Acrescimo"));
                pedido.setPedidoVendaData(rset.getDate("PedidoVenda_Data"));
                pedido.setPedidoVendaDesconto(rset.getBigDecimal("PedidoVenda_Desconto"));
                pedido.setPedidoVendaFormaPagamento(rset.getString("PedidoVenda_FormaPagamento"));
                pedido.setPedidoVendaNumeroNota(rset.getString("PedidoVenda_NumeroNota"));
                pedido.setPedidoVendaObservacao(rset.getString("PedidoVenda_Observacao"));
                pedido.setPedidoVendaTotalPedido(rset.getBigDecimal("PedidoVenda_TotalPedido"));
                pedido.setPedidoVendaTotalProdutos(rset.getBigDecimal("PedidoVenda_TotalProdutos"));
                pedido.setPedidoVendaVencimento(rset.getDate("PedidoVenda_Vencimento"));
                pedido.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedido.setCliente(ClienteControle.buscaPorCodigo(rset.getInt("Pessoa_CodigoCliente")));
                pedido.setPessoaFJCodigoCliente(rset.getInt("PessoaFJ_CodigoCliente"));
                pedido.setPedidoVendaComprador(rset.getString("PedidoVenda_Comprador"));
                pedido.setPedidoVendaUsuarioRegistro(rset.getInt("PedidoVenda_UsuarioRegistro"));
                pedidos.add(pedido);
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
        return pedidos;
    }

    /**
     * <p>
     * Esse método busca todos os pedidos por período na base de dados</p>
     *
     * @param dataInicial data do inicio do período
     * @param dataFinal data do fim do período
     * @return lista de pedidos se houver correspondência
     */
    public static List<Pedido> buscaPorData(Date dataInicial, Date dataFinal) {
        Connection connection = Conexao.getConnection();
        String sql = "";
        sql = "Select * from PedidoVenda where "
                + "PedidoVenda_Data between'" + Tools.dateFormat(dataInicial, "dd-MM-yyyy") + "' and "
                + "'" + Tools.dateFormat(dataFinal, "dd-MM-yyyy") + "' and"
                + " Emp_Codigo = 2";
        PreparedStatement pstm = null;
        List<Pedido> pedidos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Pedido pedido = new Pedido();
                pedido.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedido.setPFisicaCodigoFunc(rset.getInt("PFisica_CodigoFunc"));
                pedido.setPessoaCodigoFunc(rset.getInt("Pessoa_CodigoFunc"));
                pedido.setPedidoVendaAcrescimo(rset.getBigDecimal("PedidoVenda_Acrescimo"));
                pedido.setPedidoVendaData(rset.getDate("PedidoVenda_Data"));
                pedido.setPedidoVendaDesconto(rset.getBigDecimal("PedidoVenda_Desconto"));
                pedido.setPedidoVendaFormaPagamento(rset.getString("PedidoVenda_FormaPagamento"));
                pedido.setPedidoVendaNumeroNota(rset.getString("PedidoVenda_NumeroNota"));
                pedido.setPedidoVendaObservacao(rset.getString("PedidoVenda_Observacao"));
                pedido.setPedidoVendaTotalPedido(rset.getBigDecimal("PedidoVenda_TotalPedido"));
                pedido.setPedidoVendaTotalProdutos(rset.getBigDecimal("PedidoVenda_TotalProdutos"));
                pedido.setPedidoVendaVencimento(rset.getDate("PedidoVenda_Vencimento"));
                pedido.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedido.setCliente(ClienteControle.buscaPorCodigo(rset.getInt("Pessoa_CodigoCliente")));
                pedido.setPessoaFJCodigoCliente(rset.getInt("PessoaFJ_CodigoCliente"));
                pedido.setPedidoVendaComprador(rset.getString("PedidoVenda_Comprador"));
                pedido.setPedidoVendaUsuarioRegistro(rset.getInt("PedidoVenda_UsuarioRegistro"));
                pedidos.add(pedido);
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
        return pedidos;
    }

    public static List<Pedido> buscaDinamica(int codigoPedido, Date dataInicial, Date dataFinal, int codigoCliente) {
        Connection connection = Conexao.getConnection();
        String sql = "";
        if (codigoPedido != 0) {
            sql = "Select * from PedidoVenda where Emp_Codigo = 2 and "
                    + "PedidoVenda_Codigo = " + codigoPedido;
        } else {
            if (dataInicial != null && dataFinal != null && codigoCliente != 0) {
                sql = "Select * from PedidoVenda where "
                        + "PedidoVenda_Data between '" + Tools.dateFormat(dataInicial, "dd-MM-yyyy") + "' and "
                        + "'" + Tools.dateFormat(dataFinal, "dd-MM-yyyy") + "' and "
                        + " Emp_Codigo = 2 and Pessoa_CodigoCliente = " + codigoCliente;
            } else if (dataInicial != null && dataFinal != null && codigoCliente != 0) {
                sql = "Select * from PedidoVenda where "
                        + "PedidoVenda_Data between '" + Tools.dateFormat(dataInicial, "dd-MM-yyyy") + "' and "
                        + " '" + Tools.dateFormat(dataFinal, "dd-MM-yyyy") + "' and "
                        + " Emp_Codigo = 2 and Pessoa_CodigoCliente = " + codigoCliente;

            } else if (dataInicial != null && dataFinal != null && codigoCliente == 0) {
                sql = "Select * from PedidoVenda where "
                        + "PedidoVenda_Data between'" + Tools.dateFormat(dataInicial, "dd-MM-yyyy") + "' and "
                        + "'" + Tools.dateFormat(dataFinal, "dd-MM-yyyy") + "' and "
                        + " Emp_Codigo = 2";
            }
        }
        PreparedStatement pstm = null;
        List<Pedido> pedidos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Pedido pedido = new Pedido();
                pedido.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedido.setPFisicaCodigoFunc(rset.getInt("PFisica_CodigoFunc"));
                pedido.setPessoaCodigoFunc(rset.getInt("Pessoa_CodigoFunc"));
                pedido.setPedidoVendaAcrescimo(rset.getBigDecimal("PedidoVenda_Acrescimo"));
                pedido.setPedidoVendaData(rset.getDate("PedidoVenda_Data"));
                pedido.setPedidoVendaDesconto(rset.getBigDecimal("PedidoVenda_Desconto"));
                pedido.setPedidoVendaFormaPagamento(rset.getString("PedidoVenda_FormaPagamento"));
                pedido.setPedidoVendaNumeroNota(rset.getString("PedidoVenda_NumeroNota"));
                pedido.setPedidoVendaObservacao(rset.getString("PedidoVenda_Observacao"));
                pedido.setPedidoVendaTotalPedido(rset.getBigDecimal("PedidoVenda_TotalPedido"));
                pedido.setPedidoVendaTotalProdutos(rset.getBigDecimal("PedidoVenda_TotalProdutos"));
                pedido.setPedidoVendaVencimento(rset.getDate("PedidoVenda_Vencimento"));
                pedido.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedido.setCliente(ClienteControle.buscaPorCodigo(rset.getInt("Pessoa_CodigoCliente")));
                pedido.setPessoaFJCodigoCliente(rset.getInt("PessoaFJ_CodigoCliente"));
                pedido.setPedidoVendaComprador(rset.getString("PedidoVenda_Comprador"));
                pedido.setPedidoVendaUsuarioRegistro(rset.getInt("PedidoVenda_UsuarioRegistro"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PedidoControle. Erro: " + e);
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
                JOptionPane.showMessageDialog(null, "PedidoControle. Erro: " + e);
            }
        }
        return pedidos;
    }

    /**
     * <p>
     * Esse método busca todos os pedidos na base de dados</p>
     *
     * @return lista de pedidos se houver correspondência
     */
    public static List<Pedido> buscaTodos() {
        Connection connection = Conexao.getConnection();
        String sql = "Select * from PedidoVenda where Emp_Codigo = 2";
        PreparedStatement pstm = null;
        List<Pedido> pedidos = new ArrayList<>();
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Pedido pedido = new Pedido();
                pedido.setEmpCodigo(rset.getInt("Emp_Codigo"));
                pedido.setPFisicaCodigoFunc(rset.getInt("PFisica_CodigoFunc"));
                pedido.setPessoaCodigoFunc(rset.getInt("Pessoa_CodigoFunc"));
                pedido.setPedidoVendaAcrescimo(rset.getBigDecimal("PedidoVenda_Acrescimo"));
                pedido.setPedidoVendaData(rset.getDate("PedidoVenda_Data"));
                pedido.setPedidoVendaDesconto(rset.getBigDecimal("PedidoVenda_Desconto"));
                pedido.setPedidoVendaFormaPagamento(rset.getString("PedidoVenda_FormaPagamento"));
                pedido.setPedidoVendaNumeroNota(rset.getString("PedidoVenda_NumeroNota"));
                pedido.setPedidoVendaObservacao(rset.getString("PedidoVenda_Observacao"));
                pedido.setPedidoVendaTotalPedido(rset.getBigDecimal("PedidoVenda_TotalPedido"));
                pedido.setPedidoVendaTotalProdutos(rset.getBigDecimal("PedidoVenda_TotalProdutos"));
                pedido.setPedidoVendaVencimento(rset.getDate("PedidoVenda_Vencimento"));
                pedido.setPedidoVendaCodigo(rset.getInt("PedidoVenda_Codigo"));
                pedido.setCliente(ClienteControle.buscaPorCodigo(rset.getInt("Pessoa_CodigoCliente")));
                pedido.setPessoaFJCodigoCliente(rset.getInt("PessoaFJ_CodigoCliente"));
                pedido.setPedidoVendaComprador(rset.getString("PedidoVenda_Comprador"));
                pedido.setPedidoVendaUsuarioRegistro(rset.getInt("PedidoVenda_UsuarioRegistro"));
                pedidos.add(pedido);
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
        return pedidos;
    }
}
