package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntityCreeperHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object creeper) {
		removeGoalSelectorPathfinderGoalAll(creeper);
	}

	public static void setAbleToMove(Object creeper) {
		// TODO
	}

	public static void setAbleToMove(Object creeper, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object creeper) {
		newGoalSelectorPathfinderGoalFloat(creeper);
		newGoalSelectorPathfinderGoalSwell(creeper);
		try{
			Field f = getField(getNMSClass("EntityMonster"), "a");
			Object o = f.get(creeper);
			if(o!=null){
				Class<?> pathfindergoal = getNMSClass("PathfinderGoal");
				Object goalselector = getGoalSelector(creeper);
				goalselector.getClass().getMethod("a", int.class, pathfindergoal)
				.invoke(goalselector, 2, o);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void newGoalSelectorPathfinderGoalSwell(Object creeper){
		try {
			Class<?> entitycreeper = getNMSClass("EntityCreeper");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creeper);

			Class<?> pathfindergoalswell= getNMSClass("PathfinderGoalSwell");
			Object o = pathfindergoalswell.getConstructor(entitycreeper).newInstance(entitycreeper.cast(creeper));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 2, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeGoalSelectorPathfinderGoalSwell(
			Object blaze) {
		removeGoalSelectorPathFinderGoal(blaze, "PathfinderGoalSwell");
	}
}
