package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySquid extends CustomEntityWaterAnimal {

	public CustomEntitySquid() {
		super("CustomEntitySquid");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySquid(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySquid(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntitySquid(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySquidClass() {
		try {
			return Class.forName("temp.CustomEntitySquid");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySquid");
			helper = Class.forName("temp.CustomEntitySquidHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySquid");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntitySquidHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySquidHelper",
								"temp.CustomEntitySquidHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityWaterAnimalHelper"));
				ces.toClass();
				CtClass EntitySquid = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySquid");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySquid");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityWaterAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySquid);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySquidHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySquidHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySquidHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySquid", 94,
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
