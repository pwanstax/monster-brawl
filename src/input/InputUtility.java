package input;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class InputUtility {

	// ------------------------------ FIELD ------------------------------ //

	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();

	// ------------------------------ METHOD ------------------------------ //

	public static boolean getKeyPressed(KeyCode keycode) {
		// return true if keycode is pressed , else return false
		boolean trigger = keyPressed.contains(keycode);
		keyPressed.remove(keycode);
		return trigger;
	}

	public static void setKeyPressed(KeyCode keycode, boolean pressed) {
		// if pressed is true , add keycode to keyPressed
		if (pressed) {
			if (!keyPressed.contains(keycode)) {
				keyPressed.add(keycode);

			}
			// if pressed is false , remove keycode to keyPressed
		} else {
			keyPressed.remove(keycode);

		}
	}
}
