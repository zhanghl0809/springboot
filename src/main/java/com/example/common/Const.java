/*
 * Copyright 2014-2018 buyforyou.cn. All rights reserved.
 */
package com.example.common;

import java.util.List;

/**
 * @author LGD
 * @since 1.8
 */
public class Const {
	/**
	 * 帮你盈图片服务器约定项目代码
	 */
	public static final String FILE_SERVICE_PROJECT_NAME = "aipc";

	/**
	 * 帮你盈图片服务器约定缩放代码
	 */
	public static final String FILE_SERVICE_PROJECT_ZOOM_140 = "avatar";

	/**
	 * 帮你盈图片服务器上传成功代码
	 */
	public static final String FILE_SERVICE_SUCCESS_CODE = "0";

	/**
	 * 成功响应头状态
	 */
	public final static String NORMAL_CODE = "PR0000";
	/**
	 * 失败响应头状态
	 */
	public final static String ERR_CODE = "9999";
	
	/**
	 * 商户重新登陆的标识
	 */
	public final static String AGAIN_LOGIN_CODE = "8888";

	/**
	 * 成功标志位
	 */
	public final static String SUCCESS_FLAG = "0";
	/**
	 * 失败标志位
	 */
	public final static String FAILD_FLAG = "1";

	/**
	 * 商户端标识
	 */
	public final static String MERCHANT_FLAG = "merchant";
	/**
	 * 客户端标识
	 */
	public final static String CUSTOMER_FLAG = "customer";
	/**
	 * 员工端标识
	 */
	public final static String WORKER_FLAG = "worker";

	/**
	 * 员工端标识
	 */
	public final static String MIDS_FLAG = "mids";

	/** 文件存储常量 */
	/**
	 * 企业营业执照
	 **/
	public final static String TB_UNION_FILE_FILETYPE_0 = "0";
	/**
	 * 店铺照片
	 **/
	public final static String TB_UNION_FILE_FILETYPE_1 = "1";
	/**
	 * 身份证照片正面
	 **/
	public final static String TB_UNION_FILE_FILETYPE_2 = "2";
	/**
	 * 身份证照片反面
	 **/
	public final static String TB_UNION_FILE_FILETYPE_3 = "3";
	/**
	 * 其他
	 **/
	public final static String TB_UNION_FILE_FILETYPE_4 = "4";
	/**
	 * 商户店内图片
	 **/
	public final static String TB_UNION_FILE_FILETYPE_5 = "5";
	/**
	 * 商户商品券图片
	 **/
	public final static String TB_UNION_FILE_FILETYPE_7 = "7";


	/**
	 * 商品券常量
	 */
	public final static String TB_UNION_MERCHANT_PRODUCT_0 = "0";// 已下架
	public final static String TB_UNION_MERCHANT_PRODUCT_1 = "1";// 已上架

	/**
	 * 商品券兑换记录常量
	 */
	public final static String TB_UNION_PRODUCT_RECORD_0 = "0";// 待核销
	public final static String TB_UNION_PRODUCT_RECORD_1 = "1";// 已核销
	public final static String TB_UNION_PRODUCT_RECORD_2 = "2";// 已失效

	/**
	 * 密码登录标志位
	 */
	public final static String LOGIN_PW = "0";
	/**
	 * 短信登录标志位
	 */
	public final static String LOGIN_SMS = "1";
	/**
	 * 验证码 类型 a登录
	 */
	public final static String VERIFICATION_CODE_TYPE_A = "a";
	/**
	 * 验证码 类型 b更改密码
	 */
	public final static String VERIFICATION_CODE_TYPE_B = "b";
	/**
	 * 验证码 类型 c注册
	 */
	public final static String VERIFICATION_CODE_TYPE_C = "c";
	/**
	 * 验证码 类型 d付款
	 */
	public final static String VERIFICATION_CODE_TYPE_D = "d";
	/**
	 * 验证码 类型 商户自主开户
	 */
	public final static String VERIFICATION_CODE_TYPE_E = "e";

	/**
	 * 登录类型（0验证码登录1微信手机号登录2密码登陆）
	 */
	public final static String TB_UNION_LOGIN_CODE_0 = "0";// 验证码登录
	public final static String TB_UNION_LOGIN_MOBILE_1 = "1";// 微信手机号登录
	public final static String TB_UNION_LOGIN_PASSWORD_2 = "2";// 密码登陆

	/**
	 * 登录类型(0、员工端1、客户端2、商户端)
	 */
	public final static String TB_TYPE_LOGIN_STAFF_0 = "0";// 员工端
	public final static String TB_TYPE_LOGIN_CLIENT_1 = "1";// 客户端
	public final static String TB_TYPE_LOGIN_STORE_2 = "2";// 商户端

