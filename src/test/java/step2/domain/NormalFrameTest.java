package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.state.Miss;
import step2.domain.state.Spare;
import step2.domain.state.Strike;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalFrameTest {

    @Test
    @DisplayName("NormalFrame 초기화")
    void init() {
        assertThat(NormalFrame.init()).isInstanceOf(Frame.class);
    }

    @Test
    @DisplayName("투구하기")
    void bowl() {
        Pitch pitch = Pitch.from(8);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch);

        assertThat(frame.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크이므로 종료 확인")
    void isFinishStrike() {
        Pitch pitch = Pitch.from(10);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch);

        assertThat(frame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("투구를 다 했으므로 종료 확인")
    void isFinishSize() {
        Pitch pitch1 = Pitch.from(3);
        Pitch pitch2 = Pitch.from(5);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch1);
        frame.bowl(pitch2);

        assertThat(frame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("종료가 아님")
    void isNotFinish() {
        Pitch pitch = Pitch.from(9);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch);

        assertThat(frame.isFinish()).isFalse();
    }

    @Test
    @DisplayName("프레임의 점수가 10점을 넘을 경우 예외 처리")
    void exceptScore() {
        Pitch pitch = Pitch.from(6);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch);

        assertThrows(IllegalArgumentException.class,
                () -> frame.bowl(pitch));
    }

    @Test
    @DisplayName("스트라이크 상태")
    void strikeState() {
        Pitch pitch = Pitch.from(10);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch);

        assertThat(frame.getState()).isInstanceOf(Strike.class);
    }

    @Test
    @DisplayName("스페어 상태")
    void spareState() {
        Pitch pitch1 = Pitch.from(8);
        Pitch pitch2 = Pitch.from(2);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch1);
        frame.bowl(pitch2);

        assertThat(frame.getState()).isInstanceOf(Spare.class);
    }

    @Test
    @DisplayName("미스 상태 - 투구 1번")
    void missOneState() {
        Pitch pitch1 = Pitch.from(7);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch1);

        assertThat(frame.getState()).isInstanceOf(Miss.class);
    }

    @Test
    @DisplayName("미스 상태 - 투구 2번")
    void missTwoState() {
        Pitch pitch1 = Pitch.from(7);
        Pitch pitch2 = Pitch.from(2);
        Frame frame = NormalFrame.init();
        frame.bowl(pitch1);
        frame.bowl(pitch2);

        assertThat(frame.getState()).isInstanceOf(Miss.class);
    }

}