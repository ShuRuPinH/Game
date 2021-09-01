package game.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location", schema = "public", catalog = "game")
public class LocationEntity {
    private int id;
    private String description;
    private String secret;
    private Integer info;
    private String stateDesc;
    private List <ActionEntity> actionList;

    @OneToMany(mappedBy = "state_location", fetch = FetchType.EAGER)
    public List<ActionEntity> getActionList() {
        if (actionList==null) actionList=new ArrayList<>();
        return actionList;
    }

    public void setActionList(List<ActionEntity> actionList) {
        this.actionList = actionList;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Basic
    @Column(name = "info")
    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    @Basic
    @Column(name = "state_desc")
    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (secret != null ? !secret.equals(that.secret) : that.secret != null) return false;
        if (info != that.info) return false;
        if (stateDesc != null ? !stateDesc.equals(that.stateDesc) : that.stateDesc != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (stateDesc != null ? stateDesc.hashCode() : 0);

        return result;
    }
}
