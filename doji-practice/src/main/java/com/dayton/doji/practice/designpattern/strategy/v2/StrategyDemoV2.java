package com.dayton.doji.practice.designpattern.strategy.v2;

import com.dayton.doji.practice.designpattern.strategy.v1.PromotionActivity;

/**
 * @author Martin Deng
 * @since 2020-08-24 21:35
 */
public class StrategyDemoV2 {

	public static void main(String[] args) {
		String promotionKey = "GROUP_BUY";
		PromotionActivity promotionActivity = new PromotionActivity
				(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
		promotionActivity.execute();
	}

}
