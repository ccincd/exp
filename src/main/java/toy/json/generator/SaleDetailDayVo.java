package toy.json.generator;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 某天的售卖信息详情
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午12:01
 */
public class SaleDetailDayVo extends BaseGenerator {

    /**
     * 日期，格式为 YYYY-MM-DD
     */
    private String date;
    /**
     * 当日总的销售总量（包括各个合作业务）
     */
    private Integer total;
    /**
     * 各个合作业务的售卖数量，OTA和CPC归为“其它”类
     */
    private Map<String, Integer> bizCounts;

    public static void main(String[] args) {
        List<SaleDetailDayVo> saleDetailDayVos = Lists.newArrayList();

        SaleDetailDayVo saleDetailDayVo1 = new SaleDetailDayVo();
        saleDetailDayVo1.setDate("2016-03-14");
        saleDetailDayVo1.setTotal(120);
        Map<String, Integer> map1 = Maps.newHashMap();
        map1.put("团购", 15);
        map1.put("直销预付", 25);
        map1.put("直销现付", 35);
        map1.put("夜销", 45);
        map1.put("其他", 55);
        saleDetailDayVo1.setBizCounts(map1);
        saleDetailDayVos.add(saleDetailDayVo1);

        SaleDetailDayVo saleDetailDayVo2 = new SaleDetailDayVo();
        saleDetailDayVo2.setDate("2016-03-15");
        saleDetailDayVo2.setTotal(140);
        Map<String, Integer> map2 = Maps.newHashMap();
        map2.put("团购", 5);
        map2.put("直销预付", 6);
        map2.put("直销现付", 7);
        map2.put("夜销", 8);
        map2.put("其他", 9);
        saleDetailDayVo2.setBizCounts(map2);
        saleDetailDayVos.add(saleDetailDayVo2);

        SaleDetailDayVo saleDetailDayVo3 = new SaleDetailDayVo();
        saleDetailDayVo3.setDate("2016-03-15");
        saleDetailDayVo3.setTotal(150);
        Map<String, Integer> map3 = Maps.newHashMap();
        map3.put("团购", 5);
        map3.put("直销预付", 6);
        map3.put("直销现付", 7);
        map3.put("夜销", 8);
        map3.put("其他", 9);
        saleDetailDayVo3.setBizCounts(map3);
        saleDetailDayVos.add(saleDetailDayVo3);

        String str = BaseGenerator.serilize(saleDetailDayVos);
        System.out.println(str);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<String, Integer> getBizCounts() {
        return bizCounts;
    }

    public void setBizCounts(Map<String, Integer> bizCounts) {
        this.bizCounts = bizCounts;
    }

    @Override
    public String toString() {
        return "SaleDetailVo{" + "date='" + date + '\'' + ", total=" + total + ", bizCounts=" + bizCounts + '}';
    }
}
