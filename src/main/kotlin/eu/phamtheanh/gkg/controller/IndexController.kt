package eu.phamtheanh.gkg.controller

import eu.phamtheanh.gkg.dto.CreateStudentDTO;
import eu.phamtheanh.gkg.dto.StudentResponseDTO;
import eu.phamtheanh.gkg.dto.UpdateStudentDTO;
import eu.phamtheanh.gkg.dto.mapper.StudentMapper;
import eu.phamtheanh.gkg.repository.StudentRepository;
import eu.phamtheanh.gkg.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "redirect:/students"
    }
}