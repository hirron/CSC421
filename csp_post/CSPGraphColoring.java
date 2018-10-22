import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;

public class CSPGraphColoring extends CSP {
	
	public boolean isGood(Object X, Object Y, Object x, Object y) {
		//if X is not even mentioned in by the constraints, just return true
		//as nothing can be violated
		if(!C.containsKey(X))
			return true;
		
		//check to see if there is an arc between X and Y
		//if there isn't an arc, then no constraint, i.e. it is good
		if(!C.get(X).contains(Y))
			return true;
		
		//not equal constraint
		if(!x.equals(y)) 
			return true;
		
		return false;
	}
		
	public static void main(String[] args) throws Exception {
		CSPGraphColoring csp = new CSPGraphColoring();
		
		// Using Demo code from CSP Lecture *******
		Set<Object> varCol = new HashSet<Object>(
		Arrays.asList(new String[] {"blue", "green", "ivory", "red", "yellow"}));
		Set<Object> varDri = new HashSet<Object>(
		Arrays.asList(new String[] {"coffee", "milk", "orange-juice", "tea", "water"}));
		Set<Object> varNat = new HashSet<Object>(
		Arrays.asList(new String[] {"englishman", "japanese", "norwegian", "spaniard", "ukrainian"}));
		Set<Object> varPet = new HashSet<Object>(
		Arrays.asList(new String[] {"dog", "fox", "horse", "snails", "zebra"}));
		Set<Object> varCig = new HashSet<Object>(
		Arrays.asList(new String[] {"chesterfield", "kools", "lucky-strike", "old-gold", "parliament"}));
		
		// *******
		

		Integer[] dom = {1,2,3,4,5};
		for(Object X : varCol)
			csp.addDomain(X, dom);
		
		//unary constraints: just remove values from domains
	
		//binary constraints: add constraint arcs
		//The Englishman lives in the red house.
		csp.addBidirectionalArc("englishman", "red");

		//Uniqueness constraints
		for(Object X : varCol){
					for(Object Y : varCol){
					csp.addBidirectionalArc(X,Y);
					}
		}



		//Now let's search for solution
		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());

		
		
		
		// **** Code for 3 colouring of Australia
		
		/*
		String[] vars = {"WA", "NT", "Q", "NSW", "V", "SA", "T"}; 
		String[] colors = {"r", "g", "b"};
		String[][] pairs = {{"WA","NT"}, {"NT","Q"}, {"Q","NSW"}, {"NSW","V"}, 
							{"SA", "WA"}, {"SA", "NT"}, {"SA", "Q"}, 
							{"SA", "NSW"}, {"SA", "V"}};
		
		
		// ****
		for(Object X : vars) 
			csp.addDomain(X, colors);
		
		for(Object[] p : pairs)
			csp.addBidirectionalArc(p[0], p[1]);
		
		

		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());
		*/	
		
	}
}