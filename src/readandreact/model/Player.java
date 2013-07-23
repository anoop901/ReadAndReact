
package readandreact.model;

import java.awt.Point;


public class Player {
	
	private final PlayerPosition position;
	private Point location;
	private boolean userControlled;
	private final boolean postPlayer;
	
	public Player(PlayerPosition pos, boolean post, boolean uc) {
		location = new Point((int) (Math.random() * 1000), (int) (Math.random() * 600));
		position = pos;
		postPlayer = post;
		userControlled = uc;
	}
	
	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}
	
	public void setUserControlled(boolean uc) {
		userControlled = uc;
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
