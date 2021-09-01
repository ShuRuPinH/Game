package game.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    private Integer id;
    private String name;
    private String description;
    private Integer action;
    private Integer location;
    private Integer remItem;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "action")
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
    @Column(name = "rem_item")
    public Integer getRemItem() {
        return remItem;
    }

    public void setRemItem(Integer remItem) {
        this.remItem = remItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (action != null ? !action.equals(item.action) : item.action != null) return false;
        if (location != null ? !location.equals(item.location) : item.location != null) return false;
        if (remItem != null ? !remItem.equals(item.remItem) : item.remItem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (remItem != null ? remItem.hashCode() : 0);
        return result;
    }
}
