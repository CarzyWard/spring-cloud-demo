package com.zzwy.service;

import com.zzwy.domain.Content;

import java.util.List;
import java.util.Map;

/**
 * 内容
 *
 * @author zhongsy
 * @date 2019/3/29
 */
public interface ContentService extends BaseService<Content> {
    /**
     * 获取分页内容信息
     *
     * @param map 查询参数
     * @return 分页后的对象
     */
    List pageContent(Map<String, Object> map);
}
