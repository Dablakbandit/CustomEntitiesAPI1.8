package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityCow extends CustomEntityAnimal {

	public CustomEntityCow() {
		super("CustomEntityCow");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityCow(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityCow(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityCow(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityCowClass() {
		try {
			return Class.forName("temp.CustomEntityCow");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityCow");
			helper = Class.forName("temp.CustomEntityCowHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityCow");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityCowHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityCowHelper",
								"temp.CustomEntityCowHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
				CtClass EntityCow = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCow");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCow");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityCow);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityCowHelper.setUnableToMove(this);" + "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityCowHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityCowHelper.setAbleToMove(this, d);" + "}");
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityCow", 92,
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
