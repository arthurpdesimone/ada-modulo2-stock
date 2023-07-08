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
import java.util.stream.Collectors;

import static ada.tech.config.Configuration.API_KEY;
import static ada.tech.config.Configuration.URL;

public class StockService implements StockInterface {

    public List<Stock> downloadStock(String ticker) throws Exception {
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
        System.out.println("Ticker "+ticker+" registros: "+list.size());
        return list;
    }

    public void listStocks(LinkedList<Stock> stocks){
        for(Stock s : stocks){
            System.out.println("Data : "+s.timestamp()+"\t Preço :"+s.close());
        }
    }

    public void orderStocks(LinkedList<Stock> stocks){
        stocks.sort(Stock::compareTo);
    }

    public List<Stock> removeDuplicateStocks(LinkedList<Stock> stocks){
        System.out.println("Removendo duplicatas da lista de tamanho "+stocks.size());
        List<Stock> newList = stocks.stream().distinct().toList();
        LinkedList<Stock> stocksDuplicateRemoved = new LinkedList<>(newList);
        System.out.println("Novo tamanho da lista  "+newList.size());
        System.out.println("Duplicatas removidas  "+(stocks.size()-newList.size()));
        return stocksDuplicateRemoved;
    }

}
