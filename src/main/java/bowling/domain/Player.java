package bowling.domain;

import bowling.domain.frame.Frames;

public class Player {

	private final Name name;
	private final Frames frames;

	public Player(String name) {
		this.name = new Name(name);
		this.frames = new Frames();
	}

	public Player bowling(int pins) {
		frames.bowling(pins);
		return this;
	}

	public boolean isNotGameEnd() {
		return frames.isNotGameEnd();
	}

	public String getName() {
		return name.getName();
	}

}
