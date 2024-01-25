package com.cirilgroup.aventurier.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

public class PlayerTest {

	@InjectMocks
	private Player tested = new Player();

	// =========================================================================
	// ============================ PLAYER MOVEMENT=============================
	// =========================================================================

	@Test
	public void givenOneStepForward_whenMovePlayer_thenMoveForeward() {
		char mapArray[][] = {
			{ ' ', ' ' },
			{ '#', '#' }
		};

		Player expected = new Player();
		expected.setX(1);

		tested.setX(0);
		tested.movePlayer("E", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepBackward_whenMovePlayer_thenMoveBackward() {
		char mapArray[][] = {
			{ ' ', ' ' },
			{ '#', '#' }
		};

		Player expected = new Player();
		expected.setX(0);

		tested.setX(1);
		tested.movePlayer("O", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepDownward_whenMovePlayer_thenMoveDownward() {
		char mapArray[][] = {
			{ ' ', '#' },
			{ ' ', '#' }
		};

		Player expected = new Player();
		expected.setY(1);

		tested.setY(0);
		tested.movePlayer("S", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepUpward_whenMovePlayer_thenMoveUpward() {
		char mapArray[][] = {
			{ ' ', '#' },
			{ ' ', '#' }
		};

		Player expected = new Player();
		expected.setY(0);

		tested.setY(1);
		tested.movePlayer("N", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	// =========================================================================
	// ============================ PLAYER OBSTACLE=============================
	// =========================================================================

	@Test
	public void givenOneStepForwardWithObstacle_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ ' ', '#' },
			{ '#', '#' }
		};

		Player expected = new Player();
		expected.setX(0);
		expected.setCounterObstacle(1);

		tested.setX(0);
		tested.movePlayer("E", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepBackwardWithObstacle_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ '#', ' ' },
			{ '#', '#' }
		};

		Player expected = new Player();
		expected.setX(1);
		expected.setCounterObstacle(1);

		tested.setX(1);
		tested.movePlayer("O", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepDownwardWithObstacle_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ ' ', '#' },
			{ '#', '#' }
		};

		Player expected = new Player();
		expected.setY(0);
		expected.setCounterObstacle(1);

		tested.setY(0);
		tested.movePlayer("S", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepUpwardWithObstacle_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ '#', '#' },
			{ ' ', '#' }
		};

		Player expected = new Player();
		expected.setY(1);
		expected.setCounterObstacle(1);

		tested.setY(1);
		tested.movePlayer("N", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	// =========================================================================
	// ============================== PLAYER EDGE===============================
	// =========================================================================

	@Test
	public void givenOneStepForwardWithEdge_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ ' ' },
			{ '#', }
		};

		Player expected = new Player();
		expected.setX(0);
		expected.setCounterEdge(1);

		tested.setX(0);
		tested.movePlayer("E", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepBackwardWithEdge_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ ' ' },
			{ '#' }
		};

		Player expected = new Player();
		expected.setX(0);
		expected.setCounterEdge(1);

		tested.setX(0);
		tested.movePlayer("O", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepDownwardWithEdge_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ '#' },
			{ ' ' }
		};

		Player expected = new Player();
		expected.setY(1);
		expected.setCounterEdge(1);

		tested.setY(1);
		tested.movePlayer("S", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	@Test
	public void givenOneStepUpwardWithEdge_whenMovePlayer_thenNotMove() {
		char mapArray[][] = {
			{ ' ' },
			{ '#' }
		};

		Player expected = new Player();
		expected.setY(0);
		expected.setCounterEdge(1);

		tested.setY(0);
		tested.movePlayer("N", mapArray);

		assertThat(tested).isEqualTo(expected);
	}

	// =========================================================================
	// ============================== PLAYER OTHER =============================
	// =========================================================================

	@Test
	public void givenMovementString_whenGetMovements_thenGetCoordinates() {
		String movements = "6,7\nEESNO";
		String expected = "EESNO";

		String testedMovements = tested.getMovements(movements);

		assertThat(testedMovements).isEqualTo(expected);
	}

}
