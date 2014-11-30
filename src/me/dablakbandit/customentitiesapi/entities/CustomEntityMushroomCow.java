package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityMushroomCow extends CustomEntityCowExtender {

	public CustomEntityMushroomCow() {
		super("CustomEntityMushroomCow");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityMushroomCow(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityMushroomCow(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityMushroomCow(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityMushroomCowClass() {
		try {
			return Class.forName("temp.CustomEntityMushroomCow");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityMushroomCow");
			helper = Class.forName("temp.CustomEntityMushroomCowHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityMushroomCow");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityMushroomCowHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityMushroomCowHelper",
								"temp.CustomEntityMushroomCowHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityCowHelper"));
				ces.toClass();
				CtClass EntityMushroomCow = cp
						.getCtClass("net.minecraft.server."
								+ NMSUtils.getVersion() + "EntityMushroomCow");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMushroomCow");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCow");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityMushroomCow);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityMushroomCowHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityMushroomCowHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityMushroomCowHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityMushroomCow",
					96, customentity);
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
