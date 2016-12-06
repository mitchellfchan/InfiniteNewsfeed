package theInfinityScore;

public class Die {
	InfinityScore parent;
	int numSides = 20;

	public Die(InfinityScore _parent, int _numSides) {
		parent = _parent;
		numSides = _numSides;
	}

	public int roll() {
		int val = (int) parent.random(0, numSides);
		return (val + 1);
	}
	
	public static int getRoll(float prob1, float prob2){
		double roll = Math.random();
			if (roll >= (1-prob1)) {
				return 1;
			} else if (roll > (1-prob2-prob1)){
				return 2;
			} else {
				return 0;
			}
		
	}
	
	public static int getRoll(float prob1, float prob2, float prob3){
		double roll = Math.random();
			if (roll >= (1-prob1)) {
				return 1;
			} else if (roll > (1-prob2-prob1)){
				return 2;
			} else if (roll > (1-prob3-prob2-prob1)){
				return 3;
			} else {
				return 0;
			}
		
	}
	
//	public int pickWeightedValue(int orig, int prob1, int prob2, int prob3) {
//		 
//		int roll = (int)parent.random(0, 100);
//		  int val = orig;
//		  if (roll > (100 - prob1)) {
//		    val = 0;
//		  } else if (roll > 100 - prob2 - prob1)) {
//		    val = 1;
//		  } else if (roll > (100 - prob3 - prob2 - prob1)) {
//		    val = 2;
//		  } else {
//		    val = orig;
//		  }
//
//		  return val;
//		}
//
//	int pickWeightedValue(int orig, int prob1, int prob2, int prob3, int prob4) {
//		int roll = (int) parent.random(0, 100);
//		int val = orig;
//		if (roll > (100 - prob1)) {
//			val = 0;
//		} else if (roll > (100 - prob2 - prob1)) {
//			val = 1;
//		} else if (roll > (100 - prob3 - prob2 - prob1)) {
//			val = 2;
//		} else if (roll > (100 - prob4 - prob3 - prob2 - prob1)) {
//			val = 3;
//		} else {
//			val = orig;
//		}
//
//		return val;
//	}
//
//	static int pickWeightedValue(InfinityScore is, int orig, int[] vals) {
//		int roll = (int) is.random(100);
//		int prob = 0;
//		for (int i = 0; i < vals.length; i++) {
//			prob += vals[i];
//			if (roll > 100 - prob) {
//				return (i);
//			}
//
//		}
//		return (orig);
//	}
//
//	static int pickDieValue(int numSides, int orig, int prob16, int prob8,
//			int prob4, int prob2, int prob1) {
//		int roll = (int) random(0, numSides);
//		int val = orig;
//		if (roll > (numSides - prob16)) {
//			val = 16;
//		} else if (roll > (numSides - prob16 - prob8)) {
//			val = 8;
//		} else if (roll > (numSides - prob16 - prob8 - prob4)) {
//			val = 4;
//		} else if (roll > (numSides - prob16 - prob8 - prob4 - prob2)) {
//			val = 2;
//		} else if (roll > (numSides - prob16 - prob8 - prob4 - prob2 - prob1)) {
//			val = 1;
//		} else {
//			val = orig;
//		}
//		return val;
//	}

}
