package model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Weapon> weapons;
    private ArrayList<Useable> items;
    private Player player;
    public Inventory(Weapon startingWeapon, Player player) {
        weapons = new ArrayList<>();
        items = new ArrayList<>();
        weapons.add(startingWeapon);
        items.add(new HealthPotion());
        this.player = player;
        System.out.print(items.size() + " soze");
    }

    public void addWeapon(Weapon w) {
        getWeapons().add(w);
    }

    public void addItem(Useable p) {
        getItems().add(p);
    }
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    public ArrayList<Useable> getItems() {
        return items;
    }
    public void removeItem(Useable item) {
        getItems().remove(item);
    }
    public Useable removeItem(int item) {
        return items.remove(item);
    }
    /**
     * @param weapons the weapons to set
     */
    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<Useable> items) {
        this.items = items;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

}
