package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityGiantZombie extends CustomEntityMonster {

	public CustomEntityGiantZombie() {
		super("CustomEntityGiantZombie");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityGiantZombie(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityGiantZombie(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityGiantZombie(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityGiantZombieClass() {
		try {
			return Class.forName("temp.CustomEntityGiantZombie");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityGiantZombie");
			helper = Class.forName("temp.CustomEntityGiantZombieHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityGiantZombie");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityGiantZombieHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityGiantZombieHelper",
								"temp.CustomEntityGiantZombieHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityGiantZombie = cp
						.getCtClass("net.minecraft.server."
								+ NMSUtils.getVersion() + "EntityGiantZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityGiantZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityGiantZombie);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityGiantZombieHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityGiantZombieHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityGiantZombieHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityGiantZombie",
					53, customentity);
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
