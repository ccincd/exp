package toy.pmo.crm729;

import java.util.Map;

/**
 * 销售信息文案所需数据
 *
 * @author chi.chen
 * @date 16-3-15
 * @time 下午1:46
 */
public class SaleOverviewVo {

    /**
     * 日期范围
     */
    private String timeRange;

    /**
     * 成单总量
     */
    private int paidCount;

    /**
     * 实住间夜量
     */
    private int livedRoomNightCount;

    /**
     * 销售额
     */
    private double sellPrice;

    /**
     * 环比信息 mom(month over month)
     */
    private String momInfo;

    /**
     * 同比信息 yoy(year over year)
     */
    private String yoyInfo;

    /**
     * 各个业务线间夜量分布 分别为团购、直销预付、直销现付、夜销、其它（OTA与CPC）
     */
    Map<String, Integer> businessCounts;

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public int getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(int paidCount) {
        this.paidCount = paidCount;
    }

    public int getLivedRoomNightCount() {
        return livedRoomNightCount;
    }

    public void setLivedRoomNightCount(int livedRoomNightCount) {
        this.livedRoomNightCount = livedRoomNightCount;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMomInfo() {
        return momInfo;
    }

    public void setMomInfo(String momInfo) {
        this.momInfo = momInfo;
    }

    public String getYoyInfo() {
        return yoyInfo;
    }

    public void setYoyInfo(String yoyInfo) {
        this.yoyInfo = yoyInfo;
    }

    public Map<String, Integer> getBusinessCounts() {
        return businessCounts;
    }

    public void setBusinessCounts(Map<String, Integer> businessCounts) {
        this.businessCounts = businessCounts;
    }

    @Override
    public String toString() {
        return "SaleOverviewVo{" + "timeRange='" + timeRange + '\'' + ", paidCount=" + paidCount
                + ", livedRoomNightCount=" + livedRoomNightCount + ", sellPrice=" + sellPrice + ", momInfo='" + momInfo
                + '\'' + ", yoyInfo='" + yoyInfo + '\'' + ", businessCounts=" + businessCounts + '}';
    }
}
