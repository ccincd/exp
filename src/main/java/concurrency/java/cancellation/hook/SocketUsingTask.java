package concurrency.java.cancellation.hook;

import javax.annotation.concurrent.GuardedBy;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Test
 *
 * Created by cc on 16/5/6.
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {

    @GuardedBy("this") private Socket socket;

    protected synchronized void setSocket(Socket s) {
        socket = s;
    }

    @Override public synchronized void cancel() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            //
        }
    }

    @SuppressWarnings("all")
    @Override public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            @Override public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancel();
                } finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }
}
