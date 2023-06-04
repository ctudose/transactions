package transactions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import transactions.model.Item;
import transactions.repositories.ItemRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.springframework.transaction.annotation.Isolation.*;

@SpringBootTest
public class IsolationTest {

    @Autowired
    private ItemRepository itemRepository;

    // try with READ_COMMITTED (or with no isolation set)
    @Test
    @Transactional(isolation = REPEATABLE_READ)
    public void repeatableRead() {
        Item item = itemRepository.findAll().get(0);
        System.out.println(item.getHighestBid());

        // set breakpoint here, then run updateItem()
        itemRepository.refresh(item);
        System.out.println(item.getHighestBid());
    }

    // try with READ_COMMITTED (or with no isolation set)
    @Test
    @Transactional(isolation = SERIALIZABLE)
    public void phantomRead() {
        List<Item> itemsList1 = itemRepository.findAll();
        System.out.println(itemsList1.size());

        // set breakpoint here, then run addItem()
        List<Item> itemsList2 = itemRepository.findAll();
        System.out.println(itemsList2.size());
    }

    @Test
    void addItem() {
        Item item1 = new Item("Item1", 100);
        itemRepository.save(item1);
    }

    @Test
    public void updateItem() {
        Item item = itemRepository.findAll().get(0);
        System.out.println(item.getHighestBid());
        item.setHighestBid(item.getHighestBid() + 10);
        itemRepository.save(item);

        item = itemRepository.findAll().get(0);
        System.out.println(item.getHighestBid());
    }
}
