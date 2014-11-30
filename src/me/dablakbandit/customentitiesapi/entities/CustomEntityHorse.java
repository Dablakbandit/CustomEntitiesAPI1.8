package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityHorse extends CustomEntityAnimal {

	public CustomEntityHorse() {
		super("CustomEntityHorse");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityHorse(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityHorse(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityHorse(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityHorseClass() {
		try {
			return Class.forName("temp.CustomEntityHorse");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityHorse");
			helper = Class.forName("temp.CustomEntityHorseHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityHorse");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityHorseHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityHorseHelper",
								"temp.CustomEntityHorseHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
				CtClass EntityHorse = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityHorse");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityHorse");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityHorse);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityHorseHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityHorseHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityHorseHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityHorse", 100,
					customentity);
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
