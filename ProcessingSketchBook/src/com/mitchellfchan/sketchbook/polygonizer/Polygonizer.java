package com.mitchellfchan.sketchbook.polygonizer;

import processing.core.PApplet;
import processing.core.PConstants;
import geomerative.*;

public class Polygonizer extends PApplet {

	RShape shp;
	RShape polyshp;

	public void setup() {
		size(1200, 1200);
		smooth();

		// VERY IMPORTANT: Allways initialize the library before using it
		RG.init(this);

		shp = RG.loadShape("David no background.svg");
		shp = RG.centerIn(shp, g, 100);
	}

	public void draw() {
		background(255);

		// We decided the separation between the polygon points dependent of the
		// mouseX
		
		float val = map(mouseX, 0f, width, 0f, 1f);
		
		float pointSeparation = map(val, 0f, 1f, 0f, 400f);
		float angle = map(val,0f,1f, 0f, PConstants.PI/2);

		// We create the polygonized version
	
		RG.setPolygonizer(RG.UNIFORMSTEP);
		RG.setPolygonizerStep(val);
		
//		RG.setPolygonizer(RG.UNIFORMLENGTH);
//		RG.setPolygonizerLength(pointSeparation);
		

		
		
//		RG.setPolygonizer(RG.ADAPTATIVE);
//		RG.setPolygonizerAngle(angle);

		polyshp = RG.polygonize(shp);

		// We move ourselves to the mouse position
		translate(width / 2, height / 2);

		// We draw the polygonized group with the SVG styles
		RG.shape(polyshp);
	}

	public void mousePressed() {
		saveFrame("###.png");
	}

	public static void main(String _args[]) {
		String name = "Boner Slam"; 
		PApplet.main(com.mitchellfchan.sketchbook.polygonizer.Polygonizer.class.getName());
	}
}