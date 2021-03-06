package model.rooms;

import model.item.Item;

import java.util.ArrayList;

public class Corridor extends Room {

	private boolean ligthState;

	public Corridor(String description) {
		super(description);
		ligthState = false;
	}

	public void switchOnLight() {
		if(ligthState != true){
			ligthState = true;
			System.out.println("Turn on the light");
		}else{
			System.out.println("Light is already turned on");
		}
	}

	public void switchOffLight() {
		if(ligthState != false){
			ligthState = false;
			System.out.println("Turn off the light");
		}else
			System.out.println("Light is already turned off");
	}

	public boolean isLigthState() {
		return ligthState;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.ligthState == false){ return "The light is off";}
		else{ return "The light is on";}
	}


}