package nicolis_A_Provabella.file;


import java.util.Random;

import main.game.maze.interactable.creature.Creature;
import main.game.maze.interactable.item.armour.armourType.ArmourType;
import main.game.maze.interactable.item.weapon.weaponType.WeaponType;

public class SimpleDamageCalculation implements DamageCalculation {

    public int getDamage(Creature attacker, Creature defender){
        double modifier = compareTypes(attacker.getWeapon().getWeaponType(), defender.getArmour().getArmourType());
        double attackPoints = attacker.getWeapon().getWeaponType().getAttackPoints(attacker);
        double defendPoints = defender.getArmour().getArmourType().getDefendpoints(defender);
        double damage = attacker.getWeapon().getDamage() * modifier;
        double hitChance = Math.min((attackPoints/defendPoints*modifier), 1);
        Random rnd = new Random();
        damage = (damage * rnd.nextDouble() + damage)/2;
        //if (attacker instanceof Player){
        System.out.printf("AP: %d DP: %d%n",(int) attackPoints,(int) defendPoints);
        System.out.println("damage " + (int) damage + " with chance of " + (int) (hitChance*100) + "%");
        //}
        if (rnd.nextDouble() > (1 - hitChance)){
            return (int) damage;
        }
        return 0;
    }

    private double compareTypes(WeaponType weaponType, ArmourType armourType) {
        return armourType.getModifier(weaponType);
    }
}
