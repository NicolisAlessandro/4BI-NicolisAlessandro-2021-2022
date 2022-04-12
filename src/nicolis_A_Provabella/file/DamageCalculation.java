package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.Creature;

public interface DamageCalculation {
    int getDamage(Creature attacker, Creature defender);
}