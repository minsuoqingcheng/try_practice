package json;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 工艺工序表
 *
 * @author pigx code generator
 * @date 2019-04-28 21:52:12
 */
public class RoutionProcessDto implements Serializable{


    /**
   * 工艺ID
   */
    private Long routionId;
    /**
   * 编号
   */
    private Long id;
    /**
   * 租户ID
   */
    private Long tenantId;
    /**
   * 工序ID
   */
    private Long processId;

    /**
     * 工序名称
     */
    private String processName;

    /**
   * 创建时间
   */
    private LocalDateTime createTime;

    /**
   * 
   */
    private String extInfo;


    public Long getRoutionId() {
        return routionId;
    }

    public void setRoutionId(Long routionId) {
        this.routionId = routionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

}
