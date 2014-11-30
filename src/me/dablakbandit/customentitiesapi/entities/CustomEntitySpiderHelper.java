package me.dablakbandit.customentitiesapi.entities;

public class CustomEntitySpiderHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object spider) {
		removeGoalSelectorPathfinderGoalAll(spider);
	}

	public static void setAbleToMove(Object spider) {
		// TODO
	}

	public static void setAbleToMove(Object spider, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object spider) {
		// TODO
	}
}
