package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityHorseHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object horse) {
		removeGoalSelectorPathfinderGoalAll(horse);
	}

	public static void setAbleToMove(Object horse) {
		// TODO
	}

	public static void setAbleToMove(Object horse, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object horse) {
		// TODO
	}
}
