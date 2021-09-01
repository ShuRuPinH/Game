package game.model;

import game.clazz.HiberClazz;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class State{

    LocationEntity location;
    Map<Integer, Item > itemList= new LinkedHashMap<>();
    Collection<Integer> preHistory =new ArrayList<>();
    Collection<Integer> history =new ArrayList<>();
    Map<Integer , Integer> locationStatus = new HashMap<>();
    String info;





    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public void setItemList(Map<Integer, Item> itemList) {
        this.itemList = itemList;
    }

    public Collection<Integer> getPreHistory() {
        return preHistory;
    }

    public void setPreHistory(Collection<Integer> preHistory) {
        this.preHistory = preHistory;
    }

    public void setHistory(Collection<Integer> history) {
        this.history = history;
    }

    public Map<Integer, Integer> getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(Map<Integer, Integer> locationStatus) {
        this.locationStatus = locationStatus;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public State() {
        itemList.put(111, HiberClazz.getItemById(111));
        itemList.put(222, HiberClazz.getItemById(222));
        itemList.put(333, HiberClazz.getItemById(333));
    }

    public State(LocationEntity location ) {
        this.location = location;


    }

    public State(NState nState) {
        this.location = HiberClazz.getLocationById(nState.location);
        this.itemList = nState.itemList;
        this.preHistory = nState.preHistory;
        this.history = nState.history;
        this.locationStatus = nState.locationStatus;
        this.info = nState.info;
    }

    public ActionEntity getAction(Integer id){
        ActionEntity temp = HiberClazz.getActionById(id);
        return temp;
    }
    public void setLocationStatus(int idLoc, int status){
        locationStatus.put(idLoc,status);
    }
    public Integer getLocationStatus(Integer id){
        return locationStatus.get(id);
    }


    public Collection<Integer> getHistory() {
        return history;
    }

    public  Map<Integer, Item > getItemList(){
        return itemList;
    }
    public LocationEntity getLocation() {
        return location;
    }

    public String getInfo() {
        return info;
    }

    public ActionEntity getItAct(Integer itemID, Integer loc){
        return  HiberClazz.checkItemAct(itemID,loc);
    }

    public State turn(ActionEntity action){
         LocationEntity newLocal= HiberClazz.getLocationById(action.getLocation());
         Integer newItem= action.getNewItem();
         Integer remItem= action.getRemoveItem();



         Integer newStatus = action.getNewStatus();
         info=action.getInfo();


         if (newItem != null && newItem != 0){
             itemList.put(newItem,HiberClazz.getItemById(newItem));
         }
         if (remItem != null && remItem != 0){
             Item tmp= HiberClazz.getItemById(remItem);
             if (tmp.getRemItem()!=null){
                 itemList.remove(tmp.getRemItem());
             }
             itemList.remove(remItem);
         }
         if (newStatus != null){
             LocationEntity stateLocation= action.getState_location();

             setLocationStatus(stateLocation==null? action.getLocation():stateLocation.getId(),newStatus);
         }



         if (newLocal != null ){
             location=newLocal;

           if(!preHistory.contains(location.getId())){
               preHistory.add(location.getId());
               } else {
               preHistory.add(location.getId());
               history.add(location.getId());
           }
         }


         return this;
    }





}
