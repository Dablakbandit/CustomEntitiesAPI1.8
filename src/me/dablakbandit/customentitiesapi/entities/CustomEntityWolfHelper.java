package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWolfHelper extends CustomEntityTameableAnimalHelper {

	public static void setUnableToMove(Object wolf) {
		removeGoalSelectorPathfinderGoalAll(wolf);
	}

	public static void setAbleToMove(Object wolf) {
		// TODO
	}

	public static void setAbleToMove(Object wolf, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object wolf) {
		// TODO
	}
}
