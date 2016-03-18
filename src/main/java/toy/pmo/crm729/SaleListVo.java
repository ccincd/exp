package toy.pmo.crm729;

/**
 * 销售情况list页数据项
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午3:02
 */
public class SaleListVo {

    /**
     * 统计的销售数据类型id
     */
    private Integer id;

    /**
     * 统计的销售数据类型
     *
     */
    private String name;

    /**
     * 统计的数量
     */
    private String totalNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "SaleListVo{" + "id=" + id + ", name='" + name + '\'' + ", totalNum=" + totalNum + '}';
    }
}
