# StudentSys
# 大学生"成长轨迹"管理与评价系统
- clone项目到本地  
- 使用 /src/main/resources/dbsql/studentSys.sql生成数据库
- 启动redis服务器
- 启动eureka_server集群.
- 修改student_sys相关配置(application.yml), 部署运行
- 其余module也是注册到eureka_server集群的

>mysql版本是8.*
>

#### 登录用户

| 类型 | id       | 密码   |
| ---- | -------- | ------ |
| 家长 | 08141111 | now888 |
|      | 08142222 | now888 |
|      | 08143333 | now888 |
| 学生 | 08146666 | now888 |
|      | 08147777 | now888 |
|      | 08148888 | now888 |
| 教师 | 08149999 | now888 |
