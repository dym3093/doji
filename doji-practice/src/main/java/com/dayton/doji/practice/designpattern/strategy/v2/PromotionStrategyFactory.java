package com.dayton.doji.practice.designpattern.strategy.v2;

import com.dayton.doji.practice.designpattern.strategy.v1.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 促销策略工厂模式：<br/>
 * 结合单例模式和工厂模式进行优化的结果。<br/>
 * @author Martin Deng
 * @since 2020-08-24 21:26
 */
public class PromotionStrategyFactory {

	private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
	static {
		PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
		PROMOTION_STRATEGY_MAP.put(PromotionKey.CASH_BACK, new CashbackStrategy());
		PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUP_BUY, new GroupBuyStrategy());
	}

	private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

	private PromotionStrategyFactory(){}

	public static PromotionStrategy getPromotionStrategy(String promotionKey){
		PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get
				(promotionKey);
		return promotionStrategy==null ? NON_PROMOTION : promotionStrategy;
	}

	private interface  PromotionKey{
		String COUPON = "COUPON";
		String CASH_BACK = "CASH_BACK";
		String GROUP_BUY = "GROUP_BUY";
	}

}
