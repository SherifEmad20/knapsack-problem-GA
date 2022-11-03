package Replacement;

import Chromosomes.Chromosome;
import Selection.Selection;

public class Replacement {

	Chromosome chromosome = new Chromosome();

	public Replacement(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	public void getGeneration() {
		Selection sel = new Selection(chromosome);
		sel.sortFitnesses();
		if (this.chromosome.getCrossoverFlag() == true && this.chromosome.getMutationFlag() == false) {
			for (int i = 0; i < 2; i++) {
				if (chromosome.getChildren().get(i) != null) {
					chromosome.getPopulation().set(i, chromosome.getChildren().get(i));
				}
			}
			for (int i = 0; i < this.chromosome.getPopulation().size(); i++) {
				this.chromosome.setGeneratation(this.chromosome.getPopulation().get(i));
			}

		} else if (this.chromosome.getMutationFlag() == true) {
			for (int i = 0; i < 2; i++) {
				if (chromosome.getMutatedChromosomes().get(i) != null) {
					chromosome.getPopulation().set(i, chromosome.getChildren().get(i));
				}
			}
			for (int i = 0; i < this.chromosome.getPopulation().size(); i++) {
				this.chromosome.setGeneratation(this.chromosome.getPopulation().get(i));
			}
		}

	}

}
