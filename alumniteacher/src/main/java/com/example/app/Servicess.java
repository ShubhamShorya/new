package com.example.app;




import java.io.IOException;
import java.math.BigInteger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;



import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class Servicess {
//
@Autowired
private modelrepo  rep;
@Autowired
private Materialrepo  mrep;



//public User findUserByRegdno(BigInteger regdno,String password) {
//    return rep.findByRegdnoAndPassword(regdno,password);
//}
//   
//
//
//	public List<Event> getAllevent() {
//		// TODO Auto-generated method stub
//		List<Event> evnt=new ArrayList<>();
//		evr.findAll().forEach(evnt::add);
//		return evnt;
//	}
//	
//    public List<event> eventList() { 
//        return (List<event>) evtr.findAll(); 
//    } 
    
//	public User addUser(User user) {
//		// TODO Auto-generated method stub
//		return rep.save(user);
//		
//	}
//	public event addEvent(event evn) {
//		// TODO Auto-generated method stub
//		return evtr.save(evn);
//		
//	}
//	public void updateEmployee(String id, employee emp) {
//		// TODO Auto-generated method stub
//		employeeRepo.save(emp);
//	}
//
//	public void deleteEmployee(String id) {
//		// TODO Auto-generated method stub
//		employeeRepo.deleteById(id);
//	}

	
 
	//ge
	
//	public List<Event> findAll()
//	{
//		return  evr.findAll();
//	}
//	


	public Materialmodel  saveEventToDB(MultipartFile file,String bookname,String subject,String category
			,String subjectcode)
	{
		Materialmodel p = new Materialmodel();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setPdf(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setBookname(bookname);
		p.setCategory(category);
      p.setSubject(subject);
      p.setSubjectcode(subjectcode);
      
     return  mrep.save(p);
	}
	
	
	
	public  modelalumni  savee(String name,String year)
	{
		modelalumni p = new modelalumni();
		
		
		p.setName(name);
		
        p.setYear(year);
        //p.setEventday(eventday);
        
       return  rep.save(p);
	}
	  
//	public void  saveEventToDB(@RequestBody Materialmodel p)
//	{
////		Materialmodel p = new Materialmodel();
////		String bookname=p.getBookname();
////		String subject=p.getSubject();
////		String category=p.getCategory();
////		String subjectcode=p.getSubjectcode();
//		MultipartFile file=p.getPdf(); 
////		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
////		if(fileName.contains(".."))
////		{
////			System.out.println("not a a valid file");
////		}
////		try {
//			p.setPdf(Base64.getEncoder().encodeToString(file.getBytes()));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		p.setBookname(bookname);
////		p.setSubject(subject);
////        p.setCategory(category);
////        p.setSubjectcode(subjectcode);
//        
//        mrep.save(p);
//	}
}