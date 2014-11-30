package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityCowHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object cow) {
		removeGoalSelectorPathfinderGoalAll(cow);
	}

	public static void setAbleToMove(Object cow) {
		// TODO
	}

	public static void setAbleToMove(Object cow, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object cow) {
		// TODO
	}
}
