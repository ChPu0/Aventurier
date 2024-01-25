package com.cirilgroup.aventurier.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Player {
	// =========================================================================
	// ============================== CONSTANTES ===============================
	// =========================================================================
	private static final char BOIS_IMPENETRABLES = '#';
	// =========================================================================
	// ============================== ATTRIBUTS ================================
	// =========================================================================
	private int x;
	private int y;
	private int counterObstacle;
	private int counterEdge;
	// =========================================================================
	// ============================== METHODES PUBLIQUES =======================
	// =========================================================================

	/**
	 * Place the {@link Player} on the {@link Board} according to the coordinates in parameter
	 * 
	 * @param coordinates : {@link String}
	 */
	public void placeOnBoard(String coordinates) {

		String[] getPosition = coordinates.split(",|\n");

		this.setX(Integer.parseInt(getPosition[0]));
		this.setY(Integer.parseInt(getPosition[1]));

		System.out.println("Le joueur est positionné en (" + this.getX() + "," + this.getY() + ")");
	}

	/**
	 * Return a chain {@link String} of movements
	 * 
	 * @param movements : {@link String} movements
	 * @return movements {@link String}
	 */
	public String getMovements(String movements) {
		String[] getMovement = movements.split(",|\n");
		return getMovement[2];
	}

	/**
	 * Move the {@link Player} according to the cardinal points (N,S,E,O) chain ({@link String}) passed in parameter. If the {@link Player} encounters an
	 * obstacle or the edge of the {@link Board}, it stays in place
	 * 
	 * @param deplacements : {@link String}
	 * @param mapLines : char[][]
	 */
	public void movePlayer(String deplacements, char[][] mapLines) {
		for (char deplacement : deplacements.toCharArray()) {
			switch (deplacement) {
				case 'N':
					this.moveUp();
					break;
				case 'S':
					this.moveDown();
					break;
				case 'E':
					this.moveForward();
					break;
				case 'O':
					this.moveBackward();
					break;
				default:
					break;
			}

			if (isOnTheEdge(mapLines, x, y) || isOnObstacle(mapLines, x, y)) {
				switch (deplacement) {
					case 'N':
						this.moveDown();
						break;
					case 'S':
						this.moveUp();
						break;
					case 'E':
						this.moveBackward();
						break;
					case 'O':
						this.moveForward();
						break;
					default:
						break;
				}
			}
		}
		if(counterEdge > 0) {
			String message = String.format("Le héros est allé au-delà des bords de la carte par %d fois.", counterEdge);
			System.out.println(message);
		}
		if(counterObstacle > 0) {
		    String message = String.format("Le héros est arrivé sur une case occupée par les bois impénétrables par %d fois", counterObstacle);
		    System.out.println(message);
		}
		System.out.println("Le héros se trouve en (" + x + "," + y + ")");
	}

	// =========================================================================
	// ============================== METHODES PRIVEES =========================
	// =========================================================================

	/**
	 * Moves {@link Player} by one step forward
	 */
	private void moveForward() {
		this.setX(
			this.getX() + 1);
	}

	/**
	 * Moves {@link Player} by one step backward
	 */
	private void moveBackward() {
		this.setX(
			this.getX() - 1);
	}

	/**
	 * Moves {@link Player} by one step upward
	 */
	private void moveUp() {
		this.setY(
			this.getY() - 1);
	}

	/**
	 * Moves {@link Player} by one step downward
	 */
	private void moveDown() {
		this.setY(
			this.getY() + 1);
	}

	/**
	 * Checks if parameter x or parameter y is on an obstacle : {@link BOIS_IMPENETRABLES}
	 * 
	 * @param mapLines : char[][]
	 * @param x : int
	 * @param y : int
	 * @return isObstacle : boolean
	 */
	private boolean isOnObstacle(char[][] mapLines, int x, int y) {
		boolean isObstacle = false;
		if (mapLines[y][x] == BOIS_IMPENETRABLES) {
			counterObstacle++;
			isObstacle = true;
		}
		return isObstacle;
	}

	/**
	 * Checks if parameter x or parameter y is over the mapLines limit.
	 * 
	 * @param mapLines : char[][]
	 * @param x : int
	 * @param y : int
	 * @return isEdge : boolean
	 */
	private boolean isOnTheEdge(char[][] mapLines, int x, int y) {
		boolean isEdge = false;
		if (x < 0 || y < 0 || x >= mapLines[0].length || y >= mapLines.length) {
			counterEdge++;
			isEdge = true;
		}
		return isEdge;
	}

}
