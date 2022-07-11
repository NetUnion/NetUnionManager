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
- [X] 用户管理和登陆
- [X] SSO 支持

## 部署方式

**运行环境：** Java 11

**建立数据库：** 安装 `PostgreSQL` 数据库，先新建数据库，并执行下面的命令

```SQL
CREATE TABLE public.device (
 id serial4 NOT NULL,
 device_type varchar(10) NULL,
 manage_ip inet NULL,
 name varchar(10) NOT NULL DEFAULT NULL::character varying,
 rack_no varchar NULL
);
CREATE TABLE public."member" (
 id int4 NOT NULL DEFAULT nextval('user_id_seq'::regclass),
 "name" varchar(32) NOT NULL,
 student_id varchar(32) NOT NULL,
 phone_num varchar(11) NULL,
 bank_num varchar(19) NULL
);
CREATE TABLE public."user" (
 id serial4 NOT NULL,
 username varchar(48) NOT NULL,
 "password" varchar(256) NOT NULL,
 authority varchar(10) NOT NULL
);
```

**建立管理员账户：** 在 `user` 表中添加管理员账户，`password` 字段填入BCrypt加密后的密码。

**配置 oauth2 登录：** 在 `src/main/resources/application.yml` 中配置 `oauth2`。GitHub 的配置已给出，如需支持 OpenID, 可以参考：[CSDN](https://blog.csdn.net/u013810234/article/details/113279871)。

**打包和部署：** 执行 `mvn clean package`，会在 `target` 中生成 JAR 文件，然后 `java -jar manager.jar` 即可，服务端运行在 8080 端口。

## API

详见 [API 文档](API.md)。
