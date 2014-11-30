package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntityLivingHelper extends CustomEntityHelper {

	public static void setIAttribute(Object living, String iattributestring,
			double value) {
		try {
			Class<?> entityliving = getNMSClass("EntityLiving");
			Class<?> genericattributes = getNMSClass("GenericAttributes");
			Class<?> iattribute = getNMSClass("IAttribute");
			Object iattrib;
			switch (iattributestring) {
			case "MAX_HEALTH": {
				Field f = genericattributes.getDeclaredField("maxHealth");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "FOLLOW_RANGE": {
				Field f = genericattributes.getDeclaredField("b");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "KNOCKBACK_RESISTANCE": {
				Field f = genericattributes.getDeclaredField("c");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "MOVEMENT_SPEED": {
				Field f = genericattributes.getDeclaredField("d");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "ATTACK_DAMAGE": {
				Field f = genericattributes.getDeclaredField("e");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			default:
				iattrib = null;
			}
			Object attributeinstance = entityliving.getMethod(
					"getAttributeInstance", iattribute).invoke(living, iattrib);
			attributeinstance.getClass().getMethod("setValue", double.class)
					.invoke(attributeinstance, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double getIAttribute(Object living, String iattributestring) {
		try {
			Class<?> entityliving = getNMSClass("EntityLiving");
			Class<?> genericattributes = getNMSClass("GenericAttributes");
			Class<?> iattribute = getNMSClass("IAttribute");
			Object iattrib;
			switch (iattributestring) {
			case "MAX_HEALTH": {
				Field f = genericattributes.getDeclaredField("maxHealth");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "FOLLOW_RANGE": {
				Field f = genericattributes.getDeclaredField("b");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "KNOCKBACK_RESISTANCE": {
				Field f = genericattributes.getDeclaredField("c");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "MOVEMENT_SPEED": {
				Field f = genericattributes.getDeclaredField("d");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			case "ATTACK_DAMAGE": {
				Field f = genericattributes.getDeclaredField("e");
				f.setAccessible(true);
				iattrib = f.get(null);
				break;
			}
			default:
				iattrib = null;
			}
			Object attributeinstance = entityliving.getMethod(
					"getAttributeInstance", iattribute).invoke(living, iattrib);
			return (double) attributeinstance.getClass().getMethod("getValue")
					.invoke(attributeinstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0D;
	}

}
