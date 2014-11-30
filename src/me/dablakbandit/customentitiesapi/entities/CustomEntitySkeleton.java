package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySkeleton extends CustomEntityMonster {

	public CustomEntitySkeleton() {
		super("CustomEntitySkeleton");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySkeleton(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySkeleton(Entity e) {
		this();
		a();
		entity = NMSUtils.getHandle(e);
	}

	public CustomEntitySkeleton(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySkeletonClass() {
		try {
			return Class.forName("temp.CustomEntitySkeleton");
		} catch (Exception e) {
			return null;
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySkeleton");
		} catch (Exception e1) {
			try {
				cp.appendClassPath(new LoaderClassPath(
						CustomEntitySkeleton.class.getClassLoader()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySkeletonHelper",
								"temp.CustomEntitySkeletonHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntitySkeleton = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySkeleton");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySkeleton");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityLiving");
				cp.importPackage("temp");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySkeleton);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySkeletonHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySkeletonHelper.setAbleToMove(this);"
						+ "}");

				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySkeletonHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySkeleton",
					51, customentity);
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySkeleton");
			helper = Class.forName("temp.CustomEntitySkeletonHelper");
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

	public void newGoalSelectorPathfinderGoalArrowAttackDefault() {
		newGoalSelectorPathfinderGoalArrowAttack(1.0D, 20, 60, 15.0F);
	}

	public void newGoalSelectorPathfinderGoalArrowAttack(double d, int i,
			float f) {
		newGoalSelectorPathfinderGoalArrowAttack(d, i, i, f);
	}

	public void newGoalSelectorPathfinderGoalArrowAttack(double d, int i,
			int i1, float f) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalArrowAttack",
					Object.class, double.class, int.class, int.class,
					float.class).invoke(null, entity, d, i, i1, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalArrowAttack() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalArrowAttack",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalFleeSunDefault() {
		newGoalSelectorPathfinderGoalFleeSun(1.0D);
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault() {
		newGoalSelectorPathfinderGoalRandomStroll(1.0D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault() {
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 8.0F);
	}

	public void newGoalSelectorPathfinderGoalMeleeAttackDefault() {
		newGoalSelectorPathfinderGoalMeleeAttack(EntityName.ENTITYHUMAN, 1.2D,
				false);
	}
}
