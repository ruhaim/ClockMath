import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ClockMath {
	static String time= "15:33";
	static int hour = 0;
	static int min = 0;
	static Scanner in;
	
	public static void main(String [] args){
      in = new Scanner(System.in);
      getInput();
      //runTests();
	}
	
	private static void getInput(){
		try{
			System.out.print("Please input a time (HHMM): ");
	    	  time = in.nextLine();
	    	  if(!time.matches("\\d{4}")){
	    		  throw new Exception("Invalid Format");
	    	  }
//	    	  String[] timeSpitArr = time.substring(0, 2);
	    	  hour = Integer.parseInt( time.substring(0, 2));
	    	  if(hour>24){
	    		  throw new Exception("Invalid Hour");
	    		  
	    	  }
	    	  min = Integer.parseInt(time.substring(2, 4));
	    	  if(min>60){
	    		  throw new Exception("Invalid Minutes");
	    		  
	    	  }
	    	  float simpleAngle = getAngleSimple(hour, min);
	    	  System.out.println("SIMPLE - Angle made by the hour and minute hands (degrees) : "+ simpleAngle);
	    	  
	    	  float realAngle = getAngleReal(hour, min);
	    	  System.out.println("REAL - Angle made by the hour and minute hands (degrees) : "+ realAngle);

//	    	  float realAngleSecMin = getAngleRealMinSec(hour, min, 47);
//	    	  System.out.println("REAL - Angle made by the minute and second hands (degrees) : "+ realAngleSecMin);
	    	  
	      }catch(Exception e){
	    	  System.out.println("ERROR : "+e.getMessage());
	    	  getInput();


	    	  
	      }
	}
	
	private static float getAngleSimple(int _hr, int _min){
		float angle = 0;
		
		
		float hourAngle = (_hr%12) * (360/12);
		float minAngle = (_min) * (360/60);
		
		angle = (hourAngle - minAngle);
		
		if(angle<0){
			angle = 360 + angle;
		}
		
		if(angle>180){
			angle = 360 - angle;
		}
		
		return angle;
		
		
	}
	private static float getAngleReal(int _hr, int _min){
		float angle = 0;
		
		
		float hourAngle = ((_hr%12) * (360/12)) + (_min*0.5f); 
		//(360/(12*60))
		float minAngle = (_min) * (360/60);
		
		angle = (hourAngle - minAngle);
		
		if(angle<0){
			angle = 360 + angle;
		}
		
		if(angle>180){
			angle = 360 - angle;
		}
		
		
		return angle;
		
		
	}
	
	private static float getAngleRealMinSec(int _min, int _sec){
		float angle = 0;
		
		
//		float hourAngle = ((_hr%12) * (360/12)) + (_min*0.5f); 
		//(360/(12*60))
		float minAngle = ((_min) * (360/60)) + (_sec*0.1f);
		//(6/60)
		float secAngle = (_sec) * (360/60);
		
		angle = (minAngle - secAngle);
		
		if(angle<0){
			angle = 360 + angle;
		}
		
		if(angle>180){
			angle = 360 - angle;
		}
		
		
		return angle;
		
		
	}
	
	
	private static void runTests(){
		System.out.println("------");
		System.out.println("Running Tests");
		System.out.println("Simple - 1200 : "+ ((getAngleSimple(12, 00)==0.0)?"PASS": "FAIL") );
		System.out.println("Simple - 1230 : "+ ((getAngleSimple(12, 30)==180.0)?"PASS": "FAIL") );
		System.out.println("Simple - 0645 : "+ ((getAngleSimple(6, 45)==90.0)?"PASS": "FAIL") );
		System.out.println("Simple - 1800 : "+ ((getAngleSimple(18, 00)==180.0)?"PASS": "FAIL") );
		System.out.println("Simple - 0900 : "+ ((getAngleSimple(9, 00)==90.0)?"PASS": "FAIL") );
		System.out.println("Simple - 1500 : "+ ((getAngleSimple(15, 00)==90.0)?"PASS": "FAIL") );

		System.out.println("Real - 1200 : "+ ((getAngleReal(12, 00)==0.0)?"PASS": "FAIL") );
		System.out.println("Real - 1230 : "+ ((getAngleReal(12, 30)==165.0)?"PASS": "FAIL") );
		System.out.println("Real - 0645 : "+ ((getAngleReal(6, 45)==67.5)?"PASS": "FAIL") );
		System.out.println("Real - 1800 : "+ ((getAngleReal(18, 00)==180.0)?"PASS": "FAIL") );
		System.out.println("Real - 0900 : "+ ((getAngleReal(9, 00)==90.0)?"PASS": "FAIL") );
		System.out.println("Real - 1500 : "+ ((getAngleReal(15, 00)==90.0)?"PASS": "FAIL") );
		
		System.out.println("------");
		System.out.println("Test End");
		
		
	}
	
	
	
}