	/**
	 * 审核终极状态 0待审核
	 */
	public final static String MERCHANT_CHECK_STATUS_0 = "0";
	/**
	 * 审核终极状态 1已通过
	 */
	public final static String MERCHANT_CHECK_STATUS_1 = "1";
	/**
	 * 审核终极状态 2未通过
	 */
	public final static String MERCHANT_CHECK_STATUS_2 = "2";
	/**
	 * 审核终极状态 3法审待面审
	 */
	// public final static String MERCHANT_CHECK_STATUS_3 = "3";
	/**
	 * 审核终极状态 4面审待法审
	 */
	// public final static String MERCHANT_CHECK_STATUS_4 = "4";

	/**
	 * 商户信息 状态 审核中
	 */
	public final static String MERCHANT_INFO_CHECK_STATUS_3 = "3";
	/**
	 * 商户信息 状态 未通过
	 */
	public final static String MERCHANT_INFO_CHECK_STATUS_2 = "2";

	/**
	 * 存在
	 */
	public final static String EXIST = "1";
	/**
	 * 不存在
	 */
	public final static String INEXISTENCE = "0";

	// 面审结果
	/**
	 * 2 不通过
	 */
	public final static String FACE_TRIAL__2 = "2";

	/**
	 * 1 通过
	 */
	public final static String FACE_TRIAL__1 = "1";

	// 客户经理审核状态
	/**
	 * 0待审核
	 */
	public final static String MANAGER_AUDIT_STATUS_0 = "0";
	/**
	 * 1已通过
	 */
	public final static String MANAGER_AUDIT_STATUS_1 = "1";
	/**
	 * 2未通过
	 */
	public final static String MANAGER_AUDIT_STATUS_2 = "2";

	// 审核终极状态
	/**
	 * 0待审核
	 */
	public final static String AUDIT_ULTIMATE_STATUS_0 = "0";
	/**
	 * 1已通过
	 */
	public final static String AUDIT_ULTIMATE_STATUS_1 = "1";
	/**
	 * 2未通过
	 */
	public final static String AUDIT_ULTIMATE_STATUS_2 = "2";
	/**
	 * 3法审待面审
	 */
	public final static String AUDIT_ULTIMATE_STATUS_3 = "3";
	/**
	 * 4面审待法审
	 */
	public final static String AUDIT_ULTIMATE_STATUS_4 = "4";

	/**
	 * 商户状态 0封店
	 */
	public final static String MERCHANT__STATUS_0 = "0";
	/**
	 * 商户状态 1正常
	 */
	public final static String MERCHANT__STATUS_1 = "1";
	/**
	 * 商户状态 2冻结
	 */
	public final static String MERCHANT__STATUS_2 = "2";
	/**
	 * 商户状态 3注销
	 */
	public final static String MERCHANT__STATUS_3 = "3";
	/**
	 * 商户营业状态 0休息中
	 */
	public final static String MERCHANT_BUSINESS_STATUS_0 = "0";
	/**
	 * 商户营业状态 1营业中
	 */
	public final static String MERCHANT_BUSINESS_STATUS_1 = "1";

	// 积分变动类型
	/**
	 * 0 加分
	 */
	public final static String INTEGRAL_CHANGE_TYPE_0 = "0";

	/**
	 * 1 减分
	 */
	public final static String INTEGRAL_CHANGE_TYPE_1 = "1";

	// 是否阅读
	/**
	 * 0未阅读
	 */
	public final static String WHETHER_TO_READ_0 = "0";

	/**
	 * 1已经阅读
	 */
	public final static String WHETHER_TO_READ_1 = "1";

	// 积分规则类型
	/**
	 * 0 固定积分
	 */
	public final static String INTEGRATION_RULE_TYPE_0 = "0";

	/**
	 * 1 非固定积分
	 */
	public final static String INTEGRATION_RULE_TYPE_1 = "1";

	// 首次进入系统标识
	/**
	 * 0客户经理
	 */
	public final static String FIRST_ACCESS_SYSTEM_0 = "0";

	/**
	 * 1商户
	 */
	public final static String FIRST_ACCESS_SYSTEM_1 = "1";

	/**
	 * 2散户
	 */
	public final static String FIRST_ACCESS_SYSTEM_2 = "2";

	// 积分状态
	/**
	 * 0 正常
	 */
	public final static String INTEGRAL_STATE_0 = "0";

	/**
	 * 1 黑名单
	 */
	public final static String INTEGRAL_STATE_1 = "1";

	// 核销状态
	/**
	 * 0待核销
	 */
	public final static String VERIFICATION_OF_STATE_0 = "0";

	/**
	 * 1已核销/已使用
	 */
	public final static String VERIFICATION_OF_STATE_1 = "1";

	/**
	 * 2已失效
	 */
	public final static String VERIFICATION_OF_STATE_2 = "2";

	// 任务状态( )
	/**
	 * 1 未开始
	 */
	public final static String TASK_OF_STATUS_1 = "1";

	/**
	 * 2 进行中
	 */
	public final static String TASK_OF_STATUS_2 = "2";

	/**
	 * 3 结束
	 */
	public final static String TASK_OF_STATUS_3 = "3";

