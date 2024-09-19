package service;

import model.Price;

public class BasicPriceProcessor implements PriceProcessor{
    @Override
    public Price process(Price price) {
        return price;
    }
}
