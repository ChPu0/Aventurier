package com.cirilgroup.aventurier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Board {
	// =========================================================================
	// ============================== ATTRIBUTS ================================
	// =========================================================================
	private int sizeX;
	private int sizeY;

	// =========================================================================
	// ============================== METHODES PUBLIQUES =======================
	// =========================================================================

	/**
	 * Generate the {@link Board} of the game of the size passed in parameter.
	 *
	 * @param mapStringified : {@link String} (string map to generate the {@link Board} from)
	 * @param width : int (the width of the board)
	 * @param height : int (the height of the board)
	 * @return board : char[][] (2 dimensions array of chars representing the {@link Board})
	 */
	public char[][] generateBoard(String mapStringified, int width, int height) {
		int colIndex = 0;
		int rowIndex = 0;

		char[][] board = new char[width][height];

		System.out.println("Dessin du plateau de jeu : ");
		for (String line : mapStringified.split("\n")) {
			char[] chArr = new char[width];
			line.getChars(0, width, chArr, 0);
			for (char res : chArr) {
				board[rowIndex][colIndex] = res;
				System.out.print(board[rowIndex][colIndex]);
				colIndex++;
			}
			colIndex = 0;
			rowIndex++;
			System.out.println();
		}
		return board;
	}
}
