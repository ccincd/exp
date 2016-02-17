package common.template;

/**
 * BizProcessCallBack
 *
 * @author chi.chen
 * @date 16-2-17
 * @time 上午10:07
 */
public interface IBizProcessCallBack<T> {

    /**
     * 处理前检查参数和状态
     */
    void checkState();

    /**
     * 处理业务逻辑
     *
     * @return 处理结果
     */
    T doProcess();

    /**
     * 成功处理时，添加成功监控，记录处理时间或结果
     *
     * @param execTime 执行时间
     * @param result 处理结果
     */
    void succRecorder(long execTime, T result);

    /**
     * 处理失败时，添加失败监控
     */
    void failRecorder();

    /**
     * 在finally中执行，如果有打开的流则关闭
     *
     */
    void postProcess();
}
