package ada.tech.model;

public record Stock(String timestamp,
                    String open,
                    String high,
                    String low,
                    String close,
                    String adjusted_close,
                    String volume,
                    String dividend_amount,
                    String split_coefficient) {
}
