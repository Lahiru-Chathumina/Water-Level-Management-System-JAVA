import java.util.*;
class WaterLevelObserver{
	public void update(int waterLevel){
		
	}
}
class Alarm extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println(waterLevel>=50 ? "Alarm ON":"Alarm Off");
	}
}
class Splitter extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println(waterLevel>=75 ? "Splitter ON":"Splitter Off");
	}	
}
class Display extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println("WaterLevel : "+waterLevel);
	}
}
class SMSSender extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println("Sending SMS : "+waterLevel);
	}
}
class ControlRoom{
	private ArrayList <WaterLevelObserver>observerList;
	private int waterLevel;
	
	ControlRoom(){
		observerList=new ArrayList<>();
	}
	public void addWaterLevelObserver(WaterLevelObserver ob){
		observerList.add(ob);
	}
	public void setWaterLevel(int waterLevel){
		if(this.waterLevel!=waterLevel){
			this.waterLevel=waterLevel;
			notifyObservers();
		}
	}
	public void notifyObservers(){
		for(WaterLevelObserver ob :observerList){
			ob.update(waterLevel);
		}
	}
}
class Demo{
	public static void main(String args[]){
		ControlRoom controlRoom=new ControlRoom();
		controlRoom.addWaterLevelObserver(new Alarm());
		controlRoom.addWaterLevelObserver(new Display());
		controlRoom.addWaterLevelObserver(new SMSSender());
		controlRoom.addWaterLevelObserver(new Splitter());
		
		//--------------------------------------
		Random r=new Random();
		while(true){
			int waterLevel=r.nextInt(101); //0 to 100
			controlRoom.setWaterLevel(waterLevel);
			try{Thread.sleep(1000);}catch(Exception ex){}
		}
	}
}
