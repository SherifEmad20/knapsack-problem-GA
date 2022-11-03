package Evaluation;

import Chromosomes.Chromosome;

public class Evaluation {

	private Chromosome chromosome = new Chromosome();

	public Evaluation(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	// calculate the fitness value for each chromosome
	public double evaluateChromosome(String chromosome) {
		double totalWeight = 0;
		double totalValue = 0;
		double fitnessValue = 0;
		double difference = 0;

		// initialize gene
		char gene = '0';
		for (int i = 0; i < this.chromosome.getNumberOfItems(); i++) {

			// get genes of the chromosome
			gene = chromosome.charAt(i);

			// if gene = 1 therefore calculate total value and weight
			// example: chromosome 110
			// gene value weight
			// c1 4 4
			// c2 6 6
			// c3 5 3
			// total value = 4 + 6 = 10
			// total weight = 4 + 6 = 10
			if (gene == '1') {
				totalValue = totalValue + this.chromosome.getValueOfItems().get(i);
				totalWeight = totalWeight + this.chromosome.getWeightOfItems().get(i);
			}

		}

		difference = this.chromosome.getKnapsackCapacity() - totalWeight;
		if (difference >= 0) {
			fitnessValue = totalValue;
		}
		this.chromosome.setTotalWeightOfItems(totalWeight);
		// this.chromosome.setWeightOfItems(totalWeight);

		return fitnessValue;
	}

	// evaluate the fitness of the whole population and adds the fitness to the
	// list for selection
	public void evaluatePopulation(boolean first) {
		for (int i = 0; i < this.chromosome.getPopulationSize(); i++) {
			double tempFitness = evaluateChromosome(this.chromosome.getPopulation().get(i));
			if (first)
				this.chromosome.getFitnesses().add(tempFitness);
			else
				this.chromosome.getFitnesses().set(i, tempFitness);

		}

	}
}
