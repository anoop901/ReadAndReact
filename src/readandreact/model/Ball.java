/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandreact.model;

import java.awt.Point;

/**
 *
 * @author anoop
 */
public class Ball {
	
	private Point location;
	private Player player;
	
	public Ball() {
		location = new Point(0, 0);
		player = null;
	}
	
	public Ball(Point loc) {
		location = loc;
		player = null;
	}
	
	public Ball(Player p) {
		player = p;
		location = p.getLocation();
	}

	public void setLocation(int x, int y) {
		location = new Point(x, y);
		player = null;
	}
	
	public Point getLocation() {
		if (player == null) {
			return location;
		} else {
			return player.getLocation();
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
