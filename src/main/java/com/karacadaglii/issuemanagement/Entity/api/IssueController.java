package com.karacadaglii.issuemanagement.Entity.api;

import com.karacadaglii.issuemanagement.Entity.Util.ApiPaths;
import com.karacadaglii.issuemanagement.Entity.dto.IssueDto;
import com.karacadaglii.issuemanagement.Entity.service.impl.IssueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //Spring boot starter data rest
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Slf4j
public class IssueController {
    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id){
        log.info("IssueController GetById Called -> PARAM: " + id);
        log.debug("IssueController GetById Called -> PARAM: " + id);
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    /*@RequestMapping(path = "/update", method = RequestMethod.PUT)*/
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
