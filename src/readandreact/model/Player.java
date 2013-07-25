package readandreact.model;

import java.awt.Point;

public class Player {

	private final PlayerPosition position;
	private Point location;
	private boolean userControlled;
	private final boolean postPlayer;
	
	private Point destination;

	public Player(PlayerPosition pos, boolean post, boolean uc) {
		location = new Point((int) (Math.random() * 1000), (int) (Math.random() * 600));
		position = pos;
		postPlayer = post;
		userControlled = uc;
		destination = location;
	}

	public Player(PlayerPosition pos, boolean post, boolean uc, Point loc) {
		this(pos, post, uc);
		location = loc;
		destination = location;
	}

	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}

	public void setUserControlled(boolean uc) {
		userControlled = uc;
	}
	
	public void setDestinationPoint(Point p) {
		destination = p;
	}
	
	public void setDestinationSpot(Spot s) {
		destination = s.getLocation();
	}

	public void moveBy(int dx, int dy) {
		location.translate(dx, dy);
	}
	
	public void moveTowardsDestination(int amount) {
		int dx = destination.x - location.x;
		int dy = destination.y - location.y;
		double dist = destination.distance(location);
		moveBy((int) Math.round(dx * amount / dist), (int) Math.round(dy * amount / dist));
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
	
	public Point getDestination() {
		return destination;
	}
	

	/**
	 * @return the isUserControlled
	 */
	public boolean isUserControlled() {
		return userControlled;
	}

	public Spot getSpotStandingOn() {
		for (Spot s : Spot.values())
			if (s.containsPoint(getLocation()))
				return s;
		return null;
	}
}
