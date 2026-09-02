# JasonMessage

基于 Spring Boot / Spring Cloud 的 Java 后端多模块工程，`jasonmessage-svr-msgcenter` 是其中的核心服务——一个支持多渠道推送的消息中台，可作为组织内项目开发中的通用消息推送组件。

## 核心模块：jasonmessage-svr-msgcenter（多渠道消息推送平台）

- **数据库设计**：模板表、消息记录表、限额表结构，黑名单功能整合进限额中，简化流程、提高性能
- **接口设计**：统一对外接口协议，包括模板增删查改接口、发送消息接口、查询消息接口
- **性能优化**：缓存 + 数据库优化，QPS 提升至 3000+
- **渠道接入**：邮件 / 短信 / 飞书等多渠道推送，`msgpush/channel` 下按渠道拆分实现（`EmailServiceImpl`、`SMSServiceImpl`、`LarkServiceImpl`），便于扩展新渠道
- **架构优化**：引入 Kafka 消息队列（`KafkaMsgConsumer`），同步发送改为异步发送
- **优先级设计**：`PriorityEnum` 支持多级队列，优先保障高优先级消息
- **定时推送**：基于 MySQL + Redis 二级缓存结构实现 `TimerMsgConsumer` / `TimerMsgResendPollTask` 定时推送与重试
- **业务限额**：`GlobalQuotaMapper` / `SourceQuotaMapper` 实现全局限额与来源限额管理

## 其他模块

这个仓库还保留了同一套工程脚手架下的其它练习服务，均已从原始项目重命名、更换包名，独立可编译：

| 模块 | 说明 |
| --- | --- |
| jasonmessage-svr-common | 公共组件 / 工具类 |
| jasonmessage-svr-demo | 服务模板（新建子服务时复制此模块） |
| jasonmessage-svr-api | 各服务间 Feign 接口聚合 |
| jasonmessage-svr-gateway | API 网关 |
| jasonmessage-svr-auth | 鉴权服务 |
| jasonmessage-svr-user | 用户服务 |
| jasonmessage-svr-leaf | 分布式 ID 生成服务 |
| jasonmessage-svr-xtimer | 分布式定时任务服务 |
| jasonmessage-svr-seckill | 秒杀服务 |
| jasonmessage-svr-lottery | 抽奖服务 |
| jasonmessage-svr-shorturlx | 短链服务 |
| jasonmessage-svr-asyncflow | 异步任务流引擎（flowsvr + worker） |
| jasonmessage-svr-mqtry | 消息队列相关练习 |
| jasonmessage-svr-improve | 性能优化练习（限流 / 异步等） |
| jasonmessage-svr-testconsumer | 测试用消费者 |

## 技术栈

Spring Boot、Spring Cloud（Nacos 服务注册/配置中心、OpenFeign）、MyBatis、MySQL、Redis、Kafka、Lombok

## 构建

```
mvn -pl jasonmessage-svr-msgcenter -am clean package
```

各模块的 `src/main/resources/application.yml` 中数据库/Redis/Kafka/邮件等连接信息需按本地环境自行配置。
