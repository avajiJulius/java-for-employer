package edu.java.example.jpa.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="jpa_items_list")
public class ItemsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_item_id")
    private Long ItemListId;
    private List<Item> itemList;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "status")
    private ItemStatus status;

    public ItemsList() {
    }

    public Long getItemListId() {
        return ItemListId;
    }

    public void setItemListId(Long itemListId) {
        ItemListId = itemListId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
