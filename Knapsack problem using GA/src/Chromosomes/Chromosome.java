package Chromosomes;

import java.util.*;

public class Chromosome {
	private int numberOfItems = 3;
	private int populationSize = 4;
	private int knapsackCapacity = 10;
	private boolean crossoverFlag = false;
	private boolean mutationFlag = false;

	// Array that hold the Fitness value for each chromosome
	private ArrayList<Double> fitnesses = new ArrayList<Double>();

	// Array that hold the value for each chromosome
	private ArrayList<Double> valueOfItems = new ArrayList<Double>();

	// Array that hold the Weight Value for each chromosome
	private ArrayList<Double> weightOfItems = new ArrayList<Double>();

	// Array that hold the total weight Values for each chromosome
	private ArrayList<Double> totalWeightOfItems = new ArrayList<Double>();

	// Array that holds all the population
	private ArrayList<String> population = new ArrayList<String>();

	// Array that holds all the rate of each individual to be selected
	private ArrayList<Double> rateOfSelection = new ArrayList<Double>();

	// Array that holds the rate ranges
	private ArrayList<Double> rateRanges = new ArrayList<Double>();

	// Array that holds the rank of each chromosome
	private ArrayList<Double> ranks = new ArrayList<Double>();

	// Array that holds the mutated chromosomes of each chromosome
	private ArrayList<String> mutatedChromosomes = new ArrayList<String>();

	// arraylist that holds the selected parents for crossover
	private ArrayList<String> selectedParents = new ArrayList<String>();

	// arraylist that holds the selected parents for crossover
	private ArrayList<String> children = new ArrayList<String>();

	// arraylist that holds the selected parents for crossover
	private ArrayList<String> generatation = new ArrayList<String>();

	// generate random chromosome
	public String makeChromosome() {
		// used to build the chromosome gene by gene
		StringBuilder chromosome = new StringBuilder(numberOfItems);

		// the bits of the chromosome string
		char gene;

		for (int i = 0; i < numberOfItems; i++) {
			gene = '0';
			double random = Math.random();

			if (random > 0.5) {
				gene = '1';
			}

			// append genes with each others to create the chromosome
			chromosome.append(gene);
		}
		return chromosome.toString();
	}

	// create a population of chromosomes
	public void makePopulation() {
		for (int i = 0; i < populationSize; i++) {
			population.add(makeChromosome());
		}
	}

	// print population of chomosome
	public void printPopulation() {
		System.out.println("-------Population:-------");
		for (int i = 0; i < populationSize; i++) {
			System.out.println("C" + (i + 1) + " value: ");
			System.out.println(population.get(i));
		}
	}

	public void printFitness() {
		System.out.println("-------Fitness:-------");
		for (int i = 0; i < population.size(); i++) {
			System.out.print(population.get(i));
			System.out.print("		");
			System.out.println(fitnesses.get(i));
		}
	}

	public void printWeight() {
		System.out.println("-------Weight:-------");
		for (int i = 0; i < population.size(); i++) {
			System.out.print(population.get(i));
			System.out.print("		");
			System.out.println(totalWeightOfItems.get(i));
		}
	}

	public void printMutatedChromosomes() {
		System.out.println("-------Mutated chromosomes:-------");
		for (int i = 0; i < mutatedChromosomes.size(); i++) {
			System.out.println(mutatedChromosomes.get(i));
		}
	}

	public void printRates() {
		System.out.println("-------Rates:-------");
		for (int i = 0; i < rateOfSelection.size(); i++) {
			System.out.print(population.get(i));
			System.out.print("		");
			System.out.println(rateOfSelection.get(i));
		}
	}

	public void printRateRanges() {
		System.out.println("-------Rate ranges:-------");
		for (int i = 0; i < rateRanges.size(); i++) {
			System.out.print(population.get(i));
			System.out.print("		");
			System.out.println(rateRanges.get(i));
		}
	}

	public void printSelectedParents() {
		System.out.println("-------Selected parents:-------");
		for (int i = 0; i < selectedParents.size(); i++) {
			System.out.println(selectedParents.get(i));
		}
	}

	public void printChlidren() {
		System.out.println("------Chlidren:-------");
		for (int i = 0; i < children.size(); i++) {
			System.out.println(children.get(i));
		}
	}

	public void printGeneration() {
		System.out.println("------Generations:-------");
		for (int i = 0; i < generatation.size(); i++) {
			System.out.println(generatation.get(i));
		}
	}

	public void printData() {
		System.out.println("Chromosome                    Fitness        	      Weight:");
		for (int i = 0; i < population.size(); i++) {
			System.out.print("C" + (i + 1) + "	" + population.get(i) + "          ");
			System.out.print("          " + fitnesses.get(i) + "          ");
			System.out.print("          " + totalWeightOfItems.get(i) + "          ");
			System.out.println();
		}

	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public ArrayList<String> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<String> population) {
		this.population = population;
	}

	public void setPopulation(int i, String population) {
		this.population.add(i, population);
	}

	public ArrayList<Double> getFitnesses() {
		return fitnesses;
	}

	public void setFitnesses(Double fitnesses) {
		this.fitnesses.add(fitnesses);
	}

	public ArrayList<Double> getValueOfItems() {
		return valueOfItems;
	}

	public void setValueOfItems(double valueOfItems) {
		this.valueOfItems.add(valueOfItems);
	}

	public ArrayList<Double> getWeightOfItems() {
		return weightOfItems;
	}

	public void setWeightOfItems(double weightOfItems) {
		this.weightOfItems.add(weightOfItems);
	}

	public ArrayList<Double> getTotalWeightOfItems() {
		return totalWeightOfItems;
	}

	public void setTotalWeightOfItems(double totalWeightOfItems) {
		this.totalWeightOfItems.add(totalWeightOfItems);
	}

	public ArrayList<Double> getRanks() {
		return ranks;
	}

	public void setRanks(double ranks) {
		this.ranks.add(ranks);
	}

	public ArrayList<String> getMutatedChromosomes() {
		return mutatedChromosomes;
	}

	public void setMutatedChromosomes(String mutatedChromosomes) {
		this.mutatedChromosomes.add(mutatedChromosomes);
	}

	public ArrayList<Double> getRateOfSelection() {
		return rateOfSelection;
	}

	public void setRateOfSelection(Double rateOfSelection) {
		this.rateOfSelection.add(rateOfSelection);
	}

	public ArrayList<Double> getRateRanges() {
		return rateRanges;
	}

	public void setRateRanges(Double rateRanges) {
		this.rateRanges.add(rateRanges);
	}

	public ArrayList<String> getSelectedParents() {
		return selectedParents;
	}

	public void setSelectedParents(String selectedParents) {
		this.selectedParents.add(selectedParents);
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children.add(children);
	}

	public int getKnapsackCapacity() {
		return knapsackCapacity;
	}

	public void setKnapsackCapacity(int knapsackCapacity) {
		this.knapsackCapacity = knapsackCapacity;
	}

	public ArrayList<String> getGeneratation() {
		return generatation;
	}

	public void setGeneratation(String generatation) {
		this.generatation.add(generatation);
	}

	public boolean getCrossoverFlag() {
		return crossoverFlag;
	}

	public void setCrossoverFlag(boolean crossoverFlag) {
		this.crossoverFlag = crossoverFlag;
	}

	public boolean getMutationFlag() {
		return mutationFlag;
	}

	public void setMutationFlag(boolean mutationFlag) {
		this.mutationFlag = mutationFlag;
	}
}
