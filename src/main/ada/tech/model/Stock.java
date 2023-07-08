package ada.tech.model;

import java.util.Date;

public record Stock(String ticker, Date timestamp, Double close) implements Comparable<Stock>{
    @Override
    public int compareTo(Stock o) {
        return this.timestamp().compareTo(o.timestamp());
    }
}
