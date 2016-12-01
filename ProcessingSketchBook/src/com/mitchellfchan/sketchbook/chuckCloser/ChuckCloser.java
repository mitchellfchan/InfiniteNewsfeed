package com.mitchellfchan.sketchbook.chuckCloser;

import processing.core.*;
import sun.org.mozilla.javascript.internal.ast.ForInLoop;
import toxi.color.*;
import toxi.geom.*;



public class ChuckCloser extends PApplet{
	
	PImage source;
	TColor[][] components;
	Vec2D inputSize;
	int scale;
	int spacing;

	
	public void setup(){
		spacing = 10;
		inputSize = new Vec2D(0,0);
		
	}
	
	public void draw(){
		
	}
	
	public void loadSource(){
		source = loadImage("test.jpg");
		inputSize.x = source.width;
		inputSize.y = source.height;
	}
	
	public void analyseImage(PImage source){		
		for(int y = 0; y < inputSize.y; y++){			
			for(int x = 0; x < inputSize.x; x++){
				int c = source.get(x, y);
				TColor tc = TColor.newHex(hex(source.get(x, y)));
				components[x][y] = tc;
			}
		}
		
	}
	
	public void debugCircles(){
		for(int y = 0; y < inputSize.y; y++){			
			for(int x = 0; x < inputSize.x; x++){
				translate(x*spacing, y*spacing);
				pushStyle();
				ellipseMode(CENTER);
				fill(components[x][y].toARGB());
				ellipse(0,0,)
			}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
