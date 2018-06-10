package it.codevomit.sho.support;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 *
 * @author merka
 */
public class MockShoApplicationContext implements ApplicationContext
{
    
    Map<String, Object> nameToBeanMap;

    public MockShoApplicationContext()
    {
        this.nameToBeanMap = new HashMap<>();
    }
    
    public void addBean(String name, Object bean){
        this.nameToBeanMap.put(name, bean);
    }
        
    @Override
    public String getId()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getApplicationName()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getDisplayName()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public long getStartupDate()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ApplicationContext getParent()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Environment getEnvironment()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean containsBeanDefinition(String beanName)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getBeanDefinitionCount()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getBeanDefinitionNames()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getBeanNamesForType(ResolvableType type)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getBeanNamesForType(Class<?> type)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object getBean(String name) throws BeansException
    {
        return nameToBeanMap.get(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean containsBean(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String[] getAliases(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public BeanFactory getParentBeanFactory()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean containsLocalBean(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void publishEvent(ApplicationEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void publishEvent(Object event)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Resource[] getResources(String string) throws IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Resource getResource(String string)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ClassLoader getClassLoader()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