	// 活动状态( )
	/**
	 * 1 未开始
	 */
	public final static String ACTIVITY_OF_STATUS_0 = "0";

	/**
	 * 2已开始
	 */
	public final static String ACTIVITY_OF_STATUS_1 = "1";

	/**
	 * 3 已结束
	 */
	public final static String ACTIVITY_OF_STATUS_2 = "2";

	// 任务完成状态
	/**
	 * 1.未完成
	 */
	public final static String FINISH_OF_STATUS_1 = "1";

	/**
	 * 2 完成
	 */
	public final static String FINISH_OF_STATUS_2 = "2";

	/**
	 * 3 超额
	 */
	public final static String FINISH_OF_STATUS_3 = "3";

	/**
	 * 首次进入系统标识 0客户经理
	 */
	public final static String FIRST_ENTGER_FLAG_0 = "0";
	/**
	 * 首次进入系统标识 1商户
	 */
	public final static String FIRST_ENTGER_FLAG_1 = "1";
	/**
	 * 首次进入系统标识 2散户
	 */
	public final static String FIRST_ENTGER_FLAG_2 = "2";
	/**
	 * 1 客户拉新
	 */
	public final static String TASK_OF_TYPE_1 = "1";

	/**
	 * 2 商户拉新
	 */
	public final static String TASK_OF_TYPE_2 = "2";

	/**
	 * 3 活动转发
	 */
	public final static String TASK_OF_TYPE_3 = "3";

	/**
	 * 任务规则记录 任务类型 2实名注册
	 */
	public final static String UNIONL_RULE_TYPE_2 = "2";
	/**
	 * 任务规则记录 任务类型 3消费活动
	 */
	public final static String UNIONL_RULE_TYPE_3 = "3";
	/**
	 * 任务规则记录 任务类型 浏览商品 规则类型：0：签到 1: 手机注册 2：实名认证 3：消费活动 4：注册回馈 5：开立银行卡 6：开立电子账户 7：问题反馈 8：浏览商品 9：浏览店铺 10：购买理财 11：定期存款
	 */
	public final static String UNIONL_RULE_TYPE_8 = "8";
	/**
	 * 任务规则记录 任务类型 浏览店铺 规则类型：0：签到 1: 手机注册 2：实名认证 3：消费活动 4：注册回馈 5：开立银行卡 6：开立电子账户 7：问题反馈 8：浏览商品 9：浏览店铺 10：购买理财 11：定期存款
	 */
	public final static String UNIONL_RULE_TYPE_9 = "9";

	public final static String NOT = "0";
	public final static String YES = "1";

	/*** 用户调用阿里云 1调用 身份证验证 2调用失信黑名单信息3四要素鉴权 **/
	public static final String RESULT_TYPE_1 = "1";
	public static final String RESULT_TYPE_2 = "2";
	public static final String RESULT_TYPE_3 = "3";

	/**
	 * 01 实名认证通过！ 实名认证通过！ 02 实名认证不通过！ 实名认证不通过！ 202 无法验证！ 无法验证！【军人转业，户口迁移等】 203 异常情况！ 异常情况！ 204 姓名格式不正确！ 姓名格式不正确！ 205
	 * 身份证格式不正确！ 身份证格式不正确！
	 */
	public static final String STATUS_01 = "01";
	public static final String STATUS_02 = "02";
	public static final String ER02_IDCARD_MSG = "实名认证不通过！";
	public static final String STATUS_IDCARD_202 = "202";
	public static final String ER202_IDCARD_MSG = "无法验证！【军人转业，户口迁移等】";
	public static final String STATUS_IDCARD_203 = "203";
	public static final String ER203_IDCARD_MSG = "异常情况";
	public static final String STATUS_IDCARD_204 = "204";
	public static final String ER204_IDCARD_MSG = "姓名格式不正确！";
	public static final String STATUS_IDCARD_205 = "205";
	public static final String ER205_IDCARD_MSG = "实名认证不通过！";

	/**
	 * 男性
	 */
	public static final String MAN = "1";
	/**
	 * 女性
	 */
	public static final String WOMAN = "0";
	/**
	 * 渠道来源 2 小程序
	 */
	public static final String SOURCE_FOR_SMALL_APP = "2";

	/**
	 * 无效的状态
	 */
	public static final String INVALID_STATUS = "1";
	/**
	 * 有效的状态
	 */
	public static final String VALID_STATUS = "0";
	/**
	 * 积分来源 1 小程序
	 */
	public static final Integer INTEGRAL_SOURCE_FOR_SMALL_APP = 1;
	/**
	 * 积分类型 1任务 2 消费 3 活动 4 注销返分 5其他
	 */
	public static final String INTEGRAL_TYPE_1 = "1";
	public static final String INTEGRAL_TYPE_2 = "2";
	public static final String INTEGRAL_TYPE_3 = "3";
	public static final String INTEGRAL_TYPE_4 = "4";
	public static final String INTEGRAL_TYPE_5 = "5";
	/**
	 * 积分 增加
	 */
	public static final String INTEGRAL_INCREASE = "0";
	/**
	 * 积分 减去
	 */
	public static final String INTEGRAL_SUBTRACT = "1";

