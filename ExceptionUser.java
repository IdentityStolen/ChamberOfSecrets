/**
 * 
 */
package com.learn;

/**
 * @author SK030960
 *
 */
public class ExceptionUser {

	/**
	 * @param args
	 */
	public void numCheck(Integer i) throws ExceptionLearner {
		if (i < 0) {
			ExceptionLearner ex = new ExceptionLearner("Number can't be negetive.");
			throw ex;
		}
	}
	
//	public <T> T getT(){
//		T apun = null;
//		return apun;
//	}
//	
//	public <T> void putT(T apun){
//		T a = apun;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionUser u = new ExceptionUser();
		try {
			u.numCheck(-3);
		}
		catch (ExceptionLearner ex) {
			// TODO: handle exception
			System.out.print("Exception occured : ");
			ex.printMessage();;
		}
	}

}
