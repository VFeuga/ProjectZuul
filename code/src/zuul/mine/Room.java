package zuul.mine;

import java.util.HashMap;


/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room {
	public String description;
	private HashMap<String, Room> exits; // stores exits of this room.

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 * 
	 * @param description
	 *            The room's description.
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<>();
	}

	/**
	 * Define an exit from this room.
	 * 
	 * @param direction
	 *            The direction of the exit.
	 * @param neighbor
	 *            The room to which the exit leads.
	 */
	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}
	
	public void setExit(Room north, Room east, Room south, Room west){
		if(north != null) exits.put("north", north);
		if(east != null) exits.put("east", east);
		if(south != null) exits.put("south", south);
		if(west != null) exits.put("west",west);
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return a description of the room's exits,
	 * for example, "Exits: north west".
	 * @return A description of the available exits.
	 */
	public String getExitString(){
		String str ="";
		str+="Exits: ";
		if (getExit("north") != null) {
			str+="north ";
		}
		if (getExit("east") != null) {
			str+="east ";
		}
		if (getExit("south") != null) {
			str+="south ";
		}
		if (getExit("west") != null) { 
			str+="west ";
		}
		return str;
	}
	//
	public Room getExit(String direction){
		return exits.get(direction);
	}


}