	// 任务类型
	/**
	 * 0签到活动规则
	 */
	public static final String RULES_TYPE_0 = "0";
	/**
	 * 1 手机注册
	 */
	public static final String RULES_TYPE_1 = "1";
	/**
	 * 2 实名注册
	 */
	public static final String RULES_TYPE_2 = "2";
	/**
	 * 3 消费活动
	 */
	public static final String RULES_TYPE_3 = "3";

	/**
	 * 4 问题反馈
	 */
	public static final String RULES_TYPE_7 = "7";

	/**
	 * (原积分罐小程序appid和密码) 暂时停用 更改为客户端小程序秘钥 更改时间：2019-03-01 更改人：胡付景
	 */
	// public static final String SMALL_APPID = "wxdb980ca3e5b7dbfe";// 正式
	// public static final String APPID = "wxcd7ac89aafb77ab2";//测试号
	// public static final String SMALL_SECRET = "ae7bdccab8eaa617d53e8b213dfe7dad";// 正式

	/**
	 * 优惠券使用限制 0不限，1工作日，2周末，3自定义
	 */
	public static final String DISCOUNT_USE_LIMIT_0 = "0";
	public static final String DISCOUNT_USE_LIMIT_1 = "1";
	public static final String DISCOUNT_USE_LIMIT_2 = "2";
	public static final String DISCOUNT_USE_LIMIT_3 = "3";

	/**
	 * 日期类型地 ，1工作日，2周末，3节假日
	 */
	public static final String CALENDAR_PASS_FLAG_1 = "1";
	public static final String CALENDAR_PASS_FLAG_2 = "2";
	public static final String CALENDAR_PASS_FLAG_3 = "3";

	/**
	 * 优惠券有效类型：0有效天数，1截止时间，2有效区间
	 */
	public static final String DISCOUNT_VALID_TYPE_0 = "0";
	public static final String DISCOUNT_VALID_TYPE_1 = "1";
	public static final String DISCOUNT_VALID_TYPE_2 = "2";

	/**
	 * 优惠券领取客户类型：0所有客户，1首次注册客户，2实名客户，3实名绑卡客户，4N天未登录用户
	 */
	public static final String DISCOUNT_CUSTOMER_FLAG_0 = "0";
	public static final String DISCOUNT_CUSTOMER_FLAG_1 = "1";
	public static final String DISCOUNT_CUSTOMER_FLAG_2 = "2";
	public static final String DISCOUNT_CUSTOMER_FLAG_3 = "3";
	public static final String DISCOUNT_CUSTOMER_FLAG_4 = "4";

	/**
	 * 流水号生成规则功能号： 0001核销功能号,0002领取优惠券功能号
	 */
	public static final String FUNCTION_CODE_OFFS = "0001";
	public static final String FUNCTION_CODE_DRAW = "0002";

	/**
	 * 线上数据置顶标识 0未置顶 1置顶
	 **/
	public static final String ONLINE_STICK_0 = "0";
	public static final String ONLINE_STICK_1 = "1";

	/**
	 * 开始状态（0上线1下线）
	 **/
	public static final String INITIAL_STATE_0 = "0";
	public static final String INITIAL_STATE_1 = "1";

	/**
	 * 审核成功通知
	 */
	public final static String SCCUESS_CONTENT = "您发起的店铺入驻申请已审核通过，赶快去管理您的店铺吧~";

	/**
	 * 商户入驻成功之后通知修改营业时间
	 */
	public final static String SCCUESS_BUSINESS = "营业时间很重要，请及时调整营业时间！操作步骤：【点击店铺logo（头像）】-【点击营业时间】进行手动输入，例：周一至周五8:00-21:00；周六-周日8:00-23:00";
	/**
	 * 审核失败通知
	 */
	public final static String FAILED_CONTENT = "抱歉，您发起的店铺入驻申请已审核未通过，重新修改您的申报信息！原因：";

	/**
	 * VIP充值成功通知
	 */
	public final static String VIPVOUCHER_CONTENT = "尊重的用户，您已成功升级为VIP会员，到期日期%s，赶快开始您的会员之游吧！";

	/**
	 * 发送通知类别(0活动通知，1审核通知，2其他通知，3BD申请审核消息4商户充值通知）
	 */
	public final static String NOTIFY_CATEGORY_0 = "0";
	public final static String NOTIFY_CATEGORY_1 = "1";
	public final static String NOTIFY_CATEGORY_2 = "2";
	public final static String NOTIFY_CATEGORY_3 = "3";
	public final static String NOTIFY_CATEGORY_4 = "4";

