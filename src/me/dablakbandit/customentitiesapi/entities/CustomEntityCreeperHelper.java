package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityCreeperHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object creeper) {
		removeGoalSelectorPathfinderGoalAll(creeper);
	}

	public static void setAbleToMove(Object creeper) {
		// TODO
	}

	public static void setAbleToMove(Object creeper, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object creeper) {
		// TODO
	}
}
