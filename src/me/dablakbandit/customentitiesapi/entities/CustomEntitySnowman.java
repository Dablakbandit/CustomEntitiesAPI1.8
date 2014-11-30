package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySnowman extends CustomEntityGolem {

	public CustomEntitySnowman() {
		super("CustomEntitySnowman");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySnowman(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySnowman(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntitySnowman(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySnowmanClass() {
		try {
			return Class.forName("temp.CustomEntitySnowman");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySnowman");
			helper = Class.forName("temp.CustomEntitySnowmanHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySnowman");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntitySnowmanHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySnowmanHelper",
								"temp.CustomEntitySnowmanHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityGolemHelper"));
				ces.toClass();
				CtClass EntitySnowman = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySnowman");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySnowman");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityGolem");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySnowman);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySnowmanHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySnowmanHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySnowmanHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySnowman", 97,
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
