package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityBatHelper extends CustomEntityAmbientHelper {

	public static void setUnableToMove(Object bat) {
		removeGoalSelectorPathfinderGoalAll(bat);
	}

	public static void setAbleToMove(Object bat) {
		// TODO
	}

	public static void setAbleToMove(Object bat, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object bat) {
		// TODO
	}
}
