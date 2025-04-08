package Entity;

public class Enemies extends Entity {

    //constructors
    public Enemies() {;}
    public Enemies(int hp, int attack, int vitesse){
        this.hp = hp;
        this.attack = attack;
        this.vitesse = vitesse;
    }
    public Enemies(Enemies enemy){
        this(enemy.hp, enemy.attack, enemy.vitesse);
    }

    //methods
    //TODO: shooting function
}
