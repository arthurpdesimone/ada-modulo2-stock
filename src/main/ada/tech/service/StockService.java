package ada.tech.service;

import ada.tech.model.Stock;
import ada.tech.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static ada.tech.config.Configuration.API_KEY;
import static ada.tech.config.Configuration.URL;

public class StockService {
    /**
     * @param ticker The stock name
     * @return List containing all the stocks
     * */
    public List<Stock> downloadStock(String ticker) throws IOException, ParseException {
        List<Stock> list = new LinkedList<>();
        String stockString = Utils.downloadToString(URL+"TIME_SERIES_DAILY_ADJUSTED&symbol="+ticker+"&outputsize=full&datatype=csv&apikey="+API_KEY);

        /** Stock download*/
        BufferedReader timeSeries = new BufferedReader(new StringReader(stockString));
        timeSeries.readLine(); /** Skip the first line */
        String row;
        while ((row = timeSeries.readLine()) != null) {
            String[] data = row.split(",");
            String date = data[0];
            String close = data[4];
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date d = simpleDateFormat.parse(date);
            Double closeValue = Double.parseDouble(close);
            Stock stock = new Stock(ticker,d, closeValue);
            list.add(stock);
        }
        timeSeries.close();
        return list;
    }
}
