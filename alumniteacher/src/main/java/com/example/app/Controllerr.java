package com.example.app;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
@CrossOrigin("http://localhost:3000")
public class Controllerr {
	
	@Autowired
	modelrepo mr;
	@Autowired
	Servicess ser;
	@Autowired
	  private FileStorageService storageService;
//
//	@RequestMapping("/")
//	public String hh() {
//		return "NewFile";
//	}
//	

	@PostMapping("/add")
	modelalumni home(modelalumni ml) {
		
	
		return mr.save(ml);
		
	
	
}
	
//	  @PostMapping("/add")
//	     modelalumni newUser(@RequestParam("user") String user,@RequestParam("pwd") String pwd) {
//		  modelalumni newuser=new modelalumni();
////		  String userr=newuser.setUsername(user);
//	        return ser.savee(user,pwd);
//	    }
//	
//	  
	  
	
	 @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	 
	 
	 
	 @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	 
	 

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDB fileDB = storageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
//	  @PostMapping("/loginn")
//	  public String login(@RequestParam("name") String name,@RequestParam("year") String year,Model model) {
//		  
//		  modelalumni user=null;
//		  String message="wrong id or password";
//		  
//		  try {
//			  
//			  user=mr.findByNameAndYear(name,year);
//		  }
//		  
//		  
//		  catch(Exception e) {
//			  
//			  System.out.println("user not found");
//			  return "login";
//		  }
//		  
//		  if(user!=null) {
//			  model.addAttribute("name",name);
//			  
//			  return "Home";
//		  }
//		  
//		  else {
//			  model.addAttribute("messagge",message);
//	         return "login";
//	      }
//		  
//		 
//	  }
//	  
//	@PostMapping("/loginn")
//	public modelalumni one(@RequestBody modelalumni user) {
//		 String username= user.getUsername();
//		 String password= user.getPassword();
////	  String username=user.getUsername();
////	  String password=user.getPassword();
//	   
//		 
//	    return  mr.findByUsernameAndPassword(username,password);
//	      
//	  }
//	  @PostMapping("/addmaterial")
//	    public Materialmodel saveEvent(@RequestBody Materialmodel materialm
////	    		@RequestParam("bookname") String eventname,
////	    		@RequestParam("eventday") String eventday,
////	    		@RequestParam("desc") String desc
//	    		)
//	    {
//	    	return ser.saveEventToDB(materialm);
//	    	//return "eventt";
//	    }
//	    
	  
	  @PostMapping("/addmaterial")
	    public Materialmodel savemateiral(
	    		@RequestParam("pdf") MultipartFile pdf,
	    		@RequestParam("bookname") String bookname,
	    		@RequestParam("subject") String subject,
	    		@RequestParam("category") String category,
	    		@RequestParam("subjectcode") String subjectcode)
	    {
	    	return ser.saveEventToDB(pdf, bookname, subject, category,subjectcode);
	    	//return "eventt";
	    }
	    

	  @GetMapping("/loginn")
	  modelalumni login(@RequestParam("name") String name,@RequestParam("year") String year,Model model) {
		  
		  return  mr.findByNameAndYear(name,year);
		   
	  }

	  }
//		  
  		 // modelalumni user=null;
//		  String message="wrong id or password";
//		  
//		 
//		 
//		  
////		  catch(Exception e) {
////			  
////			  System.out.println("user not found");
////			  return "login";
////		  }
////		  
////		  if(user!=null) {
////			 return  model.addAttribute("regdno",name);
////			  
////			 // return "Home";
////		  }
////		  
////		  else {
////			 return  model.addAttribute("messagge",message);
////	         //return "login";
////	      }
//		  
		
