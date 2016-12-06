package theInfinityScore;

//TODO: Add vocoder. http://code.compartmental.net/minim/vocoder_class_vocoder.html

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.*;

//import org.json.*;
import processing.sound.SoundFile;

public class Lyricist {
	//Get all NYT Sections by going to api.nytimes.com/svc/news/v3/content/section-list.json?api-key=b7730c8193784299b8eae2afe070e53e
	/*
	{"status":"OK","copyright":"Copyright (c) 2016 The New York Times Company.  All Rights Reserved.","num_results":56,"results":[{"section":"admin","display_name":"Admin"},{"section":"afternoon update","display_name":"Afternoon Update"},{"section":"arts","display_name":"Arts"},{"section":"automobiles","display_name":"Automobiles"},{"section":"autos","display_name":"Autos"},{"section":"blogs","display_name":"Blogs"},{"section":"books","display_name":"Books"},{"section":"briefing","display_name":"Briefing"},{"section":"business","display_name":"Business"},{"section":"business day","display_name":"Business Day"},{"section":"corrections","display_name":"Corrections"},{"section":"crosswords & games","display_name":"Crosswords & Games"},{"section":"crosswords\/games","display_name":"Crosswords\/Games"},{"section":"education","display_name":"Education"},{"section":"fashion & style","display_name":"Fashion & Style"},{"section":"food","display_name":"Food"},{"section":"giving","display_name":"Giving"},{"section":"great homes & destinations","display_name":"Great Homes & Destinations"},{"section":"health","display_name":"Health"},{"section":"home & garden","display_name":"Home & Garden"},{"section":"international home","display_name":"International Home"},{"section":"job market","display_name":"Job Market"},{"section":"magazine","display_name":"Magazine"},{"section":"membercenter","display_name":"membercenter"},{"section":"movies","display_name":"Movies"},{"section":"multimedia","display_name":"Multimedia"},{"section":"multimedia\/photos","display_name":"Multimedia\/Photos"},{"section":"n.y. \/ region","display_name":"N.Y. \/ Region"},{"section":"nyt now","display_name":"NYT Now"},{"section":"obituaries","display_name":"Obituaries"},{"section":"open","display_name":"Open"},{"section":"opinion","display_name":"Opinion"},{"section":"podcasts","display_name":"Podcasts"},{"section":"public editor","display_name":"Public Editor"},{"section":"real estate","display_name":"Real Estate"},{"section":"science","display_name":"Science"},{"section":"sports","display_name":"Sports"},{"section":"style","display_name":"Style"},{"section":"sunday review","display_name":"Sunday Review"},{"section":"t magazine","display_name":"T Magazine"},{"section":"t:style","display_name":"T:Style"},{"section":"technology","display_name":"Technology"},{"section":"the learning network","display_name":"The Learning Network"},{"section":"the upshot","display_name":"The Upshot"},{"section":"theater","display_name":"Theater"},{"section":"times insider","display_name":"Times Insider"},{"section":"times topics","display_name":"Times Topics"},{"section":"today\u2019s paper","display_name":"Today\u2019s Paper"},{"section":"travel","display_name":"Travel"},{"section":"u.s.","display_name":"U.S."},{"section":"washington","display_name":"Washington"},{"section":"watching","display_name":"Watching"},{"section":"week in review","display_name":"Week in Review"},{"section":"well","display_name":"Well"},{"section":"world","display_name":"World"},{"section":"your money","display_name":"Your Money"}]}
	 */

	private InfinityScore parent;
	
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
	
	boolean didGetHeadlines = false;
	boolean didSplitHeadlines = false;
	
	public Lyricist(InfinityScore _parent){
		parent = _parent;
		words = new ArrayList<String>();
		wordsNew = new ArrayList<String>();
		
	}
	
	public void getHeadlines(){
		
			  String request = baseURL + section + ".json?api-key=" + apiKey;
			  
			 

			  nytData = parent.loadJSONObject(request);
			  //println(nytData);

			  nytArray = nytData.getJSONArray("results");
			  //println(nytArray);

			  int whichHeadline = (int)parent.random(nytArray.size() - 1);	
			  entry = nytArray.getJSONObject(whichHeadline);
			  //println(entry);

			  headline = entry.getString("title");
			 System.out.println(headline);
			 

			}
	
	public void splitHeadlines(){
		wordsNew.clear();
			String [] list = parent.split(headline,  " ");
				if (parent.verbose)System.out.println("   splitHeadlines: # of words in headline: " + list.length);
		numWords = list.length;
		for(int i = 0; i < list.length; i++){
			wordsNew.add(list[i]);
		}
		replaceArrayList(wordsNew);
		
	}
	
	public void replaceArrayList(ArrayList<String> _newWords){
		words.clear();
		words = new ArrayList<String>(_newWords);
	}
	
	public void cleanString(){
		//TODO: fill this
	}
	
	

}
