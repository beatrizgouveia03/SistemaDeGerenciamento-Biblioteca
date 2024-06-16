package View;

public class MainView implements View {
	
	public static void main(String[] args) {
        MainView mainView = new MainView();

        mainView.startView();
    }
	
	@Override
	public void startView() {
		System.out.println("Welcome to the Library System!");

	}

}
