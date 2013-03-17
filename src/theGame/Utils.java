package theGame;

public class Utils {

	public static final String stringTest(String testString){
		if(testString.length() > 0){
			return testString;
		}else{
			return "Unspecified";
		}
	}
	
	public static final int intTest(int testInt){
		if (testInt > 0){
			return testInt;
		}else{
			return 0;
		}
	}
}
