package ada.tech.service;

import ada.tech.model.Stock;

import java.util.LinkedList;
import java.util.List;

public interface StockInterface {
    /**
     * @param ticker The stock name
     * @return List containing the stock price and date of given ticker
     * */
    List<Stock> downloadStock(String ticker) throws Exception;

    /**
     * @param stocks stock list to be displayed
     * */
    void listStocks(LinkedList<Stock> stocks);

    /**
     * @param stocks stock list to be ordered by date
     * */
    void orderStocks(LinkedList<Stock> stocks);
    /**
     * @param stocks stock list to remove duplicates
     */
    List<Stock> removeDuplicateStocks(LinkedList<Stock> stocks);
}