	/*
	 * 渠道（0系统1短信2邮箱3客户经理）
	 */
	public final static String CONTACT_CHANNEL_0 = "0";
	/*
	 * 渠道（0系统1短信2邮箱3客户经理）
	 */
	public final static String CONTACT_CHANNEL_1 = "1";
	/*
	 * 渠道（0系统1短信2邮箱3客户经理）
	 */
	public final static String CONTACT_CHANNEL_2 = "2";
	/*
	 * 渠道（0系统1短信2邮箱3客户经理）
	 */
	public final static String CONTACT_CHANNEL_3 = "3";

	/**
	 * 类别（0营销、1提醒、2祝福、3预约）
	 */
	public final static String MESSAGE_TYPE_0 = "0";
	/**
	 * 类别（0营销、1提醒、2祝福、3预约）
	 */
	public final static String MESSAGE_TYPE_1 = "1";
	/**
	 * 类别（0营销、1提醒、2祝福、3预约）
	 */
	public final static String MESSAGE_TYPE_2 = "2";
	/**
	 * 类别（0营销、1提醒、2祝福 、3预约）
	 */
	public final static String MESSAGE_TYPE_3 = "3";

	/**
	 * 积分罐-员工端-营销日志 1 已完成
	 */
	public final static String MARKETINGLOG_STATUS_1 = "1";
	/**
	 * 积分罐-员工端-营销日志 0 待处理
	 */
	public final static String MARKETINGLOG_STATUS_0 = "0";

	/**
	 * 银行员工消息通知-服务类别-0-生日提醒
	 */
	public final static String USER_NOTICE_0 = "0";
	/**
	 * 银行员工消息通知-服务类别-1-产品到期提醒
	 */
	public final static String USER_NOTICE_1 = "1";

	/**
	 * 渠道来源：account_channel_0-线下
	 */
	public final static String ACCOUNT_CHANNEL_0 = "account_channel_0";
	/**
	 * 渠道来源：account_channel_1-服务号
	 */
	public final static String ACCOUNT_CHANNEL_1 = "account_channel_1";
	/**
	 * 渠道来源：account_channel_2-小程序
	 */
	public final static String ACCOUNT_CHANNEL_2 = "account_channel_2";

	/**
	 * 账户关联信息表 0:普通客户
	 */
	public final static String ACCOUNT_VALID_0 = "0";
	/**
	 * 1:有效客户
	 */
	public final static String ACCOUNT_VALID_1 = "1";
	/**
	 * 2:积分罐绑卡用户
	 */
	public final static String ACCOUNT_VALID_2 = "2";
	/**
	 * default password
	 */
	public final static String DEFAULT_PASSWORD = "000000";

	/**
	 * The company pay type 试用
	 */
	public final static String COMPANY_PAY_TYPE_0 = "0";
	/**
	 * The company pay type 付费
	 */
	public final static String COMPANY_PAY_TYPE_1 = "1";
	/**
	 * The company pay type 过期
	 */
	public final static String COMPANY_PAY_TYPE_2 = "2";

	/**
	 * 是否进入联盟（0-否，1-是）
	 */
	public final static String IS_LEAGUE_0 = "0";

	public final static String IS_LEAGUE_1 = "1";

	/**
	 * 是否存量(0存量，1推客) 0存量，1增量
	 */
	public final static String IS_PUSH_0 = "0";

	public final static String IS_PUSH_1 = "1";

	/**
	 * channel_html首次来源（页面）
	 */
	// 积分罐小程序首次进入
	public final static String CHANNEL_HTML_0 = "small_integral";
	// 小程序员工录入
	public final static String CHANNEL_HTML_1 = "user_online";
	// 商户手工录入
	public final static String CHANNEL_HTML_2 = "merchant_underline";

	/**
	 * 审核人员类型
	 */
	// 0客户经理
	public final static String EXAMINE_TYPE_0 = "0";
	// 1审核人员
	public final static String EXAMINE_TYPE_1 = "1";
	// 2运营人员
	public final static String EXAMINE_TYPE_2 = "2";
	// 3其他
	public final static String EXAMINE_TYPE_3 = "3";

	/**
	 * 申请类型
	 */
	// 0商户申请审核
	public final static String MERCHANT_EXAMINE_TYPE_0 = "0";

	// 1商户封店审核
	public final static String MERCHANT_EXAMINE_TYPE_1 = "1";

	/**
	 * 审核来源
	 */
	// 0小程序
	public final static String MERCHANT_EXAMINE_SOURCE_0 = "0";
	// 1后台
	public final static String MERCHANT_EXAMINE_SOURCE_1 = "1";

	/**
	 * 审核类型
	 */
	// 0 提交审核
	public final static String REVIEW_TYPE_0 = "0";
	// 1 法审
	public final static String REVIEW_TYPE_1 = "1";
	// 2 面审
	public final static String REVIEW_TYPE_2 = "2";
	// 3 审核通过
	public final static String REVIEW_TYPE_3 = "3";

