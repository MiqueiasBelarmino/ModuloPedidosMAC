package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao;

public abstract class ControleGenerico {

    private Connection connection;

    
    protected ControleGenerico() {
        this.connection = Conexao.getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    
    /**
     * <p>Esse método salva um objeto na base de dados</p>
     *
     * @param insertSql  comando SQL a ser executado
     * @param parametros valores do objeto a ser configurado no comando SQL
     */
    protected void save(String insertSql, Object... parametros) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Esse método atualiza um objeto na base de dados</p>
     *
     * @param updateSql  comando SQL a ser configurados
     * @param parametros valores do objeto a ser configurado no comando SQL
     */
    protected void update(String updateSql, Object... parametros) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(updateSql);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Esse método remove um objeto na base de dados</p>
     *
     * @param deleteSql  comando SQL a ser configurados
     * @param parametros valores do objeto a ser configurado no comando SQL
     */
    protected void delete(String deleteSql, Object... parametros) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
