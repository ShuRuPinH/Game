package game.conf;


import com.google.gson.Gson;
import game.clazz.HiberClazz;
import game.model.NState;
import game.model.State;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class MapController {

        HashMap <String, State> sessionList = new HashMap<>();
        static {
                System.out.println(" MapController init");
        }

        @RequestMapping(value = "/start",method = RequestMethod.POST)
        public String start (@RequestParam("action_id") Integer actionId,Model model, HttpServletRequest req){
            if (actionId==null){
                actionId=0;
            }

            String sesId = req.getSession().getId();
               State temp= sessionList.get(sesId);

               if(temp==null){
                       temp = new State();
                       sessionList.put(sesId,temp);
                          }

                model.addAttribute("state",temp.turn(HiberClazz.getActionById(actionId)));
                return "start";
        }

        @RequestMapping(value = "/new",method = RequestMethod.POST)
        public String reload (Model model, HttpServletRequest req){
            req.getSession().invalidate();
            State newState = new State();
            sessionList.put(req.getSession().getId(),newState);
            model.addAttribute("state",newState.turn(HiberClazz.getActionById(0)));
            return "start";

        }

    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public String load (Model model, HttpServletRequest req){
        if (req.getParameter("key")==null || req.getParameter("key").isEmpty() ){
            model.addAttribute("message","Введите код записи");
            return "load";
        }
        else {
            req.getSession().invalidate();
            NState temp=HiberClazz.getNStateFromDB(req.getParameter("key"));
            State newState = new State(temp);
            sessionList.put(req.getSession().getId(),newState);
            model.addAttribute("state",newState);
            return "start";
        }

    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest req){

        String sesId = req.getSession().getId();
        State temp= sessionList.get(sesId);

        if (temp==null){

            model.addAttribute("message","Ошибка записи, начните заново");
        }
            else {
            String id=null;
            while (id==null || HiberClazz.getSavesID().contains(id)){
                id = UUID.randomUUID().toString().substring(24);
            }
          //  String  json = Base64.getEncoder().encodeToString(new Gson().toJson(new NState(temp)).getBytes(StandardCharsets.UTF_8));

            HiberClazz.saveState(id,new Gson().toJson(new NState(temp)));
            model.addAttribute("message","Код сохранения (через 7 дней будет удален): <b>"+ id+"</b>");

        }
        return "save";

    }

    public static void main(String[] args) {

    }
}
