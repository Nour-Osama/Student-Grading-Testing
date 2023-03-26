package Gradingsys_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Gradingsys.Course;
class CourseTest {

	@Test
	void course_test1() {
		String[] c1={"Software Testing","CSE337s","100\n"};
		Course cr =new Course(c1);
		boolean valid = true;
		assertEquals(valid,cr.isValid());
		String name="Software Testing";
		assertEquals(name ,cr.getName());
		String code="CSE337s";
		assertEquals(code,cr.getCode());
		int total=100;
		assertEquals(total,cr.getTotal());
		String s="Course{name='Software Testing', code='CSE337s', total=100, valid=true}";
		assertEquals(s, cr.toString());
	}
	@Test
	void course_test2() {
		String[] c1={"Software@ Testing","CS1E337s","-100\n"};
		Course cr =new Course(c1);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String name="Invalid Name";
		assertEquals(name ,cr.getName());
		String code="Invalid Code";
		assertEquals(code,cr.getCode());
		int total=-100;
		assertEquals(total,cr.getTotal());
		String s="Course{name='Invalid Name', code='Invalid Code', total=-100, valid=false}";
		assertEquals(s, cr.toString());
	}
	//test course name
	@Test
	void courseName_test1() { //the name should not start with space*****fault
		String[] c={"   Software Testing","2545CSE337s","100\n"};
		Course cr =new Course(c);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String name="Invalid Name";
		assertEquals(name ,cr.getName());
			}
	@Test
	void courseName_test2() {
		String[] c={"Software@25 Testing","2545CSE337s","100\n"};
		Course cr =new Course(c);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String name="Invalid Name";
		assertEquals(name ,cr.getName());
			}
	@Test
	void courseName_test3() {//the name should not be numbers********fault
		String[] c={"12548","2545CSE337s","100\n"};
		Course cr =new Course(c);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String name="Invalid Name";
		assertEquals(name ,cr.getName());
			}
	@Test
	void courseName_test4() { //the name should have space*******fault
		String[] c={"softwaretesting","2545CSE337s","100\n"};
		Course cr =new Course(c);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String name="Invalid Name";
		assertEquals(name ,cr.getName());
			}
	
	//test course code
	@Test
	void courseCode_test() {
		String[] c3={"Software Testing","CSESF337ks","100\n"};
		Course cr =new Course(c3);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String code="Invalid Code";
		assertEquals(code,cr.getCode());
		
		}
	@Test
	void courseCode_test1() {
		String[] c3={"Software Testing","CSE33725s","100\n"};
		Course cr =new Course(c3);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String code="Invalid Code";
		assertEquals(code,cr.getCode());
		
		}
	void courseCode_test2() {
		String[] c3={"Software Testing","254CSE3375s","100\n"};
		Course cr =new Course(c3);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String code="Invalid Code";
		assertEquals(code,cr.getCode());
		
		}
	void courseCode_test3() {
		String[] c3={"Software Testing","@CSE33725s","100\n"};
		Course cr =new Course(c3);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		String code="Invalid Code";
		assertEquals(code,cr.getCode());
		
		}
	//test total mark
	@Test
	void courseMark_test1() {
		String[] c4={"Software Testing","CSE337s","1000\n"};
		Course cr =new Course(c4);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		int total=1000;
		assertEquals(total,cr.getTotal());
	
	}
	@Test
	void courseMark_test2() {
		String[] c5={"Software Testing","CSE337s","10\n"};
		Course cr =new Course(c5);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		int total=10;
		assertEquals(total,cr.getTotal());
		
	}
	@Test
	void courseMark_test3() {
		String[] c6={"Software Testing","CSE337s","-10\n"};
		Course cr =new Course(c6);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		int total=-10;
		assertEquals(total,cr.getTotal());
		
	}
	@Test
	void courseMark_test4() {
		String[] c7={"Software Testing","CSE38737s","0\n"};
		Course cr =new Course(c7);
		boolean valid = false;
		assertEquals(valid,cr.isValid());
		int total=0;
		assertEquals(total,cr.getTotal());
		
	}

}
