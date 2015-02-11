package javaBeansExample;

public class Pet {

	private String breed;
	private String color;
	private String owner;

	public Pet() {
		
	}
	
	public Pet(String breed, String color, String owner) {
		
		this.breed = breed;
		this.color = color;
		this.owner = owner;
		
	}
	
	public void playDead(String owner, String breed) {
		
		this.owner = owner;
		this.breed = breed;
		
		System.out.println(owner + ", no one can see your " + breed + "'s status");
		
	}
	
}
