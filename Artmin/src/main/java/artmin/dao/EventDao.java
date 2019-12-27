/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Event;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("eventDao")
public class EventDao extends AbstractDao<Long, Event> {
    
    public Event findById(Long id) {
        return getByKey(id);
    }

    public void saveEvent(Event event) {
        persist(event);
    }

    public void deleteEventById(Long id) {
        Query query = getSession().createSQLQuery("delete from events where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEvents(Long artistID) {
        // Enkel ophalen van events van één bepaald artiest

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("artistID", artistID));

        return (List<Event>) criteriaevent.list();
    }
}
