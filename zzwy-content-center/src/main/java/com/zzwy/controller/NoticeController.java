package com.zzwy.controller;

import com.zzwy.common.Result;
import com.zzwy.domain.Announcement;
import com.zzwy.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公告
 *
 * @author zzwy
 * @date 2019/3/31
 */
@RestController
@RequestMapping("notices")
public class NoticeController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping("newest")
    public Result<Announcement> newest() {

        Announcement dtoAnnouce = new Announcement();
        dtoAnnouce.setDisplay(true);

        Announcement announcement = announcementService.selectOne(dtoAnnouce);

        return Result.success(announcement);
    }
}
