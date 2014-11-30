package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityOcelotHelper extends CustomEntityTameableAnimalHelper {

	public static void setUnableToMove(Object ocelot) {
		removeGoalSelectorPathfinderGoalAll(ocelot);
	}

	public static void setAbleToMove(Object ocelot) {
		// TODO
	}

	public static void setAbleToMove(Object ocelot, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object ocelot) {
		// TODO
	}
}
