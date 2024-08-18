# Benson Wollman Wesely Final Project
Zombie Survivor apocalypse

# Notes
- We made some decisions based on the hypothetical continuation of the project. One example is using a double for the attack and health. The thought behind this is that in a bigger "world" there could be more complicated battle scenarios where you'd need fractions.
- Random: since the requirements around generating random numbers were somewhat vague we had to make a few decisions.
  - When we generate characters we establish a hardcoded lower bound of 1, and an upper bound defined as upperBound. We defaulted the upper bound to 4 so as it sits now our program will generate 1-4 of each character subclass.
  - We originally had 4 hardcoded as well but decided to use a variable for ease of change. This can be replicated with lower bound but decided against it.
- Iterator:
  - We observed undesired behavior in our main battle logic when the loops were executing. The bug was identified as using .remove() on an array list. When that is called it removes the current (or front) element, and shifts left. We suspected that this was causing the loop to skip over characters. Our solution was to implement an iterator that has backend functionality to handle this.
