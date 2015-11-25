/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.sql.ResultSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 *
 * @author jau
 */
public class Iterador {
    

 private TreeSet < ResultSet > m_data = new TreeSet < ResultSet > ();

    public class Iterator
    {
        private Iterador m_collection;
        private java.util.Iterator m_it;
        private int m_current;
        public Iterator(Iterador in)
        {
            m_collection = in;
        }
        public void primero()
        {
            m_it = m_collection.m_data.iterator();
            siguiente();
        }
        public void siguiente()
        {
            try
            {
                m_current = (int) m_it.next();
            }
            catch (NoSuchElementException ex)
            {
                m_current =  - 999;
            }
        }
        public boolean vacio()
        {
            return m_data.isEmpty();
        }
        public int current_item()
        {
            return m_current;
        }
    }

    public void add(ResultSet in)
    {
        m_data.add(in);
    }
    public Iterator create_iterator()
    {
        return new Iterator(this);
    }}