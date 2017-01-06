package com.thoth.domain;

public class ThSnOrder
{
	/**
	 *  作业状态（T-正常；F-废弃）
	 */
	private String workstatus;// 作业状态（T-正常；F-废弃）
	/**
	 *  作业单号(客户包裹号)
	 */
	private String workid;// 作业单号(客户包裹号)
	/**
	 *  作业类型(01-送件;01-换件;02-取件)
	 */
	private String worktype;// 作业类型(01-送件;01-换件;02-取件)
	/**
	 *  期望作业日期YYYY-MM-DD
	 */
	private String plandate;// 期望作业日期YYYY-MM-DD
	/**
	 *  期望作业时间(HH:mm:ss)
	 */
	private String plantime;// 期望作业时间(HH:mm:ss)
	/**
	 *  代收货款方式（POS；现金；扫码支付）
	 */
	private String paytype;// 代收货款方式（POS；现金；扫码支付）
	/**
	 *  代收付款金额（元）
	 */
	private Double ownmoney;// 代收付款金额（元）
	/**
	 *  作业绑定标识（客户单号）
	 */
	private String workrelaid;// 作业绑定标识（客户单号）
	/**
	 *  签回单标识(暂为空)
	 */
	private String workbacksignId;// 签回单标识(暂为空)
	/**
	 *  校验码
	 */
	private String checkcode;// 校验码
	/**
	 *  所属物流中心（分仓标识）
	 */
	private String weakid;// 所属物流中心（分仓标识）
	/**
	 *  所属K点（分拣编码 BBC BBCL BDBDDDL 与物流中心必有一个不为空）
	 */
	private String zexid;// 所属K点（分拣编码 BBC BBCL BDBDDDL 与物流中心必有一个不为空）
	/**
	 *  包裹重量（KG）
	 */
	private Double packweight;// 包裹重量（KG）
	/**
	 *  包裹体积（CCM）
	 */
	private String packvolume;// 包裹体积（CCM）
	/**
	 *  包裹长（CM）
	 */
	private String packlength;// 包裹长（CM）
	/**
	 *  包裹宽（CM）
	 */
	private String packwidth;// 包裹宽（CM）
	/**
	 *  包裹高（CM）
	 */
	private String packheight;// 包裹高（CM）
	/**
	 *  保价标识(暂为空)
	 */
	private String supportvalueTag;// 保价标识(暂为空)
	/**
	 *  订单价值（元）
	 */
	private Double ordervalue;// 订单价值（元）
	/**
	 *  商品描述
	 */
	private String commdtyname;// 商品描述
	/**
	 *  商品数量（3位整数）
	 */
	private Integer commdtynum;// 商品数量（3位整数）
	/**
	 *  备注
	 */
	private String mark;// 备注
	/**
	 *  收货省文本
	 */
	private String provincename;// 收货省文本
	/**
	 *  收货城市文本
	 */
	private String cityname;// 收货城市文本
	/**
	 *  收货详细地址文本
	 */
	private String adress;// 收货详细地址文本
	/**
	 *  邮编
	 */
	private String postalcode;// 邮编
	/**
	 *  收货区/县文本
	 */
	private String areaname;// 收货区/县文本
	/**
	 * 收货人手机号码
	 */
	private String mobilephone;// 收货人手机号码
	/**
	 *  顾客姓名
	 */
	private String customename;// 顾客姓名
	/**
	 *  自提点编码
	 */
	private String site;// 自提点编码
	/**
	 *  一票多件总包裹数
	 */
	private Integer totalpalnumber;// 一票多件总包裹数
	/**
	 *  换货单号
	 */
	private String exchangecode;// 换货单号
	/**
	 * 购物包裹总数
	 */
	private String totalspnumber;// 购物包裹总数
	/**
	 *  换单标识(0-不换；1-换)
	 */
	private Integer trade;// 换单标识(0-不换；1-换)
	/**
	 *  总重量
	 */
	private Double totalweight;// 总重量
	/**
	 *  下单时间
	 */
	private String ordertime;// 下单时间
	/**
	 *  发票状态（0-普；1-增）
	 */
	private Integer invoicestatus;// 发票状态（0-普；1-增）
	/**
	 *  购物车编号
	 */
	private String shopcartnumber;// 购物车编号
	/**
	 *  服务代理号
	 */
	private String agentnumber;// 服务代理号
	/**
	 *  包裹完整
	 */
	private Integer pagefull;// 包裹完整
	/**
	 *  来源
	 */
	private String source;// 来源
	/**
	 *  代收货款合计（新增）
	 */
	private Double totalownmoney;// 代收货款合计（新增）
	/**
	 *  包裹合并标识（1-合包；0-不合包）（新增）
	 */
	private Integer pagemerge;// 包裹合并标识（1-合包；0-不合包）（新增）
	/**
	 *  代收货款合并（1-合包；0-不合包）（新增）
	 */
	private Integer moneymerge;// 代收货款合并（1-合包；0-不合包）（新增）


