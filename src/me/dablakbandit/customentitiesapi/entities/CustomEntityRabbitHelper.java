package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityRabbitHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object rabbit) {
		removeGoalSelectorPathfinderGoalAll(rabbit);
	}

	public static void setAbleToMove(Object rabbit) {
		// TODO
	}

	public static void setAbleToMove(Object rabbit, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object rabbit) {
		// TODO
	}
}
