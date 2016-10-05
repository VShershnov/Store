/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author user
 */
public class BdRow extends BdGroup {
    public String name;
    public String discribe;
    public String maker;
    public float price;

    @Override
    public String toString() {
        return "BdRow{" + "name=" + name + ", discribe=" + discribe + ", maker=" + maker + ", price=" + price + '}';
    }
    
    
}
