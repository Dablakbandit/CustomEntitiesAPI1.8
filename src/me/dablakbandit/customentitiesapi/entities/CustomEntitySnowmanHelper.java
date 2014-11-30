package me.dablakbandit.customentitiesapi.entities;

public class CustomEntitySnowmanHelper extends CustomEntityGolemHelper {

	public static void setUnableToMove(Object snowman) {
		removeGoalSelectorPathfinderGoalAll(snowman);
	}

	public static void setAbleToMove(Object snowman) {
		// TODO
	}

	public static void setAbleToMove(Object snowman, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object snowman) {
		// TODO
	}
}
