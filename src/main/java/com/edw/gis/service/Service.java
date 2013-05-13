
package com.edw.gis.service;

import com.edw.gis.bean.Desa;
import com.edw.gis.bean.Kabupaten;
import com.edw.gis.bean.Kecamatan;
import com.edw.gis.bean.Provinsi;
import com.edw.gis.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
@WebService(serviceName = "Service")
public class Service {

    private final Logger logger = Logger.getLogger(Service.class);

    @WebMethod(operationName = "getProvinsis")
    public List<Provinsi> getProvinsis() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Provinsi> provinsis = session.createCriteria(Provinsi.class).list();
            return provinsis;
        } catch (Exception e) {
            logger.error(e, e);
            return new ArrayList<Provinsi>();
        } finally {
            session.close();
        }
    }
    
    @WebMethod(operationName = "getKabupatens")
    public List<Kabupaten> getKabupatens(@WebParam(name = "idProv") String idProv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Kabupaten> kabupatens = session.createQuery("from Kabupaten where idProv = :idProv")
                    .setString("idProv", idProv).list();
            return kabupatens;
        } catch (Exception e) {
            logger.error(e, e);
            return new ArrayList<Kabupaten>();
        } finally {
            session.close();
        }
    }
    
    @WebMethod(operationName = "getKecamatans")
    public List<Kecamatan> getKecamatans(@WebParam(name = "idKabupaten") String idKabupaten) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Kecamatan> kabupatens = session.createQuery("from Kecamatan where idKabupaten = :idKabupaten")
                    .setString("idKabupaten", idKabupaten).list();
            return kabupatens;
        } catch (Exception e) {
            logger.error(e, e);
            return new ArrayList<Kecamatan>();
        } finally {
            session.close();
        }
    }
    
    @WebMethod(operationName = "getDesas")
    public List<Desa> getDesas(@WebParam(name = "idKecamatan") String idKecamatan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Desa> desas = session.createQuery("from Desa where idKecamatan = :idKecamatan")
                    .setString("idKecamatan", idKecamatan).list();
            return desas;
        } catch (Exception e) {
            logger.error(e, e);
            return new ArrayList<Desa>();
        } finally {
            session.close();
        }
    }
     
}
