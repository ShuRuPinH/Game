package game.model;

import java.util.*;

public class NState {

    Integer ID;
    Integer location;
    Map<Integer, Item > itemList= new LinkedHashMap<>();
    Collection<Integer> preHistory =new ArrayList<>();
    Collection<Integer> history =new ArrayList<>();
    Map<Integer , Integer> locationStatus = new HashMap<>();
    String info;



    public NState(State state) {
        this.location = state.location.getId();
        this.itemList = state.itemList;
        this.preHistory = state.preHistory;
        this.history = state.history;
        this.locationStatus = state.locationStatus;
        this.info = state.info;
    }
}
