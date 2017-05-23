package com.concretepage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sjtuse.zcbookstore.dao.BookDao;
import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.soap.Student;

import javax.annotation.Resource;

@Component
public class StudentUtility {
	@Autowired
	private BookService bookService;
	private Map<Integer,Student> studentMap = new HashMap<>();

	/*public StudentUtility() {
	    List<Book> bookList = bookDao.getAllBooks();
	    for (Book b: bookList) {
	        Student s = new Student();
	        s.setStudentId(b.getBookId());
	        s.setAge(b.getBookPrice().toBigInteger().intValue());
	        s.setName(b.getBookName());
	        s.setClazz(b.getBookInfo());
	        studentMap.put(b.getBookId(), s);
        }
    }*/

	/*public StudentUtility(){
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setName("Ram");
		s1.setAge(20);
		s1.setClazz("ABC");
		studentMap.put(1, s1);
		Student s2 = new Student();
		s2.setStudentId(2);
		s2.setName("Shyam");
		s2.setAge(22);
		s2.setClazz("EFG");
		studentMap.put(2, s2);
	}*/
	/*public Student getStudent(int studentId){
		return studentMap.get(studentId);
	}*/
    public Student getStudent(int studentId) {
        Book b = bookService.getBook(studentId);
        Student s = new Student();
        s.setStudentId(b.getBookId());
        s.setAge(b.getBookPrice().toBigInteger().intValue());
        s.setName(b.getBookName());
        s.setClazz(b.getBookInfo());
        return s;
    }
}
