package xa;

import java.sql.SQLException;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;

/**
 * XidTestMain
 *
 * @author chi.chen
 * @date 16-1-25
 * @time 下午1:32
 */
public class XidTestMain {

    public static void main(String[] args) {
        MyXid myXid1, myXid2;
        int retCode1, retCode2;

        try {
            TransactionContext tc1 = new TransactionContext(
                    Constants.MYSQL_LOCAL_BOOK_STORE_URL,
                    Constants.MYSQL_USERNAME,
                    Constants.MYSQL_PASSWORD
            );
            TransactionContext tc2 = new TransactionContext(
                    Constants.MYSQL_LOCAL_HOMEWORK_URL,
                    Constants.MYSQL_USERNAME,
                    Constants.MYSQL_PASSWORD
            );

            if (tc1.getXaResource().isSameRM(tc2.getXaResource())) {
                System.out.println("The same!!");
                return;
            }

            myXid1 = new MyXid(100, new byte[]{0x01}, new byte[]{0x02});
            myXid2 = new MyXid(100, new byte[]{0x11}, new byte[]{0x12});

            tc1.getXaResource().start(myXid1, XAResource.TMNOFLAGS);
            tc1.getStatement().executeUpdate("insert into book_authors(author_id, author_name, content) values(102101, '陈驰', '我是一名演员')");
            tc1.getXaResource().end(myXid1, XAResource.TMSUCCESS);

            tc2.getXaResource().start(myXid2, XAResource.TMNOFLAGS);
            tc2.getStatement().executeUpdate("insert into user_accounts(username, pwd) values('cc', 'chenchi')");
            tc2.getXaResource().end(myXid2, XAResource.TMSUCCESS);

            /* 询问资源管理器是否可以提交 */
            retCode1 = tc1.getXaResource().prepare(myXid1);
            retCode2 = tc2.getXaResource().prepare(myXid2);
            if (retCode1 == XAResource.XA_OK && retCode2 == XAResource.XA_OK) {
                tc1.getXaResource().commit(myXid1, false);
                tc2.getXaResource().commit(myXid2, false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (XAException e) {
            e.printStackTrace();
        }
    }
}
