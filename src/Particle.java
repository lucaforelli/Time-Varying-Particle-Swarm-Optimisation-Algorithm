import java.util.Random;

public class Particle {
	private double[] bestPosition; // cost of function 
    private double[] position; // solution of candidate 
	private int bestPositionCost; // best cost of current position
    private double[] velocity; // traversal strategy for search space
	
	
	public Particle(double[] pos, double[] secondSolution, int bestCost) {
		position = pos;
		
		double[] initialVelocity = new double[position.length];
		for (int i = 0; i < position.length; i++) {
			initialVelocity[i] = (secondSolution[i] - position[i]) / 2;
		}
		velocity = initialVelocity;
		
		bestPosition = pos;
		bestPositionCost = bestCost;
	}

    public int getBestPositionCost() {
		return bestPositionCost;
	}
	
	public double[] getPosition() {
		return position;
	}
	
    public double[] getVelocity() {
		return velocity;
	}

    public double[] getBestPosition() {
		return bestPosition;
	}
	
	public void updatePosition() {
		double[] newPosition = new double[position.length];
		for (int i = 0; i < position.length; i++) {
			newPosition[i] = position[i] + velocity[i];
		}
		
		position = newPosition;

	}
	
	public void updateVelocity(double inertia, double cognitive, double social, double[] globalBest) {
		double currentVelocity[] = new double[position.length];
		double bestPersonalCurrentPos[] = new double[position.length];
		double bestGlobalCurrentPos[] = new double[position.length];
        double currentPosition[] = new double[position.length];
		double randomVectorA[] = new double[position.length];
		double randomVectorB[] = new double[position.length];
		Random random = new Random();


		// Temporary varialbes filled
		for (int i = 0; i < velocity.length; i++) {
			currentVelocity[i] = velocity[i];
			currentPosition[i] = position[i];
			bestPersonalCurrentPos[i] = bestPosition[i];
			bestGlobalCurrentPos[i] = globalBest[i];
			randomVectorA[i] = random.nextDouble();
			randomVectorB[i] = random.nextDouble();
		}
		
		 // Inertia * Current Velocity
         for (int i = 0; i < currentVelocity.length; i++) {
			currentVelocity[i] = currentVelocity[i] * inertia;
		}

        // Cognitive * Random Vector A
		for (int i = 0; i < currentVelocity.length; i++) {
			randomVectorA[i] = randomVectorA[i] * cognitive;
		}

        // Personal Best - Position
		for (int i = 0; i < currentVelocity.length; i++) {
			bestPersonalCurrentPos[i] = bestPersonalCurrentPos[i] - currentPosition[i];
		}
		
		// (Cognitive * Random Vector A) * (Pers Best - Position)
		for (int i = 0; i < currentVelocity.length; i++) {
			randomVectorA[i] = randomVectorA[i] * bestPersonalCurrentPos[i];
		}
        
		// Social * Random Vector B
		for (int i = 0; i < currentVelocity.length; i++) {
			randomVectorB[i] = randomVectorB[i] * social;
		}
		
		// Global Best - Position
		for (int i = 0; i < currentVelocity.length; i++) {
			bestGlobalCurrentPos[i] = bestGlobalCurrentPos[i] - currentPosition[i];
		}
		
		// (Social * Random Vector B) * (Global Best - Position)
		for (int i = 0; i < currentVelocity.length; i++) {
			randomVectorB[i] = randomVectorB[i] * bestGlobalCurrentPos[i];
		}
		
		/* (Inertia - Current Veloity) + ((Cognitive * Random Vector A) x Personal Best - Position) + 
        ((Social * Random Vector B) x (Global Best - Position))*/
		for (int i = 0; i < currentVelocity.length; i++) {
			currentVelocity[i] = currentVelocity[i] + randomVectorA[i] + randomVectorB[i];
		}
		
		// update velocity
		for (int i = 0; i < currentVelocity.length; i++) {
			velocity[i] = currentVelocity[i];
		}
		
	}
	
	public void updateBestPosition(DemandPrediction problem) {
		if (problem.is_valid(position) == true) {
			if (problem.evaluate(position) < problem.evaluate(bestPosition)) {
				bestPosition = position;
			}
		}
	}	
}