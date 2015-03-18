package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySpider extends CustomEntityMonster {

	public CustomEntitySpider() {
		super("CustomEntitySpider");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySpider(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySpider(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntitySpider(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySpiderClass() {
		try {
			return Class.forName("temp.CustomEntitySpider");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySpider");
			helper = Class.forName("temp.CustomEntitySpiderHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySpider");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntitySpiderHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySpiderHelper",
								"temp.CustomEntitySpiderHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntitySpider = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySpider");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySpider");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySpider);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySpiderHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySpiderHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySpiderHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySpider", 52,
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
	
	public void newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName en) {
		try {
			helper.getMethod("newGoalSelectorPathfinderSpiderMeleeAttack", Object.class, String.class)
			.invoke(null, entity, en.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMeleeAttack() {
		try {
			helper.getMethod("removeGoalSelectorPathfinderSpiderMeleeAttack",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalLeapAtTargetDefault(){
		newGoalSelectorPathfinderGoalLeapAtTarget(0.4F);
	}
	
	public void newGoalSelectorPathfinderGoalSpiderMeleeAttackDefault() {
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName.ENTITYHUMAN);
		newGoalSelectorPathfinderGoalSpiderMeleeAttack(EntityName.ENTITYIRONGOLEM);
	}
	
	public void newGoalSelectorPathfinderGoalStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(0.8D); 
	}
	
	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 8.0F);
	}

}
