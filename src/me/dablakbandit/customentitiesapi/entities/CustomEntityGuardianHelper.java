package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityGuardianHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object guardian) {
		removeGoalSelectorPathfinderGoalAll(guardian);
	}

	public static void setAbleToMove(Object guardian) {
		// TODO
	}

	public static void setAbleToMove(Object guardian, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object guardian) {
		// TODO
	}
}
