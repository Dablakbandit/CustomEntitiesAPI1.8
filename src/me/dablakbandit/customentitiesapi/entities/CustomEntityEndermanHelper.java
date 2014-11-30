package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityEndermanHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object enderman) {
		removeGoalSelectorPathfinderGoalAll(enderman);
	}

	public static void setAbleToMove(Object enderman) {
		// TODO
	}

	public static void setAbleToMove(Object enderman, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object enderman) {
		// TODO
	}
}
