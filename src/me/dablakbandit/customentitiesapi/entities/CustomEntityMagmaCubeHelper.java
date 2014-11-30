package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityMagmaCubeHelper extends CustomEntitySlimeHelper {

	public static void setUnableToMove(Object magmacube) {
		removeGoalSelectorPathfinderGoalAll(magmacube);
	}

	public static void setAbleToMove(Object magmacube) {
		// TODO
	}

	public static void setAbleToMove(Object magmacube, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object magmacube) {
		// TODO
	}
}
