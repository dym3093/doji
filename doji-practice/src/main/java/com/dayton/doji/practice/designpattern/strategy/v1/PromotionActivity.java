package com.dayton.doji.practice.designpattern.strategy.v1;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:57
 */
public class PromotionActivity {

	private PromotionStrategy promotionStrategy;

	public PromotionActivity(PromotionStrategy promotionStrategy) {
		this.promotionStrategy = promotionStrategy;
	}

	public void execute(){
		promotionStrategy.doPromotion();
	}

}
