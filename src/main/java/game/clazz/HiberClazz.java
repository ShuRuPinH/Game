package game.clazz;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game.model.ActionEntity;

import game.model.Item;
import game.model.LocationEntity;
import game.model.NState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HiberClazz {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("ExceptionInInitializerError(ex)");
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static Item getItemById(int id) {
        Session session =getTranz();
        Item temp =  session.get(Item.class,id);
        session.close();
        return temp;
    }
    public static LocationEntity getLocationById(Integer id) {
        if (id==null) return null;
      Session session =getTranz();
       LocationEntity temp =session.get(LocationEntity.class,id);
     session.close();
        return temp ;
    }
    public static ActionEntity getActionById(int id) {
        Session session =getTranz();
        ActionEntity temp =  session.get(ActionEntity.class,id);
        session.close();
        return temp;
    }

    public static ActionEntity checkItemAct(Integer itemID, Integer location){
        String sql = "select action from item_loc_actions " +
                "where id_item = "+itemID+" and (" +
                "location ="+location + " or status_loc = 777)" ;



        Session session =getTranz();
        List <Integer> temp =session.createSQLQuery(sql).list();
        session.close();
        if(temp.isEmpty()) {
                 return null;

        }

        else return getActionById(temp.get(0));

    }

    public static List <String> getSavesID(){
        String sql = "select id from save_state ";

        Session session =getTranz();
        List <String> temp =session.createSQLQuery(sql).list();
        session.close();
        if(temp.isEmpty()) return new ArrayList<String>();

        else return temp;

    }

    public static void saveState(String id, String json){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        System.out.println(id+"<id  json>"+json);
        String sql = "INSERT INTO save_state (id, state , date)  " +
                "VALUES ('"+id+"', '"+json+"', CURRENT_DATE); ";

        //String sql = "select id from save_state";
       session.createSQLQuery(sql).executeUpdate();

       //System.out.println(query.getFirstResult());
        transaction.commit();
                session.close();
    }

    public static NState getNStateFromDB(String ID){
        String sql = "select state from save_state " +
                "where id = '"+ID+"'";

        Session session =getTranz();
        List<String> temp =session.createSQLQuery(sql).getResultList();
        session.close();
        if(temp.isEmpty()) return null;
        Type type = new TypeToken<NState>() {}.getType();
        NState rez= new Gson().fromJson(temp.get(0),type);

        return rez;

    }

    public static void main(String[] args) {
/*        Session session =sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        ActionEntity temp =  session.get(ActionEntity.class,1);
        LocationEntity locTemp = session.get(LocationEntity.class, 0);


        System.out.println(temp.getDescription());
        System.out.println(locTemp.getDescription());
        System.out.println(locTemp.getActionList().get(0).getDescription());
        session.close();*/

        saveState("ен22","1202");


    }



///////////////////  START TRANZ  /////////////////////////////////
    private static Session getTranz(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

        return session;


    }
///////////////////////////////////////////////////////////////////
}