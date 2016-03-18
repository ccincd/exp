package toy.pmo.crm729;

import java.util.Map;

/**
 * 销售同比、环比数据
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午2:09
 */
public class SaleCompareVo {

    /**
     * 合作业务类型，如团购、夜销、直销预付、直销现返、其它（OTA和CPC）或总计
     */
    private String name;

    /**
     * 售卖汇总数量（以期为维度划分，包含本期、上期和去年同期）
     */
    Map<String, String> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SpecifiedBizSaleTermVo{" + "name='" + name + '\'' + ", data=" + data + '}';
    }
}
