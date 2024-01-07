package eu.phamtheanh.gkg.controller

import eu.phamtheanh.gkg.dto.CreateStudentDTO
import eu.phamtheanh.gkg.dto.StudentResponseDTO
import eu.phamtheanh.gkg.dto.UpdateStudentDTO
import eu.phamtheanh.gkg.dto.mapper.StudentMapper
import eu.phamtheanh.gkg.repository.StudentRepository
import eu.phamtheanh.gkg.service.StudentService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import jakarta.validation.Valid

@Controller
@RequestMapping("/students")
class StudentController(
    private val studentService: StudentService,
    private val studentRepository: StudentRepository,
) {
    @GetMapping
    fun showStudents(): ModelAndView {
        val students: List<StudentResponseDTO> = StudentMapper.toDTO(studentRepository.findAll())
        return ModelAndView("students").addObject("students", students)
    }

    @GetMapping("/new")
    fun showCreateForm() = ModelAndView("new-student").addObject("student", CreateStudentDTO())

    @PostMapping("/new")
    fun createStudent(
        @ModelAttribute("student")
        @Valid
        studentDTO: CreateStudentDTO,
    
        result: BindingResult,
        attributes: RedirectAttributes
    ): String {
        if (result.hasErrors()) {
            return "new-student"
        }

        studentService.save(StudentMapper.toEntity(studentDTO))
        attributes.addFlashAttribute("message", "User registered successfully!")
        return "redirect:/students"
    }

    @GetMapping("/{id}")
    fun showUpdateForm(@PathVariable id: String) = ModelAndView("edit-student").addObject("student", StudentMapper.toDTO(studentService.findById(id)))

    @PostMapping("/{id}")
    fun update(
        @PathVariable
        id: String,

        @ModelAttribute("student")
        @Valid
        studentDTO: UpdateStudentDTO,

        result: BindingResult,
        attributes: RedirectAttributes
    ): String {
        if (result.hasErrors()) {
            studentDTO.id = id
            return "edit-student"
        }

        studentService.update(id, StudentMapper.toEntity(studentDTO))
        attributes.addFlashAttribute("message", "User updated successfully!")
        return "redirect:/students"
    }

    @GetMapping("/{id}/delete")
    fun delete(@PathVariable id: String, attributes: RedirectAttributes): String {
        studentService.deleteById(id)
        attributes.addFlashAttribute("message", "User deleted successfully!")
        return "redirect:/students"
    }
}