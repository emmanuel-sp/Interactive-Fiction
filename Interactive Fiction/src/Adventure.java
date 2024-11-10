/*
 * Adventure.java
 * Author:  Emmanuel Pierre 
 * Submission Date:  Nov 13, 2022
 *
 * Purpose: The purpose of this code is to create an interactive game
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
import java.util.Scanner;
public class Adventure {
	
	public static void main(String[] args) {
		String[] commands = {"GET LAMP", "LIGHT LAMP", "NORTH", "SOUTH", "EAST", "WEST", "LOOK", "GET KEY", "OPEN CHEST", "UNLOCK CHEST"};

		System.out.println(
			"Welcome to UGA Adventures: Episode I\n"
			+"The Adventure of the Cave of Redundancy Adventure\n"
			+"By: Emmanuel Pierre"
		);
		
		Scanner keyboard = new Scanner(System.in);
		boolean game = true;
		String command;
		
		Player player = new Player();
		player.setY(0);
		player.setX(0);
		

		Map map = new Map();
		Lamp lamp = new Lamp();
		Room newRoom = map.getRoom(player.getX(), player.getY());
		System.out.println(newRoom.getDescription());
		while (game) {
			boolean isACommand = false;
			command = keyboard.nextLine();
				
			//GET LAMP
			if (command.equalsIgnoreCase("GET LAMP")) {
				if (newRoom.getLamp() != null) {
					System.out.println("OK");
					lamp = newRoom.getLamp();
					player.setLamp(lamp);
					newRoom.clearLamp();
				}
				else
					System.out.println("No lamp present");
			}
			//LIGHT LAMP
			if (command.equalsIgnoreCase("LIGHT LAMP")) {
				if (player.getLamp() != null) {
					System.out.println("OK");
					lamp.setIsLit(true);
				}
				else
					System.out.println("You don't have the lamp to light");
			}
			//
			if (newRoom.isDark()) {
				
			}
			//Movement
			if (command.equalsIgnoreCase("North")) {
				if (newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					game = false;
				}
				else if (player.getX() == 0)
					System.out.println("Can't go that way");
				else {
					player.setX(player.getX()-1);
					newRoom = map.getRoom(player.getX(), player.getY());
					if (!(newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)))
						System.out.println(newRoom.getDescription());
					else
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
			}
			
			
			if (command.equalsIgnoreCase("South")) {
				if (newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					game = false;
				}
				else if (player.getX() == 3)
					System.out.println("Can't go that way");
				else {
					player.setX(player.getX()+1);
					newRoom = map.getRoom(player.getX(), player.getY());
					if (!(newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)))
						System.out.println(newRoom.getDescription());
					else
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
			}
			
			if (command.equalsIgnoreCase("EAST")) {
				if (player.getY() == 3)
					System.out.println("Can't go that way");
				else if (((newRoom.isDark()==true) && (player.getLamp() == null)) || ((newRoom.isDark()==true) && (lamp.getIsLit() == false))) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					game = false;
				}
				else {
					player.setY(player.getY()+1);
					newRoom = map.getRoom(player.getX(), player.getY());
					if (newRoom.isDark()==false || lamp.getIsLit()==true)
						System.out.println(newRoom.getDescription());
					else if (((newRoom.isDark()==true) && (player.getLamp() == null)) || ((newRoom.isDark()==true) && (lamp.getIsLit() == false)))
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
			}
			
			if (command.equalsIgnoreCase("WEST")) {
				if (newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					game = false;
				}
				else if (player.getY() == 0)
					System.out.println("Can't go that way");
				else {
					player.setY(player.getY()-1);
					newRoom = map.getRoom(player.getX(), player.getY());
					if (!(newRoom.isDark() && (player.getLamp() == null || lamp.getIsLit()==false)))
						System.out.println(newRoom.getDescription());
					else
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
			}
			
			//LOOK
			if (command.equalsIgnoreCase("LOOK")) {
	
					if (newRoom.isDark()==false || lamp.getIsLit() == true) {
						System.out.println(newRoom.getDescription());
					}
					if (((newRoom.isDark()==true) && (player.getLamp() == null)) || ((newRoom.isDark()==true) && (lamp.getIsLit() == false)))
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					
					if (newRoom.getLamp() != null) {
						System.out.println("There is an old oil lamp that was made long ago here.");
					}
					if (newRoom.getKey() != null) {
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					if (newRoom.getChest() != null) {
						System.out.println("There is a large wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
					}
					System.out.print("Exits are: ");
					if (newRoom.canGoEast()) {
						System.out.println("east");
					}
					if (newRoom.canGoWest()) {
						System.out.println("west");
					}
					if (newRoom.canGoNorth()) {
						System.out.println("north");
					}
					if (newRoom.canGoSouth()) {
						System.out.println("south");
					}
				
			}	
			
			//GET KEY
			if (command.equalsIgnoreCase("GET KEY")) {
				if (newRoom.getKey() != null) {
					System.out.println("OK");
					player.setKey(newRoom.getKey());
					newRoom.clearKey();
				}
				else
					System.out.println("No key present");
			}
			
			//OPEN CHEST
			if (command.equalsIgnoreCase("OPEN CHEST")) {
				if (newRoom.getChest() != null && newRoom.getChest().isLocked() == false) {
					System.out.println(newRoom.getChest().getContents());
					game = false;
				}
				else if (newRoom.getChest() != null && newRoom.getChest().isLocked())
					System.out.println("The chest is locked");
				else if (newRoom.getChest() == null) 
					System.out.println("No chest present");
					
			}
			//UNLOCK CHEST
			if (command.equalsIgnoreCase("UNLOCK CHEST")) {
				if (newRoom.getChest() == null) {
					System.out.println("No chest to unlock");
				}
				else if (player.getKey() != null) {
					player.getKey().use(newRoom.getChest());
					System.out.println("OK!");
				}
				else if (player.getKey() == null) {
					System.out.println("Need a key to do any unlocking!");
				}
			}
			
			//anything else
			for (String x : commands) {
				if (x.equalsIgnoreCase(command))
					isACommand = true;
			}
			if (!(isACommand))
				System.out.println("I'm sorry I don't know how to do that.");
		}
	}

}