	/**
	 * 获取  作业状态（T-正常；F-废弃）
	 */
	public String getWorkstatus() {
		return this.workstatus;
	}

	/**
	 * 设置  作业状态（T-正常；F-废弃）
	 */
	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	/**
	 * 获取  作业单号(客户包裹号)
	 */
	public String getWorkid() {
		return this.workid;
	}

	/**
	 * 设置  作业单号(客户包裹号)
	 */
	public void setWorkid(String workid) {
		this.workid = workid;
	}

	/**
	 * 获取  作业类型(01-送件;01-换件;02-取件)
	 */
	public String getWorktype() {
		return this.worktype;
	}

	/**
	 * 设置  作业类型(01-送件;01-换件;02-取件)
	 */
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	/**
	 * 获取  期望作业日期YYYY-MM-DD
	 */
	public String getPlandate() {
		return this.plandate;
	}

	/**
	 * 设置  期望作业日期YYYY-MM-DD
	 */
	public void setPlandate(String plandate) {
		this.plandate = plandate;
	}

	/**
	 * 获取  期望作业时间(HH:mm:ss)
	 */
	public String getPlantime() {
		return this.plantime;
	}

	/**
	 * 设置  期望作业时间(HH:mm:ss)
	 */
	public void setPlantime(String plantime) {
		this.plantime = plantime;
	}

	/**
	 * 获取  代收货款方式（POS；现金；扫码支付）
	 */
	public String getPaytype() {
		return this.paytype;
	}

	/**
	 * 设置  代收货款方式（POS；现金；扫码支付）
	 */
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	/**
	 * 获取  代收付款金额（元）
	 */
	public Double getOwnmoney() {
		return this.ownmoney;
	}

	/**
	 * 设置  代收付款金额（元）
	 */
	public void setOwnmoney(Double ownmoney) {
		this.ownmoney = ownmoney;
	}

	/**
	 * 获取  作业绑定标识（客户单号）
	 */
	public String getWorkrelaid() {
		return this.workrelaid;
	}

	/**
	 * 设置  作业绑定标识（客户单号）
	 */
	public void setWorkrelaid(String workrelaid) {
		this.workrelaid = workrelaid;
	}

	/**
	 * 获取  签回单标识(暂为空)
	 */
	public String getWorkbacksignId() {
		return this.workbacksignId;
	}

	/**
	 * 设置  签回单标识(暂为空)
	 */
	public void setWorkbacksignId(String workbacksignId) {
		this.workbacksignId = workbacksignId;
	}

	/**
	 * 获取  校验码
	 */
	public String getCheckcode() {
		return this.checkcode;
	}

	/**
	 * 设置  校验码
	 */
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	/**
	 * 获取  所属物流中心（分仓标识）
	 */
	public String getWeakid() {
		return this.weakid;
	}

	/**
	 * 设置  所属物流中心（分仓标识）
	 */
	public void setWeakid(String weakid) {
		this.weakid = weakid;
	}

	/**
	 * 获取  所属K点（分拣编码 BBC BBCL BDBDDDL 与物流中心必有一个不为空）
	 */
	public String getZexid() {
		return this.zexid;
	}

