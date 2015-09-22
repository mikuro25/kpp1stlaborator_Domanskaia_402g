/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Hanna
 */
public interface DAO<T> {
    ArrayList<T> select();
    void insert(T t);
    void delete(int id);
    void update(int id, T t);
}
