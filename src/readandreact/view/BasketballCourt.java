package readandreact.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import readandreact.controller.Layer;
import readandreact.model.Player;
import readandreact.model.Spot;

public class BasketballCourt extends JPanel implements MouseMotionListener, MouseListener {

	private BufferedImage bgImage;
	private Layer layer;
	private static final int PLAYER_RADIUS = 10;

	public BasketballCourt(Layer la) {

		layer = la;

		try {
			bgImage = ImageIO.read(new File("basketballcourt.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(BasketballCourt.class.getName()).
					log(Level.SEVERE, null, ex);
		}

		setPreferredSize(new Dimension(1000, 600));
		setBackground(Color.WHITE);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(bgImage, 100, 0, null);
		
		g2.setColor(Color.GREEN);
		for (Spot spot : Spot.values()) {
			Point loc = spot.getLocation();
			g2.fillOval(loc.x - 5, loc.y - 5, 10, 10);
			//g2.drawString(spot.toString(), loc.x, loc.y);
		}
		
		Player user = layer.getUserPlayer();
		
		g2.setColor(Color.RED);
		g2.fill(new Ellipse2D.Double(
					user.getLocation().x - PLAYER_RADIUS, user.getLocation().y - PLAYER_RADIUS,
					2 * PLAYER_RADIUS, 2 * PLAYER_RADIUS));
		
		g2.setColor(Color.ORANGE);
		for (Player cpu : layer.getCpuPlayers()) {
			g2.fill(new Ellipse2D.Double(
					cpu.getLocation().x - PLAYER_RADIUS, cpu.getLocation().y - PLAYER_RADIUS,
					2 * PLAYER_RADIUS, 2 * PLAYER_RADIUS));
		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		mouseMoved(me);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		layer.getUserPlayer().setLocation(me.getX(), me.getY());
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent me) {}

	@Override
	public void mousePressed(MouseEvent me) {}

	@Override
	public void mouseReleased(MouseEvent me) {}

	@Override
	public void mouseEntered(MouseEvent me) {}

	@Override
	public void mouseExited(MouseEvent me) {}
}
