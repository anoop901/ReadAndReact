/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandreact.controller;

import java.util.ArrayList;
import readandreact.model.Player;

/**
 *
 * @author anoop
 */
public abstract class Layer {
	
	public abstract Player getUserPlayer();
	public abstract ArrayList<Player> getCpuPlayers();
}
