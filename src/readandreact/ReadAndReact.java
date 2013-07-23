
package readandreact;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import readandreact.controller.Layer1;
import readandreact.model.Player;
import readandreact.view.BasketballCourt;

public class ReadAndReact {

	private Player[] players;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame f = new JFrame();
				Layer1 layer = new Layer1();
				f.add(layer.getCourt());
				f.pack();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
	}
}
