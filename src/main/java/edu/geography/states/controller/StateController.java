package edu.geography.states.controller;

import edu.geography.states.model.CityList;
import edu.geography.states.model.NPList;
import edu.geography.states.model.State;
import edu.geography.states.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states/")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello States";
    }

    @GetMapping("/")
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @GetMapping("/{stateId}")
    public State getStateWithId(@PathVariable("stateId") String stateId) {
        return stateService.getStateByStateId(stateId);
    }

    @PostMapping("/")
    public State createNewState(@RequestBody State newState) {
        return stateService.addState(newState);
    }

    @PutMapping("/{stateId}")
    public State modifyState(@PathVariable("stateId")  String stateId, @RequestBody State modifiedState) {
        return stateService.updateState(stateId, modifiedState);
    }

    @GetMapping("/founded/{startDate}/and/{endDate}")
    public List<State> getStatedFormedBetween(@PathVariable("startDate")String startDateString, @PathVariable("endDate") String endDateString, @RequestParam(value = "size") Integer size) {
        return stateService.getStatesInRange(startDateString, endDateString, size);
    }

    /*
    @GetMapping("/cities/{stateId}")
    public ResponseEntity<CityList> getCitiesFromState(@PathVariable("stateId") String stateId) {
        return stateService.getCitiesInState(stateId);
    }
    */
    @GetMapping("/cities/{stateId}")
    public CityList getCitiesFromState(@PathVariable("stateId") String stateId) {
        return stateService.getCitiesInState(stateId);
    }

    /*
    @GetMapping("/NPs/states/{stateCd}")
    public ResponseEntity<NPList> getNPsInState(@PathVariable("stateCd") String stateCd, @RequestParam(value="size")Integer size) {
        return stateService.getNPsInState(stateCd, size);
    }
    */
    @GetMapping("/NPs/states/{stateCd}")
    public NPList getNPsInState(@PathVariable("stateCd") String stateCd) {
        return stateService.getNPsInState(stateCd);
    }



}
