package lab4;


import java.util.*;

public class Driver {
	private static Routes routes = Routes.getRoutesObj(); 
	private int driverID;         // every driver object has a unique driverID                                
	private String name;          // driver name is not necessarily unique
	private Date joinDate;        // assume to be the same as the time the corresponding driver obj is created
	private Integer salary;       // Integer wrapper class
	private static int numOfDrivers=0;   // number of drivers created using the Driver() constructor
	private static int peakSalary=100000;//peak salary for all drivers
	
	
	
	public Driver(String name, Integer salary) {//construct new Driver obj, driverID equals to numOfDrivers, after that add 1 to numOfDrivers to update it 
		driverID=numOfDrivers;                 // joinDate = the date/time the obj is constructed,  
		numOfDrivers++;                        // otherwise set salary to peakSalary
		this.name=name;                        // no msg is displayed when this constructor is running
		this.joinDate= new Date();
		if(salary<peakSalary) {this.salary=salary;} //if salary after increment is still less than peakSalary, salary equals to the incremented salary,
		else {this.salary=peakSalary;}
		System.out.printf("Driver %s has joined the company on %s, he has a monthly payment of %d dollars.\n",this.name,this.joinDate,this.salary);
		
	}
	
	public void increaseSalary(int increment) {
		 // if salary after increment is still less than peakSalary, salary equals to the incremented salary
		this.salary += increment;
		 // otherwise is the incremented salary is higher than peakSalary, set salary to peakSalary
		if (this.salary > peakSalary){
			this.salary = peakSalary;
			// output messages according to the output at the lab web
			System.out.println("You try to increment the salary of " + name + " beyond the peak " + peakSalary + ", salary adjusted to " + peakSalary);
		} else{ 
			// output messages according to the output at the lab web
			System.out.println("The salary of driver " + name + " has been increased to " + salary);
		} 
		
	}
	
	public static int returnNumOfDrivers() {
         // return numOfDrivers variable
		return numOfDrivers;
	}
	
	public Integer returnID() {
		// return driverID variable
		return driverID;
	}
	
	public Integer returnSalary() {
		// return salary variable
		return salary; 
	}
	
	public void addToRoute(Integer routeID) {
		boolean added=routes.addDriver(this, routeID); // add driver to the route according to routeID
		//check to see if the add is successful, display different messages according to the lab web
		if (added) {
			System.out.printf("Driver %s joins the route %d.\n",name, routeID);
		}
		else {
			System.out.printf("Driver %s is already in the route %d, not being added again!\n",name,routeID);
		}
		
	}
	
	public void leaveRoute(Integer routeID) {
		// by refer to the implementation of addToRoute() method above, implement leaveRoute
		boolean leaved = routes.removeDriver(this, routeID); // uses a method in the Routes.jar file, remove a driver from the route with routeID
		// check to see if the removal is successful or not, display different messages according to the lab web
		if (leaved) {
			System.out.println("Driver " + name + " has left the route " + routeID + ".");
		}
		else {
			System.out.println("Driver " + name + " is not in the route " + routeID + ", not left!");
		}			
	}
	
	public static void printAllDrivers(Integer routeID) {
		StringBuilder output= new StringBuilder("The following is/are all the driver(s) of the routes "+routeID+":\n");
		// use a method provided in Routes.jar, get all the drivers of the route=routeID, put the drivers into an array
		Driver[] print_drivers = routes.getAllDrivers(routeID);
		// Then formulate the StringBuilder output message using the driver array, see the output sample at the lab web for the exact format
		for (int i = 0; i < print_drivers.length; i++){
			output.append(print_drivers[i].name);
			output.append('\n');
		}
		if (print_drivers.length == 0){
			output.append("No driver!");
			output.append('\n');
		}
		System.out.print(output);
	}
	
	public static void printRouteCost() { 
		// print the costs of each of the routes, when there is no routes (i.e. a[] is empty output "No routes!"
		Integer a[]=routes.getAllRouteIDs(); 
		StringBuilder output = new StringBuilder();
		
		for (int i = 0 ; i < a.length; i++){
			int salaryCost = 0;
			Driver[] temp_drivers = routes.getAllDrivers(a[i]);
			
			for (int j = 0; j < temp_drivers.length; j++){
				salaryCost += temp_drivers[j].returnSalary();
			}
			
			output.append("This route " + a[i] + ", has a total salary cost of " + salaryCost + ". \n");
		}
		if (a.length == 0){
			output.append("No routes!");
		}
		System.out.println(output);
	}
	
}
