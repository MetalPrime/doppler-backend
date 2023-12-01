package com.metalprime.dopplerbackend.controller;

import com.metalprime.dopplerbackend.model.Project;
import com.metalprime.dopplerbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public String add(@RequestBody Project Project){
        projectService.addProject(Project);
        return "New Project is added";
    }

    @GetMapping("/getAll")
    public List<Project> list(){
        return projectService.getAllProjects();
    }

    @GetMapping("/getAllFilter")
    public  List<Project> listFilter(@RequestParam  int currentPage, @RequestParam String query) {return projectService.getFilterProjects(currentPage, query);}

    @GetMapping("/totalPages")
    public Integer totalPages(@RequestParam String query) {return projectService.getProjectsPages(query);}
}
