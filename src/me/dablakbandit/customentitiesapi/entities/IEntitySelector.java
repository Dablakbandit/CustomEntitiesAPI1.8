package me.dablakbandit.customentitiesapi.entities;

import me.dablakbandit.customentitiesapi.NMSUtils;

public class IEntitySelector {

	public static final IEntitySelector EntitySelectorChickenJockey = new IEntitySelector("EntitySelectorChickenJockey");
	public static final IEntitySelector EntitySelectorContainer = new IEntitySelector("EntitySelectorContainer");
	public static final IEntitySelector EntitySelectorEquipable = new IEntitySelector("EntitySelectorEquipable");
	public static final IEntitySelector EntitySelectorHorse = new IEntitySelector("EntitySelectorHorse");
	public static final IEntitySelector EntitySelectorLiving = new IEntitySelector("EntitySelectorLiving");
	public static final IEntitySelector EntitySelectorMonster = new IEntitySelector("EntitySelectorMonster");
	public static final IEntitySelector EntitySelectorNearestAttackableTarget = new IEntitySelector("EntitySelectorNearestAttackableTarget");
	public static final IEntitySelector EntitySelectorNotUndead = new IEntitySelector("EntitySelectorNotUndead");
	public static final IEntitySelector EntitySelectorViewable = new IEntitySelector("EntitySelectorViewable");

	private String name;

	private IEntitySelector(String name){
		this.name = name;
	}

	public Object get(){
		try {
			return NMSUtils.getNMSClass(name).newInstance();
		} catch (Exception e) {
			return null;
		}
	}
}
