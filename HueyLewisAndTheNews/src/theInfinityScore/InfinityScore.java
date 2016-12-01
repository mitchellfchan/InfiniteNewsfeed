/*FUN STUFF TO ASK ROB
 * -how can I use try/catch to make all my instruments as one class. For example try to load a file if it exists, no biggie if it doesn't
 */

package theInfinityScore;


import java.util.ArrayList;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.sound.*;
import toxi.color.*;


public class InfinityScore extends PApplet{

 //static final long serialVersionUID = -688316076483333806L;
	// Import Libraries
	

 	Minim minim;
 	AudioOutput out;
	
	boolean verbose = true;
 	Metronome metro;
 	//AudioPlayer audioplayer;
 	Die d6;
 	Die d20;
 	Lyricist libretto;
 	//Singer singer;
 	BingSpeech bingSpeech;
 	Conductor conductor;
 	Cello cello;
 	Violin violin;







	public void setup() {
		//TextToSpeech theTTS = new TextToSpeech();
		  minim = new Minim(this);
		  out = minim.getLineOut(Minim.STEREO, 1024);
		
		metro = new Metronome(this);
		conductor = new Conductor(this, metro);
		
		cello = new Cello(this);
		cello.initSamplesScale(conductor.bassRootString, conductor.majorScale);
		cello.setMelody(conductor.coreBassLine);
		
		violin = new Violin(this, (sketchPath + "/violin/violin_"), "_025_pianissimo_arco-normal.wav");
		
		violin.initSamplesScale("F5", conductor.majorScale);
		violin.setMelody(conductor.coreMelody);
		
		
		libretto = new Lyricist(this);
		libretto.getHeadlines();
		libretto.splitHeadlines();
		
		//singer = new Singer(this);
		//singer.recordSoundFiles(libretto.words);
		//singer.realTimeReciteLyrics(libretto.headline);
		
		bingSpeech = new BingSpeech();
		bingSpeech.recordThis("I am a genius", 69);
		
	  size(400, 400);
	  background(255);


	}
	
	



	public void draw() {
	
	  background(255);
	  metro.tick(millis());
	  conductor.run();
	 


	 
	  fill(0);
	  displayTempoData();
	  pushMatrix();
	  translate(100,300);
	  metro.display();
	  popMatrix();
	 
	}

	
	

	




	

	


	void displayTempoData() {
	  text(metro.tempo, 50, height- 250);
	  int tempoBarSize = 100;
	  strokeWeight(1);
	  stroke(155);
	  line( 0, tempoBarSize, width, tempoBarSize);
	  strokeWeight(2);
	  stroke(55);
	  noFill();
	  beginShape();
	  for (int i = 0; i < width; i++) {
	    vertex(i, (float) ((noise(metro.noiseCounter + i* metro.tempoDynamics*5)-0.5)*tempoBarSize + tempoBarSize));
	  }
	  endShape();
	}



	public static void main(String _args[]) {
		String name = "Score Infinity";
		PApplet.main(theInfinityScore.InfinityScore.class
				.getName());
	}
	
}
