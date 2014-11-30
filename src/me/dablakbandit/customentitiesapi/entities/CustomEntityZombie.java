package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityZombie extends CustomEntityMonster {

	public CustomEntityZombie() {
		super("CustomEntityZombie");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityZombie(Location location) {
		this();
		a();
		spawnEntity(location);
		removeGoalSelectorPathfinderGoalMeleeAttack();
		newGoalSelectorPathfinderGoalMeleeAttackDefault();
	}

	public CustomEntityZombie(Entity e) {
		this();
		a();
		entity = NMSUtils.getHandle(e);
	}

	public CustomEntityZombie(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityZombieClass() {
		try {
			return Class.forName("temp.CustomEntityZombie");
		} catch (Exception e) {
			return null;
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityZombie");
		} catch (Exception e1) {
			try {
				cp.appendClassPath(new LoaderClassPath(CustomEntityZombie.class
						.getClassLoader()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityZombieHelper",
								"temp.CustomEntityZombieHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityZombie = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityLiving");
				cp.importPackage("temp");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityZombie);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityZombieHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityZombieHelper.setAbleToMove(this);" + "}");

				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityZombieHelper.setAbleToMove(this, d);"
						+ "}");
				for (String m : methods) {
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				methods.clear();
				customentity = ctClass.toClass();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (customentity != null)
			CustomEntitiesAPI.getInstance().registerEntity("EntityZombie", 54,
					customentity);
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityZombie");
			helper = Class.forName("temp.CustomEntityZombieHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMeleeAttackDefault() {
		try {
			try {
				Field f = entity.getClass().getField("world");
				Object world = f.get(entity);
				Field config = world.getClass()
						.getDeclaredField("spigotConfig");
				Object config1 = config.get(world);
				Field f1 = config1.getClass().getField(
						"zombieAggressiveTowardsVillager");
				Object value = f1.get(config1);
				if ((boolean) value) {
					newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
				}
			} catch (Exception e) {
				newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsRestrictionDefault() {
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(1.0D);
	}

	public void newGoalSelectorPathfinderGoalMoveThroughVillageDefault() {
		newGoalSelectorPathfinderGoalMoveThroughVillage(1.0D, false);
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault() {
		newGoalSelectorPathfinderGoalRandomStroll(1.0D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault() {
		newGoalSelectorPathfinderGoalLookAtPlayer(8.0F);
	}

	public boolean isVillager() {
		try {
			return (boolean) entity.getClass().getMethod("isVillager")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setBaby(boolean flag) {
		try {
			entity.getClass().getMethod("setBaby", boolean.class)
					.invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
