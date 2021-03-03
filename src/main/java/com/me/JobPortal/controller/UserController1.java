package com.me.JobPortal.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.JobPortal.DAO.EducationDetailDAO;
import com.me.JobPortal.DAO.SubjectDetailDAO;
import com.me.JobPortal.DAO.UserDAO1;
import com.me.JobPortal.constants.ApplicationConstants;
import com.me.JobPortal.exception.UserException;
import com.me.JobPortal.pojo.Conversation;
import com.me.JobPortal.pojo.EducationDetail;
import com.me.JobPortal.pojo.JobPost;
import com.me.JobPortal.pojo.SubjectDetail;
import com.me.JobPortal.pojo.User1;
import com.me.JobPortal.utility.Utility;
import com.me.JobPortal.wrapper.ConversationWrapper;
import com.me.JobPortal.wrapper.SubjectUIWrapper;

@Controller
//@RequestMapping("/*")
public class UserController1 {


	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	@Qualifier("userDao1")
	UserDAO1 userDao;
	
	@Autowired
	@Qualifier("educationDetailDao")
	EducationDetailDAO educationDetialDao;
	
	@Autowired
	@Qualifier("subjectDetailDao")
	SubjectDetailDAO subjectDetailDao;
	

	//@Autowired
	//@Qualifier("userValidator")
	//UserValidator validator;

	
	
