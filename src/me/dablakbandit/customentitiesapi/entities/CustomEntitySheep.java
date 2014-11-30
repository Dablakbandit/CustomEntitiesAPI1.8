package me.dablakbandit.customentitiesapi.entities;

import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;

public class CustomEntitySheep extends CustomEntityAnimal {

	public CustomEntitySheep() {
		super("CustomEntitySheep");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntitySheep(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntitySheep(Entity e) {
		this();
		a();
		entity = NMSUtils.getHandle(e);
	}

	public CustomEntitySheep(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySheepClass() {
		try {
			return Class.forName("temp.CustomEntitySheep");
		} catch (Exception e) {
			return null;
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntitySheep");
		} catch (Exception e1) {
			try {
				cp.appendClassPath(new LoaderClassPath(CustomEntitySheep.class
						.getClassLoader()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntitySheepHelper",
								"temp.CustomEntitySheepHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
				CtClass entitysheep = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySheep");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntitySheep");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityAgeable");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityTypes");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "World");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "InventoryCrafting");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "ContainerSheepBreed");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "CraftingManager");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "ItemStack");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "Items");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "Item");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EnumColor");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "InventoryCrafting");
				cp.importPackage("temp");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(entitysheep);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySheepHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySheepHelper.setAbleToMove(this, d);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySheepHelper.setAbleToMove(this);" + "}");
				methods.add("public int getIntColor(){"
						+ "return this.datawatcher.getByte(16) & 0xF;" + "}");
				methods.add("public void setIntColor(int i){"
						+ "byte b0 = this.datawatcher.getByte(16);"
						+ "this.datawatcher.watch(16, Byte.valueOf((byte)(b0 & 0xF0 | i & 0xF)));"
						+ "}");
				methods.add("public EntityAgeable createChild(EntityAgeable paramEntityAgeable){"
						+ "CustomEntitySheep entitysheep = this;"
						+ "CustomEntitySheep ces = (CustomEntitySheep)CustomEntitySheepHelper.createEntity(this.world, this.getClass(), getLocationX(), getLocationY(), getLocationZ(), getLocationYaw(), getLocationPitch());"
						+ "int i = this.getColor().getInvColorIndex();"
						+ "int j = ces.getColor().getInvColorIndex();"
						+ "InventoryCrafting bk = (InventoryCrafting)CustomEntitySheepHelper.getInventoryCrafting(this);"
						+ "bk.getItem(0).setData(i);"
						+ "bk.getItem(1).setData(j);"
						+ "ItemStack itemstack = CraftingManager.getInstance().craft(bk, this.world);"
						+ "int k;"
						+ "if ((itemstack != null) && (itemstack.getItem() == Items.DYE)) {"
						+ "k = itemstack.getData();"
						+ "} else {"
						+ "k = this.world.random.nextBoolean() ? i : j;"
						+ "}"
						+ "ces.setColor(EnumColor.fromInvColorIndex(k));"
						+ "return ces;" + "}");
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
			CustomEntitiesAPI.getInstance().registerEntity("EntitySheep", 91,
					customentity);
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntitySheep");
			helper = Class.forName("temp.CustomEntitySheepHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPanicDefault() {
		newGoalSelectorPathfinderGoalPanic(1.25D);
	}

	public void newGoalSelectorPathfinderGoalBreedDefault() {
		newGoalSelectorPathfinderGoalBreed(1.25D);
	}

	public void newGoalSelectorPathfinderGoalTemptDefault() {
		newGoalSelectorPathfinderGoalTempt(1.1D, "WHEAT", false);
	}

	public void newGoalSelectorPathfinderGoalFollowParentDefault() {
		newGoalSelectorPathfinderGoalFollowParent(1.25D);
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault() {
		newGoalSelectorPathfinderGoalRandomStroll(1.25D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault() {
		newGoalSelectorPathfinderGoalLookAtPlayer(6.0F, 0.02F);
	}

	@Deprecated
	public Object getCustomEntitySheep() {
		return this.entity != null ? this.entity : null;
	}

	public int getColor() {
		try {
			return (int) entity.getClass().getMethod("getIntColor")
					.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("deprecation")
	public DyeColor getDyeColor() {
		return DyeColor.getByWoolData((byte) getColor());
	}

	public void setColor(int i) {
		try {
			entity.getClass().getMethod("setIntColor", int.class)
					.invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSheared(boolean flag) {
		try {
			entity.getClass().getMethod("setSheared", boolean.class)
					.invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
