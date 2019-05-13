package fastfish.mini.sns.bootmodules.config.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Order(-1)
public class DynamicDataSourceAspect {
    //rivate static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);


    @Pointcut("@within(fastfish.mini.sns.bootmodules.config.datasource.DataSource) || @annotation(fastfish.mini.sns.bootmodules.config.datasource.DataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(DataSource)")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        System.out.println("DynamicDataSourceAspect:" + dataSource);
        DataSourceContextHolder.setDataSource(dataSource);
    }

    @After("pointCut()")
    public void afterSwitchDS(){
        DataSourceContextHolder.clear();
    }
}
