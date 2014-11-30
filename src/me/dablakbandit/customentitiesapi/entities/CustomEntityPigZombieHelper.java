package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityPigZombieHelper extends CustomEntityZombieHelper {

	public static void setUnableToMove(Object pigzombie) {
		removeGoalSelectorPathfinderGoalAll(pigzombie);
	}

	public static void setAbleToMove(Object pigzombie) {
		// TODO
	}

	public static void setAbleToMove(Object pigzombie, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object pigzombie) {
		// TODO
	}
}
