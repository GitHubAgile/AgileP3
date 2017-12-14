/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "RESTAURANT", catalog = "", schema = "NBUSER")
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r")
    , @NamedQuery(name = "Restaurant.findByRestid", query = "SELECT r FROM Restaurant r WHERE r.restid = :restid")
    , @NamedQuery(name = "Restaurant.findByRestname", query = "SELECT r FROM Restaurant r WHERE r.restname = :restname")
    , @NamedQuery(name = "Restaurant.findByResttype", query = "SELECT r FROM Restaurant r WHERE r.resttype = :resttype")
    , @NamedQuery(name = "Restaurant.findByRestphone", query = "SELECT r FROM Restaurant r WHERE r.restphone = :restphone")
    , @NamedQuery(name = "Restaurant.findByRestaddress", query = "SELECT r FROM Restaurant r WHERE r.restaddress = :restaddress")
    , @NamedQuery(name = "Restaurant.findByOwnername", query = "SELECT r FROM Restaurant r WHERE r.ownername = :ownername")
    , @NamedQuery(name = "Restaurant.findByOwnercontactno", query = "SELECT r FROM Restaurant r WHERE r.ownercontactno = :ownercontactno")})
public class Restaurant implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RESTID")
    private String restid;
    @Column(name = "RESTNAME")
    private String restname;
    @Lob
    @Column(name = "IMAGE")
    private Serializable image;
    @Column(name = "RESTTYPE")
    private String resttype;
    @Column(name = "RESTPHONE")
    private String restphone;
    @Column(name = "RESTADDRESS")
    private String restaddress;
    @Column(name = "OWNERNAME")
    private String ownername;
    @Column(name = "OWNERCONTACTNO")
    private String ownercontactno;

    public Restaurant() {
    }

    public Restaurant(String restid, String restname, Serializable image, String resttype, String restphone, String restaddress, String ownername, String ownercontactno) {
        this.restid = restid;
        this.restname = restname;
        this.image = image;
        this.resttype = resttype;
        this.restphone = restphone;
        this.restaddress = restaddress;
        this.ownername = ownername;
        this.ownercontactno = ownercontactno;
    }

    public Restaurant(String restid) {
        this.restid = restid;
    }

    public String getRestid() {
        return restid;
    }

    public void setRestid(String restid) {
        String oldRestid = this.restid;
        this.restid = restid;
        changeSupport.firePropertyChange("restid", oldRestid, restid);
    }

    public String getRestname() {
        return restname;
    }

    public void setRestname(String restname) {
        String oldRestname = this.restname;
        this.restname = restname;
        changeSupport.firePropertyChange("restname", oldRestname, restname);
    }

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        Serializable oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }

    public String getResttype() {
        return resttype;
    }

    public void setResttype(String resttype) {
        String oldResttype = this.resttype;
        this.resttype = resttype;
        changeSupport.firePropertyChange("resttype", oldResttype, resttype);
    }

    public String getRestphone() {
        return restphone;
    }

    public void setRestphone(String restphone) {
        String oldRestphone = this.restphone;
        this.restphone = restphone;
        changeSupport.firePropertyChange("restphone", oldRestphone, restphone);
    }

    public String getRestaddress() {
        return restaddress;
    }

    public void setRestaddress(String restaddress) {
        String oldRestaddress = this.restaddress;
        this.restaddress = restaddress;
        changeSupport.firePropertyChange("restaddress", oldRestaddress, restaddress);
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        String oldOwnername = this.ownername;
        this.ownername = ownername;
        changeSupport.firePropertyChange("ownername", oldOwnername, ownername);
    }

    public String getOwnercontactno() {
        return ownercontactno;
    }

    public void setOwnercontactno(String ownercontactno) {
        String oldOwnercontactno = this.ownercontactno;
        this.ownercontactno = ownercontactno;
        changeSupport.firePropertyChange("ownercontactno", oldOwnercontactno, ownercontactno);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restid != null ? restid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restid == null && other.restid != null) || (this.restid != null && !this.restid.equals(other.restid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ui.Restaurant[ restid=" + restid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
