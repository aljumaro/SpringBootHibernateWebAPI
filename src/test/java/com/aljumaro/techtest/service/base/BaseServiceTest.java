package com.aljumaro.techtest.service.base;

import com.aljumaro.techtest.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 11/04/2016
 * @Time 19:25
 * @Author Juanma
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(value = "file:${apps_config_path}/SpringBootHibernateWebAPI/application.properties")
@ActiveProfiles("default")
public class BaseServiceTest {
}
