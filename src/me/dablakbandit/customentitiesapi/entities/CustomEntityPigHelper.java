package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityPigHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object pig) {
		removeGoalSelectorPathfinderGoalAll(pig);
	}

	public static void setAbleToMove(Object pig) {
		// TODO
	}

	public static void setAbleToMove(Object pig, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object pig) {
		// TODO
	}
}
