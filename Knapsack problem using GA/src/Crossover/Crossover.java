package Crossover;

import java.util.*;
import Chromosomes.Chromosome;
import Selection.Selection;

public class Crossover {

	private double Pc = 0.8;
	private Chromosome chromosome;
	private Selection selection;

	public Crossover(Chromosome chromosome) {
		this.chromosome = chromosome;
		this.selection = new Selection(chromosome);
	}

	public void crossOver() {
		Random rand = new Random();
		double randomNum = rand.nextDouble();

		int crossOverPoint = rand.nextInt(1, chromosome.getNumberOfItems());

		if (randomNum <= Pc) {
			String parent1 = chromosome.getPopulation().get(selection.rankSelection());
			String parent2 = chromosome.getPopulation().get(selection.rankSelection());
			chromosome.setSelectedParents(parent1);
			chromosome.setSelectedParents(parent2);
			String child1 = parent1.substring(0, crossOverPoint) + parent2.substring(crossOverPoint);
			String child2 = parent2.substring(0, crossOverPoint) + parent1.substring(crossOverPoint);
			chromosome.setChildren(child1);
			chromosome.setChildren(child2);
			chromosome.setCrossoverFlag(true);
			chromosome.printSelectedParents();

		} else {
			System.out.println("No crossover.");
		}

	}
}
