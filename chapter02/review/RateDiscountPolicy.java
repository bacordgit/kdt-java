package chapter02.review;

public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(int originalPrice) {
        return (int) (originalPrice*0.9);
    }
}
