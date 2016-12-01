package com.mitchellfchan.sketchbook.WatsonTTS;

public class pleaseWork {

	public pleaseWork() {
		// TODO Auto-generated constructor stub
		
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("{username}", "{password}");

		try {
		  String text = "Hello world.";
		  InputStream stream = service.synthesize (text, Voice.EN_ALLISON, "audio/wav");

		  InputStream in = WaveUtils.reWriteWaveHeader(stream);
		  OutputStream out = new FileOutputStream("hello_world.wav");
		  byte[] buffer = new byte[1024];
		  int length;
		  while ((length = in.read(buffer)) > 0) {
		    out.write(buffer, 0, length);
		  }
		  out.close();
		  in.close();
		  stream.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
