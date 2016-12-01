package theInfinityScore;

import java.util.ArrayList;
import java.util.HashMap;

import ddf.minim.*;
import ddf.minim.ugens.*;
import processing.sound.SoundFile;

public class Singer {
	
	InfinityScore parent;
	Minim minim;

	TextToSpeech tts;
	ArrayList<Sampler> samples;
	ArrayList<Vocoder> vocoders;
//Vocoder vocode;
	//Sampler testSampler;
	HashMap<String, Float> noteFreqs;
	
	int hitOn = 4;
	int numFiles;
	int currentPlace = 0;
		
	
	public Singer(InfinityScore _parent){
		parent = _parent;
		minim = parent.minim;

		noteFreqs = new HashMap<String, Float>();
		initNoteHashMap();
//
		samples = new ArrayList<Sampler>();
		vocoders = new ArrayList<Vocoder>();
//
//	
//	  tts = new TextToSpeech();
//	  tts.setVoice("dfki-poppy-hsmm");
//	  tts.saveTTSfile("testing");	
}
	

	
	public void realTimeReciteLyrics(String lyrics){
		tts.speak(lyrics, 1.0f, false, true);
	}
	
	public void recordSoundFiles(ArrayList<String> l){
		
		numFiles = l.size();
		if ( parent.verbose) System.out.println("recordSoundFiles: "+ numFiles + " is size of String Array List");
		for (int i = 0; i < l.size(); i++){
			tts.saveTTSfile(l.get(i), i);
			//tts.saveTTSfile(parent.libretto.headline);    //this would save the whole headline
			if (parent.verbose) System.out.println("recordSoundFiles: saved" + i);
		}
		initSoundFiles(numFiles);
	}
	
	
	public void playSample(int index){

		Sampler s = samples.get(index);		
		//oscil1.setFrequency(noteFreqs.get(parent.violin.getCurrentNoteString()));
		//s.patch(parent.out);
		s.trigger();
	}
	

	
	public void singNext(){

		playSample(currentPlace);
		if (parent.verbose) System.out.println(currentPlace + " / " + samples.size() + " words in array" );
		int x = Die.getRoll(.75f, .25f);
		if( x == 1) currentPlace++;
		if(currentPlace >= samples.size()){
			currentPlace = (int)(Math.random()*samples.size());
		}
	}
	
	public void initSoundFiles(int num){

		samples.clear();
		vocoders.clear();
		String path = parent.sketchPath + "/soundFiles/";
		if (parent.verbose) System.out.println(path + " is where we're searching for those files.");
		for(int i = 0; i < num; i ++){
	
		Sampler sa = new Sampler(path + i + ".wav", 4, minim);
		Vocoder v = new Vocoder(1024, 8);
		vocoders.add(v);
		//sa.patch(parent.out);
		sa.patch(v.modulator);
//		Oscil wave1 = new Oscil(220f, 0.8f, Waves.SAW);
//		Oscil wave2 = new Oscil(260f, 0.6f, Waves.SAW);
//		Summer synth = new Summer();
//		wave1.patch(synth);
//		wave2.patch(synth);
//		synth.patch(v).patch(parent.out);
		//summer.patch(v).patch(parent.out);
		samples.add(sa);
		
		if (parent.verbose)System.out.println(samples.iterator()); 
		}
		if (parent.verbose) System.out.println("initSoundFiles: " + samples.size() + " is size of Sampler arrayList");
	}
	
	
	public void clearSamples(){	
		
			samples.clear();
			
	}
	
	public void initNoteHashMap(){
		noteFreqs.put("C2", 65.41f);
		noteFreqs.put("Cs2", 69.30f);
		noteFreqs.put("D2", 73.42f);
		noteFreqs.put("Ds2", 77.78f);
		noteFreqs.put("E2", 82.41f);
		noteFreqs.put("F2", 87.31f);
		noteFreqs.put("Fs2", 92.5f);
		noteFreqs.put("G2", 98.00f);
		noteFreqs.put("Gs2", 103.83f);
		noteFreqs.put("A2", 110.0f);
		noteFreqs.put("As2", 116.54f);
		noteFreqs.put("B2", 123.47f);
		noteFreqs.put("C3", 65.41f*2);
		noteFreqs.put("Cs3", 69.30f*2);
		noteFreqs.put("D3", 73.42f*2);
		noteFreqs.put("Ds3", 77.78f*2);
		noteFreqs.put("E3", 82.41f*2);
		noteFreqs.put("F3", 87.31f*2);
		noteFreqs.put("Fs3", 92.5f*2);
		noteFreqs.put("G3", 98.00f*2);
		noteFreqs.put("Gs3", 103.83f*2);
		noteFreqs.put("A3", 110.0f*2);
		noteFreqs.put("As3", 116.54f*2);
		noteFreqs.put("B3", 123.47f*2);
		noteFreqs.put("C4", 65.41f*4);
		noteFreqs.put("Cs4", 69.30f*4);
		noteFreqs.put("D4", 73.42f*4);
		noteFreqs.put("Ds4", 77.78f*4);
		noteFreqs.put("E4", 82.41f*4);
		noteFreqs.put("F4", 87.31f*4);
		noteFreqs.put("Fs4", 92.5f*4);
		noteFreqs.put("G4", 98.00f*4);
		noteFreqs.put("Gs4", 103.83f*4);
		noteFreqs.put("A4", 110.0f*4);
		noteFreqs.put("As4", 116.54f*4);
		noteFreqs.put("B4", 123.47f*4);
		noteFreqs.put("C5", 65.41f*8);
		noteFreqs.put("Cs5", 69.30f*8);
		noteFreqs.put("D5", 73.42f*8);
		noteFreqs.put("Ds5", 77.78f*8);
		noteFreqs.put("E5", 82.41f*8);
		noteFreqs.put("F5", 87.31f*8);
		noteFreqs.put("Fs5", 92.5f*8);
		noteFreqs.put("G5", 98.00f*8);
		noteFreqs.put("Gs5", 103.83f*8);
		noteFreqs.put("A5", 110.0f*8);
		noteFreqs.put("As5", 116.54f*8);
		noteFreqs.put("B5", 123.47f*8);
		noteFreqs.put("C6", 65.41f*16);
		noteFreqs.put("Cs6", 69.30f*16);
		noteFreqs.put("D6", 73.42f*16);
		noteFreqs.put("Ds6", 77.78f*16);
		noteFreqs.put("E6", 82.41f*16);
		noteFreqs.put("F6", 87.31f*16);
		noteFreqs.put("Fs6", 92.5f*16);
		noteFreqs.put("G6", 98.00f*16);
		noteFreqs.put("Gs6", 103.83f*16);
		noteFreqs.put("A6", 110.0f*16);
		noteFreqs.put("As6", 116.54f*16);
		noteFreqs.put("B6", 123.47f*16);
		noteFreqs.put("C7", 65.41f*32);
		noteFreqs.put("Cs7", 69.30f*32);
		noteFreqs.put("D7", 73.42f*32);
		noteFreqs.put("Ds7", 77.78f*32);
		noteFreqs.put("E7", 82.41f*32);
		noteFreqs.put("F7", 87.31f*32);
		noteFreqs.put("Fs7", 92.5f*32);
		noteFreqs.put("G7", 98.00f*32);
		noteFreqs.put("Gs7", 103.83f*32);
		noteFreqs.put("A7", 110.0f*32);
		noteFreqs.put("As7", 116.54f*32);
		noteFreqs.put("B7", 123.47f*32);	
	}
		
	

}