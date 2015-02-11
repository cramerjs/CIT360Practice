package collectionsExample;

import java.util.*;

public class PetPost2 {

	public static void main(String[]args) {
	
	// create 3 new PetBeans
	
	PetBean tod = new PetBean("Tod", "Fox", "red", "Widow Tweed");
	
	PetBean copper = new PetBean("Copper", "Hound Dog", "darkbrown-brown-white", "Amos Slade");
	
	PetBean richardParker = new PetBean("Richard Parker", "Bengal Tiger", "orange-white", "Pi Patel");
	
	// create 3 new OwnerBeans
	
	OwnerBean widowTweed = new OwnerBean("Widow Tweed", "blackwidow77", "NAMERICA", true);
	
	OwnerBean amosSlade = new OwnerBean("Amos Slade", "KJVamos37", "NAMERICA", false);
	
	OwnerBean pi = new OwnerBean("Pi Patel", "yannFanPatel123", "ASIA", true);
	
	// --- ArrayList --- //
	
	System.out.println(" --- Array List --- ");
	
	ArrayList<PetBean> petArrayList = new ArrayList<PetBean>();
	System.out.println("Initial size of petArrayList: " + petArrayList.size());
	
	petArrayList.add(tod);
	petArrayList.add(copper);
	petArrayList.add(richardParker);
	System.out.println("Size of petArrayList: " + petArrayList.size());
	System.out.println("Contents of petArrayList: " + petArrayList);
	
	petArrayList.remove(richardParker);
	petArrayList.remove(1);
	System.out.println("Size of petArrayList: " + petArrayList.size());
	System.out.println("Contents of petArrayList: " + petArrayList);
	
	ArrayList<OwnerBean> ownerArrayList = new ArrayList<OwnerBean>(10);
	System.out.println("Size of ownerArrayList: " + ownerArrayList.size());
	
	// --- TreeSet --- //

	System.out.println(" --- Tree Set --- ");
	
	TreeSet<PetBean> petTreeSet = new TreeSet<PetBean>();
	petTreeSet.add(tod);
	petTreeSet.add(copper);
	petTreeSet.add(richardParker);
	System.out.println("Size of petTreeSet: " + petTreeSet.size());
	System.out.println("Contents of petTreeSet: " + petTreeSet);
	
	// --- LinkedList --- //
	
	LinkedList<PetBean> petLinkedList = new LinkedList<PetBean>();

	// --- HashMap --- //
	
	HashMap<String, PetBean> petMapByName = new HashMap<String, PetBean>();
	
	petMapByName.put("Tod", tod);
	petMapByName.put("Copper", copper);
	
	// HashMap<double, PetBean> petMapByUniqueIdNumber = new HashMap<double, PetBean>();
	
	// --- TreeMap --- //
	
	// TreeMap<PetBean> petTreeMap = new TreeMap<PetBean>();
	
	}
	
}