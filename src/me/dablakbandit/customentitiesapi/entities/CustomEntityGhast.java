package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityGhast extends CustomEntityFlying {

	public CustomEntityGhast() {
		super("CustomEntityGhast");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityGhast(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityGhast(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityGhast(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityGhastClass() {
		try {
			return Class.forName("temp.CustomEntityGhast");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityGhast");
			helper = Class.forName("temp.CustomEntityGhastHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityGhast");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityGhastHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityGhastHelper",
								"temp.CustomEntityGhastHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityFlyingHelper"));
				ces.toClass();
				CtClass EntityGhast = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityGhast");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityGhast");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityFlying");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityGhast);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityGhastHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityGhastHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityGhastHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityGhast", 56,
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
