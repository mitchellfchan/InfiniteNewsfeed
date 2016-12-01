package theInfinityScore;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Metronome {
	
	int tempo = 250;
	int minTempo = 4800;
	int maxTempo = 1200;
	float tempoDynamics = 0.005f;
	float avgTempo = (minTempo + maxTempo) / 2;
	float range = (minTempo - maxTempo)/2;
	float noiseCounter = 0;
	
	int timeSignature = 4;
	boolean newBeat = false;
	
	int noteValue = 4;
	int beatCount = 0;
	int chordCount = 0;
	int melodyCount = 0;
	
	long lastMetroCount = 0;
	
	long[] lastStruck = {0, 0, 0, 0, 0, 0, 0, 0};
	long lastChordStruck = 0;

	long lastEvent = 0;
	
	InfinityScore parent;
	
	PGraphics HUD;
	
	
	public Metronome(InfinityScore _parent) {
		parent = _parent;
	}

	
	public void tick(long ms) {
		  //parent.println(lastMetroCount);
		  if ((ms - lastMetroCount) > tempo) {
		    beatCount = beatCount+1;
		    lastMetroCount = ms;
		    newBeat = true;
		  }
		  noiseCounter += tempoDynamics;
		}
	
	public boolean tock(){
		if (newBeat == true){
			newBeat = false;
			return true;
		} else {
			return false;
		}
		}
	
	public boolean newBar(){
		if (beatCount % timeSignature == 0){
			return true;
		} else {
			return false;
		}
	}
		
	
	
	void alterTempo() {

		  float t = (float) ((parent.noise(noiseCounter) - 0.5)*2);
		  tempo = (int)(avgTempo + t*range);
		  
		}
	
	public void setTempo(int _tempo){
		tempo = _tempo;
	}	
	
	public void display(){
		parent.text(beatCount + " / " + timeSignature, 0,0);
	}

}
