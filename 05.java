class Student{
	private String name; //10
	private int exam1;
	private int exam2;
	private int exam3;
	double avarage;
	
	boolean validateMarks(int marks)/*throws Exception*/{
		if(marks>=0 && marks<=100){
			return true;
		}
		else{
			return false;
			//throw new Exception ("Exception!");
		}
	}
	
	
	Student(String n,int e1,int e2,int e3)throws Exception{
		
		name=n;
		
		if(validateMarks(e1) && validateMarks(e2) && validateMarks(e3) ){
			exam1=e1;
			exam2=e2;
		    exam3=e3;
		}
		else{
		System.out.println("Set the marks value to 0");
		throw new Exception ("Invalid Marks");
	}
}
	
		
	
	 String getName(){
		 return name;
	 }
	 int getExam1(){
		 return exam1;
	 }
	 
	 int getExam2(){
		 return exam2;
	 }
	 
	 int getExam3(){
		 return exam3;
	 }
	 
	 double calculateAverage(){
		 avarage=(exam1+exam2+exam3)/3.00;
		 return avarage;
	 }
	 
	
	 
}
class Demo{
	public static void main(String[] args){
		//Student s1,s2;
		try{
		
		Student s2=new Student("Eve",99,88,75);
		System.out.println("Name of student s1 is "+s2.getName());
		System.out.println("Marks of student s1 is "+s2.getExam1());
		System.out.println("Marks of student s1 is "+s2.getExam2());
		System.out.println("Marks of student s1 is "+s2.getExam3());
		System.out.println("Avarage of student s1 is "+s2.calculateAverage());
		
		System.out.println();
		
		Student s1=new Student("Adam",99,102,-55);
		System.out.println("Name of student s1 is "+s1.getName());
		System.out.println("Marks of student s1 is "+s1.getExam1());
		System.out.println("Marks of student s1 is "+s1.getExam2());
		System.out.println("Marks of student s1 is "+s1.getExam3());
		System.out.println("Avarage of student s1 is "+s1.calculateAverage());
		
		
		
		
		
		}
		catch(Exception e){
			System.out.println("Error is "+e.getMessage());
		}
		
       
	}
	
}	 
	
	
