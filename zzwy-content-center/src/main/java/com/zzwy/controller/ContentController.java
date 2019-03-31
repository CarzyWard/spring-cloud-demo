package com.zzwy.controller;

import com.github.pagehelper.PageInfo;
import com.zzwy.common.Result;
import com.zzwy.common.ThreadContext;
import com.zzwy.common.UUIDUtil;
import com.zzwy.domain.Content;
import com.zzwy.domain.User;
import com.zzwy.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 内容
 *
 * @author zzwy
 * @date 2019/3/31
 */
@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    ContentService contentService;

    /**
     * 浏览内容
     */
    @GetMapping("shares")
    @ResponseBody
    public Result<PageInfo> shares(@RequestParam String pageNo, @RequestParam String title) {

        Map<String, Object> queryMap = new HashMap<>(2);
        queryMap.put("search", title);
        queryMap.put("pageNo", pageNo);
        PageInfo pageInfo = new PageInfo<List>(contentService.pageContent(queryMap));

        return Result.success(pageInfo);
    }

    /**
     * 查看我的投稿
     */
    @GetMapping("contributions")
    @ResponseBody
    public Result<PageInfo> contributions() {

        User user = ThreadContext.getUser();
        Content content = new Content();
        content.setUserId(user.getUserId());

        PageInfo pageInfo = new PageInfo<Content>(contentService.select(content));


        return Result.success(pageInfo);
    }

    /**
     * 投稿
     */
    @PostMapping("contribute")
    @ResponseBody
    public Result<Boolean> contribute(@RequestBody Content content) {

        User user = ThreadContext.getUser();
        content.setUserId(user.getUserId());
        content.setId(UUIDUtil.uuid());

        int code = contentService.save(content);

        return Result.success(code > 0);
    }
}
