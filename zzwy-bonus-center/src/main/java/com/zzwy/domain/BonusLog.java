package com.zzwy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户积分表
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Table(name = "bonus_log")
public class BonusLog {

    /**
     * UUID
     */
    @Id
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 事件动作 BUY兑换  SIGN签到  CONTRIBUTE投稿  FORWARD转发
     */
    private String event;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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
