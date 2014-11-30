package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityMagmaCube extends CustomEntitySlimeExtender {

	public CustomEntityMagmaCube() {
		super("CustomEntityMagmaCube");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityMagmaCube(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityMagmaCube(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityMagmaCube(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityMagmaCubeClass() {
		try {
			return Class.forName("temp.CustomEntityMagmaCube");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityMagmaCube");
			helper = Class.forName("temp.CustomEntityMagmaCubeHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityMagmaCube");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityMagmaCubeHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityMagmaCubeHelper",
								"temp.CustomEntityMagmaCubeHelper");
				ces.setSuperclass(cp.get("temp.CustomEntitySlimeHelper"));
				ces.toClass();
				CtClass EntityMagmaCube = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMagmaCube");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMagmaCube");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySlime");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityMagmaCube);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityMagmaCubeHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityMagmaCubeHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityMagmaCubeHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityMagmaCube",
					62, customentity);
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
