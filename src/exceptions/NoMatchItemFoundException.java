package exceptions;

@SuppressWarnings("serial")
public class NoMatchItemFoundException extends Exception {
	public NoMatchItemFoundException(String message){
		super(message);
	}
}
