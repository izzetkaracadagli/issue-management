package com.karacadaglii.issuemanagement.Entity.api;

import com.karacadaglii.issuemanagement.Entity.Util.ApiPaths;
import com.karacadaglii.issuemanagement.Entity.dto.IssueDto;
import com.karacadaglii.issuemanagement.Entity.service.impl.IssueServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("versioning")
@Api(value = ApiPaths.IssueCtrl.CTRL)
public class IssueVersionedApi {
    @Autowired
    private IssueServiceImpl issueService;

    @RequestMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value = "Get by Operation v1", response = IssueDto.class)
    public ResponseEntity<IssueDto> getByIdV1(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueService.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @RequestMapping(value = "/{id}", params = "version=2")
    @ApiOperation(value = "Get by Operation v1", response = IssueDto.class)
    public ResponseEntity<IssueDto> getByIdV2(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueService.getById(id);
        return ResponseEntity.ok(issueDto);
    }
}
