/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandreact.controller;

import java.util.ArrayList;
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
		
		this.court = new BasketballCourt(this);
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
}
