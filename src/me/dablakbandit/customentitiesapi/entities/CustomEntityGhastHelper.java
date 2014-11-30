package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityGhastHelper extends CustomEntityFlyingHelper {

	public static void setUnableToMove(Object ghast) {
		removeGoalSelectorPathfinderGoalAll(ghast);
	}

	public static void setAbleToMove(Object ghast) {
		// TODO
	}

	public static void setAbleToMove(Object ghast, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object ghast) {
		// TODO
	}
}
