package com.cources.finalProject.models.dao;

import com.cources.finalProject.models.dao.impl.JDBCDaoFactory;
import com.cources.finalProject.models.dao.specificdao.FeedbackDAO;
import com.cources.finalProject.models.dao.specificdao.OrderDAO;
import com.cources.finalProject.models.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.models.dao.specificdao.PersonDAO;

public abstract class DAOFactory {
    private static DAOFactory daoFactory;

    public abstract PersonDAO createPersonDao();
    public abstract OrderRequestDAO createOrderRequestDao();
    public abstract OrderDAO createOrderDao();
    public abstract FeedbackDAO createFeedbackDao();

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DAOFactory.class) {
                if (daoFactory == null) {
                    daoFactory =  new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
