/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import streaming.dao.SaisonDAO;
import streaming.entity.Saison;

/**
 *
 * @author admin
 */
public class SaisonService {
    
    public Saison detailSaison(long id) {

        SaisonDAO dao = new SaisonDAO();
        return dao.recupDetail(id);
    }
    
}
