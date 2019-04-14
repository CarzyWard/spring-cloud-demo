

## 项目介绍

项目| 端口| 描述
---|---|---
zzwy-user-center|8010|用户服务中心
zzwy-content-center|8020|内容服务中心
zzwy-bonus-center|8030|积分服务中心
zzwy-eureka|8040|注册中心
zzwy-zuul|8050|网关


## 项目启动顺序
```
zzwy-eureka->zzwy-user-center->zzwy-content-center->zzwy-bonus-center->zzwy-zuul
```

## What is zzwy ?
zzwy is GOF, zhongsy、zhangl、wukj、yezt

## init_db.sql
database initialized script




这个代码也挺贴近生产的，存在的问题：
* 重复代码略多，考虑弄个commons模块，然后各个业务项目引入；
* 注释稍微有点少，不过业务比较简单，没注释问题也不大；
* 认证采用的是redis，这意味着所有服务都要共用这个redis，这不符合微服务去中心化的理念。另一组的作业 <https://github.com/SweetKevin/lucky-share> 是去中心化的，可以探讨下。 