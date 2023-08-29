import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class Simulation {

    public static void main(String[] args) throws IOException{
    	// create demand prediction price problem
        DemandPrediction problem = new DemandPrediction("train");
        // set search space bounds
        double[][] problemBounds = DemandPrediction.bounds();
		 
		/* 
        // parameters for basic PSO
		double swarmSize = 50;
		double inertia = 1 / (2 * (Math.log(2)));
		double cognitiveCoefficient = 0.5 + Math.log(2);
		double socialCoefficient = 0.5 + Math.log(2);
		int psoTerminationCondition = 2000;
		*/
		
		double NI = 0.9;
		// parameters for novel PSOd
		for (double ni = 0.4; ni < NI; ni++) {
			double PI = 3.14159265358979323846264338327950288419716939937510;
			double swarmSize = 50;
			double inertia = 0.65 + 0.25 * Math.cos(PI * (ni / NI));
			double cognitiveCoefficient = 2.5 - (2 * ni) / NI;
			double socialCoefficient = 0.5 + (2 * ni) / NI;
			int psoTerminationCondition = 2000;
		

        // begin PSO
		for (int i = 0; i < 100; i++) {
			ParticleSwarmOptimisation pso = new ParticleSwarmOptimisation(problem, swarmSize, inertia, cognitiveCoefficient, socialCoefficient, problemBounds, psoTerminationCondition);
			pso.runParticleSwarmOptimisation();
         }
	  }
    }
    
}
