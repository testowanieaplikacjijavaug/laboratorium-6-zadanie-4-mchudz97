import com.google.common.annotations.VisibleForTesting;

import java.io.Serializable;


public final class Fraction implements Serializable {
    public static final Fraction of(final int nominator, final int denominator) {
        if(denominator == 0){
            if(nominator == 0)
                return INDETERMINATE;
            throw new IllegalArgumentException("Fraction denominator cannot be equal to 0");
        }
        if(denominator < 0){
            return of(-nominator,-denominator);
        }
        if(nominator == 1){
            switch(denominator){
                case 1:
                    return FULL;
                case 2:
                    return HALF;
                case 3:
                    return ONE_THIRD;
            }
        }
        return new Fraction(nominator,denominator);
    }
    public int getNominator(){
        return nominator;
    }
    public int getDenominator(){
        return denominator;
    }
    public double doubleValue(){
        if(denominator == 0){
            throw new IllegalArgumentException("denominator is zero");
        }
        return (double) nominator / (double) denominator;
    }

    public Fraction multiply(Fraction by){

        return of(nominator * by.nominator, denominator * by.denominator);

    }



    public Fraction add( Fraction to){

        if(this.denominator == to.denominator){

            return of(this.nominator + to.nominator, this.denominator);

        }

        return of(this.nominator * to.denominator + this.denominator * to.nominator,
                this.denominator * to.denominator);

    }


    @Override
    public boolean equals(final Object rightSide){
        if(!(rightSide instanceof Fraction)) return false;
        final Fraction that = (Fraction) rightSide;
        return (this == that) || (nominator == that.nominator && denominator == that.denominator);
    }
    @Override
    public int hashCode(){
        return nominator + denominator;
    }
    @Override
    public String toString(){
        return new StringBuilder()
                .append(nominator)
                .append('/')
                .append(denominator)
                .toString();
    }
    public Fraction(final int nominator, final int denominator){
        this.denominator = denominator;
        this.nominator = nominator;
    }
    public static final Fraction INDETERMINATE = new Fraction(0,0);
    @VisibleForTesting static final Fraction FULL = new Fraction(1,1);
    @VisibleForTesting static final Fraction HALF = new Fraction(1,2);
    @VisibleForTesting static final Fraction ONE_THIRD = new Fraction(1,3);
    private final int nominator;
    private final int denominator;
}