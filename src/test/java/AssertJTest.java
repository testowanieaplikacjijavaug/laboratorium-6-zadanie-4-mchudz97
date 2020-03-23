import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {


    @Test
    public void whenDenominatorIsZeroAndNominatorNotZero(){

        assertThatThrownBy(() -> {Fraction.of(1,0);
        }).isInstanceOf(
                IllegalArgumentException.class).hasMessage(
                        "Fraction denominator cannot be equal to 0");



    }
    @Test
    public void whenDenominatorAndNominatorAreZeros1(){
        assertThat(Fraction.of(0,0).getDenominator()).isEqualTo(0);
    }

    @Test
    public void whenDenominatorAndNominatorAreZeros2(){
        assertThat(Fraction.of(0,0).getNominator()).isEqualTo(0);
    }
    @Test
    public void functionOfTest1(){

        assertThat(Fraction.of(1,3).getNominator()).isEqualTo(1);

    }
    @Test
    public void functionOfTest2(){

        assertThat(Fraction.of(1,3).getDenominator()).isEqualTo(3);

    }
    @Test
    public void functionOfTest3(){
        assertThat(Fraction.of(-1,-1).getDenominator()).isEqualTo(1);
    }

    @Test
    public void functionOfTest4(){
        assertThat(Fraction.of(-1,-1).getNominator()).isEqualTo(1);
    }
    @Test
    public void functionOfTest5(){
        assertThat(Fraction.of(1,-1).getNominator()).isEqualTo(-1);
    }
    @Test
    public void functionOfTest6(){
        assertThat(Fraction.of(1,-1).getDenominator()).isEqualTo(1);
    }
    @Test
    public void functionOfTest7(){
        assertThat(Fraction.of(-1,1).getNominator()).isEqualTo(-1);
    }
    @Test
    public void functionOfTest8(){
        assertThat(Fraction.of(-1,1).getDenominator()).isEqualTo(1);
    }

    @Test
    public void functionDoubleValueTest1(){
        assertThat(Fraction.of(1,1).doubleValue()).isEqualTo(1.0);
    }
    @Test
    public void functionDoubleValueExceptionTest() {

        assertThatThrownBy(() -> {Fraction.of(0,0).doubleValue();
        }).isInstanceOf(
                IllegalArgumentException.class).hasMessage(
                "denominator is zero");

    }
    @Test
    public void functionDoubleValueTest2(){
        assertThat(Fraction.of(1,10).doubleValue())
                .isBetween(0.09,0.11);
    }

    @Test
    public void addTest1(){

        assertThat(Fraction.of(1,2).
                add(Fraction.of(1,2)).doubleValue())
                .isEqualTo(Fraction.FULL.doubleValue());

    }
    @Test
    public void addTest2(){

        assertThat(Fraction.of(1,4).
                add(Fraction.of(1,4)).doubleValue())
                .isEqualTo(Fraction.HALF.doubleValue());

    }
    @Test
    public void addTest3(){

        assertThat(Fraction.of(2,1).
                add(Fraction.of(-1,1))).isEqualTo(Fraction.FULL);

    }
    @Test
    public void multiplyTest1(){

        assertThat(Fraction.of(1,1).
                multiply(Fraction.of(1,2))).isEqualTo(Fraction.HALF);

    }

    @Test
    public void multiplyTest2(){
        assertThat(Fraction.of(0,0).
                multiply(Fraction.of(100,101)))
                .isEqualTo(Fraction.INDETERMINATE);
    }
    @Test
    public void multiplyTest3(){

        assertThat(Fraction.of(-1,1).
                multiply(Fraction.of(-1,1))).isEqualTo(Fraction.FULL);

    }

    @Test
    void toStringTest() {

        assertThat(Fraction.of(2, 3).toString()).isEqualTo("2/3");
    }

    @Test
    void isFractionZero(){

        IsPositiveMatcher.assertThat(Fraction.of(0,10)).isZero();

    }
    @Test
    void isFractionPositive(){
        IsPositiveMatcher.assertThat(Fraction.of(10,10)).isPositive();
    }


}
