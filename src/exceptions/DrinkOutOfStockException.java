package exceptions;

@SuppressWarnings("serial")
public class DrinkOutOfStockException extends Exception {
	public DrinkOutOfStockException(String message){
		super(message);
	}
}