	//@InitBinder
	//private void initBinder(WebDataBinder binder) {
	//	binder.setValidator(validator);
	//}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	protected String logout(HttpServletRequest request) throws Exception {
		if(request.getSession(false)!=null) {
			request.getSession().invalidate();
		}
		return "login";
	}
	
	@RequestMapping(value = "/home1.htm", method = RequestMethod.GET)
	protected ModelAndView home1(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String countries = "[\"Afghanistan\",\"Albania\",\"Algeria\"]";
		mv.addObject("countries",countries);
		mv.setViewName("home1");
		return mv;		
		
	}
	
	@RequestMapping(value = "/get-message.htm", params={"jobPostId"}, method = RequestMethod.GET)
	protected ModelAndView getMessage(HttpServletRequest request,@RequestParam("jobPostId") Integer jobPostId) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			User1 u = (User1)request.getSession().getAttribute("user");
			ConversationWrapper cw =userDao.getConversationWrapper(u.getUserId(), jobPostId);
			mv.addObject("conversationWrapper",cw);
			mv.addObject("conversation", new Conversation(jobPostId));
			mv.setViewName("get-message");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}
		
	}
	
	
	/*
	  @RequestMapping(value = "/get-message.htm", method = RequestMethod.POST)
	  protected ModelAndView getMessage(HttpServletRequest  request, @ModelAttribute("conversation") Conversation conv) throws Exception
	  { 
		  
		  ModelAndView mv = new ModelAndView(); 
		  if(request.getSession(false)!=null) {
		  User1 u = (User1)request.getSession().getAttribute("user");
		  ConversationWrapper cw =userDao.getConversationWrapper(u.getUserId(), jobPostId); 
		  mv.addObject("conversationWrapper",cw);
		  mv.addObject("conversation", new Conversation(jobPostId));
		  mv.setViewName("get-message"); 
		  return mv; 
	  }else { 
		  mv.setViewName("login");
	  return mv; 
	  }
	  
	}*/
	 
	
	@RequestMapping(value = "/student-dashboard.htm", method = RequestMethod.GET)
	protected String getStudentDashBoard(HttpServletRequest request) throws Exception {
		if(request.getSession(false)!=null) {
			
			return "student-dashboard.htm";
		}
		return "login";
	}
	
	@RequestMapping(value = "/verify-email.htm", params={"authtoken"}, method = RequestMethod.GET)
	protected String verifyEmailUrl(HttpServletRequest request,@RequestParam("authtoken") String authtoken) throws Exception {
		System.out.println("URl : "+ authtoken);
		if(userDao.verifyEmail(authtoken))
			return "verify-email-successful";
		else
			return "verify-email-unsuccessful";
		
	}
	
	
	@RequestMapping(value = "/email-verification.htm", method = RequestMethod.GET)
	protected ModelAndView emailVerification(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			User1 u = (User1)request.getSession().getAttribute("user");
			mv.addObject("user",u);
			mv.setViewName("email-verification");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}
		
	}
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	protected String login(HttpServletRequest request) throws Exception {
		return "login";
	}
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = (HttpSession) request.getSession();
		
		try {

			System.out.println("loginUser");

			User1 u = userDao.get(request.getParameter("username"), request.getParameter("password"));
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				mv.setViewName("login");
				return mv;
			}
			session.setAttribute("user", u);
			if(u.getRole().equals(ApplicationConstants.ROLE_TEACHER)) {
				if(u.getProfileCompletion()==4) {
					System.out.println("Profile Completed");
					//send to home 
				}	
				else if(u.getProfileCompletion()==3) {
					mv.addObject("user",u);
					mv.setViewName("register-teaching-details");
					return mv;
					//send to home 
				}else if(u.getProfileCompletion()==2) {
					mv.addObject("educationDetail",new EducationDetail((int)u.getUserId()));
					mv.setViewName("register-education-certification");
					return mv;
					
				}else if(u.getProfileCompletion()==1) {
					
					SubjectUIWrapper sbw = userDao.getSubjectWrapperForTeacher(u.getUserId());
					mv.addObject("subjectWrapper",sbw);
					mv.addObject("subjectDetail",new SubjectDetail((int)u.getUserId()));
					mv.setViewName("register-subjects-skills");
					return mv;
					
				}else if(u.getProfileCompletion()==0) {
					mv.addObject("user",u);
					mv.setViewName("register-user-basic-details");
					return mv;
				} 
				
			} else if(u.getRole().equals(ApplicationConstants.ROLE_STUDENT)) {
				
				if(u.getProfileCompletion()==0) {
					mv.addObject("user",u);
					mv.setViewName("register-student-basic-details");
					return mv;
				}	
				else if(u.getProfileCompletion()==1) {
					mv.addObject("user",u);
					mv.setViewName("student-dashboard");
					return mv;
					//send to home 
				}
			}
			
			mv.setViewName("login");
			return mv;
			
			
			

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			mv.setViewName("error");
			return mv;
		}

	}
	
	
	@RequestMapping(value = "/tutor-jobs.htm", method = RequestMethod.GET)
	protected ModelAndView viewAllJob(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		// HttpSession session = (HttpSession) request.getSession();
		// User u = (User) session.getAttribute("user");
		// mv.addObject("companyName", u.getCompany().getCompanyName());
		// mv.addObject("joblist", new JobList());
		mv.addObject("jobs", userDao.list());
		mv.setViewName("tutor-jobs");

		return mv;
	}
	
	
	@RequestMapping(value = "/add-job-post.htm", method = RequestMethod.GET)
	protected ModelAndView addJobPost(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			System.out.println("addJobPost");
			User1 user = (User1)request.getSession(false).getAttribute("user");
			JobPost jobPost = new JobPost();
			jobPost.setUserId(user.getUserId());
			jobPost.setUserName(user.getName());
			mv.addObject("jobPost",jobPost);
			mv.setViewName("add-job-post");
			return mv;
		}
		mv.setViewName("login");
		return mv;

	}
	
	@RequestMapping(value = "/add-job-post.htm", method = RequestMethod.POST)
	protected ModelAndView addJobPost(HttpServletRequest request,  @ModelAttribute("jobPost") JobPost jobPost, BindingResult result) throws Exception {

		try {
			System.out.println("addJobPost : Post Method");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				JobPost p = userDao.addJobPost(jobPost);
				return new ModelAndView("student-dashboard", "user", request.getSession().getAttribute("user"));
			}else {
				mv.setViewName("login");
				return mv;
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-student-basic-details");
		}
	}
	
	
	
	
	@RequestMapping(value = "/register-student-basic-details.htm", method = RequestMethod.GET)
	protected ModelAndView registerStudentBasicDetails(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			System.out.println("registerStudentBasicDetails");
			User1 user = (User1)request.getSession(false).getAttribute("user");
			mv.addObject("user",user);
			mv.setViewName("register-student-basic-details");
			return mv;
		}
		mv.setViewName("login");
		return mv;

	}
	
	@RequestMapping(value = "/register-student-basic-details.htm", method = RequestMethod.POST)
	protected ModelAndView registerStudentBasicDetails(HttpServletRequest request,  @ModelAttribute("user") User1 user, BindingResult result) throws Exception {

		try {
			System.out.print("registerStudentBasicDetails");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				user.setProfileCompletion(1);
				User1 u = userDao.registerStudentBasicDetails(user);
				request.getSession().setAttribute("user", u);
				return new ModelAndView("student-dashboard", "user", u);
			}else {
				mv.setViewName("login");
				return mv;
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-student-basic-details");
		}
	}
	
	
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User1 user, BindingResult result) throws Exception {


		try {
			
			
			System.out.println("registerNewUser");
			user.setProfileCompletion(0);
			user.setAuthToken(UUID.randomUUID().toString());
			user.setVerified(false);
			
			user.setCreatedAt(Utility.getCurrentDateTime());
			User1 u = userDao.registerUser(user);
			
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("userid", u.getUserId());
			
			
			String address = u.getEmail();
			String subject = "Action Required: Please verify email";
			String message = "Action Required: Please verify email" + "\n" +
						"Hi "+ u.getName() +", welcome to TeacherAnytime!!" +
					"In order to start using TeacherAnytime, you need to verify your email.\n"
					+ "\n"
					+ "Verify your email\n"
					+ "https://www.abc.com/verify-email?token="+u.getAuthToken()+ " "
					+ "\n"
					+ "Regards,\n"
					+ "Team Abc";
			
			SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(address);
	        email.setSubject(subject);
	        email.setText(message);
	        
	       // mailSender.send(email);
	        
	        return new ModelAndView("email-verification","user",u);
			
	
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.println("registerUser");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",new User1());
		mv.setViewName("register-user");
//		return new ModelAndView("register-user", "user", new User());
		return mv;

	}

	
	@RequestMapping(value = "/register-user-basic-details.htm", method = RequestMethod.GET)
	protected ModelAndView registerUserBasicDetails(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			System.out.println("registerUser");
			User1 user = (User1)request.getSession(false).getAttribute("user");
			mv.addObject("user",user);
			mv.setViewName("register-user-basic-details");
			return mv;
		}
		mv.setViewName("login");
		return mv;

	}
	
	@RequestMapping(value = "/register-user-basic-details.htm", method = RequestMethod.POST)
	protected ModelAndView registerUserBasicDetails(HttpServletRequest request,  @ModelAttribute("user") User1 user, BindingResult result) throws Exception {

		//validator.validate(user, result);

		/*if (result.hasErrors()) {
//			return new ModelAndView("register-user", "user", user);
			ModelAndView mv = new ModelAndView();
			mv.addObject("companies", companyDao.list());
			mv.addObject("user", user);
			mv.setViewName("register-user");
			return mv;
		}*/
		try {
			System.out.print("register-user-basic-details");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				User1 u = userDao.registerBasicDetails(user);
				request.getSession().setAttribute("user", u);
				SubjectUIWrapper sbw = userDao.getSubjectWrapperForTeacher(user.getUserId());
				mv.addObject("subjectWrapper",sbw);
				mv.addObject("subjectDetail",new SubjectDetail((int)user.getUserId()));
				mv.setViewName("register-subjects-skills");
				
				return new ModelAndView("register-subjects-skills", "user", u);
			}else {
				mv.setViewName("login");
				return mv;
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-user-basic-details");
		}
	}
	
	@RequestMapping(value = "/register-subjects-skills.htm", method = RequestMethod.GET)
	protected ModelAndView registerSubjectsSkills(HttpServletRequest request) throws Exception {
		System.out.print("register-subjects-skills");
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			User1 user = (User1)request.getSession().getAttribute("user");
			SubjectUIWrapper sbw = userDao.getSubjectWrapperForTeacher(user.getUserId());
			mv.addObject("subjectWrapper",sbw);
			mv.addObject("subjectDetail",new SubjectDetail((int)user.getUserId()));
			mv.setViewName("register-subjects-skills");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}
		

	}
	
	@RequestMapping(value = "/register-subjects-skills.htm", method = RequestMethod.POST)
	protected ModelAndView registerSubjectSkills(HttpServletRequest request,  @ModelAttribute("subjectDetail") SubjectDetail subjectDetail, BindingResult result) throws Exception {

		try {
			System.out.print("register-subjects-skills.htm");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				User1 u = userDao.registerSubjectSkillsDetails(subjectDetail,(User1)request.getSession().getAttribute("user"));
				request.getSession().setAttribute("user", u);
				return new ModelAndView("register-education-certification", "educationDetail",
						new EducationDetail((int)((User1)request.getSession().getAttribute("user")).getUserId()));
			}else {
				mv.setViewName("login");
				return mv;
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-subjects-skills.htm");
		}
	}
	
	@RequestMapping(value = "/register-education-certification.htm", method = RequestMethod.GET)
	protected ModelAndView registerEducationCertification(HttpServletRequest request) throws Exception {
		System.out.print("register-education-certification");
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			
			mv.addObject("educationDetail",new EducationDetail((int)((User1)request.getSession().getAttribute("user")).getUserId()));
			mv.setViewName("register-education-certification");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}

	}
	
	@RequestMapping(value = "/register-education-certification.htm", method = RequestMethod.POST)
	protected ModelAndView registerEducationCertification(HttpServletRequest request,  @ModelAttribute("educationDetail") EducationDetail educationDetail, BindingResult result) throws Exception {

		try {
			System.out.print("register-education-certification");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				EducationDetail u = userDao.registerEducationDetails(educationDetail);
				User1 user = (User1)request.getSession().getAttribute("user");
				mv.addObject("user",user);
				return new ModelAndView("register-teaching-details", "user", user);
			}else {
				mv.setViewName("login");
				return mv;
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-education-certification.htm");
		}
	}
	
	
	
	
	
	@RequestMapping(value = "/register-teaching-details.htm", method = RequestMethod.GET)
	protected ModelAndView registerTeachingDetails(HttpServletRequest request) throws Exception {
		System.out.print("register-teaching-details");
		ModelAndView mv = new ModelAndView();
		if(request.getSession(false)!=null) {
			User1 user = (User1)request.getSession().getAttribute("user");
			mv.addObject("user",user);
			mv.setViewName("register-teaching-details");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}

	}
	
	@RequestMapping(value = "/register-teaching-details.htm", method = RequestMethod.POST)
	protected ModelAndView registerTeachingDetails(HttpServletRequest request,  @ModelAttribute("user") User1 user, BindingResult result) throws Exception {

		try {
			System.out.print("register-teaching-details");
			ModelAndView mv = new ModelAndView();
			if(request.getSession(false)!=null) {
				User1 u = userDao.registerTeachingDetails(user);
				request.getSession().setAttribute("user", u);
				return new ModelAndView("login", "user", u);
			}else {
				mv.setViewName("login");
				return mv;
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while register-teaching-details.htm");
		}
	}
}
