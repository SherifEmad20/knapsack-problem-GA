package Mutation;

import Chromosomes.Chromosome;

import java.text.DecimalFormat;
import java.util.*;

public class Mutation {

	private Chromosome chromosome = new Chromosome();
	private Random rand = new Random();
	DecimalFormat decimalFormat = new DecimalFormat("#.###");
	private double Pm = 0.012;

	public Mutation(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	public String mutateChromosome(String chromosome) {
		StringBuilder mutatedChromosome = new StringBuilder(chromosome);

		for (int i = 0; i < this.chromosome.getChildren().size() + 1; i++) {
			double randomNumber = this.rand.nextDouble(0.001, 0.1);
			randomNumber = Double.valueOf(decimalFormat.format(randomNumber));

			if (randomNumber <= Pm) {
				if (mutatedChromosome.charAt(i) == '1') {
					mutatedChromosome.setCharAt(i, '0');
				} else if (mutatedChromosome.charAt(i) == '0') {
					mutatedChromosome.setCharAt(i, '1');
				}
				this.chromosome.setMutationFlag(true);

			}
		}

		if (mutatedChromosome.toString().equals(chromosome))
			return null;
		else
			return mutatedChromosome.toString();

	}

	public void mutatedChildren() {
		double randomNumber = this.rand.nextDouble(0.001, 0.1); // compared with Pm (probability of mutation)
		randomNumber = Double.valueOf(decimalFormat.format(randomNumber));
		for (int i = 0; i < this.chromosome.getChildren().size(); i++) {
			this.chromosome.setMutatedChromosomes(mutateChromosome(this.chromosome.getChildren().get(i)));
		}
		this.chromosome.printMutatedChromosomes();

	}

}
