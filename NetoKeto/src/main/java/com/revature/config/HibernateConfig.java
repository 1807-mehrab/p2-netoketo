package com.revature.config;

import java.util.Properties;

import javax.sql.DataSource;

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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.revature.repository.CommentDao;
import com.revature.repository.ImageDao;
import com.revature.repository.RecipeDao;
import com.revature.repository.RecipeRatingDao;
import com.revature.repository.UserDao;
import com.revature.services.CommentService;
import com.revature.services.ImageService;
import com.revature.services.LoginService;
import com.revature.services.RecipeRatingService;
import com.revature.services.RecipeService;
import com.revature.services.UserService;

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class HibernateConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

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
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.revature"});
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
			setProperty("hibernate.dialect" , env.getProperty("hibernate.dialect"));
			setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
			}
		};
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(sessionFactory);
		return tm;
	}

	@Bean
	public UserDao userDao(SessionFactory sessionFactory) {
		UserDao dao = new UserDao();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}

	@Bean
	public UserService userService(UserDao dao) {
		UserService us = new UserService();
		us.setDao(dao);
		return us;
	}
	
	@Bean
	public LoginService loginService(UserDao dao) {
		LoginService ls = new LoginService();
		ls.setDao(dao);
		return ls;
	}
	
	@Bean
	public RecipeDao recipeDao(SessionFactory sessionFactory) {
		RecipeDao dao = new RecipeDao();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public RecipeService recipeService(RecipeDao dao) {
		RecipeService rs = new RecipeService();
		rs.setDao(dao);
		return rs;
	}
	
	@Bean
	public CommentDao commentDao(SessionFactory sessionFactory) {
		CommentDao dao = new CommentDao();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public CommentService commentService(CommentDao dao) {
		CommentService cs = new CommentService();
		cs.setDao(dao);
		return cs;
	}
	
	@Bean 
	public RecipeRatingDao recipeRatingDao(SessionFactory sessionFactory) {
		RecipeRatingDao dao = new RecipeRatingDao();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public RecipeRatingService recipeRatingService(RecipeRatingDao dao) {
		RecipeRatingService rrs= new RecipeRatingService();
		rrs.setDao(dao);
		return rrs;
	}
	
	@Bean
	public ImageDao imageDao(SessionFactory sessionFactory) {
		ImageDao dao = new ImageDao();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public ImageService imageService(ImageDao dao) {
		ImageService is= new ImageService();
		is.setDao(dao);
		return is;
	}
}