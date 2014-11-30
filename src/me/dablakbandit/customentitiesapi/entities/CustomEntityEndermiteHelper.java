package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityEndermiteHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object endermite) {
		removeGoalSelectorPathfinderGoalAll(endermite);
	}

	public static void setAbleToMove(Object endermite) {
		// TODO
	}

	public static void setAbleToMove(Object endermite, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object endermite) {
		// TODO
	}
}
