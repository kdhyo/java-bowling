package bowling.domain;

import bowling.domain.frame.Frames;

public class Player {

	private final Name name;
	private final Frames frames;

	public Player(String name) {
		this.name = new Name(name);
		this.frames = new Frames();
	}

	public String getName() {
		return name.geName();
	}

}
