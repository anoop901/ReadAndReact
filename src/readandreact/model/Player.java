
package readandreact.model;

import java.awt.Point;


public class Player {
	
	private PlayerPosition position;
	private Point location;
	private boolean userControlled;
	
	public Player(PlayerPosition pos) {
		position = pos;
	}
	
	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}
	
	public void moveBy(int dx, int dy) {
		location.translate(dx, dy);
	}

	/**
	 * @return the position
	 */
	public PlayerPosition getPosition() {
		return position;
	}

	/**
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * @return the isUserControlled
	 */
	public boolean isUserControlled() {
		return userControlled;
	}
}
