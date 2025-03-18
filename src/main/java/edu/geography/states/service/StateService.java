package edu.geography.states.service;

import edu.geography.states.model.CityList;
import edu.geography.states.model.NPList;
import edu.geography.states.model.State;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StateService {

    List<State> getAllStates();
    State getStateByStateId(String stateId);
    State addState(State newState);
    State updateState(String stateId, State modifiedState);
    //String deleteState(String stateId);
    List<State> getStatesInRange(String startDateString, String endDateString, Integer size);

    //ResponseEntity<CityList> getCitiesInState(String stateId);
    CityList getCitiesInState(String stateId);
    //ResponseEntity<NPList> getNPsInState(String stateCd);
    NPList getNPsInState(String stateCd);
}
