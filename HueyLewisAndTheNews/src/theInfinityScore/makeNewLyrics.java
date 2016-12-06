package theInfinityScore;

import java.util.ArrayList;

import ddf.minim.ugens.Sampler;
import ddf.minim.ugens.Vocoder;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class makeNewLyrics implements Runnable {

	private static InfinityScore parent;

	String baseURL = "https://api.nytimes.com/svc/news/v3/content/all/";
	String section = "U.S.";
	String apiKey = "b7730c8193784299b8eae2afe070e53e";

	JSONObject nytData = new JSONObject();
	JSONArray nytArray;
	JSONObject entry;
	String headline;
	String headlineNew;
	int numWords;

	ArrayList<String> words;
	ArrayList<String> wordsNew;
	
	BingSpeech bs;


	boolean didGetHeadlines = false;
	boolean didSplitHeadlines = false;

	public makeNewLyrics(InfinityScore _parent) {
		parent = _parent;
		words = new ArrayList<String>();
		wordsNew = new ArrayList<String>();
		bs = new BingSpeech();

	}

	public void run() {
		System.out.println("Hello from a thread!");
		getHeadlines();
		splitHeadlines();
		//recordSoundFiles(wordsNew);
	}

	public static void main(String args[]) {
		(new Thread(new makeNewLyrics(parent))).start();
	}

	public void getHeadlines() {

		String request = baseURL + section + ".json?api-key=" + apiKey;

		nytData = parent.loadJSONObject(request);
		// println(nytData);

		nytArray = nytData.getJSONArray("results");
		// println(nytArray);

		int whichHeadline = (int) parent.random(nytArray.size() - 1);
		entry = nytArray.getJSONObject(whichHeadline);
		// println(entry);

		headline = entry.getString("title");
		System.out.println("NEW HEADLINE: " + headline);

	}

	public void splitHeadlines() {
		wordsNew.clear();
		String[] list = parent.split(headline, " ");
		if (parent.verbose)
			System.out.println("   splitHeadlines: # of words in headline: "
					+ list.length);
		numWords = list.length;
		for (int i = 0; i < list.length; i++) {
			wordsNew.add(list[i]);
		}

	}
	
	public void recordSoundFiles(ArrayList<String> l) {
		//repeatCount = 0;
		int numFiles = l.size();
		if (parent.verbose)
			System.out.println("Making New Lyrics: recordSoundFiles: " + numFiles
					+ " is size of String Array List");
		for (int i = 0; i < l.size(); i++) {
			bs.recordThis(l.get(i), i);
			if (parent.verbose)
				System.out.println("Making New Lyrics: recordSoundFiles: saved" + i);
		}
		
	
		parent.singer.initSoundFiles(numFiles);
	}
	

	
	
	
}
