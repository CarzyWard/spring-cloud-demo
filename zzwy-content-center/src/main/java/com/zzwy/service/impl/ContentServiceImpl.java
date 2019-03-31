package com.zzwy.service.impl;

import com.zzwy.domain.Content;
import com.zzwy.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 内容
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {

    @Override
    public List pageContent(Map<String, Object> map) {
        //PageHelper.startPage(Integer.parseInt(String.valueOf(map.get("pageNo"))), Integer.parseInt(String.valueOf(map.get("size"))));

        //return contentMapper.pageContent(map);

        return select(null);
    }
}
