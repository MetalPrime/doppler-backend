package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Project;
import com.metalprime.dopplerbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project editProject(Project updateProject, int id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {
            Project existingProject = optionalProject.get();

            existingProject.setBean_id(updateProject.getBean_id());
            existingProject.setDescription(updateProject.getDescription());
            existingProject.setName(updateProject.getName());
            existingProject.setStatus(updateProject.getStatus());
            existingProject.setPartners_id(updateProject.getPartners_id());

            return projectRepository.save(existingProject);
        } else {
            throw new EntityNotFoundException("Not found Project with ID: " + id);
        }

    }

    @Override
    public void deleteProject(int id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(optionalProject.isPresent()) {
            projectRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not eliminate Project, not found with ID: " + id);
        }
    }

    @Override
    public Project getProjectById(int id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        return optionalProject.orElse(null);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getFilterProjects(int currentPage, String query) {
        final int ITEMS_PER_PAGE = 10;
        Pageable pageable = PageRequest.of(currentPage - 1, ITEMS_PER_PAGE);
        return projectRepository.findFilteredProjects( pageable, query);
    }

    @Override
    public Integer getProjectsPages(String query) {
        final int ITEMS_PER_PAGE = 10;
        Integer count = projectRepository.getProjectsPages(query);
        System.out.print((int) Math.ceil((double) count / ITEMS_PER_PAGE));
        return (int) Math.ceil((double) count / ITEMS_PER_PAGE);
    }


}
