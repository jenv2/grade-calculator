import java.util.Scanner;
public class Grades {
	
	// Jennifer Vaughn
	// 9/13/22
	// Grade Calculator
	// This program will calculate a student's overall weighted course grade.
	
public static Scanner CONSOLE = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner CONSOLE = new Scanner(System.in);

		System.out.println("This program accepts your homework and exam scores "
				+ "as input and calculates your overall grade in the course.");
		
		
		
	
		// Homework weight
		System.out.println("Homework weight? ");
		int hwWeight = CONSOLE.nextInt();
		
		// Exam 1 weight
		System.out.println("Exam 1 weight? ");
		int exam1Weight = CONSOLE.nextInt();	
		
		//Exam 2 weight
		int exam2Weight = 100 - hwWeight - exam1Weight;
		System.out.println("Using weights of " + hwWeight + " " + exam1Weight + " " + exam2Weight);
		
		
		
		
		
		
		// Homework
		System.out.println();
		System.out.println("Homework:");
		
		// Number of assignments, homework grade, late days, labs
		System.out.println("Number of assignments? ");
		int numHW = CONSOLE.nextInt();
		
		System.out.println("Average homework grade? ");
		double hwGrade = CONSOLE.nextDouble();
		if(hwGrade < 0) {
			hwGrade = 0;
		}
		else if(hwGrade > 10) {
			hwGrade = 10;
		}
		
		System.out.println("Number of late days used? ");
		int lateDays = CONSOLE.nextInt();
		
		System.out.println("Labs attended? ");
		int labAttend = CONSOLE.nextInt();
		
		
		
		
		double totalPoints = homeworkCalc(numHW, hwGrade, lateDays, labAttend);
		
		double hwWeightedScore = 0;
		
		
		if(numHW <= 0)	{
			totalPoints = 100;
			System.out.println("Total points: " + totalPoints + " / " + totalPoints);
			hwWeightedScore = totalPoints / totalPoints * hwWeight;
		}
		else	{
			System.out.println("Total points: " + totalPoints + " / " + (numHW * 10 + numHW * 4));
			hwWeightedScore = totalPoints / (numHW * 10 + numHW * 4) * hwWeight;
		}
		
		System.out.println("Weighted Score: " + hwWeightedScore);
		
		
		
		
		
		
		// Exam 1
		System.out.println();
		System.out.println("Exam 1:");
		
		System.out.println("Score? ");
		double exam1Score = CONSOLE.nextDouble();
		
		exam1Score = examConditionB(exam1Score);
		
		
		System.out.println("Curve? ");
		int exam1Curve = CONSOLE.nextInt();
		exam1Score += exam1Curve;
		if(exam1Score > 100)	{
			exam1Score = 100;
		}
		
		System.out.println("Total points = " + exam1Score + " / 100");
		
		double exam1WeightedScore = exam1Score / 100.0 * exam1Weight;
		System.out.println("Weighted score = " + exam1WeightedScore);
		System.out.println();
		
		
		// Exam 2
		System.out.println("Exam 2:");
		
		System.out.println("Score? ");
		double exam2Score = CONSOLE.nextDouble();
		
		exam2Score = examConditionB(exam2Score);
		
		
		System.out.println("Curve? ");
		int exam2Curve = CONSOLE.nextInt();
		exam2Score += exam2Curve;
		if(exam2Score > 100)	{
			exam2Score = 100;
		}
		
		System.out.println("Total points = " + exam2Score + " / 100");
		
		double exam2WeightedScore = exam2Score / 100.0 * exam2Weight;
		System.out.println("Weighted score = " + exam2WeightedScore);
		
		
		// Final grade
		double finalGrade = hwWeightedScore + exam1WeightedScore + exam2WeightedScore;
		System.out.println();
		System.out.println("Course grade = " + finalGrade);
		
	}	
	
	
	
	
	public static double homeworkCalc(int numHW, double hwGrade, int lateDays, int labAttend)	{
		// Calculate the homework score
		double totalPoints = numHW * hwGrade;
		
		if(lateDays > (numHW) / 2.0)	{
				totalPoints = totalPoints - (0.10 * totalPoints);
		}
		else if(lateDays == 0)	{
			totalPoints = totalPoints + 5;
		}
		
		if(totalPoints > numHW * 10)	{
			totalPoints = numHW * 10;
		}
		totalPoints = totalPoints + (labAttend * 4);
		return totalPoints;
}
	
	
	public static double examConditionB(double examScore)	{
		if(examScore < 0) {
			examScore = 0;
		}
		else if(examScore > 100) {
			examScore = 100;
		}
		return examScore;
	}
}
	
	
	
