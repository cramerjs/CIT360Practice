package javaBeansExample;

public class PetPost {

	public static void main(String[] args) {

		// ----- CREATE 2 NEW PET OBJs using No Arg Constructor -----
		
		PetBean spot = new PetBean();

		spot.setBreed("German Shepherd");
		spot.setOwner("Jerry McGuire");
		spot.setColor("grey-black");

		PetBean cowboy = new PetBean();

		cowboy.setBreed("Pitbull");
		cowboy.setOwner("Wyatt Earp");
		cowboy.setColor("brindle");

		// ----- CREATE 2 NEW PET OBJs using Full Constructor -----
		
		PetBean sylvester = new PetBean("Tabby Cat", "b&w", "Grandma");

		PetBean tweety = new PetBean("Canary", "yellow", "Grandma");
		
		
		
		// ----- DISPLAY GREETING FOR WYATT EARP -----
		
		System.out.print("Welcome to PetPost, " + spot.getOwner()
				+ "! Do you have any new pictures of your " + spot.getColor()
				+ " " + spot.getBreed() + " that you would like to share?! \n");

		
		
		// ----- CHECK COWBOY UPDATE
		
		// generate arbitrary hash code for Cowboy
		
		int cowboyHashCode = cowboy.hashCode();
		System.out.println("Cowboy's Hash Code = " + cowboyHashCode);
		
		// change owner
		
		cowboy.setOwner("Roy O'bannon");
		
		// generate new hash code for Cowboy
		
		int cowboyHashCode1 = cowboy.hashCode();
		System.out.println("Cowboy's New Hash Code = " + cowboyHashCode1);
		
			// use hashCode to see if cowboy has changed
			
			if(cowboyHashCode == cowboyHashCode1) {
				
				System.out.println("You have already added this pet to PetPost.");
				
			} else {
				
				System.out.println("Your pet's information has been updated.");
				
			}
		
			
		// ----- COMPARE TWEETY & SYLVESTER -----
		
		// compare sylvester obj to tweety obj using equals method
		
		if(tweety.equals(sylvester)) {
			
			System.out.println("You have already added this pet to PetPost.");
			
		} else {
			
			System.out.println("There is no pet like your pet!! :) ");
			
		}
		
		
//		// testing hash code to see why tweety and sylvester objects are equal
//		
//		int tweetyHashCode = tweety.hashCode();
//		System.out.println("Tweety's Hash Code = " + tweetyHashCode);
//		
//		int sylvesterHashCode = sylvester.hashCode();
//		System.out.println("Sylvester's Hash Code = " + sylvesterHashCode);
//		
//			// use hashCode to compare Tweety to Sylvester
//			
//			if(tweetyHashCode == sylvesterHashCode) {
//				
//				System.out.println("You have already added this pet to PetPost.");
//				
//			} else {
//				
//				System.out.println("There is no pet like your pet!! :) ");
//				
//			}
	
		String spotBreed = spot.getBreed();
		String spotColor = spot.getColor();
		String spotOwner = spot.getOwner();
				
		// create spot Pet obj
		Pet spotLive = new Pet(spotBreed, spotColor, spotOwner);
		
		// playDead method experimentation
		spotLive.playDead(spotOwner, spotBreed);
		
	}
	
}