package application;

public class InvalidGradeException extends Exception{
	public InvalidGradeException() {}
	public InvalidGradeException(String msg) {super(msg);}
	public InvalidGradeException(Throwable cause) {super(cause);}
	public InvalidGradeException(String msg, Throwable cause) {
		super(msg, cause);
	}
	public InvalidGradeException(String msg, Throwable cause, boolean enableSuppression, boolean writableStacktrace) {
		super(msg,cause,enableSuppression,writableStacktrace);
	}
	


}
