package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityBlazeHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object blaze) {
		removeGoalSelectorPathfinderGoalAll(blaze);
	}

	public static void setAbleToMove(Object blaze) {
		newGoalSelectorPathfinderGoalRandomStroll(blaze, 1.0D);
	}

	public static void setAbleToMove(Object blaze, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(blaze, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object blaze) {
		newGoalSelectorPathfinderGoalBlazeFireball(blaze);
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(blaze, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(blaze, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(blaze, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(blaze);
	}
	
	public static void newGoalSelectorPathfinderGoalBlazeFireball(Object blaze) {
		try {
			Class<?> entityblaze = getNMSClass("EntityBlaze");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(blaze);

			Class<?> pathfindergoalblazefireball = getNMSClass("PathfinderGoalBlazeFireball");
			Object o = pathfindergoalblazefireball.getConstructor(entityblaze)
					.newInstance(entityblaze.cast(blaze));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 4, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalBlazeFireball(
			Object blaze) {
		removeGoalSelectorPathFinderGoal(blaze, "PathfinderGoalBlazeFireball");
	}
}
