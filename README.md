# SpringCloudProject
Spring Cloud 示例项目 
Spring Cloud 示例项目 

	edi-thoth-server	注册中心
	edi-thoth-config	配置中心
	edi-thoth-parent	maven base + 配置中心 配置文件
	edi-thoth-zuul		服务网关
		
	edi-thoth-webapi	微服务 数据接收  
		
		webapi 用于接收不同客户传递过来的 数据。
			
			存在的问题
				 传递的数据结构不同、
				 使用的验证方法不同、
				 响应的数据结构数据不同。
				 
			解决方法 
			
				将webapi “不确定” 的 方法 抽取出来， 交由  其他服务端来处理 
				
				使用mongodb 来维护一个用户集合，  获取请求ip 查询 mongodb 区分 不同用户 , 得到对应的  service-id 
				通过 service-id  调用不同的 服务端。
	
	edi-thoth-Interface	抽象接口定义 项目
		
		定义了 webapi 项目中 “不确定” 的 方法 接口
	
	edi-thoth-clientOrderA	测试服务端（客户A）
		
		实现了edi-thoth-Interface 项目中  webapi 项目定义的 接口方法，处理 客户A 对应的特殊逻辑。
		
	edi-thoth-clientOrderB	测试服务端（客户B）	
		
		实现了edi-thoth-Interface 项目中  webapi 项目定义的 接口方法，处理 客户B 对应的特殊逻辑。
	
	测试
	
		第一次调用 Ribbon 耗时将较长 800ms左右 ， 第二次后 将在8ms左右。（PS:服务端并未做复杂处理）
		
	建议
		
		edi-thoth-server 最好部署 3个 及以上 并且 每个 server 都在不同的服务器上
		edi-thoth-config 建议 同edi-thoth-server 共同部署 （PS 不考虑 高可用 确定不会宕机或宕机后续服务也因停止的部署另算）
		edi-thoth-zuul   zuul 对应的是 外部调用 最简单的可以理解为 需要 访问URl 。  zuul 高可以 目前找到的 只能通过网络层了，
	
		注意 这种方式开发其中存在的问题。 
			
		转载
		
			八大误区
			
			1.网络环境是可靠的
			2.延迟水平为零
			3.传输带宽是无限的
			4.网络环境是安全的
			5.拓扑结构不会变化
			6.总会有管理员帮助解决问题
			7.流量成本为零
			8.网络内各组成部分拥有同质性
	
		网上一直没有 Spring Cloud 完整的示例 。 即便有 也并不是很完整。 （目前为止）
	所有希望能做一套完整的示例项目出来。
	
	PS: 
	   Spring Cloud 学习推荐  
	   http://blog.didispace.com  程序猿DD 写的系类文章
	   http://www.cnblogs.com/skyblog/p/5127690.html   7天学会spring cloud教程
	   入门基本OK ，提升学习请看  Spring Cloud 官方文档。
	   
	   深入或提高 请详细看Spring Cloud 使用的对应项目 原项目 如 nginx 。
	   
	   http://bbs.springcloud.com.cn/ Spring Cloud中文社区  有问题 或者 发表点心得什么的。
	   
	   感谢 程序猿DD  和 lzhou666 等 至少我从他们的分享中 学习到了很多东西。
	   
	   
	
	
	