	/**
	 * 客户类别（0商户客户，1公司推荐商户客户,2营销客户）
	 **/
	/** 0商户客户 **/
	public final static String MERCHANT_CUSTOMER_TYPE_0 = "0";
	/** 1公司推荐商户客户 **/
	public final static String MERCHANT_CUSTOMER_TYPE_1 = "1";

	/** 2 营销客户 **/
	public final static String MERCHANT_CUSTOMER_TYPE_2 = "2";

	/**
	 * 客户类型（0：我的客户 1：推荐客户）
	 **/
	// 0:我的客户
	public final static String MERCHANT_CUSTOMER_FORM_0 = "0";
	// 1:推荐客户
	public final static String MERCHANT_CUSTOMER_FORM_1 = "1";

	/**
	 * 是否推送（0否,1是）
	 **/
	// 0否
	public final static String WHETHER_TO_PUSH_0 = "0";
	// 1是
	public final static String WHETHER_TO_PUSH_1 = "1";

	// 2已核销权益
	public final static String WHETHER_TO_PUSH_2 = "2";

	/**
	 * 客户类别（0老客户，1新客户）
	 **/
	// 0 新客户
	public final static String MERCHANT_CUSTOMER_NEW_0 = "0";
	// 1 客户激活
	public final static String MERCHANT_CUSTOMER_OLD_1 = "1";
	// 2 维护营销
	public final static String MERCHANT_CUSTOMER_OLD_2 = "2";

	/**
	 * 是否删除（默认0,1已删除）
	 **/
	// 默认0
	public final static String DEL_FLAG_0 = "0";
	// 1已删除
	public final static String DEL_FLAG_1 = "1";

	/**
	 * 订单状态（0待支付,1已支付,2已取消,3支付异常）
	 **/
	// 0待支付
	public final static String ORDER_STATUS_0 = "0";
	// 1已支付
	public final static String ORDER_STATUS_1 = "1";
	// 2已完成
	public final static String ORDER_STATUS_2 = "2";
	// 3（已完成的订单）已失效
	public final static String ORDER_STATUS_3 = "3";
	// 4 手动取消订单
	public final static String ORDER_STATUS_4 = "4";
	// 5 未支付 失效订单
	public final static String ORDER_STATUS_5 = "5";
	/**
	 * 付费类型 0会员付费、1营销推送、2提醒服务
	 **/
	// 0会员付费
	public final static String PAYMENT_TYPE_0 = "0";
	// 1营销推送
	public final static String PAYMENT_TYPE_1 = "1";
	// 2提醒服务
	public final static String PAYMENT_TYPE_2 = "2";
	// 3活动支付
	public final static String PAYMENT_TYPE_3 = "3";

	/**
	 * 是否是会员(0否,1是)
	 **/
	// 0否
	public final static String IS_MEMBER_0 = "0";
	// 1是
	public final static String IS_MEMBER_1 = "1";

	/**
	 * 卷码前缀
	 **/
	// 银行礼品券
	public final static String COUPON_CODE_BC = "BC";
	// 商铺商品券
	public final static String COUPON_CODE_SC = "SC";
	// 商铺优惠券
	public final static String COUPON_CODE_SP = "SP";
	// 支付订单券
	public final static String COUPON_CODE_PO = "PO";
	/**
	 * 是否是会员(0否,1是)
	 **/
	// 0否 0未使用 0自己领
	public final static String IS_FLAG_0 = "0";
	// 1是 1已使用(已核销) 1参加点灯活动赠送 1绑卡 1领取优惠券成功
	public final static String IS_FLAG_1 = "1";
	// 2是 2未过期 2邀请别人参加活动成功消费返券
	public final static String IS_FLAG_2 = "2";
	/**
	 * 活动规则触发类型： 0不限，1仅一次,2每天
	 */
	public static final String ACTIVITY_RULE_DECTYPE_0 = "0";
	public static final String ACTIVITY_RULE_DECTYPE_1 = "1";
	public static final String ACTIVITY_RULE_DECTYPE_2 = "2";

	/**
	 * 模板发送类别（0用户登录）
	 */
	public static final String WECHAT_NOTE_TYPE_0 = "0";
	/**
	 * 模板发送类别（1积分变动通知）
	 */
	public static final String WECHAT_NOTE_TYPE_1 = "1";
	/**
	 * 模板发送类别（2系统未读消息提醒）
	 */
	public static final String WECHAT_NOTE_TYPE_2 = "2";

	public static final String WECHAT_NOTE_TYPE_ADD_INTEGRE = "获得积分";
	public static final String WECHAT_NOTE_TYPE_REDUCE_INTEGRE = "消费积分";

	/**
	 * 机构类型 1公司
	 */
	public static final String OFFICE_GRADE_1 = "1";
	/**
	 * 机构等级1一级
	 */
	public static final String OFFICE_TYPE_1 = "1";

	/**
	 * 推广方式（0小程序（客户端和员工端），1短信，2公众号，3广告）
	 */
	public static final String SPREAD_RULE_0 = "0";

