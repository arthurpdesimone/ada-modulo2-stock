package ada.tech.model;

import java.util.Date;

public record Stock(String ticker, Date timestamp, Double close) {
}
