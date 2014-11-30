package me.dablakbandit.customentitiesapi.entities;

public class CustomEntitySilverfishHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object silverfish) {
		removeGoalSelectorPathfinderGoalAll(silverfish);
	}

	public static void setAbleToMove(Object silverfish) {
		// TODO
	}

	public static void setAbleToMove(Object silverfish, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object silverfish) {
		// TODO
	}
}
