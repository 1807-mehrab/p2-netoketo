package com.revature.config;


import com.revature.repository.UserDao;
import com.revature.services.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

// This is a configuration file, Java equivalent to our beans.xml
@Configuration
@ComponentScan("com.revature") // Scan everything
@EnableTransactionManagement // Allows Transaction Management
@PropertySource("classpath:application.properties")
public class HibernateConfig
{
    @Autowired
    private Environment env;

    @Bean
    public DataSource myDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean  sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource()); // Calls our recently defined myDataSource()
        sessionFactory.setPackagesToScan(new String[] {"com.revature"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    Properties hibernateProperties()
    {
        return new Properties(){
            {
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
            }
        };
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager (SessionFactory sessionFactory){
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(sessionFactory);

        return tm;
    }

    @Bean
    public UserDao userDao(SessionFactory sessionFactory){
        UserDao dao = new UserDao();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public UserService userService(UserDao UserDao){
        UserService cs = new UserService();
        cs.setDao(UserDao);
        return  cs;
    }


}
