package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntitySpiderHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object spider) {
		removeGoalSelectorPathfinderGoalAll(spider);
	}

	public static void setAbleToMove(Object spider) {
		// TODO
	}

	public static void setAbleToMove(Object spider, double d) {
		// TODO
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object spider) {
		newGoalSelectorPathfinderGoalFloat(spider);
		newGoalSelectorPathfinderGoalLeapAtTarget(spider, 0.4F);
		try{
			Field f = getField(getNMSClass("EntityMonster"), "a");
			Object o = f.get(spider);
			if(o!=null){
				Class<?> pathfindergoal = getNMSClass("PathfinderGoal");
				Object goalselector = getGoalSelector(spider);
				goalselector.getClass().getMethod("a", int.class, pathfindergoal)
				.invoke(goalselector, 2, o);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(spider, "EntityHuman");
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(spider, "EntityIronGolem");
		newGoalSelectorPathfinderGoalRandomStroll(spider, 0.8D);
		newGoalSelectorPathfinderGoalLookAtPlayer(spider, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(spider);
	}
	
	public static void newGoalSelectorPathfinderGoalSpiderMeleeAttack(Object spider, String s) {
		try {
			Class<?> entityspider = getNMSClass("EntitySpider");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(spider);

			Class<?> pathfindergoalspidermeleeattack = getNMSClass("PathfinderGoalSpiderMeleeAttack");
			Object o = pathfindergoalspidermeleeattack.getConstructor(entityspider, Class.class)
					.newInstance(entityspider.cast(spider), getNMSClass(s));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalSpiderMeleeAttack(
			Object blaze) {
		removeGoalSelectorPathFinderGoal(blaze, "PathfinderGoalSpiderMeleeAttack");
	}
}
