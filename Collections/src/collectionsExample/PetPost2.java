package collectionsExample;

import java.util.*;

import collectionsExample.OwnerBean.Continent;

public class PetPost2 {

	public static void main(String[]args) {
		
	Continent AFRICA = null, ASIA = null, EUROPE = null, OCEANIA = null, NORTHAMERICA = null, SOUTHAMERICA = null, ANTARCTICA = null;
	
	// create new PetBeans
		
	PetBean tod = new PetBean("Tod", "Fox", "red", "Widow Tweed");
	
	PetBean copper = new PetBean("Copper", "Hound Dog", "darkbrown-brown-white", "Amos Slade");
	
	PetBean richardParker = new PetBean("Richard Parker", "Bengal Tiger", "orange-white", "Pi Patel");
	
	PetBean clifford = new PetBean("Clifford", "Big Red Dog", "red", "Jetta");
	
	PetBean lassie = new PetBean("Lassie", "collie", "white-brown", "Rudd Weatherwax");
	
	PetBean elliot = new PetBean("Elliot", "dragon", "green", "Pete");
	
	PetBean hedwig = new PetBean("Hedwig", "owl", "white", "Harry Potter");
	
	PetBean scabbers = new PetBean("Scabbers", "rat", "brown", "Ron Weasley");
	
	PetBean crookshanks = new PetBean("Crookshanks", "cat", "orange", "Hermione Granger");
	
	// create new OwnerBeans
	
	OwnerBean widowTweed = new OwnerBean("Widow Tweed", "blackwidow77", NORTHAMERICA, true);
	
	OwnerBean amosSlade = new OwnerBean("Amos Slade", "KJVamos37", NORTHAMERICA, false);
	
	OwnerBean pi = new OwnerBean("Pi Patel", "yannFanPatel123", ASIA, true);
	
	OwnerBean harryPotter = new OwnerBean("Harry Potter", "voldemortKiller2009", EUROPE, true);

	OwnerBean ronWeasley = new OwnerBean("Ron Weasley", "lameClaimToFame2010", EUROPE, false);

	OwnerBean hermioneGranger = new OwnerBean("Hermione Granger", "emmaHotson2011", EUROPE, true);

	
	// --- ArrayList --- //
	
		// List //
		// precise control over sequence, elements may be duplicated
	
	System.out.println(" --- Array List --- ");
	
	ArrayList<PetBean> petArrayList = new ArrayList<PetBean>();
		
	// add object to petArrayList
	petArrayList.add(tod);
	petArrayList.add(copper);
	petArrayList.add(0, richardParker); // adds object to the beginning of the arrayList
	
	System.out.println("Size of petArrayList: " + petArrayList.size());
	
	// Iterator
	Iterator<PetBean> itr = petArrayList.iterator();
	while(itr.hasNext()) {
		
		PetBean element = itr.next();
		System.out.println(element.toString() + " ");
		
	}
	
	// example of contains method
	System.out.println("tod is in this collection: " + petArrayList.contains(tod));
	
	// examples of remove method
	petArrayList.remove(richardParker);
	petArrayList.remove(1);
	
	// example of size method
	System.out.println("Size of petArrayList: " + petArrayList.size());
	System.out.println("Contents of petArrayList: ");
	
	// example of duplicate elements in List collection type
	petArrayList.add(tod);
	petArrayList.add(tod);
	for(PetBean pets : petArrayList)
		System.out.println(pets.getName());

	// example of clear and isEmpty methods
	petArrayList.clear();
	System.out.println("ownerArrayList is empty: " + petArrayList.isEmpty());
	
	System.out.println();

	
	// --- HashSet --- //

		// Set //
		// cannot contain duplicate elements 
	
	System.out.println(" --- Hash Set --- ");
	
	// example of duplicate elements in a set
	HashSet<PetBean> petHashSetDup = new HashSet<PetBean>();
	petHashSetDup.add(clifford);
	petHashSetDup.add(clifford);
	petHashSetDup.add(clifford);
	
	HashSet<PetBean> petHashSet = new HashSet<PetBean>();
	petHashSet.add(tod);
	petHashSet.add(copper);
	petHashSet.add(richardParker);
	
	HashSet<PetBean> petHashSet2 = new HashSet<PetBean>();
	petHashSet2.add(tod);
	petHashSet2.add(copper);
	petHashSet2.add(richardParker);
	petHashSet2.add(clifford);
	petHashSet2.add(lassie);
	petHashSet2.add(elliot);
	
	HashSet<PetBean> petHashSet3 = new HashSet<PetBean>();
	petHashSet3.add(hedwig);
	petHashSet3.add(scabbers);
	petHashSet3.add(crookshanks);
	
	HashSet<PetBean> petHashSet4 = new HashSet<PetBean>();
	petHashSet4.add(hedwig);
	petHashSet4.add(scabbers);
	petHashSet4.add(crookshanks);
	petHashSet4.add(elliot);
	
	HashSet<PetBean> petHashSet5 = new HashSet<PetBean>();
	petHashSet5.add(hedwig);
	petHashSet5.add(scabbers);
	petHashSet5.add(tod);
	petHashSet5.add(copper);
	
	System.out.println("Contents of petHashSetDup " + petHashSetDup);
	System.out.println("Contents of petHashSet " + petHashSet);
	System.out.println("Contents of petHashSet2 " + petHashSet2);	
	System.out.println("Contents of petHashSet3 " + petHashSet3);

	System.out.println(petHashSet2.containsAll(petHashSet));
	
	// example of addAll() method
	HashSet<PetBean> union = new HashSet<PetBean>(petHashSet2);
	union.addAll(petHashSet3); // union contains the merged union of petHashSet2 and petHashSet3
	System.out.println("Contents of union " + union);
	
	// example of retainAll() method
	HashSet<PetBean> intersection = new HashSet<PetBean>(petHashSet2);
	intersection.retainAll(petHashSet); // intersection contains only the elements common to both sets
	System.out.println("Contents of intersection " + intersection);

	// example of removeAll() method
	HashSet<PetBean> difference = new HashSet<PetBean>(union);
	difference.removeAll(petHashSet2); // difference contains the elements in union minus the elements in petHashSet2
	System.out.println("Contents of difference " + difference);

	// example of symmetric difference
	HashSet<PetBean> symmetricDiff = new HashSet<PetBean>(petHashSet4);
	symmetricDiff.addAll(petHashSet5);
	HashSet<PetBean> tmp = new HashSet<PetBean>(petHashSet4);
	tmp.retainAll(petHashSet5);
	symmetricDiff.removeAll(tmp);
	System.out.println("Contents of symmetricDiff " + symmetricDiff);

	System.out.println();
	
	// --- HashMap --- //
	// object that maps keys to values, cannot contain duplicate keys, 1:1 (key:value)
	
		// Hash //
	
	System.out.println(" --- Hash Map --- ");
	
	HashMap<OwnerBean, HashSet<PetBean>> petsByOwner = new HashMap<OwnerBean, HashSet<PetBean>>();
	petsByOwner.put(widowTweed, petHashSet);
	petsByOwner.put(amosSlade, petHashSet2);
	petsByOwner.put(pi, petHashSet3);
	System.out.println("Contents of petsByOwner " + petsByOwner);
	System.out.println(petsByOwner.containsValue(richardParker));
	System.out.println(petsByOwner.containsValue(petHashSet3));
	
	HashMap<Integer, OwnerBean> ownerMapByUID = new HashMap<Integer, OwnerBean>();
	ownerMapByUID.put(0001, harryPotter);
	ownerMapByUID.put(0002, ronWeasley);
	ownerMapByUID.put(0003, hermioneGranger);
	ownerMapByUID.put(0003, hermioneGranger); // overwrites previous key-value pair
	ownerMapByUID.put(0003, harryPotter); // overwrites previous value at 0003 key
	ownerMapByUID.put(0004, null);
	ownerMapByUID.put(null, hermioneGranger);
	System.out.println("Contents of ownerMapByUID" + ownerMapByUID);
	
	System.out.println(ownerMapByUID.containsValue(ronWeasley));
	
	ownerMapByUID.remove(0003, hermioneGranger);
	System.out.println("Contents of ownerMapByUID" + ownerMapByUID);
	
	HashMap<Double, String> petMapByUniqueIdNumber = new HashMap<Double, String>();
	petMapByUniqueIdNumber.put(new Double(000000), "Tod");
	petMapByUniqueIdNumber.put(new Double(000001), "Copper");
	petMapByUniqueIdNumber.put(new Double(000002), "Rex");
	petMapByUniqueIdNumber.put(new Double(000003), "Woody");
	petMapByUniqueIdNumber.put(new Double(041234), "Buzz");
//	petMapByUniqueIdNumber.put(new Double(""), "Buzz");
	petMapByUniqueIdNumber.put(new Double(999999999), "Buzz");
	petMapByUniqueIdNumber.put(new Double(-999999999), "Buzz");
	petMapByUniqueIdNumber.put(new Double(-001), "Buzz");


	System.out.println("Contents of petMapByUniqueIdNumber" + petMapByUniqueIdNumber);
	
	System.out.println();
	
	// --- TreeMap --- //
	
		// Tree //
	
	System.out.println(" --- Tree Map --- ");
	
	TreeMap<OwnerBean, HashSet<PetBean>> petsByOwnerTree = new TreeMap<OwnerBean, HashSet<PetBean>>();
	petsByOwnerTree.put(widowTweed, petHashSet);
	petsByOwnerTree.put(amosSlade, petHashSet2);
	petsByOwnerTree.put(pi, petHashSet3);
	petsByOwnerTree.put(harryPotter, union);
	petsByOwnerTree.put(hermioneGranger, symmetricDiff);
	System.out.println("Contents of petsByOwner " + petsByOwnerTree);
	System.out.println(petsByOwnerTree.containsValue(richardParker));
	System.out.println(petsByOwnerTree.containsValue(petHashSet3));
	System.out.println(petsByOwnerTree.headMap(pi));
	System.out.println(petsByOwnerTree.tailMap(pi));
	System.out.println(petsByOwnerTree.subMap(harryPotter, pi)); // pi is not included in the retrieved values
	
	}
	
}