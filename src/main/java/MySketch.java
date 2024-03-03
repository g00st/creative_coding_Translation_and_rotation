import processing.core.PApplet;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	ControlP5 cp5;
	int seed = 0;
	 float maxTranslationFactor = 0.7f;
	float maxRotationFactor = 1f;
	float intensity = 0.5f;

	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {

	}


	public void draw(){
		background(255);
		float border = 30;
		float rectSize = (width - 2 * border) / 12;
		randomSeed(seed);


		for (int row = 0; row < 24; row++) {
			for (int column = 0; column < 12; column++) {
				pushMatrix();
				translate(border, border);
				translate(column * rectSize, row * rectSize);
				float weight = sin(0.003f * millis());
				float translationFactor = weight * maxTranslationFactor;
				float rotationFactor = weight * maxRotationFactor;

				translate(translationFactor *  dist(mouseX,  mouseY, column * rectSize, row * rectSize)*random(0.5f, 0.5f),translationFactor /  dist(mouseX,  mouseY, column * rectSize, row * rectSize)*random(-0.5f, 0.5f));
				rotate(rotationFactor *dist(mouseX,  mouseY, column * rectSize, row * rectSize)/dist(0, 0, width, height) * random(-1.f, 1.f));
				rect(0, 0, rectSize, rectSize);
				popMatrix();
			}
		}

	}
}
