import horsehandler.HorseUtility;
import racehorse.Horse;
import runrace.HorseRace;
import java.util.concurrent.CyclicBarrier;
import java.util.ArrayList;
import java.util.Arrays;

public class RaceSetup {
	public static void main(String [] args) {
		ArrayList <Horse> participants = new ArrayList <Horse> ();
		ArrayList <String> horseName = new ArrayList <String>();
		horseName.addAll(Arrays.asList("Noir", "Jaguar", "Ebony", "Onyx", "Domino", "Adobe", "Kit Kat", "Brandy", "Opie", "Fiona", "Spirit",
				"Seabiscuit", "Scout", "Lacey", "Joe", "Nappie", "Autumn", "Pepper", "Nyquist", "Red Rum"));

		ArrayList <String> warCry = new ArrayList <String>();
		warCry.addAll(Arrays.asList("Yehaaaa", "Neiiiighhh", "I'm done", "I conquered", "Finish", "Vamos", "Allez", "Come on", "Davai",
				"Kom Igen", "Yukooo", "Gajaaa", "Wuhooo", "Yeheyy", "Let's do this", "Let's Go", "Iyyyaaa", "Labaaan", "Pusoooo", "Panalo"));
		
		Horse entry;
		String name;
		String shout;
		
		System.out.print("Input number of horses to enter the race: ");
		final Integer horseNumber = HorseUtility.integerCheck(2,20);
		System.out.print("Input distance of the race: ");
		final Integer raceDistance = HorseUtility.integerCheck(101);
		System.out.println("Race Details:");
		System.out.println("There are " + horseNumber + " horses included in this race");
		System.out.println("The race is " + raceDistance + " gallops long\n");
		
		CyclicBarrier gate = new CyclicBarrier(horseNumber.intValue());
		
		for (int h = 1; h <= horseNumber.intValue(); h++) {
			name = horseName.get(HorseUtility.randomInteger(horseName.size()));
			shout = warCry.get(HorseUtility.randomInteger(warCry.size()));
			horseName.remove(name);
			warCry.remove(shout);
			entry = new Horse(name + "--" + h, raceDistance, 0, 0, false, false, false, shout);
			participants.add(entry);
		}
		
		for (Horse horse : participants) {
			HorseRace enterRace = new HorseRace(horse, gate, participants);
			Thread startRace = new Thread(enterRace);
			startRace.start();
		}
	}
}