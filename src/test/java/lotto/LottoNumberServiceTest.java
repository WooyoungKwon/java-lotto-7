package lotto;

import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.constant.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberServiceTest {
    @DisplayName("로또 번호 1에서 45까지의 숫자 중 6개를 랜덤 추출한다.")
    @Test
    void 로또_번호_1에서_45까지의_숫자_중_6개를_랜덤_추출한다() {
        // given
        LottoNumberService lottoNumberService = new LottoNumberService();

        // when
        Lotto lotto = new Lotto(lottoNumberService.createRandomNumbers());

        // then
        List<Integer> lottoNumbers = lotto.getNumbersList();

        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_SIZE);
        assertThat(
                lottoNumbers
                        .stream()
                        .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER))
                .isEqualTo(true);
    }

    @DisplayName("보너스 번호 한 개를 랜덤 생성한다.")
    @Test
    void 보너스_번호_한_개를_랜덤_생성한다() {
        // given
        LottoNumberService lottoNumberService = new LottoNumberService();

        // when
        int newBonusNumber = lottoNumberService.createBonusNumber();

        // then
        assertThat(newBonusNumber).isBetween(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }
}
