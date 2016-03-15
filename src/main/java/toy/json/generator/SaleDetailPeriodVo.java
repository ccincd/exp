package toy.json.generator;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 包含某段时间的售卖信息详情以及汇总数据
 *
 * @author chi.chen
 * @date 16-3-15
 * @time 下午4:12
 */
public class SaleDetailPeriodVo {

    /**
     * 某段时间的售卖信息详情列表
     */
    private List<SaleDetailDayVo> saleDetailDayVos;
    /**
     * 汇总数据，OTA和CPC归为“其它”类
     */
    private Map<String, Integer> bizSummaries;

    public static void main(String[] args) {
        SaleDetailPeriodVo periodVo = new SaleDetailPeriodVo();

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
        saleDetailDayVo3.setDate("2016-03-16");
        saleDetailDayVo3.setTotal(150);
        Map<String, Integer> map3 = Maps.newHashMap();
        map3.put("团购", 5);
        map3.put("直销预付", 6);
        map3.put("直销现付", 7);
        map3.put("夜销", 8);
        map3.put("其他", 9);
        saleDetailDayVo3.setBizCounts(map3);
        saleDetailDayVos.add(saleDetailDayVo3);

        periodVo.setSaleDetailDayVos(saleDetailDayVos);
        Map<String, Integer> map = Maps.newHashMap();
        map.put("团购", 25);
        map.put("直销预付", 37);
        map.put("直销现付", 49);
        map.put("夜销", 61);
        map.put("其他", 73);
        map.put("总计", 245);
        periodVo.setBizSummaries(map);

        String str = BaseGenerator.serilize(periodVo);
        System.out.println(str);
    }

    public List<SaleDetailDayVo> getSaleDetailDayVos() {
        return saleDetailDayVos;
    }

    public void setSaleDetailDayVos(List<SaleDetailDayVo> saleDetailDayVos) {
        this.saleDetailDayVos = saleDetailDayVos;
    }

    public Map<String, Integer> getBizSummaries() {
        return bizSummaries;
    }

    public void setBizSummaries(Map<String, Integer> bizSummaries) {
        this.bizSummaries = bizSummaries;
    }

    @Override
    public String toString() {
        return "SaleDetailPeriodVo{" + "saleDetailDayVos=" + saleDetailDayVos + ", bizSummaries=" + bizSummaries + '}';
    }
}
