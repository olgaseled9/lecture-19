package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.CircleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.RectangleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.ShapeDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.CircleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.RectangleImpl;
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

        RectangleDao rectangleDao = new RectangleImpl(entityManager);
        CircleDao circleDao=new CircleDaoImpl(entityManager);
        Rectangle rectangle = new Rectangle("Rectangle", 10, 20);
        Circle circle = new Circle("Circle", 4);
        circleDao.saveOrUpdate(circle);
        rectangleDao.saveOrUpdate(rectangle);
        ShapeDao shapeDao=new ShapeDaoImpl(entityManager);
        logger.info("{}",shapeDao.findAll());

        entityManager.close();


    }
}
