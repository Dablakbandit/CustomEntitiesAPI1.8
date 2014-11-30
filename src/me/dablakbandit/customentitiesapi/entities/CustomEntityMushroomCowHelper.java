package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityMushroomCowHelper extends CustomEntityCowHelper {

	public static void setUnableToMove(Object mushroomcow) {
		removeGoalSelectorPathfinderGoalAll(mushroomcow);
	}

	public static void setAbleToMove(Object mushroomcow) {
		// TODO
	}

	public static void setAbleToMove(Object mushroomcow, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object mushroomcow) {
		// TODO
	}
}
