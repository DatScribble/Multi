package graphics;

public class Main extends HomeScreen {
	public static HomeScreen  HOME = new HomeScreen();
	public static void main (String[]args) {
		HOME.getHOME_FRAME().setVisible(true);
		HOME.getHOME_FRAME().setSize(500, 500);
		HOME.getHOME_FRAME().add(HOME.getHOME_LABEL());;
		HOME.getHOME_FRAME().add(HOME.getHOME_TEXT());;
		
		HOME.getHOME_LABEL().setVisible(true);

		HOME.getHOME_TEXT().setVisible(true);
		
		
	}
}
