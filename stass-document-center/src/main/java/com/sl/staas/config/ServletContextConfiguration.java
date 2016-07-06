package com.sl.staas.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sl.staas.web")
public class ServletContextConfiguration extends WebMvcConfigurerAdapter {

   @Bean
   public TilesConfigurer tilesConfigurer() {

      TilesConfigurer tilesConfigurer = new TilesConfigurer();
      tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml" });
      return tilesConfigurer;
   }

   @Bean
   public ViewResolver tilesViewResolver() {
      UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
      urlBasedViewResolver.setViewClass(TilesView.class);
      return urlBasedViewResolver;
   }

   @Bean
   public MessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasenames(new String[] { "WEB-INF/i18n/messages", "WEB-INF/i18n/application" });
      messageSource.setFallbackToSystemLocale(false);
      return messageSource;
   }

   @Bean
   public LocaleResolver localeResolver() {
      CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
      cookieLocaleResolver.setCookieName("locale");
      return cookieLocaleResolver;
   }

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      super.addInterceptors(registry);

      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
      localeChangeInterceptor.setParamName("lang");

      registry.addInterceptor(localeChangeInterceptor);
   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      super.addResourceHandlers(registry);
      registry.addResourceHandler("/resources/**").addResourceLocations(new String[] { "/", "classpath:/META-INF/web-resources/" });
   }

}
