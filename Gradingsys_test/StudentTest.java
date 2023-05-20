package Gradingsys_test;
import Gradingsys.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays; 
class StudentTest {

	@Test
		void student_test() {
			String[] s= {"Nada Waleed","1901544s","10","10","20","50"};
			Student st =new Student(s,100);
			String expected ="Nada Waleed";
			assertEquals(expected,st.getName());
			st.calculateGPA();
			double gpa=3.7;
			assertEquals(gpa,st.getGpa());
			String grade="A-"; 
			assertEquals(grade,st.getGrade());
			boolean v=true ;
			assertEquals(v, st.isValid());
			String code="1901544s";
			assertEquals(code,st.getCode());
			int[] marks = {10, 10, 20, 50};
			boolean m=Arrays.equals( marks, st.getMarks());
			boolean m_expected=true;
			assertEquals(m_expected,m);
			String sn="Student{name='Nada Waleed', code='1901544s', marks=[10, 10, 20, 50], valid=true, gpa=3.7, grade='A-'}";
			assertEquals(sn,st.toString());

	}
	

	@Test
	void student_test1() {
		String[] s3= {"Nada@12 Waleed","190154ASD4s","10","10","21","50"};
		Student st =new Student(s3,100);
		String expected ="Invalid Name";
		assertEquals(expected,st.getName());
		st.calculateGPA();
		double gpa=-1.0;
		assertEquals(gpa,st.getGpa());
		String grade="U"; 
		assertEquals(grade,st.getGrade());
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
		String s="Student{name='Invalid Name', code='Invalid Code', marks=[-1, -1, -1, -1], valid=false, gpa=-1.0, grade='U'}";
		assertEquals(s,st.toString());
}
	
	//test student name
	@Test
	void studentName_test() {
		String[] s= {"Nada@12 Waleed","1901544s","10","10","21","50"};
		Student st =new Student(s,100);
		String expected ="Invalid Name";
		assertEquals(expected,st.getName());
		boolean v=false ;
		assertEquals(v, st.isValid());}
	@Test
	void studentName_test1() {
		String[] s= {"Nada3512 Waleed","1901544s","10","10","21","50"};
		Student st =new Student(s,100);
		String expected ="Invalid Name";
		assertEquals(expected,st.getName());
		boolean v=false ;
		assertEquals(v, st.isValid());}
	@Test
	void studentName_test2() {//name must have space****fault
		String[] s= {"NadaWaleed","1901544s","10","10","21","50"};
		Student st =new Student(s,100);
		String expected ="NadaWaleed";
		assertEquals(expected,st.getName());
		boolean v=false ;
		assertEquals(v, st.isValid());}
	@Test
	void studentName_test3() { //name should not start with space*****fault
		String[] s= {"    Nada Waleed","1901544s","10","10","21","50"};
		Student st =new Student(s,100);
		String expected ="Invalid Name";
		assertEquals(expected,st.getName());
		boolean v=false ;
		assertEquals(v, st.isValid());}
	@Test
	void studentName_test4() { 
		String[] s= {" 125485","1901544s","10","10","21","50"};
		Student st =new Student(s,100);
		String expected ="Invalid Name";
		assertEquals(expected,st.getName());
		boolean v=false ;
		assertEquals(v, st.isValid());}

