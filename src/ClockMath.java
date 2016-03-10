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
	}
	
	private static void getInput(){
		try{
			System.out.println("Please input a time (HH:MM):");
	    	  time = in.nextLine();
	    	  if(!time.matches("\\d{0,2}:\\d{2}")){
	    		  throw new Exception("Invalid Format");
	    	  }
	    	  String[] timeSpitArr = time.split(":");
	    	  hour = Integer.parseInt(timeSpitArr[0]);
	    	  if(hour>24){
	    		  throw new Exception("Invalid Hour");
	    		  
	    	  }
	    	  min = Integer.parseInt(timeSpitArr[1]);
	    	  if(min>60){
	    		  throw new Exception("Invalid Minutes");
	    		  
	    	  }
	    	  float simpleAngle = getAngleSimple(hour, min);
	    	  System.out.println("SIMPLE - Angle made by the hour and minute hands (degrees) : "+ simpleAngle);
	    	  
	    	  float realAngle = getAngleReal(hour, min);
	    	  System.out.println("Real - Angle made by the hour and minute hands (degrees) : "+ realAngle);
	    	  
	      }catch(Exception e){
	    	  System.out.println("ERROR : "+e.getMessage());
	    	  getInput();
//	    	  Date d = Calendar.getInstance().getTime();
//	    	  hour = d.getHours();
//	    	  min = d.getMinutes();

	    	  
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
	
	
}
