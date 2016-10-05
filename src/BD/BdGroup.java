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
public class BdGroup {
    public int id;
    public String name_group;
    public int count;    
    public float cost;

    public int getId() {
        return id;
    }

    public String getName_group() {
        return name_group;
    }

    public int getCount() {
        return count;
    }

    public float getCost() {
        return cost;
    }

    
    
    @Override
    public String toString() {
        return "BdGroup{" + "name_group=" + name_group + ", count=" + count + ", cost=" + cost + '}';
    }
}   
