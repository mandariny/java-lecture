import model.Price;
import service.BasicPriceProcessor;
import service.DiscountPriceProcessor;
import service.PriceProcessor;
import service.TaxPriceProcessor;

public class Chapter10Section3 {
    public static void main(String[] args) {
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor);
        Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
