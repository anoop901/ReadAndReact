/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandreact.controller;

import java.util.ArrayList;
import javax.swing.Timer;
import readandreact.model.Ball;
import readandreact.model.Player;
import readandreact.model.PlayerPosition;
import readandreact.model.Spot;
import readandreact.view.BasketballCourt;

/**
 *
 * @author anoop
 */
public class Layer1 extends Layer {
	
	private Player userControlledPlayer;
	private ArrayList<Player> cpuPlayers;
	private BasketballCourt court;
	private Ball ball;
	
	public Timer timer;
	
	public Layer1() {
		this.cpuPlayers = new ArrayList<Player>();
		for (PlayerPosition pos : PlayerPosition.values()) {
                    switch(pos) {
                        case POINT_GUARD: userControlledPlayer = new Player(pos, false, true, Spot.TOP.getLocation()); break;
                        case SHOOTING_GUARD: cpuPlayers.add(new Player(pos, false, false, Spot.LEFT_WING_5OUT.getLocation())); break;
                        case SMALL_FORWARD: cpuPlayers.add(new Player(pos, false, false, Spot.RIGHT_WING_5OUT.getLocation())); break;
                        case POWER_FORWARD: cpuPlayers.add(new Player(pos, false, false, Spot.LEFT_CORNER.getLocation())); break;
                        case CENTER: cpuPlayers.add(new Player(pos, false, false, Spot.RIGHT_CORNER.getLocation())); break;
                    }
		}
		
		for (Player p : cpuPlayers) {
			p.setDestinationSpot(Spot.TOP);
		}
		
		this.ball = new Ball(userControlledPlayer);
		this.court = new BasketballCourt(this);
		this.timer = new Timer(10, court);
		this.timer.start();
	}
	
	public BasketballCourt getCourt() {
		return court;
	}

	@Override
	public ArrayList<Player> getCpuPlayers() {
		return cpuPlayers;
	}

	@Override
	public Player getUserPlayer() {
		return userControlledPlayer;
	}

	@Override
	public Ball getBall() {
		return ball;
	}
	
	@Override
	public void stepAnim() {
		for (Player cpu : getCpuPlayers()) {
			cpu.moveTowardsDestination(5);
			if (cpu.getLocation().distance(cpu.getDestination()) < 5) {
				cpu.setLocation(cpu.getDestination().x, cpu.getDestination().y);
				cpu.setDestinationPoint(cpu.getLocation());
			}
		}
	}
}
