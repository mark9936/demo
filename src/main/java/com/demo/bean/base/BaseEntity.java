package com.demo.bean.base;

import com.demo.util.constants.CommonConstants;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

@Data
@MappedSuperclass
public class BaseEntity {

    /**
     * 建檔人員工編號
     *
     * @return the creationUserId
     */
    @Column(name = "CreationUserId", updatable = false)
    private String creationUserId;

    /**
     * 建檔日期
     */
    @CreationTimestamp
    @Column(name = "CreationDTime", updatable = false)
    private LocalDateTime creationDTime;

    /**
     * 異動人員員工編號
     *
     * @return the modifyUserId
     */
    @Column(name = "ModifyUserId")
    private String modifyUserId;

    /**
     * 異動日期
     */
    @UpdateTimestamp
    @Column(name = "ModifyDTime")
    private LocalDateTime modifyDTime;

    /**
     * (Insert) EntityManager儲存Entity之前呼叫.
     */
    @PrePersist
    public void prePersist() {
        creationUserId = this.getMDC(creationUserId);
        creationDTime = LocalDateTime.now();
    }

    /**
     * (Update) EntityManager將Entity與資料庫同步更新發生前呼叫.
     */
    @PreUpdate
    public void preUpdate() {
        if (creationDTime == null) {
            creationDTime = LocalDateTime.now();
        }

        modifyUserId = this.getMDC(modifyUserId);
        modifyDTime = LocalDateTime.now();
    }

    /**
     * @formatter:off
     * 從UserServiceImpl取得註冊的loginBean資訊 <br>
     * 如果沒有註冊到資料，則欄位的值為[UNKNOWN].
     *
     * @param fieldVal
     * @return the mdc
     * @formatter:on
     */
    private String getMDC(String fieldVal) {
        return StringUtils.hasText(MDC.get(CommonConstants.EMP_ID)) ? MDC.get(
                CommonConstants.EMP_ID)
                : StringUtils.hasText(fieldVal) ? fieldVal : "UNKNOWN";
    }
}
