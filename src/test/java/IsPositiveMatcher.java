import org.assertj.core.api.AbstractAssert;

public class IsPositiveMatcher extends AbstractAssert<IsPositiveMatcher, Fraction> {


    public IsPositiveMatcher(Fraction fraction) {
        super(fraction, IsPositiveMatcher.class);
    }

    public static IsPositiveMatcher assertThat(Fraction actual) {
        return new IsPositiveMatcher(actual);
    }

    public IsPositiveMatcher isPositive(){
        isNotNull();
        if(actual.getNominator() < 0){
            failWithMessage("Fraction isnt positive");
        }
        return this;
    }
    public IsPositiveMatcher isZero(){
        isNotNull();
        if(actual.getNominator() != 0 || actual.getDenominator() == 0){
            failWithMessage("Fraction isnt zero");
        }
        return this;
    }


}
