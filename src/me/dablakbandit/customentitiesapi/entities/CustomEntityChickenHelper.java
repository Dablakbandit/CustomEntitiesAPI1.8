package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityChickenHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object chicken) {
		removeGoalSelectorPathfinderGoalAll(chicken);
	}

	public static void setAbleToMove(Object chicken) {
		// TODO
	}

	public static void setAbleToMove(Object chicken, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object chicken) {
		// TODO
	}
}
