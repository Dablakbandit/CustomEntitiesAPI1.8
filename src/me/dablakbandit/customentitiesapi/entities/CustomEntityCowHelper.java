package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityCowHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object cow) {
		removeGoalSelectorPathfinderGoalAll(cow);
	}

	public static void setAbleToMove(Object cow) {
		newGoalSelectorPathfinderGoalRandomStroll(cow, 1.0D);
	}

	public static void setAbleToMove(Object cow, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(cow, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object cow) {
		newGoalSelectorPathfinderGoalFloat(cow);
		newGoalSelectorPathfinderGoalPanic(cow, 2.0D);
		newGoalSelectorPathfinderGoalBreed(cow, 1.0D);
		newGoalSelectorPathfinderGoalTempt(cow, 1.25D, "WHEAT", false);
		newGoalSelectorPathfinderGoalFollowParent(cow, 1.25D);
		newGoalSelectorPathfinderGoalRandomStroll(cow, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(cow, "EntityHuman", 6.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(cow);
	}
}
