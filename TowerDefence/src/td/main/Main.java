package td.main;



import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{
	
	
	public static void main(String[] args){
		JFrame f = new JFrame("Tower Defence");
		JPanel main_panel = new JPanel();
		Game game = new Game();
		
		main_panel.add(game);

		f.setContentPane(main_panel);
		f.setBounds(0,0,800,600);
		f.setLayout(null);
		f.setUndecorated(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setFocusable(false);
	}
}
