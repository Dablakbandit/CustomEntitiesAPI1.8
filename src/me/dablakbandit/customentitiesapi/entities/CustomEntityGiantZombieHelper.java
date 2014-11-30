package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityGiantZombieHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object giantzombie) {
		removeGoalSelectorPathfinderGoalAll(giantzombie);
	}

	public static void setAbleToMove(Object giantzombie) {
		// TODO
	}

	public static void setAbleToMove(Object giantzombie, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object giantzombie) {
		// TODO
	}
}
