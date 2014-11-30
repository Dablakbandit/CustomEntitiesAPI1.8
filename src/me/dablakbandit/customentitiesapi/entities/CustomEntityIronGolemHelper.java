package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityIronGolemHelper extends CustomEntityGolemHelper {

	public static void setUnableToMove(Object irongolem) {
		removeGoalSelectorPathfinderGoalAll(irongolem);
	}

	public static void setAbleToMove(Object irongolem) {
		newGoalSelectorPathfinderGoalRandomStroll(irongolem, 1D);
	}

	public static void setAbleToMove(Object irongolem, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(irongolem, d);
	}

	public static void newGoalSelectorPathfinderGoalOfferFlower(Object irongolem) {
		try {
			Class<?> entityirongolem = getNMSClass("EntityIronGolem");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(irongolem);

			Class<?> pathfindergoalofferflower = getNMSClass("PathfinderGoalOfferFlower");
			Object o = pathfindergoalofferflower
					.getConstructor(entityirongolem).newInstance(
							entityirongolem.cast(irongolem));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 1, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalOfferFlower(
			Object irongolem) {
		removeGoalSelectorPathFinderGoal(irongolem, "PathfinderGoalOfferFlower");
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object irongolem) {
		newGoalSelectorPathfinderGoalMeleeAttack(irongolem, 1.0D, true);
		newGoalSelectorPathfinderGoalMoveTowardsTarget(irongolem, 0.9D, 32.0F);
		newGoalSelectorPathfinderGoalMoveThroughVillage(irongolem, 0.6D, true);
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(irongolem, 1.0D);
		newGoalSelectorPathfinderGoalOfferFlower(irongolem);
		newGoalSelectorPathfinderGoalRandomStroll(irongolem, 0.6D);
		newGoalSelectorPathfinderGoalLookAtPlayer(irongolem, "EntityPlayer",
				6.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(irongolem);
		// TODO
		// Wrong goalselector, needs to be added to the targetselector
		/*
		 * final Class<?> esm = getNMSClass("EntitySelectorMonster");
		 * 
		 * @SuppressWarnings("rawtypes") final Constructor cons =
		 * esm.getDeclaredConstructors()[0]; cons.setAccessible(true); try {
		 * newGoalSelectorPathfinderGoalNearestAttackableTarget(irongolem,
		 * "EntityInsentient", 0, false, true, cons.newInstance()); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}
}
