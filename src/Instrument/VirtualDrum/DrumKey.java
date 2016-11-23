package Instrument.VirtualDrum;

import java.awt.Image;

import javax.swing.ImageIcon;

import Instrument.Key;

public class DrumKey extends Key {
	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_METAL = 1;
	public static final int TYPE_KICK = 2;

	//@preOn
	static Image[] images = {
			new ImageIcon("Resource/Image/Drum/normal.png").getImage(),
			new ImageIcon("Resource/Image/Drum/metal.png").getImage(),
			new ImageIcon("Resource/Image/Drum/kick.png").getImage(),			
	};
	//@preOff

	private ImageIcon keyUpImage;
	private ImageIcon keyDownImage;

	public DrumKey(int type, int height, int width) {
		super();

		if (height == -1) {
			keyUpImage = new ImageIcon(images[type]);
			keyDownImage = new ImageIcon(images[type].getScaledInstance(222, 187, Image.SCALE_SMOOTH));
		}
		else {
			keyUpImage = new ImageIcon(images[type].getScaledInstance(width, height, Image.SCALE_SMOOTH));
			keyDownImage = new ImageIcon(images[type].getScaledInstance((int) (width * 1.1), (int) (height * 1.1), Image.SCALE_SMOOTH));
		}
		setIcon(keyUpImage);
	}

	@Override
	public boolean keyDown() {
		if (isPressed) return false;
		isPressed = true;
		setIcon(keyDownImage);
		return true;
	}

	@Override
	public void keyUp() {
		isPressed = false;
		setIcon(keyUpImage);
	}
}
