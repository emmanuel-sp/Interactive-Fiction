/*
 * Player.java
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
public class Player {
	private int playerX = 0;
	private int playerY = 0;
	private Key playerKey;
	private Lamp playerLamp;
	
	Player(){
	}
	public Key getKey() {
		return playerKey;
	}
	public void setKey(Key theKey) {
		playerKey = theKey;
	}

	public Lamp getLamp() {
		return playerLamp;
	}
	
	public void setLamp(Lamp theLamp) {
		playerLamp = theLamp;
	}
	public int getX(){
		return playerX;
	}
	public int getY() {
		return playerY;
	}
	public void setX(int x) {
		playerX = x;
	}
	public void setY(int y) {
		playerY = y;
	}
}
