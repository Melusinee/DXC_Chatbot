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
