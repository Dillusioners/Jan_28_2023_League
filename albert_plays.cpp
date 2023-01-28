/*
	Name: LeeTuah
	Date: Jan 28 22:05 IST
	Purpose: Program 1 of League
	The program is as follows:-

	Albert chooses a positive integer k, then two real numbers a, b are randomly chosen in the interval [0,1] 
	with uniform distribution. The square root of the sum (k·a+1)^2+(k·b+1)^2 is then computed and rounded
	to the nearest integer. If the result is equal to k, he scores k points; otherwise he scores nothing. 
	For example, if k=6, a=0.2 and b=0.85, then (k·a+1)^2+(k·b+1)^2=42.05.
	The square root of 42.05 is 6.484... and when rounded to the nearest integer, it becomes 6.
	This is equal to k, so he scores 6 points. 
	It can be shown that if he plays 10 turns with k=1, k=2, ..., k=10, the expected value of his total score,
	rounded to five decimal places, is 10.20914.
	If he plays 10^5 turns with k=1, k=2, k=3, ..., k=10^5, what is the expected value of his total score,
	rounded to five decimal places?
*/

// (rand() % 100 + 1) / 100.0
// sqrt((k·a+1)^2+(k·b+1)^2)

# include <iostream>
# include <ctime>
# include <cmath>

int getTotalScore(int upper_limit){
	int k, total_points = 0, formula;
	float a, b;

	for(k = 1; k <= upper_limit; k++){
		a = (rand() % 100 + 1) / 100.0;
		b = (1 - a);

		formula = (int)(sqrt(pow((k * a + 1), 2) + pow((k * b + 1), 2)));
		if(k == formula){
			total_points += k;
		}
	}

	return total_points;
}

int main(int argc, char const *argv[]){
	srand(time(NULL));
	float approx_score = 0, total_itr = 100000.0;

	for(int itr = 0; itr != 100; itr++){
		approx_score += getTotalScore(total_itr);
	}

	std::cout << "After playing 10^5 times for 100 rounds, the approx score is " << approx_score / 100.0 << '\n';

	return 0;
}
