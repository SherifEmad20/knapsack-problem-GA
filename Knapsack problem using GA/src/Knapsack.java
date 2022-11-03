import java.util.*;

import Chromosomes.Chromosome;
import Evaluation.Evaluation;
import Selection.Selection;
import Crossover.Crossover;
import Mutation.Mutation;
import Replacement.Replacement;

public class Knapsack {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Chromosome chromosome = new Chromosome();
		Evaluation evaluation = new Evaluation(chromosome);
		Crossover crossover = new Crossover(chromosome);
		Mutation mutation = new Mutation(chromosome);
		Replacement replacement = new Replacement(chromosome);

		int knapsackCapacity = 0;
		int numberOfItems = 0;
		int population = 4;
		double itemValue = 0;
		double itemWeight = 0;

		int testCases = 0;
		System.out.print("Enter number of test cases: ");
		testCases = scanner.nextInt();
		while (testCases != 0) {
			int testCaseIncremental = 0;
			System.out.print("Enter capacity of knapsack: ");
			knapsackCapacity = scanner.nextInt();

			System.out.print("Enter number of items: ");
			numberOfItems = scanner.nextInt();

			chromosome.setNumberOfItems(numberOfItems);
			chromosome.setPopulationSize(population);
			chromosome.makePopulation();
			// chromosome.showPopulation();

			System.out.println("------------------------");

			chromosome.setKnapsackCapacity(knapsackCapacity);

			System.out.println("Enter Values and Weights: ");

			for (int i = 0; i < chromosome.getNumberOfItems(); i++) {
				itemValue = scanner.nextDouble();
				itemWeight = scanner.nextDouble();

				chromosome.setValueOfItems(itemValue);
				chromosome.setWeightOfItems(itemWeight);
			}

			System.out.println("Test case number: " + (testCaseIncremental + 1));

			evaluation.evaluatePopulation(true);
			chromosome.printData();
			System.out.println("------------------------");

			crossover.crossOver();
			System.out.println("------------------------");

			chromosome.printChlidren();
			System.out.println("------------------------");

			mutation.mutatedChildren();

			System.out.println("------------------------");
			replacement.getGeneration();
			evaluation.evaluatePopulation(false);
			chromosome.printData();

			System.out.println("------------------------");

			testCases--;
			testCaseIncremental++;
			chromosome.getFitnesses().clear();
			chromosome.getValueOfItems().clear();
			chromosome.getWeightOfItems().clear();
			chromosome.getTotalWeightOfItems().clear();
			chromosome.getPopulation().clear();
			chromosome.getRateOfSelection().clear();
			chromosome.getRateRanges().clear();
			chromosome.getRanks().clear();
			chromosome.getMutatedChromosomes().clear();
			chromosome.getSelectedParents().clear();
			chromosome.getChildren().clear();
			// chromosome.getGeneratation().clear();
		}
	}

}
