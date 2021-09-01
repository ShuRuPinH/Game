package game.model;

import javax.persistence.*;

@Entity
@Table(name = "action", schema = "public", catalog = "game")
public class ActionEntity {
    private int id;
    private String description;
    private Integer removeItem;
    private Integer newItem;
    private Integer location;
    private LocationEntity state_location;
    private Boolean hidden;
    private Integer noHaveItem;
    private Integer status;
    private Integer newStatus;
    private String info;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_location", referencedColumnName = "id")
    public LocationEntity getState_location() {
        return state_location;
    }

    public void setState_location(LocationEntity state_location) {
        this.state_location = state_location;
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
    @Column(name = "remove_item")
    public Integer getRemoveItem() {
        return removeItem;
    }

    public void setRemoveItem(Integer removeItem) {
        this.removeItem = removeItem;
    }

    @Basic
    @Column(name = "new_item")
    public Integer getNewItem() {
        return newItem;
    }

    public void setNewItem(Integer newItem) {
        this.newItem = newItem;
    }

    @Basic
    @Column(name = "location")
    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    @Basic
    @Column(name = "hidden")
    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (removeItem != null ? !removeItem.equals(that.removeItem) : that.removeItem != null) return false;
        if (newItem != null ? !newItem.equals(that.newItem) : that.newItem != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (hidden != null ? !hidden.equals(that.hidden) : that.hidden != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (removeItem != null ? removeItem.hashCode() : 0);
        result = 31 * result + (newItem != null ? newItem.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (hidden != null ? hidden.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "nohave_item")
    public Integer getNoHaveItem() {
        return noHaveItem;
    }

    public void setNoHaveItem(Integer haveItem) {
        this.noHaveItem = haveItem;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Basic
    @Column(name = "new_status")
    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer status) {
        this.newStatus = status;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
