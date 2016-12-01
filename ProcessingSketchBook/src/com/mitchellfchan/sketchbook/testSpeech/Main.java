package com.mitchellfchan.sketchbook.testSpeech;

import marytts.modules.synthesis.Voice;

public class Main {
	
	public static void main(String[] args){
		TextToSpeech tts = new TextToSpeech();
		//Voice.getAvailableVoices().stream().forEach(System.out::println);
		tts.setVoice("dfki-poppy-hsmm");
		tts.speak("James Franco", 2.0f, false, true);
		tts.saveTTSfile("Hillary Clinton");
	//tts.playTTSfile();
	}

}
