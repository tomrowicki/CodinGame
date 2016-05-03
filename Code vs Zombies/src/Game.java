import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Save humans, destroy zombies!
 **/
class Player {
	
	static Zombie zombieToAttack;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		

		// game loop
		while (true) {
			int x = in.nextInt();
			int y = in.nextInt();
			int humanCount = in.nextInt();

			List<Human> humans = new ArrayList<Human>();
			for (int i = 0; i < humanCount; i++) {
				int humanId = in.nextInt();
				int humanX = in.nextInt();
				int humanY = in.nextInt();
				Human human = new Human(humanId, humanX, humanY);
				humans.add(human);
			}
			int zombieCount = in.nextInt();
			List<Zombie> zombies = new ArrayList<Zombie>();
			for (int i = 0; i < zombieCount; i++) {
				int zombieId = in.nextInt();
				int zombieX = in.nextInt();
				int zombieY = in.nextInt();
				int zombieXNext = in.nextInt();
				int zombieYNext = in.nextInt();
				Zombie zombie = new Zombie(zombieId, zombieX, zombieY, zombieXNext, zombieYNext);
				zombies.add(zombie);
			}

			if (humanCount < 2) {
				Human human = humans.get(0);
				printCoordinates(human.x, human.y);
			} else {
				Human mostEndangeredHuman = getMostEndangeredHuman(humans, zombies);
				// TODO zobaczyæ jak sprawdza siê strategia z szar¿¹ na najbli¿szego zombiaka
				// TODO przygotowaæ ró¿ne strategie i ustawiaæ w zal¿noœci od kontekstu
				// TODO dla ka¿dej strategii rozpisaæ w excelu jaki score w którym teœcie i które nie przechodz¹
				// TODO napisaæ symulator, który pomo¿e ka¿dorazowo wybraæ najlepsz¹ strategiê
				printCoordinates(zombieToAttack.xNext, zombieToAttack.yNext);
			}

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");

			// System.out.println("0 0"); // Your destination coordinates
		}
	}

	private static Human getMostEndangeredHuman(List<Human> humans, List<Zombie> zombies) {

		Human mostEndangeredHuman = null;
		double closestDistance = 20000.0;

		for (Human human : humans) {
			for (Zombie zombie : zombies) {
				double distance = getDistance(human, zombie);
				if (mostEndangeredHuman == null || closestDistance > distance) {
					mostEndangeredHuman = human;
					closestDistance = distance;
					zombieToAttack = zombie;
				}
			}
		}
		return mostEndangeredHuman;
	}

	private static double getDistance(Human human, Zombie zombie) {
		int x = human.x - zombie.x;
		int y = human.y - zombie.y;
		double c = Math.sqrt((x * x) + (y * y));
		return c;
	}

	private static class Human {

		private int id;
		private int x;
		private int y;

		public Human(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}

	private static class Zombie {

		private int id;
		private int x;
		private int y;
		private int xNext;
		private int yNext;

		public Zombie(int id, int x, int y, int xNext, int yNext) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.xNext = xNext;
			this.yNext = yNext;
		}
	}

	private static void printCoordinates(int x, int y) {

		System.out.println(x + " " + y);
	}
}