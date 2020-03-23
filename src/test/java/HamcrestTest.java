import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import java.lang.reflect.Constructor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {




    @Test
    public void whenDenominatorIsZeroAndNominatorNotZero(){

        Assertions.assertThrows( IllegalArgumentException.class,
                ()->Fraction.of(1,0));



    }
    @Test
    public void whenDenominatorAndNominatorAreZeros1(){


        assertThat(Fraction.of(0,0).getDenominator(), is(0));
    }
    @Test
    public void whenDenominatorAndNominatorAreZeros2(){


        assertThat(Fraction.of(0,0).getNominator(), is(0));
    }

    @Test
    public void functionOfTest1(){

        assertThat(Fraction.of(1,3).getNominator(), is(1));

    }
    @Test
    public void functionOfTest2(){

        assertThat(Fraction.of(1,3).getDenominator(), is(3));

    }
    @Test
    public void functionOfTest3(){

        assertThat(Fraction.of(-1,-1).getNominator(), is(1));

    }
    @Test
    public void functionOfTest4(){

        assertThat(Fraction.of(-1,-1).getDenominator(), is(1));

    }
    @Test
    public void functionOfTest5(){

        assertThat(Fraction.of(1,-1).getDenominator(), is(1));

    }
    @Test
    public void functionOfTest6(){

        assertThat(Fraction.of(1,-1).getNominator(), is(-1));

    }
    @Test
    public void functionOfTest7(){

        assertThat(Fraction.of(-1,1).getNominator(), is(-1));

    }
    @Test
    public void functionOfTest8(){

        assertThat(Fraction.of(-1,1).getDenominator(), is(1));

    }
    @Test
    public void functionDoubleValueTest1(){

        assertThat(Fraction.of(1,1).doubleValue(), is(1.0));

    }
    @Test
    public void functionDoubleValueExceptionTest(){

        Assertions.assertThrows( IllegalArgumentException.class,
                ()->Fraction.of(0,0).doubleValue());

    }
    @Test
    public void functionDoubleValueTest2(){

        assertThat(Fraction.of(1,10).doubleValue(),
                allOf(greaterThan(0.09), lessThan(0.11)));

    }
    @Test
    public void addTest1(){

        assertThat(Fraction.of(1,2).
                        add(Fraction.of(1,2)).doubleValue(),
                is(Fraction.FULL.doubleValue()));

    }

    @Test
    public void addTest2(){

        assertThat(Fraction.of(1,4).
                add(Fraction.of(1,4)).doubleValue(),
                equalTo((Fraction.HALF).doubleValue()));

    }
    @Test
    public void addTest3(){

        assertThat(Fraction.of(2,1).
                add(Fraction.of(-1,1)), equalTo(Fraction.FULL));


    }
    @Test
    public void multiplyTest1(){
        assertThat((Fraction.of(1,1).
                multiply(Fraction.of(1,2))), equalTo(Fraction.HALF));
    }
    @Test
    public void multiplyTest2(){
        assertThat(Fraction.of(0,0).
                multiply(Fraction.of(100,101)),
                equalTo(Fraction.INDETERMINATE));


    }
    @Test
    public void multiplyTest3(){
        assertThat(Fraction.of(-1,1).
                multiply(Fraction.of(-1,1)), equalTo(Fraction.FULL));
    }

    @Test
    void toStringTest() {

        assertThat(Fraction.of(2, 3).toString(), is("2/3"));
    }

    @Test
    void isSignValid(){
        assertThat(Fraction.of(1, -1),
                is(ValidSignFractionMatcher.validMatcher()));
    }
    @Test
    void isFractionSpecial(){
        assertThat(Fraction.of(0,0),
                is(SpecialFractionMatcher.specialFraction()));
    }


}
