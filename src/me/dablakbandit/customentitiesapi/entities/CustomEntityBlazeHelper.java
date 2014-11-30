package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityBlazeHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object blaze) {
		removeGoalSelectorPathfinderGoalAll(blaze);
	}

	public static void setAbleToMove(Object blaze) {
		// TODO
	}

	public static void setAbleToMove(Object blaze, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object blaze) {
		// TODO
	}
}
