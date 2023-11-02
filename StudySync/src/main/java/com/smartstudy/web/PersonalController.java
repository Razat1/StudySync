package com.smartstudy.web;
import com.smartstudy.entity.UserSubjects;
import com.smartstudy.repository.SubjectRepository;
import com.smartstudy.repository.UserRepository;
import com.smartstudy.repository.UserSubjectRepository;
import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class PersonalController {
//    private Authentication authentication;
//
//    private final SubjectService subjectService;
//    private final UserSubjectService userSubjectService;
//
//    private final UserService userService;
//    private CustomUser getCurrentUser() {
//        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return user;
//    }
//@Autowired
//public UserSubjectRepository userSubjectRepository;
//
//    @Autowired
//    public PersonalController(SubjectService subjectService, UserService userService, UserSubjectService userSubjectService) {
//
//      {
//            this.subjectService = subjectService;
//            this.userSubjectService = userSubjectService;
//            this.userService = userService;
//
//        }
//    }

//    @GetMapping("/user/subjects")
//    public String getSubjectsPage(Model model) {
//        List<Subjects> subjects = subjectService.getAllSubjects();
//        model.addAttribute("subjects", subjects); // Add subjects to the model
//        model.addAttribute("subjectRequest", new Subjects());
//        return "Subjects";
//    }
//    @PostMapping("/user/subjects")
//    public String addSubjects(@RequestParam("subjectIds") List<Long> subjectIds, Model model, Principal principal) {
//        if (principal instanceof CustomUser) {
//            CustomUser customUser = (CustomUser) principal;
//            User user = customUser.getUser();
//            System.out.println(getCurrentUser());
//            // Get the subjects based on their IDs
//            List<Subjects> selectedSubjects = subjectService.getSubjectIds(subjectIds);
//            System.out.println(subjectIds);
//            // Create and save UserSubjects entities to associate subjects with the user
//            for (Subjects selectedSubject : selectedSubjects) {
//                UserSubjects userSubjects = new UserSubjects();
//                userSubjects.setUser(user);      // Set the user
//                userSubjects.setSubject(selectedSubject); // Set the subject
//
//                // Save the UserSubjects entity to establish the association
//                userSubjectRepository.save(userSubjects);
//            }
//        }
//
//        return "redirect:/user/personal"; // Redirect to the personal page or any other suitable page.
//    }

@Autowired
private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserSubjectRepository userSubjectRepository;
    @GetMapping("/user/subjects")
    public String showSubjects(Model model, Principal principal) {
        List<Subjects> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
//        User user = userRepository.findByUsername(principal.getName());
//        if (user != null) {
//            List<UserSubjects> userSubjects = user.getUserSubjects();
//            model.addAttribute("userSubjects", userSubjects);
//        }
        return "Subjects";
    }

    @PostMapping("/user/addSubject") // Use "/user/addSubject" here
    public String addSubjectToUser(@RequestParam Long subjectId, Principal principal, Model model) {
        // Get the currently logged-in user
        User user = userRepository.findByUsername(principal.getName());

        // Get the selected subject
        Subjects subject = subjectRepository.findById(subjectId).orElse(null);

        if (user != null && subject != null) {
            // Create a new UserSubject association and save it
            UserSubjects userSubject = new UserSubjects();
            userSubject.setUser(user);
            userSubject.setSubject(subject);
            userSubjectRepository.save(userSubject);
            List<Subjects> subjects = subjectRepository.findAll();
            model.addAttribute("subjects", subjects);
        }
//        List<Subjects> allSubjects = subjectRepository.findAll();
//        model.addAttribute("allSubjects", allSubjects);
//
//       // User user = userRepository.findByUsername(principal.getName());
//        if (user != null) {
//            List<UserSubjects> userSubjects = user.getUserSubjects();
//            model.addAttribute("userSubjects", userSubjects);
//        }

        return "redirect:/user/subjects"; // Redirect back to the subject page
    }
}




