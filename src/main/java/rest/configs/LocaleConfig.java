package rest.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LocaleConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("locale/messages", "messages");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        source.setFallbackToSystemLocale(false);
        return source;
    }

    @Bean
    public LocaleResolver localeResolver()  {
        return new SmartLocaleResolver();
    }

    class SmartLocaleResolver extends AcceptHeaderLocaleResolver {
        public Locale resolveLocale(HttpServletRequest request) {
            String languageHeader = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
            if (languageHeader != null && !languageHeader.isEmpty()) {
                String[] locale = languageHeader.split("-");
                if (locale.length == 2) {
                    return new Locale(locale[0], locale[1]);
                }
            }
            return Locale.getDefault();
        }
    }
}
