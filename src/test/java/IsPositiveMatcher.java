import org.assertj.core.api.AbstractAssert;

public class IsPositiveMatcher extends AbstractAssert<IsPositiveMatcher, Fraction> {


    public IsPositiveMatcher(Fraction fraction) {
        super(fraction, Fraction.class);
    }

    public static IsPositiveMatcher assertThat(Fraction actual) {
        return new IsPositiveMatcher(actual);
    }

    public boolean isPositive(){
        isNotNull();
        if(actual.getNominator() >= 0){
           return true;
        }
        return false;
    }
    public boolean isZero(){
        isNotNull();
        if(actual.getNominator() == 0 && actual.getDenominator() != 0){
            return true;
        }
        return false;
    }


}
