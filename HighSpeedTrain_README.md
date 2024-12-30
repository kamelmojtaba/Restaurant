

# Project Title:
**Synchronization in Operating Systems - HighSpeedTrain**

---

## Course Details:
- **University**: University of Khartoum  
- **Faculty**: Faculty of Mathematical Sciences  
- **Department**: Computer Science  
- **Course**: Operating Systems  
- **Lab**: Synchronization in Operating Systems  
- **Due Date**: December 24, 2024  

---

## Team Members:
1. **وفاء عبد الباقي حمد النيل أحمد**  
   - Department: Statistics - Computer Science  
   - Student ID: 18-241  

2. **عصماء عبدالله عبداللطيف محمد**  
   - Department: Statistics - Computer Science  
   - Student ID: 18-228  

3. **مآب عباس الأمين أحمد**  
   - Department: Statistics - Computer Science  
   - Student ID: 17-228  

---

## Project Objectives:
1. Understand process/thread synchronization mechanisms.  
2. Explore primitive locks used in thread synchronization.  
3. Implement and demonstrate the use of condition variables and locks in real-world scenarios.

---

## Overview:
This project simulates the synchronization required for HighSpeedTrain's operations, where both trains and passengers (represented as threads) coordinate efficiently for orderly boarding. It ensures that:  
1. Trains load passengers until seats are full or no passengers remain.  
2. Passengers wait for available seats before boarding.  

---

## Program Specifications:
### Functions:
1. **station_init(struct station *station)**  
   Initializes the `station` structure.

2. **station_load_train(struct station *station, int count)**  
   Called when a train arrives, specifying the number of available seats. This function ensures passengers board until the train is full or no passengers remain.

3. **station_wait_for_train(struct station *station)**  
   Called by passengers upon arrival at the station. They wait until a seat is available.

4. **station_on_board(struct station *station)**  
   Called by passengers after they have taken a seat to signal successful boarding.

### Structure:
- **struct station**  
  Contains:
  - A lock for synchronization.
  - Condition variables for train arrival and boarding.
  - Variables for tracking waiting passengers, free seats, and boarded passengers.

---

## Key Features:
- **Single Lock Usage**: Ensures thread safety without excessive complexity.  
- **Condition Variables**: Prevents busy-waiting and facilitates orderly communication between threads.  
- **Multiple Passenger Boarding**: Allows multiple threads to proceed concurrently, ensuring efficient loading.  
- **Test Harness**: Includes a simulation of train and passenger threads with customizable configurations.  

---

## Compilation Instructions:
To compile and run the program:  
1. Use the following command:  
   ```bash
   gcc -o HighSpeedTrain HighSpeedTrain.c -pthread
   ```
2. Run the executable:  
   ```bash
   ./HighSpeedTrain
   ```

---

## Linux Environment Setup:
1. Ensure `gcc` and `pthread` library are installed.  
2. Use a Linux terminal for compilation and execution.

---

## Testing:
- The main program simulates:
  - 10 passenger threads arriving at intervals.
  - 2 train threads arriving with predefined seat counts.  
- Results demonstrate proper synchronization between trains and passengers.

### Screenshot:
![Screenshot of HighSpeedTrain Simulation Output](https://github.com/user-attachments/assets/d567ea5c-9fb6-4347-a623-9e63377180f2)

*Figure: HighSpeedTrain simulation output in the terminal.*

---

## Acknowledgments:
This project is developed as part of the Operating Systems coursework to demonstrate practical thread synchronization techniques using locks and condition variables.

--- 
