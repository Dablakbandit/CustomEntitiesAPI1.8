package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityCaveSpiderHelper extends CustomEntitySpiderHelper {

	public static void setUnableToMove(Object cavespider) {
		removeGoalSelectorPathfinderGoalAll(cavespider);
	}

	public static void setAbleToMove(Object cavespider) {
		// TODO
	}

	public static void setAbleToMove(Object cavespider, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object cavespider) {
		// TODO
	}
}
