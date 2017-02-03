/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author NINJA-CHACHA
 */

class ItemNotFound extends Exception
{
    ItemNotFound(String str)
    {
        System.out.println(str);
    }
}


public class Inventory{

    private final ArrayList<InventoryItem> arr;
    
    public Inventory()
    {
        //initialized with null set of inventory items
        arr = new ArrayList<InventoryItem>();
    }
    
    public void addNewInventoryItem(InventoryItem new_item)
    {
        arr.add(new_item);
    }
    
    public void addStock(int item_code, int qty) throws ItemNotFound 
    {
        int flag = 0;
        InventoryItem itm;
        Iterator itr = arr.iterator();
        while(itr.hasNext())
        {
            itm = (InventoryItem)itr.next();
            if(itm.getCode() == item_code)
            {
                flag = 1;
                itm.addStock(qty);
            }
            
        }
        if(flag == 0)
            throw new ItemNotFound("Item Code does not exist in database");
        //adds specified qty of specified item to the inventory
        //you may have locate the specified item in the collection before increasing its stock
    }
    
    public void withdrawStock(int item_code, int qty) throws ItemNotFound, InSufficientStock
    {
        Iterator itr = arr.iterator();
        InventoryItem itm;
        int flag = 0;
        while(itr.hasNext())
        {
            itm = (InventoryItem) itr.next();
            if(itm.getCode() == item_code)
            {
                flag = 1;
                itm.withdrawStock(qty);
            }
        }
        if(flag == 0)
            throw new ItemNotFound("Item code doesnot exist in database");
    }

    public InventoryItem[] itemsUnderStock()
    {
        return (InventoryItem[])arr.toArray();
    }
    
    public InventoryItem search(int item_code) throws ItemNotFound, ItemNotFound 
    {
    //returns item object with given item code, if found
        Iterator itr = arr.iterator();
        InventoryItem itm;
        while(itr.hasNext())
        {
            itm = (InventoryItem) itr.next();
            if(itm.getCode() == item_code)
                return itm;
        }
               throw new ItemNotFound("Item Code not Found in Databse");
    }
    
    public double totalInventoryCost()
    {
        double cost = 0;
        Iterator itr = arr.iterator();
        InventoryItem itm;
        while(itr.hasNext())
        {
            itm = (InventoryItem) itr.next();
            cost += itm.getCost();
        }
        return cost;
    }
     
    public void printAll()
    {
        PrintStream stdout = new PrintStream(System.out);
        Iterable<InventoryItem> item = null;
        for(InventoryItem i : item){
            stdout.println("==========================");
            stdout.println("Item code ->" + i.getCode());
            stdout.println("Item Current Stock ->" + i.getStock());
            stdout.println("Item Cost ->" + i.getCost());
        }
    }
}