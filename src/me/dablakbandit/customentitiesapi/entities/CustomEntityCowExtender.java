package me.dablakbandit.customentitiesapi.entities;

public abstract class CustomEntityCowExtender extends CustomEntityAnimal {

	public CustomEntityCowExtender(String name) {
		super(name);
	}
	
	public void newGoalSelectorPathfinderGoalPanicDefault(){
		newGoalSelectorPathfinderGoalPanic(2.0D);
	}
	
	public void newGoalSelectorPathfinderGoalBreedDefault(){
		newGoalSelectorPathfinderGoalBreed(1.0D);
	}
	
	public void newGoalSelectorPathfinderGoalTemptDefault(){
		newGoalSelectorPathfinderGoalTempt(1.25D, "WHEAT", false);
	}
	
	public void newGoalSelectorPathfinderGoalFollowParentDefault(){
		newGoalSelectorPathfinderGoalFollowParent(1.25D);
	}
	
	public void newGoalSelectorPathfinderGoalRandomStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(1.0D);
	}
	
	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 6.0F);
	}
}
