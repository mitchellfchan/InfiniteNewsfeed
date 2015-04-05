package com.mitchellfchan.sketchbook.camDesigner;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

import java.util.ArrayList;




public class CamDesigner extends PApplet{
	
	ArrayList <PVector> doodle;
	int startX ;
	int startY ;
	PShape cam1;
	int camRadius;
	float camDisplaySize = 200;
	
	public PShape xCam;
	public PShape yCam;
	
	public void setup(){
		size(600,600, P2D);
		//fill(255, 130, 89, 128);
		startX = width/2;
		startY = height/4;
		camRadius = 200;
		doodle = new ArrayList<PVector>();
		cam1 = new PShape();
		xCam = createShape();
		yCam = createShape();
		
	}
	
	public void draw(){
		background(255);
		drawDoodleBounds();
		if(mousePressed) record();
		displayDoodle();
		
		
		
		
	}
	
	public static void main(String _args[]) {
		String name = "Boner Slam"; 
		PApplet.main(com.mitchellfchan.sketchbook.camDesigner.CamDesigner.class.getName());
	}
	
	public void drawDoodleBounds(){
		pushMatrix();
		pushStyle();
		this.translate(startX, startY);
		rectMode(CENTER);
		stroke(0);
		strokeWeight(2);
		rect(0,0,400,100);
		strokeWeight(1);
		line(-200, 0, 200, 0);
		line(0, -100, 0, 100);
		popStyle();
		popMatrix();
		
	}
	
	public void record(){
		
		PVector newPoint  = new PVector((mouseX), (mouseY));
		doodle.add(newPoint);
		renderCam();
		
	}
	
	public void displayDoodle(){
		if(doodle.size() > 1){
		for (int i = 1; i < doodle.size(); i++) {
			  PVector v1 = doodle.get(i);
			  PVector v2 = doodle.get(i-1);
			  pushStyle();
			  stroke(0,128);
			  line(v1.x, v1.y, v2.x, v2.y);
			  popStyle();
			}
	
		}
	}
	
	
	public void keyPressed(){
	
		doodle.clear();
		
	}
	
	public void renderCam(){
		float angleStep = (PApplet.TWO_PI*7/8)/doodle.size();
		
		PShape xCam = createShape();
		xCam.beginShape();
		
		
		for(int i = 0; i < doodle.size(); i++ ){
			PVector v = doodle.get(i);
			float x = (camRadius + (v.x - startX)/4) * PApplet.cos(i*angleStep);
			float y = (camRadius + (v.x - startX)/4) * PApplet.sin(i*angleStep);
			xCam.vertex(x, y);
		} 
		xCam.beginContour();
		xCam.vertex(-10, 0);
		xCam.vertex(10, 0);
		xCam.endContour();	
		xCam.beginContour();
		xCam.vertex(0, -10);
		xCam.vertex(0, 10);
		xCam.endContour();
		xCam.beginContour();
		xCam.vertex(50, -10);
		xCam.vertex(50, 10);
		xCam.vertex(100, 0);
		xCam.endContour();
		xCam.endShape(CLOSE);
		
		PShape yCam = createShape();
		yCam.beginShape();
		for(int i = 0; i < doodle.size(); i++ ){
			PVector v = doodle.get(i);
			float x = (camRadius +( v.y - startY)/2) * PApplet.cos(i*angleStep);
			float y = (camRadius + (v.y - startY)/2) * PApplet.sin(i*angleStep);
			yCam.vertex(x, y);
		}
		yCam.beginContour();
		yCam.vertex(-10, 0);
		yCam.vertex(10, 0);
		yCam.endContour();	
		yCam.beginContour();
		yCam.vertex(0, -10);
		yCam.vertex(0, 10);
		yCam.endContour();
		yCam.beginContour();
		yCam.vertex(50, -10);
		yCam.vertex(50, 10);
		yCam.vertex(100, 0);
		yCam.endContour();
		yCam.endShape(CLOSE);
		
		this.pushMatrix();
		this.pushStyle();
		//strokeWeight(2);
		stroke(0);
		fill(143,211,210);
		this.translate(width/4, height-200);
		xCam.setStrokeWeight(4);
		shape(xCam, 0, 0,camDisplaySize,camDisplaySize);
		this.translate(width/2, 0);
		strokeWeight(4);
		stroke(0);
		yCam.setStrokeWeight(4);
		shape(yCam, 0, 0,camDisplaySize,camDisplaySize);
		this.popStyle();
		this.popMatrix();
		
		
		
	}
	
	public void displayCam(){
		

		
	}

}