	/**
	 * 接收人身份 1-客户经理
	 */
	public static final String RECEVICE_IDENTITY_1 = "1";

	/**
	 * 接收人身份 2-下级结构运营人员
	 */
	public static final String RECEVICE_IDENTITY_2 = "2";

	/**
	 * 类型（0短信,1短链接,2实名认证）
	 */
	public static final String PAY_DESC_TYPE_0 = "0";

	/**
	 * 类型（0短信,1短链接,2实名认证）
	 */
	public static final String PAY_DESC_TYPE_1 = "1";

	/**
	 * 是否启用商品券推送 0:否，1：是
	 * 
	 */
	public static final String PRODUCT_IS_OPEN_0 = "0";

	/**
	 * 是否启用商品券推送0:否，1：是
	 */
	public static final String PRODUCT_IS_OPEN_1 = "1";

	/**
	 * 0 待处理1 处理成功2.处理失败
	 */

	/**
	 * 0 待处理
	 */
	public static final String BATCH_STATUS_0 = "0";

	/**
	 * 1 处理成功
	 */
	public static final String BATCH_STATUS_1 = "1";

	/**
	 * 2.处理失败
	 */
	public static final String BATCH_STATUS_2 = "2";

	/**
	 * 余额提醒服务短信模板
	 */
	public static final String BALANCE_REMIND_MODEL = "c0fde0e3b6c249c0b700eae0409c3dd9";

	/**
	 * 模板类型 1：银行,0:商户
	 */

	/**
	 * 0:商户
	 */
	public static final String ORG_TYPE_0 = "0";

	/**
	 * 1：银行
	 */
	public static final String ORG_TYPE_1 = "1";

	/**
	 * 是否从模板库中选择 0:从模板库中选择，1：自定义
	 */

	/**
	 * 0:从模板库中选择
	 */
	public static final String IS_OPTION_0 = "0";

	/**
	 * 1：自定义
	 */
	public static final String IS_OPTION_1 = "1";

	/**
	 * 邀请有礼状态 状态 0 已结束 1进行中
	 */

	/**
	 * 0 已结束
	 */
	public static final String GIFT_STATUS_0 = "0";

	/**
	 * 1进行中
	 */
	public static final String GIFT_STATUS_1 = "1";

	/**
	 * 轮播标识 0未开启 1开启
	 */

	/**
	 * 0 未开启
	 */
	public static final String NOTICE_FLAG_0 = "0";

	/**
	 * 1 开启
	 */
	public static final String NOTICE_FLAG_1 = "1";

	/**
	 * 未进入联盟客户为新客户 0：新客户,1:老客户
	 */

	/**
	 * 0：新客户
	 */
	public static final String IS_NEW_0 = "0";

	/**
	 * 1:老客户
	 */
	public static final String IS_NEW_1 = "1";

	/**
	 * 商户入驻类型 0:直接入驻，1：扫码入驻
	 */

	/**
	 * 0:直接入驻
	 */
	public static final String ENTER_TYPE_0 = "0";

	/**
	 * 1：扫码入驻
	 */
	public static final String ENTER_TYPE_1 = "1";

	/**
	 * 是否可登录 1:可以登录 0：禁止登录
	 */
	// 1:可以登录
	public static final String LOGIN_FLAG_1 = "1";

	// 0：禁止登录
	public static final String LOGIN_FLAG_0 = "0";

	/**
	 * 提示语类型:0:智能客服欢迎语 1:智能客服未识别消息 2:反馈[解决]回复语 3：反馈[未解决]回复语
	 */
	// 0:智能客服欢迎语
	public static final String Intelligent_type_0 = "0";

	// 1:智能客服未识别消息
	public static final String Intelligent_type_1 = "1";

	/**
	 * 浏览类型:1：商品详情浏览 2、商户详情信息浏览
	 */
	public static String BROWSE_TYPE_1 = "1";

	/**
	 * 浏览类型:1：商品详情浏览 2、商户详情信息浏览
	 */
	public static final String BROWSE_TYPE_2 = "2";
	// 2:反馈[解决]回复语
	public static final String Intelligent_type_2 = "2";

	// 3：反馈[未解决]回复语
	public static final String Intelligent_type_3 = "3";

	/**
	 * 解答状态 0：未匹配 1:未解决 2：已解决
	 */
	// 0：未匹配
	public static final String SOLUTION_STATE_0 = "0";

	// 1:未解决
	public static final String SOLUTION_STATE_1 = "1";

	// 2：已解决
	public static final String SOLUTION_STATE_2 = "2";

	/**
	 *
	 * 机构类型 [1] string 1银行，2商户
	 */
	// 1银行
	public static final String ORGANIZATION_TYPE_1 = "1";

	// 2商户
	public static final String ORGANIZATION_TYPE_2 = "2";

	/**
	 * awardsType 奖品类型 [1] string 1积分，2优惠券,3礼品券,4商品券
	 */

	// 1积分
	public static final String awards_type_1 = "1";

