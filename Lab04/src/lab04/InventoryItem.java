/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NINJA-CHACHA
 */
public class InventoryItem 
{
    //Field Declarations
private int item_code;
private String item_description;
private int qty_in_stock;
private int min_required_stock;
private double cost;
    
    public InventoryItem (int itm_code, String itm_description, int qty, int min_qty, double cost)
    {
    this.item_code = itm_code;
    this.item_description = itm_description;
    this.qty_in_stock = qty;
    this.min_required_stock = min_qty;
    this.cost = cost;
    //arr.add()
    }

    public InventoryItem (int code,String description,double cost )
    {
        this.item_code = code;
        this.item_description = description;
        this.cost = cost;
        this.qty_in_stock =0;
        this.min_required_stock = 0;
    
    //sets qty and min_qty to zero
    }

    public int getCode()
    {
        return this.item_code;
    }
    public void addStock(int qty)
    {
        //increases the stock by given amount
        this.qty_in_stock += qty;
    }

    public int getStock()
    {
        return this.qty_in_stock;
    }
    
    public double getCost()
    {
        return this.cost;
    }
    
    public int getQty(int code)
    {
        return this.qty_in_stock;
    }
    
    public Boolean isUnderStock(int code)
    {
        if(this.qty_in_stock <= this.min_required_stock)
            return true;
        else
            return false;
    }
    
    public void withdrawStock(int qty) throws InSufficientStock
    {
    //decreases the stock by given amount
        if(this.qty_in_stock < 0)
            throw new InSufficientStock("*** Not Enough Stock in Ware House ***");
        else
        {
            this.qty_in_stock += qty;
        }
    }
    
    public void printItem(){
        PrintStream stdout = new PrintStream(System.out);
        stdout.println("Item Code ->" + this.item_code);
        stdout.println("Item Description -> "+this.item_description);
        stdout.println("Item Quantity ->" + this.qty_in_stock);
        stdout.println("Item Cost -> "+this.cost);
        stdout.println("Item Min Quantity -> "+this.min_required_stock);
    }
    

}

class InSufficientStock extends Exception
{
    InSufficientStock(String str)
    {
       System.out.println(str); 
    }
}   