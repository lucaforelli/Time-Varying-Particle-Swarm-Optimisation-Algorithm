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

This algorithm is adjusted from the research paper from 
Hu et al. titled 'A Particle Swarm Optimization Algorithm with Time Varying Parameter'.

## References
Hu, Z., Zou, D., Kong, Z. and Shen, X., 2018, June. A particle swarm optimization algorithm 
with time varying parameters. In 2018 Chinese Control And Decision Conference (CCDC) (pp. 
4555-4561). IEEE.


