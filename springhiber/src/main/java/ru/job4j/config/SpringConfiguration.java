
package ru.job4j.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.job4j.repository.ItemDao;
import ru.job4j.repository.ItemDaoImpl;
import ru.job4j.service.DatabaseService;
import javax.sql.DataSource;
import java.util.Properties;
@Import(BasicDataSourceCfg.class)
@EnableTransactionManagement
@Configuration
public class SpringConfiguration {
    private final DataSource dataSource;

    public SpringConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ru.job4j");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        hibernateProperties.setProperty(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        return hibernateProperties;
    }

    @Bean
    public DatabaseService databaseService() {
        return new DatabaseService();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public ItemDao itemDao(SessionFactory sessionFactory) {
        return new ItemDaoImpl(sessionFactory);
    }
}
