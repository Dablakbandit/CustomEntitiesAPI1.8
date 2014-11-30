package me.dablakbandit.customentitiesapi.entities;

import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import me.dablakbandit.customentitiesapi.entities.EntityName.EntityLivingName;
import ja.CtClass;
import ja.CtNewMethod;

public abstract class CustomEntityCreature extends CustomEntityInsentient {

	public CustomEntityCreature(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityCreatureHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityCreatureHelper",
								"temp.CustomEntityCreatureHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityInsentientHelper"));
				ces.toClass();
			}
			try {
				Class.forName("temp.CustomPathfinderGoalMeleeAttack");
			} catch (Exception e) {
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "PathfinderGoalMeleeAttack");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityLiving");
				CtClass ctclass = cp
						.makeClass("temp.CustomPathfinderGoalMeleeAttack");
				ctclass.setSuperclass(cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "PathfinderGoalMeleeAttack"));
				ctclass.addMethod(CtNewMethod
						.make("public void e(){"
								+ "EntityLiving entityliving = (EntityLiving)temp.CustomEntityCreatureHelper.getPathfinderGoalMeleeAttackbGoalTarget(this);"
								+ "if(entityliving!=null){" + "super.e();"
								+ "}" + "}", ctclass));
				ctclass.toClass();
				ctclass.writeFile(CustomEntitiesAPI.getInstance()
						.getDataFolder().getAbsolutePath()
						+ "/test1/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPanic(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalPanic",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalPanic() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalBreed",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalTempt(double d, String item,
			boolean b) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalTempt",
					Object.class, double.class, String.class, boolean.class)
					.invoke(null, entity, d, item, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalTempt(String item, boolean b) {
		newGoalSelectorPathfinderGoalTempt(1.1D, item, false);
	}

	public void newGoalSelectorPathfinderGoalTempt(String item) {
		newGoalSelectorPathfinderGoalTempt(1.1D, item, false);
	}

	public void removeGoalSelectorPathfinderGoalTempt() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalTempt",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalRandomStroll(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalRandomStroll",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalRandomStroll() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalRandomStroll",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public void newGoalSelectorPathfinderGoalMeleeAttack(String class0,
			double d, boolean value) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMeleeAttack",
					Object.class, String.class, double.class, boolean.class)
					.invoke(null, entity, class0, d, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMeleeAttack(EntityLivingName eln,
			double d, boolean value) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMeleeAttack",
					Object.class, String.class, double.class, boolean.class)
					.invoke(null, entity, eln.getName(), d, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMeleeAttack(double d, boolean value) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMeleeAttack",
					Object.class, double.class, boolean.class).invoke(null,
					entity, d, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMeleeAttack() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalMeleeAttack",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsRestriction(double d) {
		try {
			helper.getMethod(
					"newGoalSelectorPathfinderGoalMoveTowardsRestriction",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMoveTowardsRestriction() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalMoveTowardsRestriction",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveThroughVillage(double d,
			boolean value) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMoveThroughVillage",
					Object.class, double.class, boolean.class).invoke(null,
					entity, d, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMoveThroughVillage() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalMoveThroughVillage",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public void newGoalSelectorPathfinderGoalAvoidPlayer(String class0,
			float f, double d, double d0) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalAvoidPlayer",
					Object.class, String.class, float.class, double.class,
					double.class).invoke(null, entity, class0, f, d, d0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalAvoidPlayer(EntityName en,
			float f, double d, double d0) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalAvoidPlayer",
					Object.class, String.class, float.class, double.class,
					double.class).invoke(null, entity, en.getName(), f, d, d0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalAvoidPlayer(float f, double d,
			double d0) {
		newGoalSelectorPathfinderGoalAvoidPlayer(EntityName.ENTITYPLAYER, f, d,
				d0);
	}

	public void removeGoalSelectorPathfinderGoalAvoidPlayer() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalAvoidPlayer",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveIndoorsDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMoveIndoors",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMoveIndoors() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalMoveIndoors",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalRestrictOpenDoorDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalRestrictOpenDoor",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalRestrictOpenDoor() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalRestrictOpenDoor",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsTarget(double d, float f) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMoveTowardsTarget",
					Object.class, double.class, float.class).invoke(null,
					entity, d, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMoveTowardsTarget() {
		try {
			helper.getMethod(
					"removeGoalSelectorPathfinderGoalMoveTowardsTarget",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Target selector not goal selector
	/*
	 * public void newGoalSelectorPathfinderGoalHurtByTarget(double d){ try {
	 * helper.getMethod("newGoalSelectorPathfinderGoalHurtByTarget",
	 * Object.class, double.class).invoke(null, entity, d); } catch (Exception
	 * e) { e.printStackTrace(); } }
	 * 
	 * public void removeGoalSelectorPathfinderGoalHurtByTarget(){ try {
	 * helper.getMethod("removeGoalSelectorPathfinderGoalHurtByTarget",
	 * Object.class).invoke(null, entity); } catch (Exception e) {
	 * e.printStackTrace(); } } public void
	 * newGoalSelectorPathfinderGoalNearestAttackableTarget(String class0, int
	 * i, boolean b){
	 * newGoalSelectorPathfinderGoalNearestAttackableTarget(class0, i, b,
	 * false); }
	 * 
	 * public void newGoalSelectorPathfinderGoalNearestAttackableTarget(String
	 * class0, int i, boolean b, boolean b1){
	 * newGoalSelectorPathfinderGoalNearestAttackableTarget(class0, i, b, b1,
	 * null); }
	 * 
	 * public void newGoalSelectorPathfinderGoalNearestAttackableTarget(String
	 * class0, int i, boolean b, boolean b1, IEntitySelector ies){ try {
	 * helper.getMethod("newGoalSelectorPathfinderGoalNearestAttackableTarget",
	 * Object.class, String.class, int.class, boolean.class, boolean.class,
	 * Object.class) .invoke(null, entity, class0, i, b, b1, ies.get()); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 * 
	 * public void removeGoalSelectorPathfinderGoalNearestAttackableTarget(){
	 * try {
	 * helper.getMethod("removeGoalSelectorPathfinderGoalNearestAttackableTarget"
	 * , Object.class).invoke(null, entity); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	public void newGoalSelectorPathfinderGoalRestrictSunDefault() {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalRestrictSun",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalRestrictSun() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalRestrictSun",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalFleeSun(double d) {
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalFleeSun",
					Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalFleeSun() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalFleeSun",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
