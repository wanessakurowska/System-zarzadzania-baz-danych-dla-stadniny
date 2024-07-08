package bdbt_bada_project.Stadnina_App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    public HorsesDAO daoHorses;

    @RequestMapping(value="/horses", method = RequestMethod.GET)
    public String viewHorses(Model model) {
        List<Horses> listHorses = daoHorses.list();
        model.addAttribute("listHorses", listHorses);
        return "horses";
    }

    @RequestMapping("/new_horse")
    public String newHorse(Model model){
        Horses horse = new Horses();
        List<Breeds> listBreeds = daoBreeds.list();
        model.addAttribute("listBreeds", listBreeds);
        model.addAttribute("horse", horse);
        return "new_horse";
    }

    @RequestMapping(value = "/save_horse", method = RequestMethod.POST)
    public String save(@ModelAttribute("horse") Horses horse) {
        daoHorses.save(horse);
        return "redirect:/horses";
    }

    @RequestMapping("/edit_horse/{Nr_Konia}")
    public ModelAndView showHorseEditForm(@PathVariable(name = "Nr_Konia") int Nr_Konia){
        ModelAndView mav = new ModelAndView("edit_horse");
        Horses horse = daoHorses.get(Nr_Konia);
        mav.addObject("horse", horse);
        return mav;
    }

    @RequestMapping(value = "/update_horse", method = RequestMethod.POST)
    public String updateHorse(@ModelAttribute("horse") Horses horse){
        daoHorses.update(horse);

        return "redirect:/horses";
    }

    @RequestMapping(value = "/delete_horse/{Nr_Konia}")
    public String deleteHorse(@PathVariable(name="Nr_Konia") int Nr_Konia){
        daoHorses.delete(Nr_Konia);

        return "redirect:/horses";
    }

    @Autowired
    public EmployeesDAO daoEmployees;

    @RequestMapping(value="/employees", method = RequestMethod.GET)
    public String viewEmployees(Model model) {
        List<Employees> listEmployees = daoEmployees.list();
        model.addAttribute("listEmployees", listEmployees);
        return "employees";
    }

    @RequestMapping("/new_employee")
    public String newEmployee(Model model){
        Employees employee = new Employees();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @RequestMapping(value = "/save_employee", method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employees employee) {
        daoEmployees.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/edit_employee/{Nr_Pracownika}")
    public ModelAndView showEmployeeEditForm(@PathVariable(name = "Nr_Pracownika") int Nr_Pracownika){
        ModelAndView mav = new ModelAndView("edit_employee");
        Employees employee = daoEmployees.get(Nr_Pracownika);
        mav.addObject("employee", employee);
        return mav;
    }

    @RequestMapping(value = "/update_employee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employees employee){
        daoEmployees.update(employee);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/delete_employee/{Nr_Pracownika}")
    public String deleteEmployee(@PathVariable(name="Nr_Pracownika") int Nr_Pracownika){
        daoEmployees.delete(Nr_Pracownika);

        return "redirect:/employees";
    }

    @GetMapping("/edit_employee_profile")
    public String editProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Employees employee = EmployeesDAO.findByUsername(currentUserName);
        model.addAttribute("employee", employee);

        return "edit_employee_profile";
    }

    @PostMapping("/update_employee_profile")
    public String updateProfile(@ModelAttribute("employee") Employees employee, Model model) {
        // Aktualizuj dane pracownika w bazie danych
        EmployeesDAO.update(employee);

        model.addAttribute("employee", employee);
        model.addAttribute("successMessage", "Dane zostały zaktualizowane.");

        return "redirect:/employee_profile";
    }



    @Autowired
    public BreedsDAO daoBreeds;

    @RequestMapping(value="/breeds", method = RequestMethod.GET)
    public String viewBreeds(Model model) {
        List<Breeds> listBreeds = daoBreeds.list();
        model.addAttribute("listBreeds", listBreeds);
        return "breeds";
    }

    @RequestMapping("/new_breed")
    public String newBreed(Model model){
        Breeds breed = new Breeds();
        model.addAttribute("breed", breed);
        return "new_breed";
    }

    @RequestMapping(value = "/save_breed", method = RequestMethod.POST)
    public String saveBreed(@ModelAttribute("breed") Breeds breed) {
        daoBreeds.save(breed);
        return "redirect:/breeds";
    }

    @RequestMapping("/edit_breed/{Nr_Rasy}")
    public ModelAndView showBreedEditForm(@PathVariable(name = "Nr_Rasy") int Nr_Rasy){
        ModelAndView mav = new ModelAndView("edit_breed");
        Breeds breed = daoBreeds.get(Nr_Rasy);
        mav.addObject("breed", breed);
        return mav;
    }

    @RequestMapping(value = "/update_breed", method = RequestMethod.POST)
    public String updateBreed(@ModelAttribute("breed") Breeds breed){
        daoBreeds.update(breed);

        return "redirect:/breeds";
    }

    @RequestMapping(value = "/delete_breed/{Nr_Rasy}")
    public String deleteBreed(@PathVariable(name="Nr_Rasy") int Nr_Rasy){
        daoBreeds.delete(Nr_Rasy);

        return "redirect:/breeds";
    }

    @Autowired
    public PostcodeDAO daoPostcode;

    @RequestMapping(value="/postcodes", method = RequestMethod.GET)
    public String viewPostcode(Model model) {
        List<Postcode> listPostcode = daoPostcode.list();
        model.addAttribute("listPostcode", listPostcode);
        return "postcodes";
    }

    @RequestMapping("/new_postcode")
    public String newPostcode(Model model){
        Postcode postcode = new Postcode();
        model.addAttribute("postcode", postcode);
        return "new_postcode";
    }

    @RequestMapping(value = "/save_postcode", method = RequestMethod.POST)
    public String savePostcode(@ModelAttribute("postcode") Postcode postcode) {
        daoPostcode.save(postcode);
        return "redirect:/postcodes";
    }

    @RequestMapping("/edit_postcode/{Nr_Poczty}")
    public ModelAndView showPostcodeEditForm(@PathVariable(name = "Nr_Poczty") int Nr_Poczty){
        ModelAndView mav = new ModelAndView("edit_postcode");
        Postcode postcode = daoPostcode.get(Nr_Poczty);
        mav.addObject("postcode", postcode);
        return mav;
    }

    @RequestMapping(value = "/update_postcode", method = RequestMethod.POST)
    public String updatePostcode(@ModelAttribute("postcode") Postcode postcode){
        daoPostcode.update(postcode);

        return "redirect:/postcodes";
    }

    @RequestMapping(value = "/delete_postcode/{Nr_Poczty}")
    public String deletePostcode(@PathVariable(name="Nr_Poczty") int Nr_Poczty) {
        daoPostcode.delete(Nr_Poczty);
        return "redirect:/postcodes";
    }

    @Autowired
    public AdressesDAO daoAdresses;

    @RequestMapping(value="/adresses", method = RequestMethod.GET)
    public String viewAdresses(Model model) {
        List<Adresses> listAdresses = daoAdresses.list();
        model.addAttribute("listAdresses", listAdresses);
        return "adresses";
    }

    @RequestMapping("/new_adress")
    public String newAdress(Model model){
        Adresses adress = new Adresses();
        model.addAttribute("adress", adress);
        return "new_adress";
    }

    @RequestMapping(value = "/save_adress", method = RequestMethod.POST)
    public String saveAdress(@ModelAttribute("adress") Adresses adress) {
        daoAdresses.save(adress);
        return "redirect:/adresses";
    }

    @RequestMapping("/edit_adress/{Nr_Adresu}")
    public ModelAndView showAdressEditForm(@PathVariable(name = "Nr_Adresu") int Nr_Adresu){
        ModelAndView mav = new ModelAndView("edit_adress");
        Adresses adress = daoAdresses.get(Nr_Adresu);
        mav.addObject("adress", adress);
        return mav;
    }

    @RequestMapping(value = "/update_adress", method = RequestMethod.POST)
    public String updateAdress(@ModelAttribute("adress") Adresses adress){
        daoAdresses.update(adress);

        return "redirect:/adresses";
    }

    @RequestMapping(value = "/delete_adress/{Nr_Adresu}")
    public String deleteAdress(@PathVariable(name="Nr_Adresu") int Nr_Adresu) {
        daoPostcode.delete(Nr_Adresu);
        return "redirect:/adresses";
    }

    @Autowired
    public HorseCaretakerDAO daoCaretaker;

    @RequestMapping("/assign_caretaker")
    public String assignCaretaker(Model model){
        HorseCaretaker horseCaretaker = new HorseCaretaker();
        List<Horses> listHorses = daoHorses.list();
        List<Employees> listEmployees = daoEmployees.list();
        model.addAttribute("horseCaretaker", horseCaretaker);
        model.addAttribute("listHorses", listHorses);
        model.addAttribute("listEmployees", listEmployees);
        return "assign_caretaker";
    }

    @RequestMapping(value = "/save_caretaker", method = RequestMethod.POST)
    public String saveCaretaker(@ModelAttribute("horseCaretaker") HorseCaretaker horseCaretaker) {
        daoCaretaker.save(horseCaretaker);
        return "redirect:/employees";
    }

    @Autowired
    public OwnersDAO daoOwners;

    @RequestMapping(value="/owners", method = RequestMethod.GET)
    public String viewOwner(Model model) {
        List<Owners> listOwners = daoOwners.list();
        model.addAttribute("listOwners", listOwners);
        return "owners";
    }

    @RequestMapping("/new_owner")
    public String newOwner(Model model){
        Owners owner = new Owners();
        List<Adresses> listAdresses = daoAdresses.list();
        model.addAttribute("owner", owner);
        model.addAttribute("listAdresses", listAdresses);
        return "new_owner";
    }

    @RequestMapping(value = "/save_owner", method = RequestMethod.POST)
    public String saveOwner(@ModelAttribute("owner") Owners owner) {
        daoOwners.save(owner);
        return "redirect:/owners";
    }

    @RequestMapping("/edit_owner/{Nr_Wlasciciela}")
    public ModelAndView showOwnerEditForm(@PathVariable(name = "Nr_Wlasciciela") int Nr_Wlasciciela){
        ModelAndView mav = new ModelAndView("edit_owner");
        Owners owner = daoOwners.get(Nr_Wlasciciela);
        List<Adresses> listAdresses = daoAdresses.list();
        mav.addObject("listAdresses", listAdresses);
        mav.addObject("owner", owner);
        return mav;
    }

    @RequestMapping(value = "/update_owner", method = RequestMethod.POST)
    public String updateOwner(@ModelAttribute("owner") Owners owner){
        daoOwners.update(owner);

        return "redirect:/owners";
    }

    @RequestMapping(value = "/delete_owner/{Nr_Wlasciciela}")
    public String deleteOwner(@PathVariable(name="Nr_Wlasciciela") int Nr_Wlasciciela) {
        daoOwners.delete(Nr_Wlasciciela);

        return "redirect:/employees";
    }

    @GetMapping("/edit_owner_profile")
    public String editOwnerProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Owners owner = OwnersDAO.findByUsername(currentUserName);
        model.addAttribute("owner", owner);

        return "edit_owner_profile";
    }

    @PostMapping("/update_owner_profile")
    public String updateOwnerProfile(@ModelAttribute("owner") Owners owner, Model model) {
        // Aktualizuj dane pracownika w bazie danych
        OwnersDAO.update(owner);

        model.addAttribute("owner", owner);
        model.addAttribute("successMessage", "Dane zostały zaktualizowane.");

        return "owner_profile";
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/new_horse").setViewName("new_horse");
        registry.addViewController("/new_breed").setViewName("new_breed");
        registry.addViewController("/new_worker").setViewName("new_worker");
        registry.addViewController("/new_postcode").setViewName("new_postcode");
        registry.addViewController("/new_adress").setViewName("new_adress");
        registry.addViewController("/breeds").setViewName("breeds");
        registry.addViewController("/horses").setViewName("horses");
        registry.addViewController("/workers").setViewName("workers");
        registry.addViewController("/employees").setViewName("employees");
        registry.addViewController("/new_employee").setViewName("new_employee");
        registry.addViewController("/owners").setViewName("owners");
        registry.addViewController("/new_owner").setViewName("new_owner");
        registry.addViewController("/postcodes").setViewName("postcodes");
        registry.addViewController("/adresses").setViewName("adresses");
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/owner_profile").setViewName("owner_profile");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

//
//    @Controller
//    public class DashboardController {
//        @RequestMapping("/main")
//        public String defaultAfterLogin(HttpServletRequest request) {
//            if (request.isUserInRole("ADMIN")) {
//                return "redirect:/main_admin";
//            } else if (request.isUserInRole("USER")) {
//                return "redirect:/main_user";
//            } else {
//                return "redirect:/";
//            }
//        }
//    }
//    @RequestMapping(value={"/main_admin"})
//    public String showAdminPage(Model model) {
//        return "admin/main_admin";
//    }
//    @RequestMapping(value={"/main_user"})
//    public String showUserPage(Model model) {
//        return "user/main_user";
//    }
}