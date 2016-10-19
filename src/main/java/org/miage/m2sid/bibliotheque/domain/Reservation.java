package org.miage.m2sid.bibliotheque.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Reservation.
 */
@Entity
@Table(name = "reservation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_demande")
    private ZonedDateTime dateDemande;

    @ManyToOne
    private Usager usager;

    @ManyToOne
    private Oeuvre oeuvre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateDemande() {
        return dateDemande;
    }

    public Reservation dateDemande(ZonedDateTime dateDemande) {
        this.dateDemande = dateDemande;
        return this;
    }

    public void setDateDemande(ZonedDateTime dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Usager getUsager() {
        return usager;
    }

    public Reservation usager(Usager usager) {
        this.usager = usager;
        return this;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public Reservation oeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
        return this;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        if(reservation.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, reservation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "id=" + id +
            ", dateDemande='" + dateDemande + "'" +
            '}';
    }
}
