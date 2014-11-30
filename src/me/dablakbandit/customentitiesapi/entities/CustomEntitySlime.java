package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySlime extends CustomEntityInsentient {

	public CustomEntitySlime() {
		super("CustomEntitySlime");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySlime(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySlime(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntitySlime(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySlimeClass() {
		try {
			return Class.forName("temp.CustomEntitySlime");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySlime");
			helper = Class.forName("temp.CustomEntitySlimeHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySlime");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntitySlimeHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySlimeHelper",
								"temp.CustomEntitySlimeHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityInsentientHelper"));
				ces.toClass();
				CtClass EntitySlime = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySlime");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySlime");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityInsentient");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySlime);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySlimeHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySlimeHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySlimeHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySlime", 55,
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
