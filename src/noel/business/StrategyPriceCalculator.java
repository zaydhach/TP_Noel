package noel.business;

public interface StrategyPriceCalculator {

	public double calculatePrice(Long oldprice,Long oldQt,Long qtCom);
}
