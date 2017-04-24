package runrace;
import racehorse.Horse;
import raceupdate.HorseUpdates;
import horsehandler.HorseUtility;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Arrays;

public class HorseRace implements Runnable {
	private Horse horse;
	private CyclicBarrier gate;
	private ArrayList <Horse> participants;
	private Boolean status = false;
	private static final AtomicBoolean flag = new AtomicBoolean(false);
	
	public HorseRace(Horse horse, CyclicBarrier gate, ArrayList <Horse> participants) {
		this.horse = horse;
		this.gate = gate;
		this.participants = participants;
	}
	
	public void run() {
		try {
			gate.await();
			while (true) {				
				if (horse.getGateStatus()) {
					break;
				}

				HorseUpdates.toGate(horse);

				if(horse.getGateStatus()) {
					break;
				}
			}

			gate.await();

			if (flag.compareAndSet(false, true)) {			//Compare/Checks if Flag is False. Then sets it to True.
				System.out.println("All horses are currently at the gate.\nRace will start in 5 seconds");
				Thread.sleep(5000);
				System.out.println("Race starts now!\n");
			}
			
			gate.await();
			
			while (true) {
				if (horse.getFinishStatus()) {
					break;
				}	

				HorseUpdates.toFinish(horse);
				//Thread.sleep(10);

				Optional <Horse> lastHorse = participants.stream()
														 .sorted(new DistanceComparator())
														 .findFirst();
														 
				if (horse.getDistanceCovered() == lastHorse.get().getDistanceCovered()) {
					horse.setBoost(true);
				}
				
				if(horse.getFinishStatus().equals(true)) {
					System.out.println(horse.getHorseName() + " is finished and roars " + horse.getWarCry());
				}			
			}
			
		} catch (BrokenBarrierException | InterruptedException e) {
			e.printStackTrace(System.out);
		}
	
	}
}

class DistanceComparator implements Comparator <Horse> {
	public int compare(Horse a, Horse b) {
		return a.getDistanceCovered() - b.getDistanceCovered();
	}
}