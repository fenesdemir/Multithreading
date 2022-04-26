
# Problem definition
In this project, we are expected to simulate an elevator system in a shopping mall using threads.

**Purpose**

The aim of the project is to reduce the density of requests to elevators in a shopping mall, together with other elevators by using multithread.

# Requirements
**Mall Features**

- The number of floors in the shopping mall is 5.
- There are 5 elevators in total.
- One of the elevators is working continuously. The rest are active or passive, depending on the density.
- The maximum capacity of the elevators is 10.
- The transition between floors in elevators is 200 ms.

## Features of project components:

**AVM Login Thread**

It allows a random number of customers to enter the mall between [1-10] with 500 ms time intervals (Ground Floor). It takes the customers to the elevator queue to go to a random floor (1-4).

**AVM Exit Thread** 

It allows a random number of customers to exit the AVM between [1-5] with 1000 ms time intervals (Ground Floor). It takes customers who want to exit from a random floor (1-4) to the elevator queue to go to the ground floor.

**Elevator Thread**

It controls the queues on the floors. It ensures that customers in the queue can be transported to the floors they request, not exceeding the maximum capacity. This thread should be as many as the number of elevators (5).

**NOTE:Those who want to enter the other floors (the mall) from the ground floor or those who want to exit from the other floors (from the shopping mall) form a queue.**

**Control Thread** 

Controls the queues on the floors. In case the total number of people waiting in the queue exceeds 2 times the capacity of the elevator (20), it activates the new elevator. When the total number of people waiting in the queue goes below the elevator capacity, one of the elevators becomes passive. This operation is not valid when only one elevator is running.

# Ease of Use 

The user does not need to do anything after running the program. Just following the terminal for outputs would be enough.
