package designandanalysisproject;
import java.util.ArrayList;

public class Test {
	public static void main(String[]args) {
		ArrayList<GreedyAlgo.Person>peopleFloors=new ArrayList<>();
		peopleFloors.add(new GreedyAlgo.Person(16));
		peopleFloors.add(new GreedyAlgo.Person(15));
        peopleFloors.add(new GreedyAlgo.Person(21));
		peopleFloors.add(new GreedyAlgo.Person(22));
		peopleFloors.add(new GreedyAlgo.Person(23));
		int groundFloor=20;
		int maxCapacity=5;
		int maxStops=3;
		GreedyAlgo.ElevatorChosenFloors result=GreedyAlgo.chooseBestStops(peopleFloors,groundFloor,maxCapacity,maxStops );
		System.out.println("The floors that are chosen according to this algorithm are : "+result.chosenFloors);
		System.out.println("The minimized walking distances calculated are: "+result.minimizedWalkingDistance);
			}
}
