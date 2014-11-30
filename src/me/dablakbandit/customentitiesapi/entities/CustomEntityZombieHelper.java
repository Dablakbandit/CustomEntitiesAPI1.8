package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityZombieHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object zombie) {
		removeGoalSelectorPathfinderGoalAll(zombie);
	}

	public static void setAbleToMove(Object zombie) {
		newGoalSelectorPathfinderGoalRandomStroll(zombie, 1D);
	}

	public static void setAbleToMove(Object zombie, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(zombie, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object zombie) {
		newGoalSelectorPathfinderGoalFloat(zombie);
		newGoalSelectorPathfinderGoalMeleeAttack(zombie, "EntityHuman", 1.0D,
				false);
		// TODO Exploding creeper
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(zombie, 1.0D);
		newGoalSelectorPathfinderGoalMoveThroughVillage(zombie, 1.0D, true);
		newGoalSelectorPathfinderGoalRandomStroll(zombie, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(zombie, 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(zombie);
	}

}