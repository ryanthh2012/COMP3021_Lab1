package lab4;

public class TestLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main in TestLab4 started");
		System.out.printf("Total number of driver(s) is %d\n", Driver.returnNumOfDrivers());
		Driver alan= new Driver("Alan",10000);
		Driver ben= new Driver("Ben",200000);
		Driver candy= new Driver("Candy",150000);
		Driver david= new Driver("David",200000);
		Driver eric= new Driver("Eric",50000);
		System.out.printf("Total number of driver(s) is %d\n", Driver.returnNumOfDrivers());
		alan.addToRoute(1);
		ben.addToRoute(2);
		candy.addToRoute(2);
		candy.addToRoute(2);
		david.addToRoute(2);
		eric.addToRoute(3);
		ben.increaseSalary(10000);
		alan.increaseSalary(20000);
		
		alan.leaveRoute(2);
		alan.leaveRoute(1);
		alan.addToRoute(2);
		
		Driver.printAllDrivers(1);
		Driver.printAllDrivers(2);
		Driver.printAllDrivers(3);
		
		Driver.printRouteCost();

	}

}
