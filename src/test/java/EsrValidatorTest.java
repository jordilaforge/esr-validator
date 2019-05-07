import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class EsrValidatorTest {

    private EsrValidator esrValidator;

    @Before
    public void init() {
        esrValidator = new EsrValidator();
    }

    @Test
    public void validate_valid_esr_0() {
        boolean valid = esrValidator.validate("961116900000006600000009284");
        Assertions.assertThat(valid).isTrue();
    }

    @Test
    public void validate_valid_esr_1() {
        boolean valid = esrValidator.validate("250000000000135678765455541");
        Assertions.assertThat(valid).isTrue();
    }

    @Test
    public void validate_valid_esr_2() {
        boolean valid = esrValidator.validate("120000000000234478943216899");
        Assertions.assertThat(valid).isTrue();
    }

    @Test
    public void validate_valid_esr_3() {
        boolean valid = esrValidator.validate("120000000000234478943216899");
        Assertions.assertThat(valid).isTrue();
    }

    @Test
    public void validate_valid_esr_4() {
        boolean valid = esrValidator.validate("210000000003139471430009017");
        Assertions.assertThat(valid).isTrue();
    }

    @Test
    public void validate_too_long() {
        boolean valid = esrValidator.validate("1200000000002344789432168992");
        Assertions.assertThat(valid).isFalse();
    }

    @Test
    public void validate_too_short() {
        boolean valid = esrValidator.validate("12000000000023447894321689");
        Assertions.assertThat(valid).isFalse();
    }
}
