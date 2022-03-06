package bowling.domain.frame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Frames {

	private final Deque<Frame> frames;

	public Frames() {
		this.frames = new ArrayDeque<>(Collections.singletonList(NormalFrame.start()));
	}

	public Frames bowling(int pins) {
		Frame frame = frames.removeLast();
		if (frame.isNext()) {
			frames.addLast(frame);
			return bowling(pins, frame.nextFrame());
		}
		return bowling(pins, frame);
	}

	private Frames bowling(int pins, Frame frame) {
		frame = frame.bowling(pins);
		frames.addLast(frame);
		return this;
	}

	public boolean isNotGameEnd() {
		return !hasGameEnd();
	}

	public boolean hasGameEnd() {
		Frame lastFrame = frames.peekLast();
		return frames.size() == 10 && lastFrame.hasGameEnd();
	}

	public int currentRound() {
		return frames.size();
	}

	public List<Frame> getFrame() {
		return Collections.unmodifiableList(new ArrayList<>(frames));
	}

}
