package bowling.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BowlingUsersTest {

    private static Stream<Arguments> provideForBowling() {
        return Stream.of(
                    Arguments.of(Arrays.asList("jms", "kkk", "jjj"), Arrays.asList(10, 0, 9), "jjj"),
                    Arguments.of(Arrays.asList("jms", "kkk"), Arrays.asList(10, 0, 9), "jms"),
                    Arguments.of(Arrays.asList("kms", "jks", "jsy", "lyb"), Arrays.asList(10, 0, 10, 1, 2), "lyb")
        );
    }

    @ParameterizedTest
    @MethodSource("provideForBowling")
    @DisplayName("볼링 진행하기")
    void bowling(List<String> userNames, List<Integer> countOfPinsList, String expected) {
        // given
        BowlingUsers bowlingUsers = BowlingUsers.of(userNames);

        // when
        for (int countOfPins : countOfPinsList) {
            bowlingUsers.bowling(countOfPins);
        }

        // then
        assertThat(bowlingUsers.getTurnUserName()).isEqualTo(expected);

    }

}
