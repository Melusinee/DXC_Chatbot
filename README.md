# DXC_Chatbot
## DXC Chatbot 整理与更新

这是对2018/02 - 2018/06 月间在DXC Technology公司 (https://www.dxc.technology/) 进行学校Capstone实习期间所完成的在线聊天机器人代码进行整理与额外添加功能
</br>
整个chatbot以Google发行的AliceBot为基础进行web开发和功能增加
</br>
所有前端样式均为DXC Technology公司风格，部分为公司所提供，特此声明。
</br>

## 额外需要添加的依赖和jar包
因为使用了alicebot，使用者可以自行在pom.xml文件中添加依赖
```
 <dependencies>
	<dependency>
		<artifactId>com.google</artifactId>
		<groupId>Ab</groupId>
		<version>0.0.4.3</version>
		<scope>system</scope>
		<systemPath>${basedir}/lib/Ab.jar</systemPath>
	</dependency>
</dependencies>
```
如果添加依赖不成功，可以手动将对应的jar包安装至maven对应的文件夹，形成本地依赖文件，对应的Ab.jar已经添加到master路径下的Others Utilities 文件夹中
## 使用技术栈：
Spring, SpringMVC，Mybatis, MySql, AliceBot, AIML <br>
HTML,JavaScript,Ajax (这一行为实习同组组员负责完成)

## 现有功能
### Greeting 打招呼
* 由 /resources/bot/super/aiml 中的 greeting.aiml 提供判断，/resources/bot/super/aimlif 中的 greeting.aiml.csv提供不同的回答。
* 可以提供记住用户姓名并回复用户姓名进行打招呼
* 可以使用的激活打招呼功能语句：Hello/Hi/Hi [用户名]/Bye
### Booking 预约会议
* 由 /resources/bot/super/aiml 中的 booking.aiml 提供判断，/resources/bot/super/aimlif 中的 booking.aiml.csv提供不同的回答。
* 可以实行对员工的会议预约，并由机器人查询员工的合适时间
* 可以使用的激活预约会议语句：Book a meeting with [员工名]/ Booking
### Search 查询活动/文章/展览 及 活动注册
* 由 /resources/bot/super/aiml 中的 search.aiml 提供判断，/resources/bot/super/aimlif 中的 search.aiml.csv提供不同的回答。
* 可以实现对用户的活动查询，并由机器人查询活动/文章/展览，并完成用户的注册活动请求
* 可以使用的激活查询语句：Search * articles for me / Search an * event for me / find meetups/ Register please/...

### 查询所有员工信息：
* 可以实行对员工的信息查询，并由机器人回复所有现在的数据库内存储的员工信息
* 可以使用的激活查询语句：find all staffs...

### 查询所有会议信息：
* 可以实行对会议的信息查询，并由机器人回复所有现在的数据库内存储的会议信息
* 可以使用的激活查询语句：find all meetings...

### 更新员工：
* 可以将用户提到的新员工加入到数据库内，并由机器人回复确认现在新加入的员工信息
* 可以使用的激活查询语句：we have a new staff named [staff named] with id [id number] ...
