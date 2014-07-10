/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

import world.WorldObject;

/**
 *
 * @author cortell
 */
public class Actor extends WorldObject {

    //actor name is a name that the actor will have
    String Actor_Name;
    //level determines how much experience an Actor has earned
    int Level;
    //health determines how much damage an actor can take
    int Health;
    //agility determines how agile an actor is
    int Agility;
    //strength determines how much damage an actor can deal
    int Strength;
    //willpower determines how much supernatural ability a player can utilize
    int Willpower;

    public String getActor_Name() {
        return Actor_Name;
    }

    public void setActor_Name(String Actor_Name) {
        this.Actor_Name = Actor_Name;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int Agility) {
        this.Agility = Agility;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int Strength) {
        this.Strength = Strength;
    }

    public int getWillpower() {
        return Willpower;
    }

    public void setWillpower(int Willpower) {
        this.Willpower = Willpower;
    }

}
