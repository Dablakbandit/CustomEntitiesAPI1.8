package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityAnimalHelper extends CustomEntityAgeableHelper {

	public static void newGoalSelectorPathfinderGoalBreed(Object animal,
			double d) {
		try {
			Class<?> entityanimal = getNMSClass("EntityAnimal");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(animal);

			Class<?> pathfindergoalbreed = getNMSClass("PathfinderGoalBreed");
			Object o = pathfindergoalbreed.getConstructor(entityanimal,
					double.class).newInstance(entityanimal.cast(animal), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 2, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalBreed(Object animal) {
		removeGoalSelectorPathFinderGoal(animal, "PathfinderGoalBreed");
	}

	public static void newGoalSelectorPathfinderGoalFollowParent(Object animal,
			double d) {
		try {
			Class<?> entityanimal = getNMSClass("EntityAnimal");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(animal);

			Class<?> pathfindergoalfollowparent = getNMSClass("PathfinderGoalFollowParent");
			Object o = pathfindergoalfollowparent.getConstructor(entityanimal,
					double.class).newInstance(entityanimal.cast(animal), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 4, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalFollowParent(
			Object animal) {
		removeGoalSelectorPathFinderGoal(animal, "PathfinderGoalFollowParent");
	}
}
