package designandanalysisproject;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class GreedyAlgo {

	static class Person{//Person class which specifies the floor that person wants to choose
		int floor;

		public Person(int floor){
			this.floor=floor;//constructor to define floor person wants to choose
		}
	}

	public static class ElevatorChosenFloors{//ElevatorChosenFloors class to display the results
		ArrayList<Integer>chosenFloors;//array list for floors which were chosen
		ArrayList<Integer>minimizedWalkingDistance;//array list for walking distance

		public ElevatorChosenFloors(ArrayList<Integer>chosenFloors,ArrayList<Integer>minimizedWalkingDistance){//generating the constructor
			this.chosenFloors=chosenFloors;//the result constructor which takes the chosen floors and minimized walking distance as a parameter
			this.minimizedWalkingDistance=minimizedWalkingDistance;
		}
	}
public static Comparator<Integer> compareFloors(int startingPoint){//create a method to compare the floors and choose the lowest floor
		return new Comparator<Integer>(){
		public int compare(Integer a, Integer b){//method to compare a and b
			int distanceA=Math.abs(a-startingPoint);//calculate distance of a from the starting point
			int distanceB=Math.abs(b-startingPoint);//calculate the distance of b from starting point
			if(distanceA==distanceB){//if the distances are the same
				return Integer.compare(a,b);//then choose the lower floor
			}
			return Integer.compare(distanceA,distanceB);//else choose the lower distance
		}};
}
	public static ElevatorChosenFloors chooseBestStops(ArrayList<Person>peopleFloors,int groundFloor, int maxCapacity, int maximumStops){//defne the method or computing best results for floors chosen and the mnimized walking distance by takng the floors that people have chosen, the capacity of the elevator, the maximum numbers of stops, and the starting(ground floor)

ArrayList<Integer>chosenFloors=new ArrayList<Integer>();//array list for chosenFloors in this method as a result
ArrayList<Integer>minimizedWalkingDistance=new ArrayList<Integer>();//array list for minimized walking distance as a result
		PriorityQueue<Integer>pq=new PriorityQueue<>(compareFloors(groundFloor));//sort the floors in the priority queue with respect to their distance from the ground floor using the above method


		//initialize current floor, remaining capacity and stops remaining
		int currentFloor=groundFloor; //the current floor now is the ground floor
		int remainingCapacity=maxCapacity;//the remaining capacity is the maximum capacity as no one has gotten off the elevator yet
		int remainingNoOfStops=maximumStops;//as no one has gotten off the elevator, the number of remaining stops is the maximum number of stops
		for(Person person:peopleFloors){
			pq.add(person.floor);//add all the floors that people have chosen to the priority queue and sort the priority queue with respect to the distance from the ground floor
		}
while(!pq.isEmpty()&&remainingNoOfStops>0&&remainingCapacity>0){//while there are still people in the elevator
	int closestFloor=pq.remove();//choose the closest floor from priority queue wth respect to minimum distance from ground floor closer floors are given the highest priority
	chosenFloors.add(closestFloor);//add the closest floor to the chosenFloors array
	remainingNoOfStops--;//decrease the maximum number of stops
	remainingCapacity--;//decrease the capacity
	PriorityQueue<Integer>temp=new PriorityQueue( compareFloors(closestFloor));//sort the floors in the priority queue with respect to their distance from the closest floor using the above method
while(!pq.isEmpty()){//while the priority queue is not empty

	int nextFloor=pq.remove();//the next floor is chosen from priority queue
	if(nextFloor!=closestFloor){//if it is not equal to chosenFloor
		temp.add(nextFloor);//then it is added in temporary queue
	}
	//this sorts the temporary queue based on the above method
}
pq=temp;//update the priority queue with the temporary queue which is the next closest floor to the current floor
currentFloor=closestFloor;//update the current floor
}
//function to calculate minimized walking distance
if(!chosenFloors.isEmpty()){//if the chosenFloors array is not empty
	int lastChosenFloor= chosenFloors.get(chosenFloors.size()-1);//lastChosenFloor is the floor at the end of chosenFloors array
	for(Person person:peopleFloors){//for every person in peopleFloors
		if(!chosenFloors.contains(person.floor)){//if their floors are not chosen
			minimizedWalkingDistance.add(Math.abs(lastChosenFloor-person.floor));//the walking distance is calculated as the difference between the floor not chosen and the floor at the end of chosenFloors array and add it to the minimizedWalkingDistance array
		}
	}
}
return new ElevatorChosenFloors(chosenFloors,minimizedWalkingDistance);//return the chosenFloors array and minimizedWalkingDistance

	}

}
