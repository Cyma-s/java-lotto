package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.InputErrorMessage;
import org.junit.jupiter.api.Test;

public class InputErrorTest extends NsTest {
    @Test
    void 구입금액_단위_테스트() {
        assertSimpleTest(() -> {
            runException("462");
            assertThat(output()).contains(InputErrorMessage.MONEY_IS_NOT_DIVIDED.getErrorMessage());
        });
    }

    @Test
    void 당첨번호_문자열_구분자_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "1.2.3.4.5.6");
            assertThat(output()).contains(InputErrorMessage.INVALID_LOTTO_NUMBERS.getErrorMessage());
        });
    }

    @Test
    void 당첨번호_숫자가_아닌_문자열_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "21,42,6,15,27f");
            assertThat(output()).contains(InputErrorMessage.INVALID_LOTTO_NUMBERS.getErrorMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
