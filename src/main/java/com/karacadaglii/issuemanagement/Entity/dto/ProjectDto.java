package com.karacadaglii.issuemanagement.Entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Tranfer Object")
public class ProjectDto {
    @NotNull
    @ApiModelProperty(name = "ProjectId")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,name = "Name of Project")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true,name = "Code of Project")
    private String projectCode;
}
