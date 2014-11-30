package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityPig extends CustomEntityAnimal {

	public CustomEntityPig() {
		super("CustomEntityPig");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityPig(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityPig(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityPig(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityPigClass() {
		try {
			return Class.forName("temp.CustomEntityPig");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityPig");
			helper = Class.forName("temp.CustomEntityPigHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityPig");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityPigHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityPigHelper",
								"temp.CustomEntityPigHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
				CtClass EntityPig = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityPig");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityPig");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityPig);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityPigHelper.setUnableToMove(this);" + "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityPigHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityPigHelper.setAbleToMove(this, d);" + "}");
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityPig", 90,
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
