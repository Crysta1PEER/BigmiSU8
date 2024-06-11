# BigmiSU8
选车系统小项目。基于mybatis、Servlet、JSP等技术的Web应用程序。灵感来源自保时捷官网与小米汽车页面。

# 前言
※随着科学技术的发展，如今互联网企业也可以生产车辆。那么我们不妨大胆设想一下，如果我们从零开始————或者说，先从一个网页开始，完成我们的造车计划，会需要多长的时间呢？
※千里之行，始于足下。先从这个网页开始：
-主页展示页：首先我们要让大家知道，我们是卖车的。
-包含基于Mybatis、JDBC的登录系统。登录认证可用于创建、提交、查看订单等。不登录的话我们不知道把车卖给谁。
-包含Session缓存UID字段，可缓存登录认证信息。不是很安全，但是饼太多会吃不完，后面再改。
-每进行一次操作都会留下log记录。作为付定金后不给退款的证据。
-选车界面：DIY你心仪的车辆！就是要与众不同！
-查看订单：漫漫人生，难免会做出后悔的决定。不过定金不退，就当交学费吧。
-header/footer部分使用JSP include拼接。就像搭积木一样。

# 版本更新记录
+250413 #bigmisu8 确定参与人员@魏涛 @刘云涛 @刘少瑞 @程义峰 @王焱琛 @刘巍然 。
+240508 #bigmisu8 新建文件夹。项目立项。
+240514 #bigmisu8 @魏涛 项目功能划分与分工。
+240520 #login_with_jdbc @魏涛 提交“基于JDBC的登录、注册系统雏形”至仓库。交由@王焱琛进行完善修改。
+240520 #bigmisu8 交由@刘云涛 制作主展示页body。
+240520 #bigmisu8 交由@刘少瑞 制作登录注册前端界面body。
+240521 #bigmisu8 交由@刘云涛 制作通用header/footer部分。
+240525 #buycar @程义峰 @刘巍然 选车界面前端（预览版）提交至仓库。
-240526 #login_with_jdbc @魏涛 测试Session缓存功能。修改bug并提交至仓库。
+240527 #login_interface @刘少瑞 登录界面上传。
+240601 #buycar @程义峰 图片素材更新。
+240601 #buycar @刘巍然 连接Servlet，修改文件结构等细微问题。@魏涛 数据库连接servlet并提交仓库。
+240603 #buycar 交由@王焱琛 进行后端连接测试。
+240608 #bigmisu8 @魏涛 建立新仓库。
-240609 #buycar @程义峰 文件结构修改。
+240611 #bigmisu8 @魏涛 Readme.md文件。
+240611 #login_interface @刘少瑞 登录界面传入值更新。

# 结语
※看样子，短期内造车的想法还是不太现实。不仅没有骗到定金，还被服务器费用赔的裤衩都不剩了。不过没关系，我相信只要心怀梦想，再大的目标也能变得易如反掌。祝我们终能圆梦，永远相信美好的事情即将发生。