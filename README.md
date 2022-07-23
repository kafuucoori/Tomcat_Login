### 功能实现：

#####     用户注册

​        数据检查
​        添加数据

#####     用户查询

​        模糊查询
​        多表联查
​        分页显示

#####     用户登录

​        输入重置
​        登录过滤
​        免密登录

#####     用户修改

​        修改数据
​        全选数据
​        多选数据
​        批量删除

### 待实现功能：

​    数据反选
​    主动退出账号
​    密码找回功能
​    删除当前账号自动退出

### Requirements：

​    Java-1.8.0  Tomcat-9.0.64
​    Jquery-2.1.4  JSTL-1.1.32
​    Mysql-8.0.28  Druid-1.2.9

​	JDBC  Cookie  Session  JSP
​	HTML  JavaScript  CSS  Ajax

### IDEA部署准备：

1. ​    添加tomcat库 jsp-api.jar

2. ​    添加tomcat库 servlet-api.jar

3. ​    修改数据库配置文件 druid.properties

4. ​    将top/kafuucoori/util/ConnUtil.java中的配置文件druidpath地址修改正确

5. ​    添加druid连接池在 /web/WEB-INF/lib/druid-1.2.9.jar

6. ​    添加mysql驱动包在 /web/WEB-INF/lib/mysql-connector-java-8.0.28.jar

7. ​    添加jstl驱动包在 /web/WEB-INF/lib/jstl.jar /web/WEB-INF/lib/standard.jar

8. ​    添加 Tomcat Configuration:

   ​        设置URL为 http://localhost:8888/Tomcat_Login/ （HTTPport 8888 JMXport 1099）

   ​        设置Deployment中的Application context为 /Tomcat_Login

### Mysql部署准备：

```
    -- 创建user表
    create table user
    (
    id int not null PRIMARY KEY AUTO_INCREMENT,
    name varchar(10) not null,
    pwd varchar(255) not null,
    hobby varchar(255) not null,
    cid int not null
    );
    -- 创建country表
    create table country
    (
    cid int not null PRIMARY KEY AUTO_INCREMENT,
    country varchar(255) not null
    );
    -- 插入user表数据
    insert into user (id,name,pwd,hobby,cid) values (1,'冰织',123,'跑',1);
    insert into user (id,name,pwd,hobby,cid) values (2,'Alice',456,'Read',5);
    insert into user (id,name,pwd,hobby,cid) values (3,'チノ',789,'歌う',4);
    insert into user (id,name,pwd,hobby,cid) values (4,'Test1',147,'测试1',1);
    insert into user (id,name,pwd,hobby,cid) values (5,'Test2',258,'测试2',2);
    insert into user (id,name,pwd,hobby,cid) values (6,'Test3',369,'测试3',3);
    insert into user (id,name,pwd,hobby,cid) values (7,'Test4',147,'测试4',4);
    insert into user (id,name,pwd,hobby,cid) values (8,'Test5',258,'测试5',5);
    insert into user (id,name,pwd,hobby,cid) values (9,'Test6',369,'测试6',6);
    insert into user (id,name,pwd,hobby,cid) values (10,'Test7',147,'测试7',1);
    insert into user (id,name,pwd,hobby,cid) values (11,'Test8',258,'测试8',2);
    insert into user (id,name,pwd,hobby,cid) values (12,'Test9',369,'测试9',3);
    insert into user (id,name,pwd,hobby,cid) values (13,'Test10',147,'测试10',4);
    insert into user (id,name,pwd,hobby,cid) values (14,'Test11',258,'测试11',5);
    insert into user (id,name,pwd,hobby,cid) values (15,'Test12',369,'测试12',6);
    -- 插入country表数据
    insert into country (cid,country) values (1,'China');
    insert into country (cid,country) values (2,'Germany');
    insert into country (cid,country) values (3,'France');
    insert into country (cid,country) values (4,'Japan');
    insert into country (cid,country) values (5,'UK');
    insert into country (cid,country) values (6,'USA');
```

### 目前问题：

