package theInfinityScore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Conductor {
	
	final int c = 0;
	final int d = 1;
	final int e = 2;
	final int f = 3;
	final int g = 4;
	final int a = 5;
	final int b = 6;
	final int c2 = 7;
	
	InfinityScore parent;
	Metronome m;
	AudioPlayer ap;
	
	int decision = 1;
	int dDie = 100;
	int dMelodyProb = 55;
	int dChordProb = 25;
	int dRestProb = 6;
	
	int[] majorScale = {0,2,4,5,7,9,11};
	int[] minorScale = {0,2,3,5,7,8,10};
	
	int[] coreMelody = {0,1,2,3,4,5,6,5,4,3,2,1}; 
	int[] coreBassLine = {0,5,0,3};
	
	String bassRootString = "C2";
	
	Runnable newLyricsPlease;
	ExecutorService executor = Executors.newCachedThreadPool();
	
	
	
	
	public Conductor(InfinityScore _parent, Metronome _m) {
		parent = _parent;
		m = _m;
		newLyricsPlease = new makeNewLyrics(parent);
		
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		//refreshLyrics();
		
		if(m.tock()){
			if (parent.verbose) System.out.println("TOCK");
			
			if(m.beatCount == 32) executor.submit(newLyricsPlease);
			
			if(m.beatCount%parent.violin.hitOn == 0){
				parent.out.playNote(0, 4.0f, parent.violin);
			}
			if(m.beatCount%parent.cello.hitOn == 0){
				parent.out.playNote(0, 4.0f, parent.cello);
			}
			
			if(m.beatCount%parent.singer.hitOn == 0){
				parent.singer.singNext();
			}
			

		}
		
	
	}
	
	public void refreshLyrics(){
		System.out.println("Replacing Lyrics");
		if (parent.singer.repeatCount > 2){
			parent.libretto.getHeadlines();
			parent.libretto.splitHeadlines();
			parent.singer.recordSoundFiles(parent.libretto.words);
			
		}
	}
	
	
	
	
	
//	void decideWhatToDo(Die d, Metronome m) {
//		  if (parent.millis() - m.lastEvent > m.tempo/m.noteValue) {
//		    decision = d.pickWeightedValue(decision, dMelodyProb, dChordProb, dRestProb);
//		  }
//		  if (decision == 0) melodyManager();
//		  if (decision == 1) chordManager();
//		  if (decision == 2) restManager();
//		}
//
//	
//
//		void restManager() {
//		  if (millis() - lastEvent > tempo/restValue) {
//		    if (beatCount%timeSignature == 0)  restValue   = pickDieValue(rDie, restValue, r16Prob, r8Prob, r4Prob, r2Prob, r1Prob);
//		    lastEvent = millis();
//		  }
//		}
//
//
//		
//		float millis(){
//			return parent.millis();
//		}
//		
//		}
}
