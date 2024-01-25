package com.cirilgroup.aventurier.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BufferManager {
	// =========================================================================
	// ============================== METHODES PUBLIQUES =======================
	// =========================================================================

	/**
	 * Provide a {@link BufferedReader}
	 * 
	 * @param coordinatesFileName : {@link String}
	 * @return reader : {@link BufferedReader}
	 */
	public static BufferedReader provideBufferReader(String fileName) {
		BufferedReader reader = null;
		if (fileName != null) {
			try {
				reader = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				System.err.println("Erreur de lecture du fichier : ");
				e.printStackTrace();
			}
		}
		return reader;
	}

	/**
	 * Convert a {@link BufferedReader} input into a {@link String}
	 * 
	 * @param mapReader : {@link BufferedReader}
	 * @return message : {@link String}
	 */
	public static String bufferedToString(BufferedReader reader) throws IOException {
		String line = null;
		String message = new String();
		while ((line = reader.readLine()) != null) {
			message += line;
			message += "\n";
		}
		return message;
	}

}
