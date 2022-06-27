package com.fis.training.controller;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.model.Evidence;
import com.fis.training.model.TrackEntry;
import com.fis.training.model.core.Rank;
import com.fis.training.service.CriminalCaseService;
import com.fis.training.service.DetectiveService;
import com.fis.training.service.EvidenceService;
import com.fis.training.service.TrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/detective")
@CrossOrigin("*")
public class DetectiveRestController {
    @Autowired
    DetectiveService detectiveService;
    @Autowired
    CriminalCaseService criminalCaseService;
    @Autowired
    EvidenceService evidenceService;
    @Autowired
    TrackEntryService trackEntryService;

    @PostMapping
    public ResponseEntity<Detective> addDetective(@RequestBody Detective detective){
        Detective detective1 = this.detectiveService.createDetective(detective);
        return ResponseEntity.ok(detective1);
    }

    @GetMapping("/getAll")
    public List<Detective> getAllDetective(){
        return detectiveService.findAll();
    }

    @PutMapping
    public Detective updateDetective(@RequestBody Detective detective){
        return this.detectiveService.updateDetective(detective);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetective(@PathVariable Long id) {
        this.detectiveService.deleteDetectiveById(id);
    }

    @GetMapping("{id}")
    public Detective getById(@PathVariable Long id){
        return  this.detectiveService.findById(id);
    }

    @GetMapping("/finbyRank/{rank}")
    public List<CriminalCase> getByRank(@PathVariable Rank rank){
        Detective detective=detectiveService.findByRank(rank);
        List<CriminalCase> list=criminalCaseService.findAll();
        List<CriminalCase>list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getLeadInvestigator().equals(detective)){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    @GetMapping("/finbyRank/{rank}")
    public List<Evidence> getByRankEvidence(@PathVariable Rank rank){
        Detective detective=detectiveService.findByRank(rank);
        List<TrackEntry> list=trackEntryService.findAll();
        List<Evidence> list1=evidenceService.findAll();
        List<Evidence>list2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getDetective().getId().equals(detective)){
               for(int j=0;j<list1.size();j++){
                  if(list1.get(j).getId().equals(list.get(i).getEvidence().getId())){
                      list2.add(list1.get(j));
                  }
               }
            }
        }
        return list2;
    }

}