	/**
	 * 设置  所属K点（分拣编码 BBC BBCL BDBDDDL 与物流中心必有一个不为空）
	 */
	public void setZexid(String zexid) {
		this.zexid = zexid;
	}

	/**
	 * 获取  包裹重量（KG）
	 */
	public Double getPackweight() {
		return this.packweight;
	}

	/**
	 * 设置  包裹重量（KG）
	 */
	public void setPackweight(Double packweight) {
		this.packweight = packweight;
	}

	/**
	 * 获取  包裹体积（CCM）
	 */
	public String getPackvolume() {
		return this.packvolume;
	}

	/**
	 * 设置  包裹体积（CCM）
	 */
	public void setPackvolume(String packvolume) {
		this.packvolume = packvolume;
	}

	/**
	 * 获取  包裹长（CM）
	 */
	public String getPacklength() {
		return this.packlength;
	}

	/**
	 * 设置  包裹长（CM）
	 */
	public void setPacklength(String packlength) {
		this.packlength = packlength;
	}

	/**
	 * 获取  包裹宽（CM）
	 */
	public String getPackwidth() {
		return this.packwidth;
	}

	/**
	 * 设置  包裹宽（CM）
	 */
	public void setPackwidth(String packwidth) {
		this.packwidth = packwidth;
	}

	/**
	 * 获取  包裹高（CM）
	 */
	public String getPackheight() {
		return this.packheight;
	}

	/**
	 * 设置  包裹高（CM）
	 */
	public void setPackheight(String packheight) {
		this.packheight = packheight;
	}

	/**
	 * 获取  保价标识(暂为空)
	 */
	public String getSupportvalueTag() {
		return this.supportvalueTag;
	}

	/**
	 * 设置  保价标识(暂为空)
	 */
	public void setSupportvalueTag(String supportvalueTag) {
		this.supportvalueTag = supportvalueTag;
	}

	/**
	 * 获取  订单价值（元）
	 */
	public Double getOrdervalue() {
		return this.ordervalue;
	}

	/**
	 * 设置  订单价值（元）
	 */
	public void setOrdervalue(Double ordervalue) {
		this.ordervalue = ordervalue;
	}

	/**
	 * 获取  商品描述
	 */
	public String getCommdtyname() {
		return this.commdtyname;
	}

	/**
	 * 设置  商品描述
	 */
	public void setCommdtyname(String commdtyname) {
		this.commdtyname = commdtyname;
	}

	/**
	 * 获取  商品数量（3位整数）
	 */
	public Integer getCommdtynum() {
		return this.commdtynum;
	}

	/**
	 * 设置  商品数量（3位整数）
	 */
	public void setCommdtynum(Integer commdtynum) {
		this.commdtynum = commdtynum;
	}

	/**
	 * 获取  备注
	 */
	public String getMark() {
		return this.mark;
	}

	/**
	 * 设置  备注
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * 获取  收货省文本
	 */
	public String getProvincename() {
		return this.provincename;
	}

	/**
	 * 设置  收货省文本
	 */
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	/**
	 * 获取  收货城市文本
	 */
	public String getCityname() {
		return this.cityname;
	}

	/**
	 * 设置  收货城市文本
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	/**
	 * 获取  收货详细地址文本
	 */
	public String getAdress() {
		return this.adress;
	}

	/**
	 * 设置  收货详细地址文本
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * 获取  邮编
	 */
	public String getPostalcode() {
		return this.postalcode;
	}

	/**
	 * 设置  邮编
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * 获取  收货区/县文本
	 */
	public String getAreaname() {
		return this.areaname;
	}

	/**
	 * 设置  收货区/县文本
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	/**
	 * 获取 收货人手机号码
	 */
	public String getMobilephone() {
		return this.mobilephone;
	}

	/**
	 * 设置 收货人手机号码
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	/**
	 * 获取  顾客姓名
	 */
	public String getCustomename() {
		return this.customename;
	}

