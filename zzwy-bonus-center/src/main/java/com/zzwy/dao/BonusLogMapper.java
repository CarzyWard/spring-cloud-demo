package com.zzwy.dao;

import com.zzwy.domain.BonusLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 积分流水
 *
 * @author zzwy
 * @date 2019/3/29
 */
public interface BonusLogMapper extends Mapper<BonusLog> {
    /**
     * 统计积分流水数量
     * @param  map 参数
     * @return
     */
    int count(Map map);


}
