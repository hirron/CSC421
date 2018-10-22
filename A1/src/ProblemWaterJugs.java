import java.util.HashSet;
import java.util.Set;

public class ProblemWaterJugs extends Problem {
    
	boolean goal_test(Object state) {
        StateWaterJugs puzzle_state = (StateWaterJugs)state;
         
		 if(puzzle_state.jugs[0] == 1 || puzzle_state.jugs[1]== 1 || puzzle_state.jugs[2] == 1){
			 return true;
		 }
        return false;
	}
	
	private void setObjectToBase(StateWaterJugs old, StateWaterJugs copy)
	{
		copy.jugs[0] = old.jugs[0];
		copy.jugs[1] = old.jugs[1];
		copy.jugs[2] = old.jugs[2];
	}
	
	private boolean same2(StateWaterJugs s, StateWaterJugs ss){
		return(!(ss.jugs[0] == s.jugs[0] && ss.jugs[1]== s.jugs[1] && ss.jugs[2] == s.jugs[2]));	 
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
        StateWaterJugs s = (StateWaterJugs) state;

        
        StateWaterJugs ss; //successor state
        
 
        ss = new StateWaterJugs();
			
			for (int x = 0; x < 3; x++){
				ss.jugs[x] = s.jugs[x];
	
					// Add all fill and empty jug options
						if(x==0){
							//System.out.println("Made it here");
							ss.jugs[x] = 12;
							if(!(ss.jugs[0] == 0 && ss.jugs[1]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
							ss = new StateWaterJugs();
							setObjectToBase(s, ss);
						
						if(ss.jugs[x] != 12 && ss.jugs[x] !=0){
							ss.jugs[x] = 0;
							if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
							ss = new StateWaterJugs();
							setObjectToBase(s, ss);
							}						
							
						}
						
						if(x==1){
							//System.out.println("Made it here2");
							ss.jugs[x] = 8;
							if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
							ss = new StateWaterJugs();
							setObjectToBase(s, ss);
							
							if(ss.jugs[x] != 8 && ss.jugs[x] !=0){
								ss.jugs[x] = 0;
								if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
								ss = new StateWaterJugs();
								setObjectToBase(s, ss);
							}
							
						//	ss.jugs[x] = 0;
						}
						
						if(x==2){
							//System.out.println("Made it here 3");
							ss.jugs[x] = 3;
							if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
							ss = new StateWaterJugs();
							setObjectToBase(s, ss);
						//	ss.jugs[x] = 0;
						if(ss.jugs[x] != 3 && ss.jugs[x] !=0){
							ss.jugs[x] = 0;
							if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
							ss = new StateWaterJugs();
							setObjectToBase(s, ss);
							}
						
						}
			
			}
			
			int diff = 0;
			
			// pouring from 12 jugs
			if(ss.jugs[0] > 0){				
				diff = 8- ss.jugs[1];
				
				if(ss.jugs[0] >= diff){
					ss.jugs[0] = ss.jugs[0] - diff;
					ss.jugs[1] = ss.jugs[1] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[0] < diff){
					
					diff = ss.jugs[0];
					ss.jugs[0] = 0;
					ss.jugs[1] = ss.jugs[1] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				diff = 3-ss.jugs[2];
				if(ss.jugs[0] >= diff){
					ss.jugs[0] = ss.jugs[0]-diff;
					ss.jugs[2] = ss.jugs[2]+diff;
	
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[0] < diff){
					
					diff = ss.jugs[0];
					ss.jugs[0] = 0;
					ss.jugs[2] = ss.jugs[2] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
			}
			
			// pouring from 8 jugs
			if(ss.jugs[1] > 0){
				diff = 12 - ss.jugs[0];
				
				if(ss.jugs[1] >= diff){
					ss.jugs[1] = ss.jugs[1] - diff;
					ss.jugs[0] = ss.jugs[0] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[1] < diff){
					
					diff = ss.jugs[1];
					ss.jugs[1] = 0;
					ss.jugs[0] = ss.jugs[0] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				diff = 3-ss.jugs[2];
				if(ss.jugs[1] >= diff){
					ss.jugs[1] = ss.jugs[1] - diff;
					ss.jugs[2] = ss.jugs[2] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[1] < diff){
					
					diff = ss.jugs[1];
					ss.jugs[1] = 0;
					ss.jugs[2] = ss.jugs[2] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
			}
			
			// pouring from 3 jugs
			if(ss.jugs[2] > 0){
				diff = 12 - ss.jugs[0];
				
				if(ss.jugs[2] >= diff){
					ss.jugs[2] = ss.jugs[2] - diff;
					ss.jugs[0] = ss.jugs[0] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[2] < diff){
					
					diff = ss.jugs[2];
					ss.jugs[2] = 0;
					ss.jugs[0] = ss.jugs[0] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				diff = 8- ss.jugs[1];
				
				if(ss.jugs[2] >= diff){
					ss.jugs[2] = ss.jugs[2] - diff;
					ss.jugs[1] = ss.jugs[1] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
				
				if(ss.jugs[2] < diff){
					
					diff = ss.jugs[2];
					ss.jugs[2] = 0;
					ss.jugs[1] = ss.jugs[1] + diff;
					
					if(!(ss.jugs[0] == 0 && ss.jugs[1 ]== 0 && ss.jugs[2] == 0)  && same2(s, ss)){ set.add(ss); }
					ss = new StateWaterJugs();
					setObjectToBase(s, ss);
				}
				
			}
		
        return set;
    }

      
  
    
	
	double step_cost(Object fromState1, Object toState1) {
		StateWaterJugs fromState = (StateWaterJugs) fromState1;
		StateWaterJugs toState = (StateWaterJugs) toState1;
		
		
		double step_cost = toState.jugs[0]-fromState.jugs[0];
		if (step_cost < 0){
			step_cost = step_cost*-1;
		}
		
		if(step_cost > 0){
			return step_cost;
		}
		
		step_cost = toState.jugs[1]-fromState.jugs[1];
		
		if (step_cost < 0){
			step_cost =	step_cost*-1;
		}
		
		if(step_cost > 0){
			return step_cost;
		}
		
		step_cost = toState.jugs[2]-fromState.jugs[2];
		if (step_cost < 0){
			step_cost= step_cost*-1;
		}
		if(step_cost > 0){
			return step_cost;
		}
		
		return step_cost;
	}

	public double h(Object state) { return 0; }


	public static void main(String[] args) throws Exception {
		ProblemWaterJugs problem = new ProblemWaterJugs();
		problem.initialState = new StateWaterJugs(); 
		

		
	
		Search search  = new Search(problem);
		
		System.out.println("TreeSearch------------------------");
		System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
	    System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());
		
		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());
		
		
		System.out.println("\n\nIterativeDeepening----------------------");
		System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}
	
}