	//test student code
	
	
	@Test
	void studentCode_test() {
		String[] s= {"Nada Waleed","1901544s","0","10","10","60"};
		Student st =new Student(s,100);
		boolean v=true ;
		assertEquals(v, st.isValid());
		String code="1901544s";
		assertEquals(code,st.getCode());
	}
	@Test
	void studentCode_test1() {
		String[] s= {"Nada Waleed","19015441","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}
	void studentCode_test2() {
		String[] s= {"Nada Waleed","19P1544S","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=true ;
		assertEquals(v, st.isValid());
		String code="19P15441";
		assertEquals(code,st.getCode());
	}
	void studentCode_test3() {
		String[] s= {"Nada Waleed","190P1544","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=true ;
		assertEquals(v, st.isValid());
		String code="190P1544";
		assertEquals(code,st.getCode());
	}
	
	@Test
	void studentCode_test4() {//expected to be valid but it don't*****fault
		String[] s= {"Nada Waleed","19P15441","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}
	@Test
	void studentCode_test5() {
		String[] s= {"Nada Waleed","1901544mn","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}
	@Test
	void studentCode_test6() {
		String[] s= {"Nada Waleed","19015@25","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}
	@Test
	void studentCode_test7() {
		String[] s= {"Nada Waleed","mbjhtegjhy","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}
	@Test
	void studentCode_test8() {
		String[] s= {"Nada Waleed","19015447826","0","0","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		String code="Invalid Code";
		assertEquals(code,st.getCode());
	}

	
	//test student marks
	@Test
	void studentMarks_test1() {
		String[] s= {"Nada Waleed","1901544s","50","10","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}
	@Test
	void studentMarks_test2() {
		String[] s= {"Nada Waleed","1901544s","50","20","10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}
	@Test
	void studentMarks_test3() {
		String[] s= {"Nada Waleed","1901544s","50","20","-10","60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}
	@Test
	void studentMarks_test4() {
		String[] s= {"Nada Waleed","1901544s","50","20","-10","600"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}
	@Test
	void studentMarks_test5() {
		String[] s= {"Nada Waleed","1901544s","0","0","0","0"};
		Student st =new Student(s,100);
		boolean v=true ;
		assertEquals(v, st.isValid());
		int[] marks = {0, 0, 0, 0};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}
	@Test
	void studentMarks_test6() {
		String[] s= {"Nada Waleed","1901544s","-10","-10","-20","-60"};
		Student st =new Student(s,100);
		boolean v=false ;
		assertEquals(v, st.isValid());
		int[] marks = {-1, -1, -1, -1};
		boolean m=Arrays.equals( marks, st.getMarks());
		boolean m_expected=true;
		assertEquals(m_expected,m);
	}

	
	//test calculate GPA
	@Test
	void gpa_test1() {
		String[] s1= {"Nada Waleed","1901544s","10","10","20","60"};
		Student st =new Student(s1,100);
		st.calculateGPA();
		double gpa1=4.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="A+";
		assertEquals(grade1,st.getGrade());
		}

	@Test
	void gpa_test2() {
		String[] s2= {"Nada Waleed","1901544s","7","10","20","59"};
		Student st =new Student(s2,100);
		st.calculateGPA();
		double gpa1=4.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="A";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test3() {
		String[] s3= {"Nada Waleed","1901544s","10","10","20","50"};
		Student st =new Student(s3,100);
		st.calculateGPA();
		double gpa1=3.7;
		assertEquals(gpa1,st.getGpa());
		String grade1="A-";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test4() {
		String[] s4= {"Nada Waleed","1901544s","10","8","16","50"};
		Student st =new Student(s4,100);
		st.calculateGPA();
		double gpa1=3.3;
		assertEquals(gpa1,st.getGpa());
		String grade1="B+";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test5() {
		String[] s5= {"Nada Waleed","1901544s","10","10","20","40"};
		Student st =new Student(s5,100);
		st.calculateGPA();
		double gpa1=3.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="B";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test6() {
		String[] s6= {"Nada Waleed","1901544s","10","6","10","50"};
		Student st =new Student(s6,100);
		st.calculateGPA();
		double gpa1=2.7;
		assertEquals(gpa1,st.getGpa());
		String grade1="B-";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test7() {
		String[] s7= {"Nada Waleed","1901544s","0","10","10","55"};
		Student st =new Student(s7,100);
		st.calculateGPA();
		double gpa1=2.3;
		assertEquals(gpa1,st.getGpa());
		String grade1="C+";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test8() {
		String[] s8= {"Nada Waleed","1901544s","3","7","10","50"};
		Student st =new Student(s8,100);
		st.calculateGPA();
		double gpa1=2.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="C";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test9() {
		String[] s9= {"Nada Waleed","1901544s","4","2","10","51"};
		Student st =new Student(s9,100);
		st.calculateGPA();
		double gpa1=1.7;
		assertEquals(gpa1,st.getGpa());
		String grade1="C-";
		assertEquals(grade1,st.getGrade());
		}
	@Test
	void gpa_test10() {
		String[] s10= {"Nada Waleed","1901544s","7","8","10","40"};
		Student st =new Student(s10,100);
		st.calculateGPA();
		double gpa1=1.3;
		assertEquals(gpa1,st.getGpa());
		String grade1="D+";
		assertEquals(grade1,st.getGrade());
		}
	void gpa_test11() {
		String[] s11= {"Nada Waleed","1901544s","4","5","11","40"};
		Student st =new Student(s11,100);
		st.calculateGPA();
		double gpa1=1.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="D";
		assertEquals(grade1,st.getGrade());
		}
	void gpa_test12() {
		String[] s12= {"Nada Waleed","1901544s","7","0","10","40"};
		Student st =new Student(s12,100);
		st.calculateGPA();
		double gpa1=0.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="F";
		assertEquals(grade1,st.getGrade());
		}
	void gpa_test13() {
		String[] s13= {"Nada Waleed","1901544s","0","0","0","0"};
		Student st =new Student(s13,100);
		st.calculateGPA();
		double gpa1=0.0;
		assertEquals(gpa1,st.getGpa());
		String grade1="F";
		assertEquals(grade1,st.getGrade());
		}
	
	

}
