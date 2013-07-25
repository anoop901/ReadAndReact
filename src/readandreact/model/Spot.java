
package readandreact.model;

import java.awt.Point;


public enum Spot {
	// FROM POINT of view of someone standing at the top facing the basket
	LEFT_CORNER, RIGHT_CORNER, TOP, RIGHT_WING_5OUT, RIGHT_WING_WITH_POST, LEFT_WING_5OUT, LEFT_WING_WITH_POST,
		HIGH_POST_LEFT, HIGH_POST_RIGHT, MID_POST_LEFT, MID_POST_RIGHT, LOW_POST_LEFT, LOW_POST_RIGHT,
		SHORT_CORNER_LEFT, SHORT_CORNER_RIGHT;
		
	public static final double radius = 40;
		
	public Point getLocation() {
		switch (this) {
			case LEFT_CORNER: return new Point(50, 90);
			case RIGHT_CORNER: return new Point(950, 90);
			case TOP: return new Point(500, 560);
			case RIGHT_WING_5OUT: return new Point(900, 390);
			case RIGHT_WING_WITH_POST: return new Point(770, 500);
			case LEFT_WING_5OUT: return new Point(100, 390);
			case LEFT_WING_WITH_POST: return new Point(230, 500);
			case HIGH_POST_LEFT: return new Point(380, 385);
			case HIGH_POST_RIGHT: return new Point(620, 385);
			case MID_POST_LEFT: return new Point(350, 230);
			case MID_POST_RIGHT: return new Point(650, 230);
			case LOW_POST_LEFT: return new Point(350, 140);
			case LOW_POST_RIGHT: return new Point(650, 140);
			case SHORT_CORNER_LEFT: return new Point(270, 40);
			case SHORT_CORNER_RIGHT: return new Point(730, 40);
			default: return null;
		}
	}
        
        public boolean isOnPerimeter() {
            switch (this) {
                case LEFT_CORNER: return true;
		case RIGHT_CORNER: return true;
		case TOP: return true;
		case RIGHT_WING_5OUT: return true;
		case RIGHT_WING_WITH_POST: return true;
		case LEFT_WING_5OUT: return true;
		case LEFT_WING_WITH_POST: return true;
		case HIGH_POST_LEFT: return false;
		case HIGH_POST_RIGHT: return false;
		case MID_POST_LEFT: return false;
		case MID_POST_RIGHT: return false;
		case LOW_POST_LEFT: return false;
		case LOW_POST_RIGHT: return false;
		case SHORT_CORNER_LEFT: return false;
		case SHORT_CORNER_RIGHT: return false;
		default: return false;
            }
        }
        
        public static Spot getAppropriateWing(boolean fiveOut, boolean right) {
            if(fiveOut && right) return RIGHT_WING_5OUT;
            if(fiveOut && !right) return LEFT_WING_5OUT;
            if(!fiveOut && right) return RIGHT_WING_WITH_POST;
            return LEFT_WING_WITH_POST;
        }
        
        public Spot[] getAdjacentPerimeterSpots(boolean fiveOut) {
            // [spotToLeft, spotToRight]
            switch(this) {
                case LEFT_CORNER: return new Spot[] {getAppropriateWing(fiveOut, false), null };
                case RIGHT_CORNER: return new Spot[] {getAppropriateWing(fiveOut, true), null };
                case RIGHT_WING_5OUT: return new Spot[] {TOP, RIGHT_CORNER};
                case RIGHT_WING_WITH_POST: return new Spot[] {TOP, RIGHT_CORNER};
                case LEFT_WING_5OUT: return new Spot[] {TOP, LEFT_CORNER};
                case LEFT_WING_WITH_POST: return new Spot[] {TOP, LEFT_CORNER};
                case TOP: return new Spot[] {getAppropriateWing(fiveOut, false), getAppropriateWing(fiveOut, true)};
                default: return new Spot[] { null, null };
            }
        }
        
        public Spot spotAboveBallSide(boolean fiveOut, Spot currentBallPosition) {
            boolean toTheRight = (currentBallPosition.getLocation().x - this.getLocation().x) > 0;
            int arrayIndex = toTheRight ? 1 : 0;
            return this.getAdjacentPerimeterSpots(fiveOut)[arrayIndex];
        }
		
		public boolean containsPoint(Point p) {
			return (this.getLocation().distance(p) < radius);
		}
}
