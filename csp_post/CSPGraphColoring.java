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
		
		Arrays.asList(new String[] {"blue", "green", "ivory", "red", "yellow"}));
		static Set<Object> varDri = new HashSet<Object>(
		Arrays.asList(new String[] {"coffee", "milk", "orange-juice", "tea", "water"}));
		static Set<Object> varNat = new HashSet<Object>(
		Arrays.asList(new String[] {"englishman", "japanese", "norwegian", "spaniard", "ukrainian"}));
		static Set<Object> varPet = new HashSet<Object>(
		Arrays.asList(new String[] {"dog", "fox", "horse", "snails", "zebra"}));
		static Set<Object> varCig = new HashSet<Object>(
		Arrays.asList(new String[] {"chesterfield", "kools", "lucky-strike", "old-gold", "parliament"}));
		
		// *******
		
		
		String[] vars = {"WA", "NT", "Q", "NSW", "V", "SA", "T"}; 
		String[] colors = {"r", "g", "b"};
		String[][] pairs = {{"WA","NT"}, {"NT","Q"}, {"Q","NSW"}, {"NSW","V"}, 
							{"SA", "WA"}, {"SA", "NT"}, {"SA", "Q"}, 
							{"SA", "NSW"}, {"SA", "V"}};
		
		for(Object X : vars) 
			csp.addDomain(X, colors);
		
		for(Object[] p : pairs)
			csp.addBidirectionalArc(p[0], p[1]);
		
		
		static Set<Object> varCol = new HashSet<Object>(
		

		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());
	}
}