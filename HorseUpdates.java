package raceupdate;
import racehorse.Horse;
import horsehandler.HorseUtility;

public class HorseUpdates {
	public static void toGate(Horse horse) {
		if (horse.getGateDistance() < 10) {
			Integer horseStep = HorseUtility.moveHorse(horse.getGateDistance());
			
			System.out.println(horse.getHorseName() + " moved " + horseStep 
					          + ((horseStep == 1) ? " gallop " : " gallops ") + " towards the Barn Gate");
			horseStep += horse.getGateDistance();
			horse.setGateDistance(horseStep);
			
		} else {
			horse.setGateStatus(true);
		}
	}
	
	public static void toFinish(Horse horse) {
		if (horse.getDistanceCovered() < horse.getRaceDistance()) {
			Integer horseGallop;
			
			if (horse.getBoost().equals(true)) {
				horseGallop = HorseUtility.boostHorse(horse.getRaceDistance() - horse.getDistanceCovered());
				
				if (horseGallop < 11) {
					System.out.println(horse.getHorseName() + " did not use the boost and moved " 
							          + horseGallop + " steps forward.");
				} else {
					System.out.println(horse.getHorseName() + " used his boost and moved " + horseGallop + " steps forward. " + System.currentTimeMillis() );
				}
				horse.setBoost(false);
			} else {
				horseGallop = HorseUtility.moveHorse(horse.getRaceDistance() - horse.getDistanceCovered());
				System.out.println(horse.getHorseName() + " moved " + horseGallop + " steps forward. " + System.currentTimeMillis());
			}
			horseGallop += horse.getDistanceCovered();
			horse.setDistanceCovered(horseGallop);
		} else {
			horse.setFinishStatus(true);
		}
	}
}