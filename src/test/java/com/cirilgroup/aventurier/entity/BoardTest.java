package com.cirilgroup.aventurier.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

public class BoardTest {
	@InjectMocks
	Board board;

	@Test
	public void given2x2BoardFile_whenGenerateBoard_then2x2BoardGenerated() {
		Board board = new Board();
		String map = "##\n##";
		char expected[][] = {{ '#', '#' }, { '#', '#' }};
		
		char tested[][] = board.generateBoard(map,2, 2);
		
		assertThat(tested).isEqualTo(expected);
	}
	
}
