package smattect.co.zw.smatrentalpro.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smattect.co.zw.smatrentalpro.service.ApplicantsService;
import smattect.co.zw.smatrentalpro.utils.dao.Applicants;
import smattect.co.zw.smatrentalpro.utils.dto.request.ApplicantsRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/application")
@Tag(name = "Application Controller", description = "Application Controller")
@RequiredArgsConstructor
public class ApplicantsController {

    private final ApplicantsService applicantsService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addApplication(@RequestBody ApplicantsRequest applicantsRequest){
         applicantsService.addApplicant(applicantsRequest);
        return ResponseEntity.ok(new ResponseMessage("property created success"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Applicants>> applicantsDetails(){
        return ResponseEntity.ok(applicantsService.applicantsDetails());
    }


}
