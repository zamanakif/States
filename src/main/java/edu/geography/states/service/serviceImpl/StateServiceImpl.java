package edu.geography.states.service.serviceImpl;

import edu.geography.states.model.City;
import edu.geography.states.model.CityList;
import edu.geography.states.model.NP;
import edu.geography.states.model.NPList;
import edu.geography.states.model.State;
import edu.geography.states.repository.StateRepository;
import edu.geography.states.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public State getStateByStateId(String stateId) {
        Optional<State> optionalState = stateRepository.findById(stateId);
        return optionalState.orElse(null);
    }

    public State addState(State newState) {
        return stateRepository.save(newState);
    }

    public State updateState(String stateId, State modifiedState) {
        State oldState = getStateByStateId(stateId);
        oldState.setStateName(modifiedState.getStateName());
        oldState.setCapital(modifiedState.getCapital());
        oldState.setNickName(modifiedState.getNickName());
        oldState.setFoundingDate(modifiedState.getFoundingDate());
        oldState.setNumber(modifiedState.getNumber());
        oldState.setStateId(modifiedState.getStateId());
        return stateRepository.save(oldState);
    }

    //String deleteState(String stateId);

    public List<State> getStatesInRange(String startDateString, String endDateString, Integer size) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(startDateString, dtf);
        LocalDate endLocalDate = LocalDate.parse(endDateString, dtf);
        System.out.println("In Service, start date passed = " + startDateString + ", LDT value = " + startLocalDate.toString());
        System.out.println("In Service, end date passed = " + endDateString + ", LDT value = " + endLocalDate.toString());
        System.out.println("In Service, limit = " + size);

        return stateRepository.findAll().stream().filter(x -> startLocalDate.isBefore(x.getFoundingDate()) && endLocalDate.isAfter(x.getFoundingDate()) ).limit(size).collect(Collectors.toList());
    }


    public CityList getCitiesInState(String stateId) {
        /*
        //System.out.println("Calling URL ....." + "http://localhost:8088/cities/list/states/" + stateId);return this.restTemplate.getForEntity("http://localhost:8088/cities/list/states/" + stateId, CityList.class);
        System.out.println("Calling URL ....." + "http://CITIESDEMO/cities/list/states/" + stateId);
        //ResponseEntity<CityList> respEntCityList = this.restTemplate.getForEntity("http://CITIESDEMO/cities/list/states/" + stateId, CityList.class);
        //System.out.println("Number of cities returned = " + cityList.getBody().getListOfCities().stream().count());
        CityList cityList = this.restTemplate.getForEntity("http://CITIESDEMO/cities/list/states/" + stateId, CityList.class).getBody();
        //System.out.println("Number of cities returned = " + cityList.getBody().getListOfCities().stream().count());
        return cityList;
        //return this.restTemplate.getForEntity("http://CITIESDEMO/cities/list/states/" + stateId, CityList.class);
        */
        return null;
    }

    public NPList getNPsInState(String stateCd) {

        ResponseEntity<NPList> respEntNPList = this.restTemplate.getForEntity("http://localhost:8086/nps/list/states/"
                + stateCd, NPList.class);
        System.out.println("Number of NPs returned = " + respEntNPList.getBody().getListOfNPs().size());
        //return this.restTemplate.getForEntity("http://localhost:8086/nps/list/states/" + stateCd + "?size=" + size, NPList.class).getBody();
        return respEntNPList.getBody();
        //return this.restTemplate.getForEntity("http://NATIONALPARKS/nps/list/states/" + stateCd + "?size=" + size, NPList.class);
    }

    /*
    @Autowired
    private WebClient.Builder webClientBuilder;

    public ResponseEntity<CityList> getCitiesInStateWebClientWay(String stateId) {
        CityList cityList = webClientBuilder.build()
                                .get()
                                .uri("http://localhost:8088/cities/list/state/" + stateId)
                                .retrieve().bodyToMono(CityList.class)
                                .block();
        return ResponseEntity.of(cityList);
    }
    */

}
