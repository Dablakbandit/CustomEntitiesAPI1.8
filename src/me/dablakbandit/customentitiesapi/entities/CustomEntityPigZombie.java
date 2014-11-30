package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityPigZombie extends CustomEntityZombieExtender {

	public CustomEntityPigZombie() {
		super("CustomEntityPigZombie");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityPigZombie(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityPigZombie(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityPigZombie(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityPigZombieClass() {
		try {
			return Class.forName("temp.CustomEntityPigZombie");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityPigZombie");
			helper = Class.forName("temp.CustomEntityPigZombieHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityPigZombie");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityPigZombieHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityPigZombieHelper",
								"temp.CustomEntityPigZombieHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityZombieHelper"));
				ces.toClass();
				CtClass EntityPigZombie = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityPigZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityPigZombie");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityZombie");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityPigZombie);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityPigZombieHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityPigZombieHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityPigZombieHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityPigZombie",
					57, customentity);
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