	/**
	 * 设置  顾客姓名
	 */
	public void setCustomename(String customename) {
		this.customename = customename;
	}

	/**
	 * 获取  自提点编码
	 */
	public String getSite() {
		return this.site;
	}

	/**
	 * 设置  自提点编码
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * 获取  一票多件总包裹数
	 */
	public Integer getTotalpalnumber() {
		return this.totalpalnumber;
	}

	/**
	 * 设置  一票多件总包裹数
	 */
	public void setTotalpalnumber(Integer totalpalnumber) {
		this.totalpalnumber = totalpalnumber;
	}

	/**
	 * 获取  换货单号
	 */
	public String getExchangecode() {
		return this.exchangecode;
	}

	/**
	 * 设置  换货单号
	 */
	public void setExchangecode(String exchangecode) {
		this.exchangecode = exchangecode;
	}

	/**
	 * 获取 购物包裹总数
	 */
	public String getTotalspnumber() {
		return this.totalspnumber;
	}

	/**
	 * 设置 购物包裹总数
	 */
	public void setTotalspnumber(String totalspnumber) {
		this.totalspnumber = totalspnumber;
	}

	/**
	 * 获取  换单标识(0-不换；1-换)
	 */
	public Integer getTrade() {
		return this.trade;
	}

	/**
	 * 设置  换单标识(0-不换；1-换)
	 */
	public void setTrade(Integer trade) {
		this.trade = trade;
	}

	/**
	 * 获取  总重量
	 */
	public Double getTotalweight() {
		return this.totalweight;
	}

	/**
	 * 设置  总重量
	 */
	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}

	/**
	 * 获取  下单时间
	 */
	public String getOrdertime() {
		return this.ordertime;
	}

	/**
	 * 设置  下单时间
	 */
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * 获取  发票状态（0-普；1-增）
	 */
	public Integer getInvoicestatus() {
		return this.invoicestatus;
	}

	/**
	 * 设置  发票状态（0-普；1-增）
	 */
	public void setInvoicestatus(Integer invoicestatus) {
		this.invoicestatus = invoicestatus;
	}

	/**
	 * 获取  购物车编号
	 */
	public String getShopcartnumber() {
		return this.shopcartnumber;
	}

	/**
	 * 设置  购物车编号
	 */
	public void setShopcartnumber(String shopcartnumber) {
		this.shopcartnumber = shopcartnumber;
	}

	/**
	 * 获取  服务代理号
	 */
	public String getAgentnumber() {
		return this.agentnumber;
	}

	/**
	 * 设置  服务代理号
	 */
	public void setAgentnumber(String agentnumber) {
		this.agentnumber = agentnumber;
	}

	/**
	 * 获取  包裹完整
	 */
	public Integer getPagefull() {
		return this.pagefull;
	}

	/**
	 * 设置  包裹完整
	 */
	public void setPagefull(Integer pagefull) {
		this.pagefull = pagefull;
	}

	/**
	 * 获取  来源
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * 设置  来源
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 获取  代收货款合计（新增）
	 */
	public Double getTotalownmoney() {
		return this.totalownmoney;
	}

	/**
	 * 设置  代收货款合计（新增）
	 */
	public void setTotalownmoney(Double totalownmoney) {
		this.totalownmoney = totalownmoney;
	}

	/**
	 * 获取  包裹合并标识（1-合包；0-不合包）（新增）
	 */
	public Integer getPagemerge() {
		return this.pagemerge;
	}

	/**
	 * 设置  包裹合并标识（1-合包；0-不合包）（新增）
	 */
	public void setPagemerge(Integer pagemerge) {
		this.pagemerge = pagemerge;
	}

	/**
	 * 获取  代收货款合并（1-合包；0-不合包）（新增）
	 */
	public Integer getMoneymerge() {
		return this.moneymerge;
	}

	/**
	 * 设置  代收货款合并（1-合包；0-不合包）（新增）
	 */
	public void setMoneymerge(Integer moneymerge) {
		this.moneymerge = moneymerge;
	}
}
