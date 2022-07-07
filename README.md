# 网管会管理系统

## 技术栈

- 后端框架: Spring Boot
- 数据库: PostgreSQL
- 数据库连接池: Druid
- 数据库持久化: MyBatis 3
- 前端框架: 预期为 Vue

## 预期功能

- [X] 设备数据库
- [X] 人员数据库
- [ ] 招新数据库

## 部署方式

- 运行环境：Java 11

打包：执行 `mvn clean package`，会在 `target` 中生成 JAR 文件，然后 `java -jar manager.jar` 即可，服务端运行在 8080 端口。

## API

### 成员数据库

- `/member` GET 获取所有成员信息（JSON 格式）
- `/member/{id}` GET 获取单个成员信息（JSON格式）
- `/member/add` POST 添加人员，传入 JSON，必须且仅能包括 `name`、`studentId` 两个字段，若包含其他字段，不会报错但不会录入数据库
- `/member/delete/{id}` DELETE 删除指定成员
- `/member/update/bank` POST 为人员添加或更新银行卡号，传入表单，包括 `id`、`bankNum` 两个字段
- `/member/update/phone` POST 为人员添加或更新手机号，传入表单，包括 `id`、`phoneNum` 两个字段

### 设备数据库

- `/device` GET 获取所有设备信息（JSON 格式）
- `/device/{id}` GET 获取单个设备信息（JSON格式）
- `/device/add` POST 添加设备，传入 JSON，包括 `deviceType`、`name` 两个字段，若包含其他字段，不会报错但不会录入数据库
- `/device/delete/{id}` DELETE 删除指定设备
- `/device/update/type` POST 为设备添加或更新类型，传入表单，包括 `id`、`deviceType` 两个字段
- `/device/update/name` POST 为设备添加或更新名称，传入表单，包括 `id`、`name` 两个字段
- `/device/update/manageIp` POST 为设备添加或更新管理 IP，传入表单，包括 `id`、`manageIp` 两个字段
- `/device/update/rackNo` POST 为设备添加或更新架号，传入表单，包括 `id`、`rackNo` 两个字段

### 返回值类型

获取信息会返回JSON或null，添加新成员/设备操作会返回如下形式的字符串

```text
Member{id=6, name='test', studentId='test', phoneNum='null', bankNum='null'}
```

若要为成员/设备添加或更新其他字段，成功后会返回与上文类似的字符串，失败则会返回 `EMPTY ID` 或 `FAILED` 等字符串。
