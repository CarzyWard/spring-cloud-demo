package com.zzwy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公告
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Table(name = "announcement")
public class Announcement {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否展示
     */
    private Boolean display;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
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