​    页面过小时会出现顶部布局错乱
​    使用最新的jQuery时会报500错误(故选择了低版本）
​    一但手动创建的数据库连接过多就会报错(不确定关闭代码应该写哪)

### 乱码情况：

1. ​    post请求乱码

   ​        request.setCharacterEncoding("utf-8");

2. ​    get请求乱码

   ​        tomcat 文件夹中找到 sever.xml 的 Connector 中配置 URIEncoding = "utf-8"

3. ​    sql语句乱码

   ​        在连接数据库的 url 后面加上 useUnicode = true & characterEncoding = utf-8

4. ​    返回的数据乱码

   ​        response.setCharacterEncoding("utf-8");

5. ​    页面解析的时候乱码

   ​        response.setContentType("text/html; charset=utf-8");

6. ​    javascript输出乱码

```
		<script type="text/javascript" charset="utf-8">
```

7. ​    外部javascript输出乱码（在项目的web.xml文件中添加以下代码）

```
        <jsp-config>
            <jsp-property-group>
                <display-name>HtmlConfiguration</display-name>
                <url-pattern>*.html</url-pattern>
                <page-encoding>UTF-8</page-encoding>
            </jsp-property-group>
            <jsp-property-group>
                <display-name>JspConfiguration</display-name>
                <url-pattern>*.jsp</url-pattern>
                <page-encoding>UTF-8</page-encoding>
            </jsp-property-group>
            <jsp-property-group>
                <display-name>JsConfiguration</display-name>
                <url-pattern>*.js</url-pattern>
                <page-encoding>UTF-8</page-encoding>
            </jsp-property-group>
        </jsp-config>
```

### 代码格式：

```
    jsp中使用java代码：
        <%XXX%>
    jsp中使用java标签代码：jstl
        <c:XXX>
    显示数据：(el表达式)
        ${xxx}
        ${XXXScope.xxx}
```

### Servlet处理流程：

1. ​	设置请求编码格式
2. ​	设置响应编码格式
3. ​	接收请求端的参数
4. ​	进行逻辑代码的处理
5. ​	返回响应的结果

### 登录流程：

1. ​	使用JSP生成页面
2. ​	客户端先发送请求，得到要登录的界面
3. ​	用户填写相应的用户数据发送给服务器
4. ​	服务器接收到请求后进行逻辑处理
5. ​	服务端将处理后的结果返回给客户端

### 用户免密登录 ：

1. ​	用户发送验证cookie信息的请求，编写对应的servlet进行处理
2. ​	如果包含cookie，直接跳转到成功页面
3. ​	如果不包含cookie信息直接跳转到登录页面

### MVC 设计模式：

​    m   model        模型
​    v     view         视图
​    c     controller   控制器   servlet
​           model 还分为三层：
​           entity    实体类       编写的是与数据库的表一一对应的java类   prop
​           dao       数据库层     负责数据库增删查改的接口 （死）
​           service   业务逻辑层   调用和拼接dao层来实现方法 （活）
​    调用层级： entity调用于各层
​        BaseDao -> ConnUtil -> dao--daoimpl -> service--serviceimpl -> servlet -> jsp
​    util 工具类：
​        ConnUtil   连接数据库
​        BaseDao    基础增删查改功能
​    filter 过滤器：
​        处理各种乱码问题
​        设置访问权限

#### Session：

​    失效时间默认30min 秒为单位 当浏览器关闭时消失
​    无最大上限 以键值对储存
​    储存在服务器端
​    主要功能：通过SessionID保证会话唯一性

#### Cookie：

​    默认关闭浏览器即失效
​    最大4KB 4096byte
​    储存在客户端

#### 重定向：

​    response.sendRedirect("");
​    网址改变
​    产生两次请求
​    在客户端发生可以重定向到任何网址
​    request中存放的变量全部失效，并进入一个新的request作用域

#### 转发：

​    request.getRequestDispatcher("").forward(request, response);
​    网址不变
​    产生一次请求
​    在服务端发生只能转发到本站点的网址
​    以前的request中存放的变量不会失效，就会和新的拼接在一起

### 注意事项：

​    使用文件后缀名匹配时前面不要加 /
​    contains是包含,equals是相等(完全一样)
​    表单数据使用重定向，否则会出现多次提交现象
​    解决重定向不共享数据的问题可以使用cookie

By:

​    @KafuuCoori
​    kafuucoori@qq.com
​    www.kafuucoori.top
