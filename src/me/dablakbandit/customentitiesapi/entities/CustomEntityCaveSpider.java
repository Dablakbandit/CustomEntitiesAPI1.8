package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityCaveSpider extends CustomEntitySpiderExtender {

	public CustomEntityCaveSpider() {
		super("CustomEntityCaveSpider");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityCaveSpider(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityCaveSpider(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityCaveSpider(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityCaveSpiderClass() {
		try {
			return Class.forName("temp.CustomEntityCaveSpider");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityCaveSpider");
			helper = Class.forName("temp.CustomEntityCaveSpiderHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityCaveSpider");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityCaveSpiderHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityCaveSpiderHelper",
								"temp.CustomEntityCaveSpiderHelper");
				ces.setSuperclass(cp.get("temp.CustomEntitySpiderHelper"));
				ces.toClass();
				CtClass EntityCaveSpider = cp
						.getCtClass("net.minecraft.server."
								+ NMSUtils.getVersion() + "EntityCaveSpider");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityCaveSpider");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySpider");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityCaveSpider);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityCaveSpiderHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityCaveSpiderHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityCaveSpiderHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityCaveSpider",
					59, customentity);
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
