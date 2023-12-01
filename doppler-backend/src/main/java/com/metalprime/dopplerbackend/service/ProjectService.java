package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Project;

import java.util.List;

public interface ProjectService {
    public Project addProject(Project project);

    public Project editProject(Project project, int id);

    public void deleteProject(int id);

    public Project getProjectById(int id);

    public List<Project> getAllProjects();

    public List<Project> getFilterProjects(int currentPage, String query);

    public Integer getProjectsPages(String query);
}
