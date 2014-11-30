package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityEnderDragonHelper extends CustomEntityInsentientHelper {

	public static void setUnableToMove(Object enderdragon) {
		removeGoalSelectorPathfinderGoalAll(enderdragon);
	}

	public static void setAbleToMove(Object enderdragon) {
		// TODO
	}

	public static void setAbleToMove(Object enderdragon, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object enderdragon) {
		// TODO
	}
}