	// 2优惠券
	public static final String awards_type_2 = "2";

	// 3礼品券
	public static final String awards_type_3 = "3";

	// 4商品券
	public static final String awards_type_4 = "4";
	/**
	 * 浏览基础积分
	 */
	public static final int BROWSE_INTEGRAL = 10;
	/**
	 * 浏览获取积分开关 true 打开
	 */
	public static final Boolean BROWSE_INTEGRAL_ON = true;

	/**************************
	 * 员工端客户金融标签分类驾驶舱
	 ***************************************************************************/
	/**
	 * 金融标签分类：贵宾客户VIP
	 */
	public static final String FINANCE_VIP = "VIP";

	/**
	 * 金融标签分类：理财客户
	 */
	public static final String FINANCE_FINANCIAL = "financial";
	/**
	 * 金融标签分类：贷款客户
	 */
	public static final String FINANCE_LOANS = "loans";
	/**
	 * 金融标签：普通客户
	 */
	public static final String FINANCE_GENERAL = "general";

	/**
	 * 是否一键推送：0：自定义，1：一键拉新
	 */
	// 0：自定义
	public static final String PUSH_CATEGORY_0 = "0";

	// 1：一键拉新
	public static final String PUSH_CATEGORY_1 = "1";

	/**
	 * 发送场景(0产品营销,1节日营销,2活动推广,3生日提醒4到期提醒5商户激活6季节营销—默认0)
	 */
	public static final String SEND_SCENE_1 = "1";

	public static final String SEND_SCENE_6 = "6";


	/**
	 * 智库接口响应成功状态
	 */
	public static final String AIPC_MIDS_SUCCEED = "2000";

	/**
	 * 客户位置信息使用队列信息
	 */
	public static final String AIPC_CUSTOMER_LOCATION_EXCHANGE = "aipc.ex.spread";
	public static final String AIPC_CUSTOMER_LOCATION_KEY = "aipc.location.message.key";

	/**
	 * 推送类型 2推送商品券信息
	 */
	public static final String PUSH_TYPE_2 = "2";

	/**
	 * 客户预约类型：预约开储蓄卡 0预约开储蓄卡，1预约信用卡，2预约理财，3预约贷款，4预约停车位
	 */
	public static final String CUSTOMER_RESERVATION_0 = "0";
	/**
	 * 客户预约类型 ：预约信用卡 0预约开储蓄卡，1预约信用卡，2预约理财，3预约贷款，4预约停车位
	 */
	public static final String CUSTOMER_RESERVATION_1 = "1";
	/**
	 * 客户预约类型：预约理财 0预约开储蓄卡，1预约信用卡，2预约理财，3预约贷款，4预约停车位
	 */
	public static final String CUSTOMER_RESERVATION_2 = "2";
	/**
	 * 客户预约类型：预约贷款 0预约开储蓄卡，1预约信用卡，2预约理财，3预约贷款，4预约停车位
	 */
	public static final String CUSTOMER_RESERVATION_3 = "3";
	/**
	 * 客户预约类型：预约停车位 0预约开储蓄卡，1预约信用卡，2预约理财，3预约贷款，4预约停车位
	 */
	public static final String CUSTOMER_RESERVATION_4 = "4";

	/**
	 * 是否默认收货地址 0:不默认,1:默认
	 */
	public static final String TACITLY_APPROVE_0 = "0";

	public static final String TACITLY_APPROVE_1 = "1";

	/**
	 * 客户端支付：订单状态（订单状态（0待付款、1已支付、2(已完成)已核销、3已失效(支付完成未核销) 4未支付手动取消 5未支付系统自动取消））
	 **/

	public static final String ORDER_PAY_TYPE_0 = "0";

	public static final String ORDER_PAY_TYPE_1 = "1";

	public static final String ORDER_PAY_TYPE_2 = "2";
	public static final String ORDER_PAY_TYPE_3 = "3";
	public static final String ORDER_PAY_TYPE_4 = "4";
	public static final String ORDER_PAY_TYPE_5 = "5";
	/**
	 * 代金券信息标识 SG单品代金券
	 */
	public static final String VOUCHER_SINGLE = "SG_";
	/**
	 * 客户浏览商品时，贴标签或者增加权重
	 */
	public static final String AIPC_CUSTOMER_TAGS_EXCHANGE = "aipc.ex.spread";
	public static final String AIPC_CUSTOMER_TAGS = "aipc.tags.message.key";

	/**
	 * 券核销时，将券信息放入MQ
	 */
	public static final String AIPC_COUPON_CANCLE_EXCHANGE = "aipc.ex.spread";
	public static final String AIPC_COUPON_CANCLE = "aipc.coupon.cancle.key";

	/**
	 * 是否被收藏.1:收藏
	 */
	public static final String IS_COLLECT = "1";
	public static final String NOT_COLLECT = "0";

	public static final String SENSITIVE_EXCEPTION_PROMPTING_LANGUAGE="请求参数存在敏感词，请重新输入";
}
