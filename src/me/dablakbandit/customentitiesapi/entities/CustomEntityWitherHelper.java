package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWitherHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object wither) {
		removeGoalSelectorPathfinderGoalAll(wither);
	}

	public static void setAbleToMove(Object wither) {
		// TODO
	}

	public static void setAbleToMove(Object wither, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object wither) {
		// TODO
	}
}
