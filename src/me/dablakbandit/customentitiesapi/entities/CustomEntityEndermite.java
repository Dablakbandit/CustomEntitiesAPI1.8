package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityEndermite extends CustomEntityMonster {

	public CustomEntityEndermite() {
		super("CustomEntityEndermite");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityEndermite(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityEndermite(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityEndermite(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityEndermiteClass() {
		try {
			return Class.forName("temp.CustomEntityEndermite");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityEndermite");
			helper = Class.forName("temp.CustomEntityEndermiteHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityEndermite");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityEndermiteHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityEndermiteHelper",
								"temp.CustomEntityEndermiteHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityEndermite = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityEndermite");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityEndermite");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityEndermite);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityEndermiteHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityEndermiteHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityEndermiteHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityEndermite",
					67, customentity);
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
