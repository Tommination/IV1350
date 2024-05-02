package model;

import DTOs.SaleDTO;
import integration.InventoryHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private String IDToTest;
    private Sale instanceToTest;
    private Item expectedItem;
    private SaleItem expectedLastItem;
    private double expectedTotal;
    int amountOfScans = 1;
    SaleDTO saleInfo;
    @BeforeEach
    void setUp() {

        InventoryHandler inv = new InventoryHandler();
        expectedItem = new Item (inv.getItemDetails("1337"));
        amountOfScans = 2;
        SaleItem item = new SaleItem(expectedItem, amountOfScans);
        IDToTest = "1337";
        instanceToTest = new Sale(inv);
        expectedLastItem = item;
        expectedTotal = (expectedItem.getItem().getPrice()*amountOfScans);


    }
    private SaleDTO scanItemTimes(int amountOfScans){
        for (int i = 0; i < amountOfScans; i++){
            saleInfo = instanceToTest.checkIdentifier(IDToTest);
        }
        return saleInfo;
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        expectedLastItem = null;
        expectedTotal = 0;
    }

    @Test
    void checkTotal() {
        saleInfo = scanItemTimes(amountOfScans);
        double foundTotal = saleInfo.getTotal();
        assertTrue((foundTotal == expectedTotal), "the total isn't what is expected");
    }
    @Test
    void checkLastItemQuantity() {
        saleInfo = scanItemTimes(amountOfScans);
        SaleItem lastItemFound = saleInfo.getLatestScan();
        assertTrue(lastItemFound.getQuantity() == expectedLastItem.getQuantity(), "The quantities don't match");
    }

    @Test
    void checkLastItem() {
        saleInfo = scanItemTimes(amountOfScans);
        SaleItem lastItemFound = saleInfo.getLatestScan();
        assertTrue(lastItemFound.getItem().getName().equals(expectedLastItem.getItem().getName()), "The names don't match");
        assertTrue(lastItemFound.getItem().getDescription().equals(expectedLastItem.getItem().getDescription()), "The descriptions don't match");
    }


}