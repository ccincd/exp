package common.template;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * AbstractBizProcessCallBack
 *
 * @author chi.chen
 * @date 16-2-17
 * @time 上午10:35
 */
public abstract class AbstractBizProcessCallBack<T> implements IBizProcessCallBack<T> {

    private List<Closeable> closeables = new ArrayList<Closeable>();

    protected void AddCloseable(Closeable closeable) {
        if (closeable != null && !closeables.contains(closeable)) {
            closeables.add(closeable);
        }
    }

    protected void removeCloseable(Closeable closeable) {
        if (closeable != null && closeables.contains(closeable)) {
            closeables.remove(closeable);
        }
    }

    @Override
    abstract public void checkState();

    @Override
    public abstract T doProcess();

    @Override
    abstract public void succRecorder(long execTime, T result);

    @Override
    abstract public void failRecorder();

    @Override
    public void postProcess() {
        if (!CollectionUtils.isEmpty(closeables)) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    // close quietly
                }
            }
        }
    }
}
