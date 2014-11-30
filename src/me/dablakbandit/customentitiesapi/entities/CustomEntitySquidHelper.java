package me.dablakbandit.customentitiesapi.entities;

public class CustomEntitySquidHelper extends CustomEntityWaterAnimalHelper {

	public static void setUnableToMove(Object squid) {
		removeGoalSelectorPathfinderGoalAll(squid);
	}

	public static void setAbleToMove(Object squid) {
		// TODO
	}

	public static void setAbleToMove(Object squid, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object squid) {
		// TODO
	}
}
