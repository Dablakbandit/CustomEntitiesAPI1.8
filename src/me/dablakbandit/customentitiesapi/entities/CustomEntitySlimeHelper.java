package me.dablakbandit.customentitiesapi.entities;

public class CustomEntitySlimeHelper extends CustomEntityInsentientHelper {

	public static void setUnableToMove(Object slime) {
		removeGoalSelectorPathfinderGoalAll(slime);
	}

	public static void setAbleToMove(Object slime) {
		// TODO
	}

	public static void setAbleToMove(Object slime, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object slime) {
		// TODO
	}
}
