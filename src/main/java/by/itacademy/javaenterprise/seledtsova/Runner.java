package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.CardDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.ChequeDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.PaymentDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl.CardDaoImpl;
import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl.ChequeDaoImpl;
import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl.PaymentDaoImpl;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Card;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Cheque;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.CircleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.RectangleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.ShapeDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.CircleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.RectangleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.ShapeDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Circle;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        RectangleDao rectangleDao = new RectangleDaoImpl(entityManager);
        CircleDao circleDao = new CircleDaoImpl(entityManager);
        Rectangle rectangle = new Rectangle("Rectangle", 10, 20);
        Circle circle = new Circle("Circle", 4);
        circleDao.saveOrUpdate(circle);
        rectangleDao.saveOrUpdate(rectangle);
        ShapeDao shapeDao = new ShapeDaoImpl(entityManager);
        logger.info("{}", shapeDao.findAll());

        CardDao cardDao = new CardDaoImpl(entityManager);
        ChequeDao chequeDao = new ChequeDaoImpl(entityManager);
        PaymentDao paymentDao = new PaymentDaoImpl(entityManager);
        Card card = new Card();
        card.setCardNumber(645325);
        card.setCardType("Visa");
        card.setId(null);
        card.setAmount(1500);
        Cheque cheque = new Cheque();
        cheque.setId(null);
        cheque.setAmount(1600);
        cheque.setChequeNumber(102265);
        cheque.setChequeType("Order");
        chequeDao.saveOrUpdate(cheque);
        cardDao.saveOrUpdate(card);
        logger.info("{}", paymentDao.findAll());
        entityManager.close();
    }
}
