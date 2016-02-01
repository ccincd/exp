package xa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAResource;

/**
 * TransactionContext
 *
 * @author chi.chen
 * @date 16-1-25
 * @time 下午3:30
 */
public class TransactionContext {

    private XADataSource xaDataSource;

    private XAConnection xaConnection;

    private XAResource xaResource;

    private Connection connection;

    private Statement statement;

    public TransactionContext(String url, String user, String password) throws SQLException {
        xaDataSource = Commons.getDataSource(url, user, password);
        xaConnection = xaDataSource.getXAConnection();
        xaResource = xaConnection.getXAResource();
        connection = xaConnection.getConnection();
        statement = connection.createStatement();
    }

    public XADataSource getXaDataSource() {
        return xaDataSource;
    }

    public XAConnection getXaConnection() {
        return xaConnection;
    }

    public XAResource getXaResource() {
        return xaResource;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
