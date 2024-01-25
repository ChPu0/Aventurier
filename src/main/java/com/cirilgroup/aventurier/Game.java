package com.cirilgroup.aventurier;

import java.io.BufferedReader;
import java.io.IOException;

import com.cirilgroup.aventurier.entity.Board;
import com.cirilgroup.aventurier.entity.Player;
import com.cirilgroup.aventurier.utils.BufferManager;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Game {
	// =========================================================================
	// ============================== CONSTANTES ===============================
	// =========================================================================
	private static final String CARTE_NOM_FICHIER = "carteV2.txt";
	private static final String COORDONNES_NOM_FICHIER = "coordonnees.txt";
	private static Board board = new Board();

	// =========================================================================
	// ============================== METHODES PUBLIQUES =======================
	// =========================================================================
	/**
	 * Runs the script of the {@link Game}
	 * 
	 * @throws IOException
	 */
	public static void playGame() throws IOException {

		BufferedReader mapReader = BufferManager.provideBufferReader(CARTE_NOM_FICHIER);
		String mapStringified = BufferManager.bufferedToString(mapReader);
		BufferedReader coordonatesReader = BufferManager.provideBufferReader(COORDONNES_NOM_FICHIER);
		String coordonatesStringified = BufferManager.bufferedToString(coordonatesReader);

		char[][] boardArray = board.generateBoard(mapStringified, 20, 20);

		Player player = new Player();

		player.placeOnBoard(coordonatesStringified);

		String movements = player.getMovements(coordonatesStringified);

		player.movePlayer(movements, boardArray);

		mapReader.close();
		coordonatesReader.close();
	}
}
