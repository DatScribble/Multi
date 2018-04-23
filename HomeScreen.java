package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomeScreen {
	private static JFrame HOME_FRAME = new JFrame();
	private static JLabel HOME_LABEL = new JLabel();
	private static JTextField HOME_TEXT = new JTextField();
	public static JFrame getHOME_FRAME() {
		return HOME_FRAME;
	}
	public static void setHOME_FRAME(JFrame hOME_FRAME) {
		HOME_FRAME = hOME_FRAME;
	}
	public static JLabel getHOME_LABEL() {
		return HOME_LABEL;
	}
	public static void setHOME_LABEL(JLabel hOME_LABEL) {
		HOME_LABEL = hOME_LABEL;
	}
	public static JTextField getHOME_TEXT() {
		return HOME_TEXT;
	}
	public static void setHOME_TEXT(JTextField hOME_TEXT) {
		HOME_TEXT = hOME_TEXT;
	}
	
	
}
