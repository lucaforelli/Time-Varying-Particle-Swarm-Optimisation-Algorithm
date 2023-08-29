# Introduction
This experimental study focuses on implementing a novel computational intelligence solution to
predict the daily demand of a logistic company using an artificial neural network model. A 
baseline solution will also be implemented to be compared against the novel solution in order to
identify, with justification, the winning solution. The baseline solution implements a basic
Particle Swarm Optimisation (PSO) algorithm and the novel solution implements a PSO with 
time varying parameters.

## Proposed Computional Intelligence Solution
The baseline solution implements a basic Particle Swarm Optimisation algorithm, which consist 
of a set of particles in a swarm moving within the search space, each representing a potential 
solution. The parameters that control the behaviour of this algorithm, such as the velocity weight 
and the acceleration constants, are fixed for the duration of the search for this algorithm.
The proposed novel solution implements a Time Varying Particle Swarm Optimisation (TVPSO) 
algorithm, that uses a dynamic trigonometric function to adjust the inertia weight over time. 
Additionally, the learning factors, cognitive coefficient and social coefficient are also 
dynamically adjusted. In the initial stage of the search, the inertia weight is set to a large value 
and decreases gradually and reaches a small value at the end. 

This algorithm is adjusted from the research from 
Hu et al. titled 'A Particle Swarm Optimization Algorithm with Time Varying Parameter'.

## Results
Implementing Welch’s t-test, the p-value results in 0.00671687145671919000, which is less than 
α (0.05), meaning that there is enough evidence to reject the null hypothesis and to accept the 
alternate hypothesis. 
The baseline algorithm has a higher chance of producing values that are suboptimal, 
whereas the novel algorithm on average produces values that has less major 
fluctuations. By adjusting the velocity dynamically, it allows the algorithm to adapt to changing 
characteristics of the search space and adjust the parameters of the algorithm to better suit the 
changes. However the limitations of TVPSO is that the convergence is slow in the beginning of 
the test. Because the inertia weight is updated each iteration, it can be difficult to predict the 
movement of the swarm, making it challenging to tune the parameters of the algorithm to 
achieve the desired performance (Hu et al., 2018).
In conclusion, the winning solution is the novel algorithm, as the results from the testing data in 
comparing the two algorithms lead to sufficient evidence in finding parameters to minimise the 
MSE for predicting demand for the logistics operation.

## References
Hu, Z., Zou, D., Kong, Z. and Shen, X., 2018, June. A particle swarm optimization algorithm 
with time varying parameters. In 2018 Chinese Control And Decision Conference (CCDC) (pp. 
4555-4561). IEEE.


