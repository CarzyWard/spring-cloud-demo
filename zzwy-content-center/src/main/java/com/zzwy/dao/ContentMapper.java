package com.zzwy.dao;

import com.zzwy.domain.Content;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 内容
 *
 * @author zzwy
 * @date 2019/3/29
 */
public interface ContentMapper extends Mapper<Content> {

    List pageContent(Map<String, Object> paramMap);
}
