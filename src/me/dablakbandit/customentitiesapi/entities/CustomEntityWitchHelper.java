package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWitchHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object witch) {
		removeGoalSelectorPathfinderGoalAll(witch);
	}

	public static void setAbleToMove(Object witch) {
		// TODO
	}

	public static void setAbleToMove(Object witch, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object witch) {
		// TODO
	}
}
