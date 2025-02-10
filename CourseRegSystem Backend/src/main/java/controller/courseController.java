package controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.course;
import service.courseService;

@RestController
public class courseController {

	@Autowired
	courseService courseServe;
//	
//	@GetMapping("courses")
//	public List<course>availableCourses(){
//		return courseService.availablecourses();
//	}
}
