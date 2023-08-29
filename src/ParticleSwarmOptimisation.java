import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ParticleSwarmOptimisation {
	private DemandPrediction problem;
	private double swarmSize;
	private double cognitiveCoefficient;
    private double inertia;
	private double[][] problemBounds;
    private double socialCoefficient;
	private int terminationCondition;
	
	public ParticleSwarmOptimisation(DemandPrediction problem, double swarmSize, double inertia, double cognitiveCoefficient, double socialCoefficient, double[][] problemBounds, int terminationCondition) {
		this.problem = problem;
		this.swarmSize = swarmSize;
		this.inertia = inertia;
		this.cognitiveCoefficient = cognitiveCoefficient;
		this.socialCoefficient = socialCoefficient;
		this.problemBounds = problemBounds;
		this.terminationCondition = terminationCondition;
	}
	
	public void runParticleSwarmOptimisation() throws IOException {
        Random random = new Random();
		double[] globalBest = new double[problemBounds.length];
		double globalBestCost = 0;
		int count = 0;
		ArrayList<Particle> population = new ArrayList<Particle>();
		
		// Population init
		for (int i = 0; i < swarmSize; i++) {
			double[] initialPosition = generateRandomParameters(problemBounds, random);
			double[] secondPosition = generateRandomParameters(problemBounds, random);
			Particle p = new Particle(initialPosition, secondPosition, 0);
			population.add(p);
		}
		
		
		// terminate once best evaluation met 
		while (count < terminationCondition) {
			//System.out.println(" ");
			
			// global best update 
			for(Particle p: population) {
				double[] particleBestPosition = p.getBestPosition();
				double particleBestCost = problem.evaluate(particleBestPosition);
				
				if (globalBestCost == 0) {
					globalBestCost = particleBestCost;
					
					for (int i = 0; i < p.getBestPosition().length; i++) {
						globalBest[i] = particleBestPosition[i];
					}	
				} else if (globalBestCost > particleBestCost) {
					globalBestCost = particleBestCost;
					
					for (int i = 0; i < p.getBestPosition().length; i++) {
						globalBest[i] = particleBestPosition[i];
					}
				}
			}
			
            // loop for each particle in the population
			for (Particle p: population) {
				
				// update velocity
				p.updateVelocity(inertia, cognitiveCoefficient, socialCoefficient, globalBest);
				
				// update position
				p.updatePosition();
				
				// update personal best
				p.updateBestPosition(problem);
			}
			
			count++;
		}
		
		// check MSE of best parameters on test problem
        DemandPrediction validationProblem  = new DemandPrediction("test");
        double validationError = validationProblem.evaluate(globalBest);
		System.out.println(validationError);
		//System.out.println("global best cost" + globalBestCost);
        //System.out.println("Validation error of best solution found during training: " + validationError);
		//System.out.println("Best solution found during training of validation error: " + validationError);
		//System.out.println('\n');
	}
	
    public static double[] generateRandomParameters(double[][] problemBounds, Random random){
        double[] randomParameters = new double[problemBounds.length];
        for (int i = 0; i < problemBounds.length; i++) {
            randomParameters[i] = problemBounds[i][0] + random.nextDouble() * (problemBounds[i][1] - problemBounds[i][0]);
        }
        return randomParameters;
    }
}
