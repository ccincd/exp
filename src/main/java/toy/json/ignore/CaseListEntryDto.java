package toy.json.ignore;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 平台端案例列表项Dto
 *
 * Created by cc on 16/6/18.
 */
public class CaseListEntryDto implements Serializable {

    public static void main(String[] args) {
        CaseListEntryDto entryDto = new CaseListEntryDto();

        entryDto.setAreaId(23L);
        entryDto.setCanModify(false);
        entryDto.setCanQueryReason(false);
        entryDto.setCanUpdate(true);
        entryDto.setCanViewDetail(false);
        entryDto.setCaseName("hi");
        entryDto.setCity("hi");
        entryDto.setCaseNum("hi");
        entryDto.setCompanyName("hi");
        entryDto.setStatus("hi");
        entryDto.setStatusCode((byte) 1);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String str = objectMapper.writeValueAsString(entryDto);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final long serialVersionUID = 6629112810791849541L;

    /**
     * 案例编号
     */
    private String caseNum;

    /**
     * 案例名称
     */
    private String caseName;

    /**
     * 地区码
     */
    @JsonIgnore
    private Long areaId;

    /**
     * 所属城市（包含地区）
     */
    private String city;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 当前会话数
     */
    private Integer currentSession;

    /**
     * 会话总数
     */
    private Integer totalSession;

    /**
     * 案例状态码
     */
    @JsonIgnore
    private byte statusCode;

    /**
     * 案例状态
     */
    private String status;

    /**
     * 是否显示案例详情按钮
     */
    private boolean canViewDetail;

    /**
     * 是否显示强制下架按钮
     */
    private boolean canForceDown;

    /**
     * 是否显示立即修改按钮
     */
    private boolean canModify;

    /**
     * 是否显示下架理由按钮
     */
    private boolean canQueryReason;

    /**
     * 是否显示立即完善按钮
     */
    private boolean canUpdate;

    /**
     * 是否显示删除按钮
     */
    private boolean canRemove;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public boolean isCanForceDown() {
        return canForceDown;
    }

    public void setCanForceDown(boolean canForceDown) {
        this.canForceDown = canForceDown;
    }

    public boolean isCanModify() {
        return canModify;
    }

    public void setCanModify(boolean canModify) {
        this.canModify = canModify;
    }

    public boolean isCanQueryReason() {
        return canQueryReason;
    }

    public void setCanQueryReason(boolean canQueryReason) {
        this.canQueryReason = canQueryReason;
    }

    public boolean isCanRemove() {
        return canRemove;
    }

    public void setCanRemove(boolean canRemove) {
        this.canRemove = canRemove;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isCanViewDetail() {
        return canViewDetail;
    }

    public void setCanViewDetail(boolean canViewDetail) {
        this.canViewDetail = canViewDetail;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Integer currentSession) {
        this.currentSession = currentSession;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(Integer totalSession) {
        this.totalSession = totalSession;
    }

    public byte getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(byte statusCode) {
        this.statusCode = statusCode;
    }
}
