package com.karacadaglii.issuemanagement.Entity.api;

import com.karacadaglii.issuemanagement.Entity.Util.ApiPaths;
import com.karacadaglii.issuemanagement.Entity.dto.ProjectDto;
import com.karacadaglii.issuemanagement.Entity.service.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController  //Spring boot starter data rest
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get by Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Project Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Validated @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    /*@RequestMapping(path = "/update", method = RequestMethod.PUT)*/
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Projet Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Project Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
