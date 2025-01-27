package org.skypro.skyshop.product;

public class DiscountedProduct extends SimpleProduct {
    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name, price);
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (скидка " + discountPercent + "%)";
    }
}