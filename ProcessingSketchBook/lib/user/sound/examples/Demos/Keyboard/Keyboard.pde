/*
This example shows how to make a simple sampler and sequencer with the Sound library. In this
sketch 5 different short samples are loaded and played back at different pitches, in this
case 5 different octaves. The sequencer triggers and event every 200-1000 mSecs randomly.
Each time a sound is played a colored rect with a random color is displayed.
*/

import processing.sound.*;

AudioDevice device;
SoundFile[] file;
PrintWriter output;

// Define the number of samples 
int numsounds = 1;


int displaySize[] = {0,0,0,0,0,0,0,0,0,0};

color bgCol = #E3EFF5;
color displayColor[] = {bgCol, bgCol, #FF0000, #FF9900, #FFE603, #08CE13, #1BDED9, #036DFF, #D003FF, #FF0000};

int c = 2;
int d = 3;
int e = 4;
int f = 5;
int g = 6;
int a = 7;
int b = 8;
int c2 = 9;



void setup(){
  size(1000, 400);
  background(255);
  
  // Create a Sound renderer and an array of empty soundfiles
  device = new AudioDevice(this, 48000, 32);
  file = new SoundFile[numsounds];
 
  
  // Load 5 soundfiles from a folder in a for loop. By naming the files 1., 2., 3., n.aif it is easy to iterate
  // through the folder and load all files in one line of code.
  for (int i = 0; i < numsounds; i++){
    file[i] = new SoundFile(this, (i+1) + ".aif");
  }
  
  // Create a text file output
  output = createWriter(day() +"_" + hour() + "." + minute() + ".txt");
  
}

void draw(){

    background(bgCol);
    displayNotes();

}


void playNote(int note){
  displaySize[note] = 75;
}

void displayNotes(){
  for(int i = 0; i < displaySize.length; i++){
    ellipseMode(CENTER);
    fill(displayColor[i]);
    ellipse(i*100, height/2, displaySize[i], displaySize[i]);
    displaySize[i]--;
    displaySize[i] = constrain(displaySize[i], 0, 75);
  }
}
  


void keyPressed() {
  
 
  switch(key){
  case 'a':
    file[0].play(261.6/261.6, 1.0);
    playNote(c);
    break;

  case 's':
    file[0].play(293.7/261.6, 1.0);
    playNote(d);
    break;
  
  case 'd':
    file[0].play(329.6/261.6, 1.0);
    playNote(e);
    break;
  
  case 'f':
    file[0].play(349.2/261.6, 1.0);
    playNote(f);
    break;
  
  case 'g':
    file[0].play(392/261.6, 1.0);
    playNote(g);
    break;
  
   case 'h':
    file[0].play(440/261.6, 1.0);
    playNote(a);
    break;
   
   case 'j':
    file[0].play(493.9/261.6, 1.0);
    playNote(b);
    break;

   case 'k':
    file[0].play(523.3/261.6, 1.0);
    playNote(c2);
    break;
    
  }
}