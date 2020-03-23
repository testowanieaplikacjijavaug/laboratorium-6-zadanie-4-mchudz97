import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ValidSignFractionMatcher extends TypeSafeMatcher<Fraction> {
    @Override
    protected boolean matchesSafely(Fraction item) {

        return item.getDenominator()>=0;
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("Fraction has valid sign");
    }

    public static ValidSignFractionMatcher validMatcher(){
        return new ValidSignFractionMatcher();
    }
}