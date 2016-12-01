package com.mitchellfchan.sketchbook.camDesigner;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

import java.util.ArrayList;

public class CamDesigner extends PApplet {

	ArrayList<PVector> doodle;
	
	int startX;
	int startY;
	PShape cam1;
	int camRadius;
	float camDisplaySize = 200;
	public boolean recordMode = false;
	public boolean penLift = true;

	public PShape xCam;
	public PShape yCam;

	public void setup() {
		size(900, 600, P2D);
		// fill(255, 130, 89, 128);
		startX = width / 2;
		startY = height / 3 + 10;
		camRadius = 200;
		doodle = new ArrayList<PVector>();
		
		cam1 = new PShape();
		xCam = createShape();
		yCam = createShape();

	}

	public void draw() {
		background(255);
		drawDoodleBounds();
		if (recordMode){
			record();
			
		}
		renderCam();
		displayDoodle();
		

	}

	public void drawDoodleBounds() {
		pushMatrix();
		pushStyle();
		this.translate(startX, startY);
		rectMode(CENTER);
		stroke(0);
		strokeWeight(2);
		rect(0, 0, width*2/3, height*2/3);
		strokeWeight(1);
		line(-width/3, 0, width/3, 0);
		line(0, -height/3, 0, height/3);
		popStyle();
		popMatrix();

	}

	public void record() {

		PVector newPoint = new PVector((mouseX), (mouseY), penLifted());
		doodle.add(newPoint);
		// renderCam();

	}
	
	public float penLifted(){
		if(mousePressed) return 1.0f;
		else return 0f;
	}

	public void displayDoodle() {
		if (doodle.size() > 1) {
			for (int i = 1; i < doodle.size(); i++) {
				PVector v1 = doodle.get(i);
				PVector v2 = doodle.get(i - 1);
				pushStyle();
				if(v1.z == 0f){
					noStroke();
				} else {
				stroke(0, 128);
				}
				line(v1.x, v1.y, v2.x, v2.y);
				popStyle();
			}

		}
	}

	public void keyPressed() {

		if (key == 'r') {
			recordMode = !recordMode;
		} else if (key == 's') {
			saveCams();
		} else {
		doodle.clear();
		}

	}

	public void renderCam() {
		float angleStep = (PApplet.TWO_PI * 7 / 8) / doodle.size();

		PShape xCam = createShape();
		xCam.beginShape();

		for (int i = 0; i < doodle.size(); i++) {
			PVector v = doodle.get(i);
			float x = (camRadius + (v.x) / 8)
					* PApplet.cos(i * angleStep);
			float y = (camRadius + (v.x) / 8)
					* PApplet.sin(i * angleStep);
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
		for (int i = 0; i < doodle.size(); i++) {
			PVector v = doodle.get(i);
			float x = (camRadius + (v.y) / 8)
					* PApplet.cos(i * angleStep);
			float y = (camRadius + (v.y) / 8)
					* PApplet.sin(i * angleStep);
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
		
		PShape zCam = createShape();
		zCam.beginShape();
		for (int i = 0; i < doodle.size(); i++) {
			PVector v = doodle.get(i);
			float x = (camRadius + (v.z*10))
					* PApplet.cos(i * angleStep);
			float y = (camRadius + (v.z*10))
					* PApplet.sin(i * angleStep);
			zCam.vertex(x, y);
		}
		zCam.endShape(CLOSE);

		this.pushMatrix();
		this.pushStyle();
		// strokeWeight(2);
		stroke(0);
		
		
		this.translate(width / 4, height - 200);
		xCam.fill(143, 211, 210);
		xCam.setStrokeWeight(4);
		shape(xCam, 0, 0, camDisplaySize, camDisplaySize);
		
		this.translate(width / 4, 0);
		yCam.fill(143, 211, 210);
		yCam.setStrokeWeight(4);
		shape(yCam, 0, 0, camDisplaySize, camDisplaySize);
		
		this.translate(width/4, 0);
		zCam.fill(143, 211, 210);
		zCam.setStrokeWeight(4);
		shape(zCam, 0, 0, camDisplaySize, camDisplaySize);
		
		this.popStyle();
		this.popMatrix();

	}

	public void displayCam() {

	}

	public void saveCams() {
		println("Saving...");
	}

	public static void main(String _args[]) {
		String name = "Boner Slam";
		PApplet.main(com.mitchellfchan.sketchbook.camDesigner.CamDesigner.class
				.getName());
	}

}
