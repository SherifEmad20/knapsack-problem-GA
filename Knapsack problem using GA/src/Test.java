import java.util.*;

import Chromosomes.Chromosome;
import Mutation.Mutation;
import Selection.Selection;
import Evaluation.Evaluation;
import Crossover.Crossover;
import Replacement.Replacement;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// --------------------------------------------------------------------------//

		// --------------------------------------------------------------------------//

		// --------------------------------------------------------------------------//
		Chromosome chromosome = new Chromosome();
		chromosome.setNumberOfItems(3);
		chromosome.setPopulationSize(4);
		chromosome.setKnapsackCapacity(10);
		chromosome.makePopulation();
		chromosome.printPopulation();

		Evaluation evaluation = new Evaluation(chromosome);

		System.out.println("Enter Values and Weights: ");

		for (int i = 0; i < chromosome.getNumberOfItems(); i++) {
			double itemValue = scanner.nextDouble();
			double itemWeight = scanner.nextDouble();

			chromosome.setValueOfItems(itemValue);
			chromosome.setWeightOfItems(itemWeight);
		}

		evaluation.evaluatePopulation(true);
		chromosome.printData();
		System.out.println("------------------------");

		Crossover crossover = new Crossover(chromosome);
		crossover.crossOver();
		System.out.println("------------------------");

		chromosome.printChlidren();
		System.out.println("------------------------");

		Mutation mutation = new Mutation(chromosome);
		mutation.mutatedChildren();

		System.out.println("------------------------");
		Replacement r = new Replacement(chromosome);
		r.getGeneration();
		evaluation.evaluatePopulation(false);
		chromosome.printData();
		// --------------------------------------------------------------------------//

	}

}
