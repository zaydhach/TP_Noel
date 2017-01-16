package noel.business;

public class PriceCalculator implements StrategyPriceCalculator
{

	@Override
	public double calculatePrice(Long oldPrice, Long oldQuantity, Long newQuantity) {	
		return (oldPrice*oldQuantity)/newQuantity ;
	}
	
}