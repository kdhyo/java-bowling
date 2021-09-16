package bowling.domain;

public abstract class Frame {
    protected Pitch pitch;
    protected States states;

    protected Frame(Pitch pitch, States states) {
        this.pitch = pitch;
        this.states = states;
    }

    public void bowl(Pins pins) {
        pitch.bowl(pins);
        states.add(pitch.getState());
    }

    public Pins getFirstPin() {
        return pitch.getFirstPin();
    }

    public Pins getSecondPin() {
        return pitch.getSecondPin();
    }

    public Pins getBonusPin() {
        return pitch.getBonusPin();
    }

    public boolean isFirstPitchDone() {
        return pitch.isFirstPitchDone();
    }

    public boolean isSecondPitchDone() {
        return pitch.isSecondPitchDone();
    }

    public boolean isBonusPitchDone() {
        return pitch.isBonusPitchDone();
    }

    public boolean isFinish() {
        return pitch.isFinish();
    }

    public States getStates() {
        return states;
    }

    public abstract boolean isEnd();

    public abstract int getFrameNumber();

    public abstract Frame next();

    public abstract boolean hasNext();

    public abstract Score getScore();

    protected abstract Score additionalScore(Score score);
}
