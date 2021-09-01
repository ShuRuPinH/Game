package game.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = "game")
    public class WebContextConfig implements WebMvcConfigurer {
        @Bean
        public ViewResolver configureViewResolver(){
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/jsp/");
            resolver.setSuffix(".jsp");
            return resolver;
        }
        //Если хотим использовать CSS и JS
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(31556926);
        }
    }

