package toy.xa;

import javax.transaction.xa.Xid;

/**
 * MyXid
 *
 * @author chi.chen
 * @date 16-1-25
 * @time 下午12:25
 */
public class MyXid implements Xid {

    protected int formatId;

    protected byte gtrid[];

    protected byte bqual[];

    public MyXid(int formatId, byte[] gtrid, byte[] bqual) {
        this.formatId = formatId;
        this.gtrid = gtrid;
        this.bqual = bqual;
    }

    public MyXid() {
    }

    public int getFormatId() {
        return formatId;
    }

    public byte[] getGlobalTransactionId() {
        return gtrid;
    }

    public byte[] getBranchQualifier() {
        return bqual;
    }
}
