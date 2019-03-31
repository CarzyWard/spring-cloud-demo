package com.zzwy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户积分表
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Table(name = "user_bonus")
public class UserBonus {

    /**
     * 用户ID
     */
    @Id
    private String userId;
    /**
     * 积分数
     */
    private Integer bonus;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
