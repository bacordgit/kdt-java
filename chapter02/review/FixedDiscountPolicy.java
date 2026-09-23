package chapter02.review;

public class FixedDiscountPolicy implements DiscountPolicy{
    private static final int FIXED_AMOUNT=1000;
    @Override
    public int discount(int originalPrice){
        return Math.max(0,originalPrice-FIXED_AMOUNT);
    }
}
