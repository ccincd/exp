package toy.pmo.crm729;

import java.util.List;

/**
 * 某项合作业务的售卖详细信息
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午12:01
 */
public class SaleDetailPerBizVo {

    /**
     * 合作业务名称
     */
    private String bizName;

    /**
     * 售卖总量
     */
    private String total;

    /**
     * 售卖数量列表（以天为维度）
     */
    private List<String> counts;

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<String> getCounts() {
        return counts;
    }

    public void setCounts(List<String> counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "SaleDetailPerBizVo{" + "bizName='" + bizName + '\'' + ", total=" + total + ", counts=" + counts + '}';
    }
}
