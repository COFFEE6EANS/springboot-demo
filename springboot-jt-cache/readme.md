### cache 组件
- CacheManager
- Cache存储结构Key-Value
- 缓存项
- Cache存储方式
- 缓存策略
- 分布式缓存
- Cache Hit 缓存命中
- Cache Miss 缓存丢失
- Cache Evication 缓存清楚
- Hot Data 热点数据
- On-Heap
- Off-Heap 堆外内存

- simple 适用于单体 或开发环境
- none 关闭缓存
- redis
- generic 自定义缓存 需要实现一个org.springframework.cache.CacheManager

### 注解
- @Cacheable 方法上,读取
- @CacheEvict 方法上,失效
- @CachePut 方法上,更新
- @Cache    方法上,综合
- @CacheConfig 类上,公共设置