package toy.json.generator;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 销售情况同比、环比数据
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午2:09
 */
public class SpecifiedBizSaleSummaryVo extends BaseGenerator {

    /**
     * 售卖汇总数量（以期为维度划分，包含本期、上期和去年同期）
     */
    Map<String, Integer> data;
    /**
     * 合作业务类型，如团购、夜销、直销预付、直销现返、其它（OTA和CPC）或总计
     */
    private String name;

    public static void main(String[] args) {
        List<SpecifiedBizSaleSummaryVo> saleSummaryVos = Lists.newArrayList();

        SpecifiedBizSaleSummaryVo saleSummaryVo1 = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo1.setName("团购");
        Map<String, Integer> data1 = Maps.newHashMap();
        data1.put("本期", 35);
        data1.put("上期", 32);
        data1.put("去年同期", 36);
        saleSummaryVo1.setData(data1);
        saleSummaryVos.add(saleSummaryVo1);

        SpecifiedBizSaleSummaryVo saleSummaryVo2 = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo2.setName("直销预付");
        Map<String, Integer> data2 = Maps.newHashMap();
        data2.put("本期", 35);
        data2.put("上期", 32);
        data2.put("去年同期", 36);
        saleSummaryVo2.setData(data2);
        saleSummaryVos.add(saleSummaryVo2);

        SpecifiedBizSaleSummaryVo saleSummaryVo3 = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo3.setName("直销现付");
        Map<String, Integer> data3 = Maps.newHashMap();
        data3.put("本期", 35);
        data3.put("上期", 32);
        data3.put("去年同期", 36);
        saleSummaryVo3.setData(data3);
        saleSummaryVos.add(saleSummaryVo3);

        SpecifiedBizSaleSummaryVo saleSummaryVo5 = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo5.setName("夜销");
        Map<String, Integer> data5 = Maps.newHashMap();
        data5.put("本期", 35);
        data5.put("上期", 32);
        data5.put("去年同期", 36);
        saleSummaryVo5.setData(data5);
        saleSummaryVos.add(saleSummaryVo5);

        SpecifiedBizSaleSummaryVo saleSummaryVo4 = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo4.setName("其它");
        Map<String, Integer> data4 = Maps.newHashMap();
        data4.put("本期", 35);
        data4.put("上期", 32);
        data4.put("去年同期", 36);
        saleSummaryVo4.setData(data4);
        saleSummaryVos.add(saleSummaryVo4);

        SpecifiedBizSaleSummaryVo saleSummaryVo = new SpecifiedBizSaleSummaryVo();
        saleSummaryVo.setName("总计");
        Map<String, Integer> data = Maps.newHashMap();
        data.put("本期", 35);
        data.put("上期", 32);
        data.put("去年同期", 36);
        saleSummaryVo.setData(data);
        saleSummaryVos.add(saleSummaryVo);

        String str = BaseGenerator.serilize(saleSummaryVos);
        System.out.println(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getData() {
        return data;
    }

    public void setData(Map<String, Integer> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SpecifiedBizSaleTermVo{" + "name='" + name + '\'' + ", data=" + data + '}';
    }
}
