package transactions.repositories;

import transactions.model.Item;

import java.time.LocalDate;

public interface ItemRepositoryCustom {

    void addItem(String name, int highestBid);

    void checkNameDuplicate(String name);

    void addLogs();

    void showLogs();

    void addItemNoRollback(String name, int highestBid);

    void refresh(Item item);
}
