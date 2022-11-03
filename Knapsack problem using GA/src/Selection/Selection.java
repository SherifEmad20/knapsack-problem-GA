package Selection;

import java.text.DecimalFormat;
import java.util.*;
import Chromosomes.Chromosome;

public class Selection {
	private Chromosome chromosome = new Chromosome();
	DecimalFormat decimalFormat = new DecimalFormat("#.##");

	public Selection(Chromosome chromosome) {
		this.chromosome = chromosome;
		sortFitnesses();
	}

	// sort fitnesses from smaller to bigger and sort population based on the
	// changes in the fitness
	public void sortFitnesses() {
		// loop to rotate around array elements
		for (int j = 0; j < this.chromosome.getFitnesses().size(); j++) {
			// Loop to check if their is an element smaller than the other to sort them
			for (int k = 0; k < this.chromosome.getFitnesses().size() - 1; k++) {

				// if it found an smaller element swap the two with each other
				if (this.chromosome.getFitnesses().get(k) > this.chromosome.getFitnesses().get(j)) {
					Collections.swap(this.chromosome.getFitnesses(), j, k);
					Collections.swap(this.chromosome.getPopulation(), j, k);
				}
			}
		}
	}

	// calculate total rank
	public double totalRank() {
		double totalRank = 0;
		for (int i = 1; i <= this.chromosome.getPopulation().size(); i++) {
			totalRank = totalRank + i;
		}
		return totalRank;
	}

	// assign rate to each individual in the population
	public void RatesCalculator() {

		double rate = 0;
		double totalRank = totalRank();
//		System.out.println("Total rank: " + totalRank);

		for (int i = 1; i <= this.chromosome.getPopulation().size(); i++) {

			rate = i / totalRank;
			this.chromosome.getRateOfSelection().add(i - 1, rate);
		}

	}

	public void RatesRange() {
		double total = this.chromosome.getRateOfSelection().get(0);
		this.chromosome.getRateRanges().add(0, total);

		for (int i = 1; i < this.chromosome.getPopulation().size(); i++) {
			total = total + this.chromosome.getRateOfSelection().get(i);

			double num = Double.valueOf(decimalFormat.format(total));

			this.chromosome.getRateRanges().add(i, num);

		}
	}

	public int rankSelection() {

		totalRank();
		RatesCalculator();
		RatesRange();

		int Selected = 0;
		Random rand = new Random();
		double ball = rand.nextDouble(0.1, 1.1);
		ball = Double.valueOf(decimalFormat.format(ball));

		for (int i = 0; i < this.chromosome.getPopulationSize(); i++) {

			if (ball <= this.chromosome.getRateRanges().get(i)) {
				Selected = i;
//				System.out.println("Random number is: " + ball);
				break;

			}
		}
		return Selected;
	}
}
