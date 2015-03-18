package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityChickenHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object chicken) {
		removeGoalSelectorPathfinderGoalAll(chicken);
	}

	public static void setAbleToMove(Object chicken) {
		newGoalSelectorPathfinderGoalRandomStroll(chicken, 1.0D);
	}

	public static void setAbleToMove(Object chicken, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(chicken, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object chicken) {
		newGoalSelectorPathfinderGoalFloat(chicken);
		newGoalSelectorPathfinderGoalPanic(chicken, 1.4D);
		newGoalSelectorPathfinderGoalBreed(chicken, 1.0D);
		newGoalSelectorPathfinderGoalTempt(chicken, 1.0D, "WHEAT_SEEDS", false);
		newGoalSelectorPathfinderGoalFollowParent(chicken, 1.1D);
		newGoalSelectorPathfinderGoalRandomStroll(chicken, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(chicken, "EntityHuman", 6.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(chicken);
	}
}
