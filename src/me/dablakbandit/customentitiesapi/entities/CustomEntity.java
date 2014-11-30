package me.dablakbandit.customentitiesapi.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import ja.ClassPool;
import ja.CtClass;
import ja.CtField;
import ja.LoaderClassPath;

public abstract class CustomEntity {

	protected List<String> methods = new ArrayList<String>();
	protected List<CtField> fields = new ArrayList<CtField>();
	protected CtClass ctClass;
	protected Class<?> customentity, helper;
	protected ClassPool cp = CustomEntities.getClassPool();
	protected Object entity;
	String b;

	public CustomEntity(String name){
		try{
			customentity = Class.forName("temp." + name);
			helper = Class.forName("temp." + name + "Helper");
			return;
		}catch(Exception e){
		}
		try {
			cp.appendClassPath(new LoaderClassPath(CustomEntity.class.getClassLoader()));
			try{
				Class.forName("temp.CustomEntityHelper");
			} catch (Exception e) {
				CtClass ces = cp.getAndRename("me.dablakbandit.customentitiesapi.entities.CustomEntityHelper", "temp.CustomEntityHelper");
				ces.toClass();
			}
			ctClass = cp.makeClass("temp." + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			fields.add(new CtField(CtClass.booleanType, "pushable", ctClass));
			cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "NBTTagCompound");
			methods.add("public void b(NBTTagCompound nbt){"
					+ "super.a(nbt);"
					+ "nbt.setBoolean(\"pushable\", this.pushable);"
					+ "}");
			methods.add("public void a(NBTTagCompound nbt){"
					+ "super.a(nbt);"
					+ "if(nbt.hasKey(\"pushable\")){"
					+ "this.pushable = nbt.getBoolean(\"pushable\");"
					+ "}else{"
					+ "this.pushable = true;"
					+ "}"
					+ "}");
			methods.add("public void g(double d0, double d1, double d2){"
					+ "if(this.pushable){"
					+ "super.g(d0, d1, d2);"
					+ "}"
					+ "}");
			methods.add("public void setPushable(){"
					+ "this.pushable=true;"
					+ "}");
			methods.add("public void setUnpushable(){"
					+ "this.pushable=false;"
					+ "}");
			methods.add("public boolean getUnpushable(){"
					+ "return !this.pushable;"
					+ "}");
			methods.add("public boolean getPushable(){"
					+ "return this.pushable;"
					+ "}");
			methods.add("public double getLocationX(){"
					+ "return this.locX;"
					+ "}");
			methods.add("public double getLocationY(){"
					+ "return this.locY;"
					+ "}");
			methods.add("public double getLocationZ(){"
					+ "return this.locZ;"
					+ "}");
			methods.add("public float getLocationYaw(){"
					+ "return this.yaw;"
					+ "}");
			methods.add("public float getLocationPitch(){"
					+ "return this.pitch;"
					+ "}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void spawnEntity(Location location){
		if(entity!=null)return;
		try {
			Object o = NMSUtils.getHandle(location.getWorld());
			Object newentity = helper.getMethod("createEntity", Object.class, Class.class, double.class, double.class, double.class, float.class, float.class)
					.invoke(null, o, customentity, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
			o.getClass().getMethod("addEntity", NMSUtils.getNMSClass("Entity")).invoke(o, newentity);
			entity = newentity;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void teleportTo(Location location){
		try {
			entity.getClass().getMethod("teleportTo", location.getClass(), boolean.class).invoke(entity, location, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getAirTicks(){
		try {
			return (int) entity.getClass().getMethod("getAirTicks").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getId(){
		try {
			return (int) entity.getClass().getMethod("getId").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public UUID getUUID(){
		try {
			return (UUID) entity.getClass().getMethod("getUniqueID").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setAirTicks(int i){
		try {
			entity.getClass().getMethod("setAirTicks", int.class).invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setInvisible(boolean flag){
		try {
			entity.getClass().getMethod("setInvisible", boolean.class).invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLocation(double d0, double d1, double d2){
		try {
			entity.getClass().getMethod("setLocation", double.class, double.class, double.class).invoke(entity, d0, d1, d2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setOnFire(int i){
		try {
			entity.getClass().getMethod("setOnFire", int.class).invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPosition(double d0, double d1, double d2){
		try {
			entity.getClass().getMethod("setPosition", double.class, double.class, double.class).invoke(entity, d0, d1, d2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPositionRotation(double d0, double d1, double d2, float f1, float f2){
		try {
			entity.getClass().getMethod("setPositionRotation", double.class, double.class, double.class, float.class, float.class).invoke(entity, d0, d1, d2, f1, f2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSneaking(boolean flag){
		try {
			entity.getClass().getMethod("setSneaking", boolean.class).invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Entity getBukkitEntity(){
		try {
			return (Entity) entity.getClass().getMethod("getBukkitEntity").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setDamageable(boolean value){
		if(value){
			try{
				helper.getMethod("setDamageable", Object.class).invoke(null, entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				helper.getMethod("setUndamageable", Object.class).invoke(null, entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void setUndamageable(boolean value){
		if(!value){
			try{
				helper.getMethod("setDamageable", Object.class).invoke(null, entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				helper.getMethod("setUndamageable", Object.class).invoke(null, entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void setDamageable(){
		try{
			helper.getMethod("setDamageable", Object.class).invoke(null, entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setUndamageable(){
		try{
			helper.getMethod("setUndamageable", Object.class).invoke(null, entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean getDamageable(){
		try{
			return (boolean)helper.getMethod("getDamageable", Object.class).invoke(null, entity);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
	}
	
	public final void setPushable(){
		try {
			entity.getClass().getMethod("setPushable").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void setPushable(boolean value){
		if(value){
			setPushable();
		}else{
			setUnpushable();
		}
	}
	
	public final void setUnpushable(){
		try {
			entity.getClass().getMethod("setUnpushable").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void setUnpushable(boolean value){
		if(value){
			setUnpushable();
		}else{
			setPushable();
		}
	}
	
	public final boolean getPushable(){
		try {
			return (boolean)entity.getClass().getMethod("getPushable").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public final void setAbleToMove(){
		try {
			helper.getMethod("setAbleToMove", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void setAbleToMove(boolean value){
		if(value){
			setAbleToMove();
		}else{
			setUnableToMove();
		}
	}

	public final void setAbleToMove(double d){
		try {
			helper.getMethod("setAbleToMove", Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void setUnableToMove(){
		try {
			helper.getMethod("setUnableToMove", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void setUnableToMove(boolean value){
		if(value){
			setUnableToMove();
		}else{
			setAbleToMove();
		}
	}

	public Object getEntity(){
		return this.entity;
	}
}
