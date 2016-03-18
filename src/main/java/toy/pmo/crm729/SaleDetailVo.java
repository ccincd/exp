package toy.pmo.crm729;

import java.util.List;

/**
 * 售卖详细信息
 *
 * @author chi.chen
 * @date 16-3-15
 * @time 下午4:12
 */
public class SaleDetailVo {

    /**
     * 日期列表，格式为yyyy-MM-dd
     */
    private List<String> dates;

    /**
     * 合作业务售卖信息列表
     */
    private List<SaleDetailPerBizVo> saleInfo;

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<SaleDetailPerBizVo> getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(List<SaleDetailPerBizVo> saleInfo) {
        this.saleInfo = saleInfo;
    }

    @Override
    public String toString() {
        return "SaleDetailVo{" + "dates=" + dates + ", saleInfo=" + saleInfo + '}';
    }
}
