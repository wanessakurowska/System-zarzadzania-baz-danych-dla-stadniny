package bdbt_bada_project.Stadnina_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private EmployeesDAO employeesDAO;

    @GetMapping("/employee_profile")
    public String showMyProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Employees employee = employeesDAO.findByUsername(currentUserName);

        if (employee != null) {
            model.addAttribute("employee", employee);
        } else {
            // Obsługa przypadku, gdy dane pracownika nie zostały znalezione
            // Można wyświetlić komunikat błędu lub przekierować na inną stronę
        }

        return "employee_profile";
    }

    @Autowired
    private OwnersDAO ownersDAO;

    @GetMapping("/owner_profile")
    public String showOwnerProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Owners owner = ownersDAO.findByUsername(currentUserName);

        if (owner != null) {
            model.addAttribute("owner", owner);
        } else {
            // Obsługa przypadku, gdy dane pracownika nie zostały znalezione
            // Można wyświetlić komunikat błędu lub przekierować na inną stronę
        }

        return "owner_profile"; // Nazwa widoku Thymeleaf
    }
}

