package com.example.demo.view;

import javax.sql.DataSource;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;



import com.example.demo.ClassicMusic;
import com.example.demo.MusicListBuilder;
import com.example.demo.MusicPlayer;
import com.example.demo.RockMusic;
import com.example.demo.repo.SongRepo;

 @Configuration
 @EnableWebMvc
@ComponentScan("demo")

public class ilyaConfiguration implements WebMvcConfigurer {
	 
	@Autowired 
	 private final ApplicationContext applicationContext ;
	
    public ilyaConfiguration(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
	}

    
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/demo/srs/main/webapp/");
        templateResolver.setSuffix("");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

	@Bean
    RockMusic rockMusic() {
		return new RockMusic();
	};
	
    @Bean 
    ClassicMusic classicMusic() {
	return new ClassicMusic();
    }
    @Bean 
    MusicListBuilder mb() {
    	return new MusicListBuilder( classicMusic(),rockMusic());
    }
    
    @Bean 
   
    MusicPlayer musicPLayer() {
    	return new MusicPlayer(classicMusic(),rockMusic(), mb() );	
    }
    
    @Bean 
    JdbcTemplate template(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean 
    SongRepo songRepo(JdbcTemplate template) {
    return new SongRepo(template);
    }
    
    }
