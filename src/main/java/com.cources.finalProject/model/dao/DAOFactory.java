package com.cources.finalProject.model.dao;

import com.cources.finalProject.model.dao.impl.JDBCDaoFactory;
import com.cources.finalProject.model.dao.specificdao.FeedbackDAO;
import com.cources.finalProject.model.dao.specificdao.OrderDAO;
import com.cources.finalProject.model.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.model.dao.specificdao.PersonDAO;

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
